package com.example.nieves.plantilla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Animación -> la creamos en la carpeta animación
        ImageButton imgbtn = (ImageButton) findViewById(R.id.imagenInicial);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.inicial);
        imgbtn.startAnimation(animation);
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Vamos a iniciar una actividad de esta ventana a la otra...
                // Esa segunda actividad tiene que reflejarse en el androidManifest
                startActivity(new Intent(MainActivity.this, Segunda.class));
            }
        });
    }
}
