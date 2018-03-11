package com.example.nieves.plantilla;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by nieves on 11/03/18.
 */
// Tengo que decirle que herede de activity
public class Segunda extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Con qué layout se va a referenciar
        setContentView(R.layout.segunda);
        Button btnadd = (Button) findViewById(R.id.add);
        Button btnShow = (Button) findViewById(R.id.show);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Segunda.this, Add.class));
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Segunda.this, Adaptador.class));
            }
        });
    }
}
