package com.example.nieves.examennieves;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;

/**
 * Created by nieves on 12/03/18.
 */

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Sopa extends AppCompatActivity implements View.OnClickListener {
    Game game = new Game();
    private ImageButton letraImage;
    Boolean click2 = false;
    private final int ids[][] =
            {{R.id.a1,R.id.a2,R.id.a3,R.id.a4,R.id.a5,R.id.a6,R.id.a7,R.id.a8,R.id.a9,R.id.a10},
                    {R.id.b1,R.id.b2,R.id.b3,R.id.b4,R.id.b5,R.id.b6,R.id.b7,R.id.b8,R.id.b9,R.id.b10},
                    {R.id.c1,R.id.c2,R.id.c3,R.id.a4,R.id.c5,R.id.c6,R.id.c7,R.id.c8,R.id.c9,R.id.c10},
                    {R.id.d1,R.id.d2,R.id.d3,R.id.d4,R.id.d5,R.id.d6,R.id.d7,R.id.d8,R.id.d9,R.id.d10},
                    {R.id.e1,R.id.e2,R.id.e3,R.id.e4,R.id.e5,R.id.e6,R.id.e7,R.id.e8,R.id.e9,R.id.e10},
                    {R.id.f1,R.id.f2,R.id.f3,R.id.f4,R.id.f5,R.id.f6,R.id.f7,R.id.f8,R.id.f9,R.id.f10},
                    {R.id.g1,R.id.g2,R.id.g3,R.id.g4,R.id.g5,R.id.g6,R.id.g7,R.id.g8,R.id.g9,R.id.g10},
                    {R.id.h1,R.id.h2,R.id.h3,R.id.h4,R.id.h5,R.id.h6,R.id.h7,R.id.h8,R.id.h9,R.id.h10},
                    {R.id.i1,R.id.i2,R.id.i3,R.id.i4,R.id.i5,R.id.i6,R.id.i7,R.id.g8,R.id.i9,R.id.i10},
                    {R.id.j1,R.id.j2,R.id.j3,R.id.j4,R.id.j5,R.id.j6,R.id.j7,R.id.j8,R.id.j9,R.id.j10}};
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sopa);
        for(int i = 0; i< 10;  i++){
            for (int j = 0; j < 10;  j++){
                letraImage = (ImageButton) findViewById(ids[i][j]);
                char letra = game.getLetra(i,j);
                letraImage.setImageDrawable(getDrawable(putImage(letra)));
                letraImage.setOnClickListener(this);
            }
        }
    }

    private int putImage(char letra) {
        switch (letra){
            case 'a': return R.drawable.a;
            case 'b': return R.drawable.b;
            case 'c': return R.drawable.c;
            case 'd': return R.drawable.d;
            case 'e': return R.drawable.e;
            case 'f': return R.drawable.f;
            case 'g': return R.drawable.g;
            case 'h': return R.drawable.h;
            case 'i': return R.drawable.i;
            case 'j': return R.drawable.j;
            case 'k': return R.drawable.k;
            case 'l': return R.drawable.l;
            case 'm': return R.drawable.m;
            case 'n': return R.drawable.n;
            case 'o': return R.drawable.o;
            case 'p': return R.drawable.p;
            case 'q': return R.drawable.q;
            case 'r': return R.drawable.r;
            case 's': return R.drawable.s;
            case 't': return R.drawable.t;
            case 'v': return R.drawable.v;
            case 'w': return R.drawable.w;
            case 'x': return R.drawable.x;
            case 'y': return R.drawable.y;
            case 'z': return R.drawable.z;
        }
        return R.drawable.z;
    }

    private void comprobar() {
        boolean coincide = false;
        if(coincide){
            Toast.makeText(getApplicationContext(),"Encontraste una palabra", Toast.LENGTH_SHORT);
        }else{
            Toast.makeText(getApplicationContext(),"No has acertado",Toast.LENGTH_SHORT);
        }
    }


    private void recogerFinalPalabra(View view) {
        comprobar();
    }


    @Override
    public void onClick(View view) {
        String mensaje ="";

        if(!click2){
            click2 = true;
            mensaje = "click 1";
            // recoger el inicio
        }else{
            click2 = false;
            mensaje ="click 2";
            recogerFinalPalabra(view);
        }
        Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
    }



}
