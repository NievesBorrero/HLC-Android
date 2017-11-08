package com.example.nieves.calculadora2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    // QUEDA: las comas en decimales y +/-
    double operando1=0;
    double operando2=0;
    boolean suma,resta,divide,multiplica = false;
    EditText textResult;
    TextView textCuentas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* Botones numericos*/
        final Button btn0 = (Button) findViewById(R.id.btn0);
        final Button btn1 = (Button) findViewById(R.id.btn1);
        final Button btn2 = (Button) findViewById(R.id.btn2);
        final Button btn3 = (Button) findViewById(R.id.btn3);
        final Button btn4 = (Button) findViewById(R.id.btn4);
        final Button btn5 = (Button) findViewById(R.id.btn5);
        final Button btn6 = (Button) findViewById(R.id.btn6);
        final Button btn7 = (Button) findViewById(R.id.btn7);
        final Button btn8 = (Button) findViewById(R.id.btn8);
        final Button btn9 = (Button) findViewById(R.id.btn9);
        textResult = (EditText) findViewById(R.id.result);
        textResult.setEnabled(false);
        textCuentas = (TextView) findViewById(R.id.cuentas);
        /* Botones de operaciones aritmeticas */
        Button btnMas = (Button) findViewById(R.id.btnMas);
        Button btnMenos = (Button) findViewById(R.id.btnMenos);
        Button btnMul = (Button) findViewById(R.id.btnMul);
        Button btnDiv = (Button) findViewById(R.id.btnDiv);

        /* Otros Botones */
        Button btnC = (Button) findViewById(R.id.btnC);
        Button btnIgual = (Button) findViewById(R.id.btnIgual);
        Button btnSigno = (Button) findViewById(R.id.signo);
        final Button btnDec = (Button) findViewById(R.id.btnDec);

        /* Eventos otros botones */

        btnSigno.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                textResult.setText(textResult.getText()+" -");
            }

        });

        btnIgual.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(!esOperandoUno()){
                    textResult.setText(Double.toString(realizarOperacion()));
                }
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textCuentas.setText("0");
                textResult.setText("0");
                operando1= operando2 = 0;
            }
        });

        /* Eventos botones operaciones aritméticas */

        btnMas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(esOperandoUno()){
                    suma = true;
                    textCuentas.setText(textCuentas.getText()+" + ");
                } else {
                    suma = true;
                    textCuentas.setText(Double.toString(realizarOperacion())+" + ");
                }
            }
        });

        btnMenos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(esOperandoUno()){
                    resta = true;
                    textCuentas.setText(textCuentas.getText()+" - ");
                } else {
                    resta = true;
                    textCuentas.setText(Double.toString(realizarOperacion())+" - ");
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(esOperandoUno()){
                    multiplica = true;
                    textCuentas.setText(textCuentas.getText()+" x ");
                } else {
                    multiplica = true;
                    textCuentas.setText(Double.toString(realizarOperacion())+" x ");
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(esOperandoUno()){
                    divide = true;
                    textCuentas.setText(textCuentas.getText()+" / ");
                } else {
                    divide = true;
                    textCuentas.setText(Double.toString(realizarOperacion())+"/");
                }

            }
        });

        btn0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                addNum(btn0, textCuentas);
            }
        });

        /* Eventos botones con números */
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                addNum(btn1, textCuentas);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNum(btn2, textCuentas);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNum(btn3, textCuentas);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNum(btn4, textCuentas);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNum(btn5, textCuentas);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNum(btn6, textCuentas);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNum(btn7, textCuentas);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNum(btn8, textCuentas);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNum(btn9, textCuentas);
            }
        });

        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNum(btnDec, textCuentas);
            }
        });
    }

    /**
     * Recoge el valor del boton pulsado, comprueba qué operando es y lo guarda.
     *
     * @param boton
     * @param textCuentas
     */
    private void addNum(Button boton, TextView textCuentas) {
        if(esOperandoUno()){
           
                String valorUno;
                if (operando1 == 0) {
                    valorUno = boton.getText().toString();
                } else {
                    valorUno = Double.toString(operando1) + boton.getText().toString();
                }
                operando1 = Integer.parseInt(valorUno);
                textCuentas.setText(valorUno);
            
        }else{
          
                String valorDos;
                if (operando2 == 0) {
                    valorDos = boton.getText().toString();
                } else {
                    valorDos = Double.toString(operando1) + boton.getText().toString();
                }
                operando2 = Integer.parseInt(valorDos);
                textCuentas.setText(textCuentas.getText()+valorDos);
            
        }
    }

    /*
    * Comprueba si es la primera coma.
    * @param operando (int)
    * @return operando (int)
    */
    private boolean esPrimeraComa(int operando) {
        String num = Integer.toString(operando);
        Pattern patron = Pattern.compile(",");
        Matcher matcher = patron.matcher(num);
        return matcher.matches();
    }

    /**
     * Realiza la operación correspondiente
     * @return resultado (double)
     */

    private double realizarOperacion(){
        double resultado=0;
        if(suma)
            resultado= sumar(operando1, operando2);
        if(resta)
            resultado= restar(operando1, operando2);
        if(multiplica)
            resultado= multiplicar(operando1, operando2);
        if(divide)
            resultado= dividir(operando1, operando2);

        operando1 = resultado;
        operando2= 0;

        return resultado;

    }

    /**
     * Realiza una suma
     * @param operando1
     * @param operando2
     * @return resultado (double)
     */
    private double sumar(double operando1, double operando2){
        suma = false;
        return operando1+operando2;
    }

    /**
     * Realiza una resta
     * @param operando1
     * @param operando2
     * @return resultado (double)
     */
    private double restar(double operando1, double operando2){
        resta= false;
        return operando1 - operando2;
    }

    /**
     * Realiza una multiplicación
     * @param operando1
     * @param operando2
     * @return resultado (double)
     */
    private double multiplicar(double operando1, double operando2){
        multiplica = false;
        return operando1 * operando2;
    }

    /**
     * Realiza una división
     * @param operando1
     * @param operando2
     * @return resultado (double)
     */
    private double dividir(double operando1, double operando2){
        divide = false;
        return operando1/operando2;
    }


    /**
     * Comprueba si es el primer operando
     * @return true o false
     */
    private boolean esOperandoUno() {
        return suma == false && resta == false && divide == false && multiplica== false;
    }
}
