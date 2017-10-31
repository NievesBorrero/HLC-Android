package com.example.nieves.calculadora;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.input1);
        et2 = (EditText)findViewById(R.id.input2);

        Button buttonS = (Button) findViewById(R.id.buttonS);
        /**
         * Al pulsar el botón suma, se suman los valores
         */
        buttonS.setOnClickListener (new Button.OnClickListener(){
            public void onClick(View v){
                TextView myTextView = (TextView) findViewById(R.id.resultado);
                double num1= Double.parseDouble(et1.getText().toString());
                double num2= Double.parseDouble(et2.getText().toString());
                myTextView.setText(" "+(num1+num2));
            }
        });
        /**
         * Al pulsar el botón resta, se restan los valores
         */
        Button buttonR = (Button) findViewById(R.id.buttonR);
        buttonR.setOnClickListener (new Button.OnClickListener(){
            public void onClick(View v){
                TextView myTextView = (TextView) findViewById(R.id.resultado);
                double num1= Double.parseDouble(et1.getText().toString());
                double num2= Double.parseDouble(et2.getText().toString());
                myTextView.setText(" "+(num1-num2));
            }
        });

        /**
         * Al pulsar el botón resta, se multiplican los valores
         */
        Button buttonM = (Button) findViewById(R.id.buttonM);
        buttonM.setOnClickListener (new Button.OnClickListener(){
            public void onClick(View v){
                TextView myTextView = (TextView) findViewById(R.id.resultado);
                double num1= Double.parseDouble(et1.getText().toString());
                double num2= Double.parseDouble(et2.getText().toString());
                myTextView.setText(" "+(num1*num2));
            }
        });

        /**
         * Al pulsar el botón resta, se dividen los valores
         */
        Button buttonD = (Button) findViewById(R.id.buttonD);
        buttonD.setOnClickListener (new Button.OnClickListener(){
            public void onClick(View v){
                TextView myTextView = (TextView) findViewById(R.id.resultado);
                double num1= Double.parseDouble(et1.getText().toString());
                double num2= Double.parseDouble(et2.getText().toString());
                myTextView.setText(" "+(num1/num2));
            }
        });


    }
}


