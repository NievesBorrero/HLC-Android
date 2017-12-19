package com.example.nieves.conecta4;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class splash extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView img = (ImageView) findViewById(R.id.imagenLogo);
        img.setOnClickListener(this);
/* Para que empiece tras 4 segundos
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run(){
                Intent intent = new Intent(splash.this, MainActivity.class);
                startActivity(intent);
            }
        }, 4000);

*/


    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(splash.this, MainActivity.class);
        startActivity(intent);
    }
}
