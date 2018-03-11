package com.example.nieves.conecta4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by nieves on 8/02/18.
 */

public class InterfazOnline extends Activity {
    public String urlCasa = "192.168.1.132";
    public String urlClase = "192.168.115.221";
    public String urlserve = urlClase;
    RequestQueue queue;
    private ArrayList<String> partida;
    private ListView partidas;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        queue = VolleySingleton.getInstance(this).getRequestQueue(); // Asignamos la cola de peticiones
        setContentView(R.layout.interfaz_online);
        Button btMas = (Button) findViewById(R.id.crearPartida);
        Timer timer = new Timer(); // Para que refresque el mostrarPartidas() cada x tiempo
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mostrarPartidas();
                    }
                });
            }
        },3000, 5000);
        partidas = (ListView)findViewById(R.id.partidas);
        btMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearPartida();

            }
        });
    }
    /*
    * Permite crear una nueva partida
    */
    private void crearPartida() {
        String url = "http://"+urlserve+"/conecta4/start.php";
        /* Solicita un string de respuesta a la url dada */
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    Toast.makeText(getApplicationContext(),"Se ha añadido",Toast.LENGTH_LONG).show();
                    String idPartida = "";
                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); // factoria
                    DocumentBuilder db = dbf.newDocumentBuilder(); // Documento dentro de la factoria
                    InputSource is = new InputSource(); // Buffer de entrada
                    is.setCharacterStream(new StringReader(response));
                    Document doc = db.parse(is); // Parseamos la cadena
                    NodeList nodes = doc.getElementsByTagName("game");// Extraemos los nodos con la etiqueta
                        // game del xml
                    for(int i=0; i < nodes.getLength(); i++){
                        Element element = (Element) nodes.item(i);
                        idPartida = element.getAttribute("id");
                    }
                    // Creamos un nuevo intent para comenzar la partida
                    Intent intent = new Intent(InterfazOnline.this, MainActivity.class);
                    Bundle b = new Bundle();
                    b.putString("ID", idPartida);
                    b.putString("color", "1");
                    b.putString("estado", "j");
                    b.putString("MODO", "ONLINE");
                    intent.putExtras(b);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"No se ha podido añadir",Toast.LENGTH_LONG).show();

            }
        });
        queue.add(request); // Añadimos la solicitud a la RequestQueue
    }

    /**
     * Muestra todas las partidas almacenadas en el servidor
     */
    private void mostrarPartidas(){
        partida = new ArrayList<>();
        String url = "http://"+urlserve+"/conecta4/games.php";
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) { // Escucha lo que nos devuelve el servidor (la respuesta) de la petición enviada
                try {
                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                    DocumentBuilder db = dbf.newDocumentBuilder();
                    InputSource is = new InputSource();
                    is.setCharacterStream(new StringReader(response));
                    Document doc = db.parse(is);
                    NodeList nodes = doc.getElementsByTagName("game");
                    for(int i=0; i < nodes.getLength(); i++){
                        Element element = (Element) nodes.item(i);
                        partida.add("partida"+element.getAttribute("id")+"\n");
                    }
                    ArrayAdapter myadapter = new ArrayAdapter(getApplicationContext(), R.layout.simple_text, R.id.simpleTexto,partida);
                    partidas.setAdapter(myadapter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"No se ha podido añadir",Toast.LENGTH_LONG).show();

            }
        });
        queue.add(request);
    }

}