package com.example.nieves.baloncesto;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Marcador extends AppCompatActivity {
    int puntuacionLocal=0;
    int puntuacionVisitante=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marcador);
        resultado();

        Button btn1L = (Button) findViewById(R.id.unPtoL);
        Button btn2L = (Button) findViewById(R.id.dosPtosL);
        Button btn3L = (Button) findViewById(R.id.tresPtosL);
        Button btn1V = (Button) findViewById(R.id.unPtoV);
        Button btn2V = (Button) findViewById(R.id.dosPtosV);
        Button btn3V = (Button) findViewById(R.id.tresPtosV);
        Button restaL = (Button) findViewById(R.id.restarLocal);
        Button restaV = (Button) findViewById(R.id.restarV);
        Button reset = (Button) findViewById(R.id.reiniciar);
        Button fin = (Button) findViewById(R.id.fin);
        TextView local = (TextView) findViewById(R.id.tituloLocal);
        TextView visitante = (TextView) findViewById(R.id.tituloVisitante);
        Bundle datos = this.getIntent().getExtras();
        local.setText(datos.getString("local"));
        visitante.setText(datos.getString("visitante"));

        btn1L.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                puntuacionLocal++;
                resultado();

            }
        });
        btn2L.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                puntuacionLocal += 2;
                resultado();

            }
        });
        btn3L.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                puntuacionLocal +=3;
                resultado();

            }
        });
        btn1V.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                puntuacionVisitante++;
                resultado();

            }
        });
        btn2V.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                puntuacionVisitante += 2;
                resultado();

            }
        });
        btn3V.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                puntuacionVisitante +=3;
                resultado();

            }
        });
        restaL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                puntuacionLocal--;
                resultado();
            }
        });
        restaV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                puntuacionVisitante--;
                resultado();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmaReinicio();
            }
        });
        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msj = "Resultado:\nVisitante:"+Integer.toString(puntuacionVisitante)+"\nLocal:"+Integer.toString(puntuacionLocal);
                Toast toast =  Toast.makeText(getApplicationContext(),msj,Toast.LENGTH_SHORT);
                toast.show();
                reiniciarPuntuacion();
                resultado();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("puntLocal",puntuacionLocal);
        outState.putInt("puntVisitante",puntuacionVisitante);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        puntuacionLocal = savedInstanceState.getInt("puntLocal");
        puntuacionVisitante = savedInstanceState.getInt("puntVisitante");
        resultado();
    }


    private void confirmaReinicio() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Marcador.this);
        alertDialog.setMessage("¿Deseas reiniciar?");
        alertDialog.setTitle("Reiniciar");
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                reiniciarPuntuacion();
                resultado();
            }
        });

        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which)
            {
            }
        });


        alertDialog.show();
    }

    void reiniciarPuntuacion() {
        puntuacionVisitante=0;
        puntuacionLocal = 0;
    }

    void resultado(){
        TextView tlocal = (TextView) findViewById(R.id.MarcadorLocal);
        TextView tvisitante = (TextView) findViewById(R.id.MarcadorVisitante);
        tlocal.setText(Integer.toString(puntuacionLocal));
        tvisitante.setText(Integer.toString(puntuacionVisitante));
    }
}
