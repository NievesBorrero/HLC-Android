package com.example.nieves.plantilla;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by nieves on 11/03/18.
 */

public class Add extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Con qué layout se va a referenciar
        setContentView(R.layout.add);
        TextView viewNombre = (TextView) findViewById(R.id.nombre);
        TextView viewCiudad = (TextView) findViewById(R.id.ciudad);
        TextView viewDescripcion = (TextView) findViewById(R.id.descripcion);
        final EditText Enombre = (EditText) findViewById(R.id.inputNombre);
        final EditText Eciudad = (EditText) findViewById(R.id.inputCiudad);
        final EditText Edescripcion = (EditText) findViewById(R.id.inputDescripcion);
        Button btn = (Button) findViewById(R.id.btnAdd);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = Enombre.getText().toString();
                String ciudad = Eciudad.getText().toString();
                String descripcion = Edescripcion.getText().toString();
                //
                Intent intent = new Intent(Add.this,Confirmar.class);
                // Guardamos los datos -> Bundle
                Bundle bundle = new Bundle();
                bundle.putString("NOMBRE", nombre);
                bundle.putString("CIUDAD", ciudad);
                bundle.putString("DESCRIPCION", descripcion);
                intent.putExtras(bundle);
                //Lanzamos nuestra actividad
                startActivity(intent);
            }
        });
    }
}
