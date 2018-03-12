package com.example.nieves.baloncesto;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText tituloLocal;
    private EditText tituloVisitante;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        tituloLocal = (EditText) findViewById(R.id.nombreLocal);
        tituloVisitante = (EditText) findViewById(R.id.nombreVisitante);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Marcador.class);
                intent.putExtra("local", tituloLocal.getText().toString());
                intent.putExtra("visitante",tituloVisitante.getText().toString());
                startActivity(intent);
            }
        });
    }
}
