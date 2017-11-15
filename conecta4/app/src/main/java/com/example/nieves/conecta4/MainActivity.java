package com.example.nieves.conecta4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Game game;
    ImageView f0c0 = (ImageView) findViewById(R.id.f0c0);
    int[][] ids = {
            {R.id.f0c0, R.id.f0c1, R.id.f0c2, R.id.f0c3, R.id.f0c4, R.id.f0c5, R.id.f0c6},
            {R.id.f1c0, R.id.f1c1, R.id.f1c2, R.id.f1c3, R.id.f1c4, R.id.f1c5, R.id.f1c6},
            {R.id.f2c0, R.id.f2c1, R.id.f2c2, R.id.f2c3, R.id.f2c4, R.id.f2c5, R.id.f2c6},
            {R.id.f3c0, R.id.f3c1, R.id.f3c2, R.id.f3c3, R.id.f3c4, R.id.f3c5, R.id.f3c6},
            {R.id.f4c0, R.id.f4c1, R.id.f4c2, R.id.f4c3, R.id.f4c4, R.id.f4c5, R.id.f4c6},
            {R.id.f5c0, R.id.f5c1, R.id.f5c2, R.id.f5c3, R.id.f5c4, R.id.f5c5, R.id.f5c6}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game(1);

    }


    public void pulsado(View v){
        ImageView imageView = (ImageView) v;
        int row=0, column=0;
        switch(game.getEstado()){
            case 'J': procesaJugada(row, column); break;
            case 'T': ; break; // partida terminada, mensajito etc
            default:break;
        }
    }

    private void procesaJugada(int row, int column){
        if(game.isFull(column)){
            Toast toast = Toast.makeText(getApplicationContext(),"columna completa",Toast.LENGTH_LONG);
        }else{
            game.colocarFicha(column);
            dibujarFicha(row, column);
            game.changeTurn();
        }
    }

    /*
    * Cambia el src del drawable en esa posición.
     */
    private void dibujarFicha(int row, int column){
        int id = ids[row][column];
        ImageView ficha = (ImageView) findViewById(id);
        if(game.getTurno()==game.HUMANO)
            ficha.setImageResource(R.drawable.fichaazul);
        else
            ficha.setImageResource(R.drawable.ficharoja);
    }


}
