package com.example.nieves.conecta4;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class splash extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView img = (ImageView) findViewById(R.id.imagenLogo);
        Button btnOnline = (Button) findViewById(R.id.btnonline);
        Button btnOffline = (Button) findViewById(R.id.btnOffline);
/* Para que empiece tras 4 segundos
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run(){
                Intent intent = new Intent(splash.this, MainActivity.class);
                startActivity(intent);
            }
        }, 4000);

*/
    btnOnline.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(splash.this, InterfazOnline.class));
        }
    });

    btnOffline.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(splash.this, MainActivity.class));
        }
        });


    }



    @Override
    public void onClick(View view) {
        Intent intent = new Intent(splash.this, MainActivity.class);
        startActivity(intent);
    }
}
