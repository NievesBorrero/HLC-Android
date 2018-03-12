package com.example.nieves.examennieves;

/**
 * Created by nieves on 12/03/18.
 */

public class Game {
    private char[][] tablero = new char[10][10];
    private final String arrayLetras = "abcdefghijklmnopqrstvwxyz";
    private Capital[] capitales = new Capital[5];

    public Game(){
        colocarLetras();
        generarCiudades();
        ubicarCiudades();
    }


    private void colocarLetras (){
        for(int i = 0; i < 10; i++){
            for(int j= 0; j<10;j++){
                int aleatorio = (int)Math.floor(Math.random()*(24-0)+0);
                tablero[i] [j] = arrayLetras.charAt(aleatorio);
            }
        }
    }
    private void generarCiudades(){
        capitales[0] = new Capital("roma");
        capitales[1] = new Capital("jaen");
        capitales[2] = new Capital("pisa");
        capitales[3] = new Capital("viena");
        capitales[4] = new Capital("palo");

    }


    private void ubicarCiudades(){
        capitales[0].colocarPalabraCiudad(0,0,0,3);
        capitales[1].colocarPalabraCiudad(2,2,1,7);
        capitales[2].colocarPalabraCiudad(4,4,0,3);
        capitales[3].colocarPalabraCiudad(6,6,0,3);
        capitales[4].colocarPalabraCiudad(8,8,2,6);


        for (int i =0; i< capitales.length; i++){
            for (int j =0; j< capitales[i].getCapital().length(); j++){
                tablero[i][j] = capitales[i].getCapital().charAt(j);
            }
        }

    }

    public char getLetra(int fila, int columna){
        return tablero[fila][columna];
    }
}
