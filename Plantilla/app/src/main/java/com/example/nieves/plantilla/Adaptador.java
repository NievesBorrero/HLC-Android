package com.example.nieves.plantilla;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nieves on 11/03/18.
 */

public class Adaptador extends Activity {
    ArrayList<Lugar> lugares = new ArrayList<>();
    ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemlist);
        insertarLugares();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                TextView esteView = (TextView) view.findViewById(R.id.nombreItem);
                TextView esteOtroView = (TextView) view.findViewById(R.id.ciudadItem);
                String nombre = esteView.getText().toString();
                String ciudad = esteOtroView.getText().toString();
                Intent intent = new Intent(Adaptador.this,VistaConcreta.class);
                // Guardamos los datos -> Bundle
                Bundle bundle = new Bundle();
                bundle.putString("NOMBRE1", nombre);
                bundle.putString("CIUDAD1", ciudad);
                intent.putExtras(bundle);
                //Lanzamos nuestra actividad
                startActivity(intent);
            }
        });
    }
    public void insertarLugares(){
        lugares.add(new Lugar("mezquita", "Córdoba", "preciosa"));
        lugares.add(new Lugar("mezquita1", "Córdoba1", "preciosa2"));
        lugares.add(new Lugar("mezquita2", "Córdoba2", "preciosa3"));

        ArrayAdaptador adapter = new ArrayAdaptador(this, lugares);
        listView = (ListView) findViewById(R.id.lista);
        listView.setAdapter(adapter);
    }
}
