package com.example.nieves.conecta4;

/**
 * Created by nieves on 15/11/17.
 */

public class Game {
    static final int N_FILAS=6;
    static final int N_COLUMNAS=7;
    int[][] tablero;
    static final int VACIO=0;
    static final int MAQUINA=1;
    static final int HUMANO=2;

    private char estado;

    private int turno= HUMANO;

    public Game(int jugador){
        tablero = new int[N_FILAS][N_COLUMNAS];
        setTurno(jugador);
        crearTablero();
        setEstado('J');
    }

    private void crearTablero(){
        for (int i= 0; i<N_FILAS; i++){
            for(int j=0; j<N_COLUMNAS;j++){
                tablero[i][j]=VACIO;
            }
        }
    }

    /**
     * Busca dónde va a caer la ficha
     * @param column
     * @return
     */
    private int rowSelect(int column){
        int i = N_FILAS-1;
        int row = -1;
        boolean select = false;
        while(i>=0 && !select){
            if(tablero[i][column]== VACIO){
                row = i;
                select=true;
            }
            i--;
        }
        return row;
    }

    public void changeTurn(){
        setTurno(getTurno()==MAQUINA ? HUMANO:MAQUINA);
    }

    /**
     * Coloca la ficha si puede
     * @param column
     * @return
     */
    public boolean colocarFicha(int column){
        boolean estaColocada = false;
        if(tablero[rowSelect(column)][column]==VACIO){
            tablero[rowSelect(column)][column]=getTurno();
            estaColocada=true;
        }
        return estaColocada;
    }

    boolean isFull(int column){
        if(tablero[0][column]!=VACIO)
            return true;
        return false;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
}
