package com.example.nieves.botones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    TextView vtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vtext= (TextView) findViewById(R.id.text);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener (new Button.OnClickListener(){
            public void onClick(View v){
                TextView myTextView = (TextView) findViewById(R.id.text);
                myTextView.setText("Botón pulsado, bravo!");
            }
        });

        button.setOnLongClickListener(new Button.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                TextView myTextView = (TextView) findViewById(R.id.text);
                myTextView.setText("largo!");
                return false;
            }
        });
    }




}
