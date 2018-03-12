package com.example.nieves.examennieves;

/**
 * Created by nieves on 12/03/18.
 */

public class Capital {
    private int filaInicial;
    private int columnaInicial;
    private int filaFinal;
    private int columnaFinal;
    private String capital;

    public Capital (String nombre){
        this.capital = nombre;
    }

    public int getSize(){
        return capital.length();
    }
    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getFilaInicial() {
        return filaInicial;
    }

    public void setFilaInicial(int filaInicial) {
        this.filaInicial = filaInicial;
    }

    public int getColumnaInicial() {
        return columnaInicial;
    }

    public void setColumnaInicial(int columnaInicial) {
        this.columnaInicial = columnaInicial;
    }

    public void setFilaFinal(int filaFinal) {
        this.filaFinal = filaFinal;
    }

    public void setColumnaFinal(int columnaFinal) {
        this.columnaFinal = columnaFinal;
    }

    public void colocarPalabraCiudad(int fi, int ff, int ci, int cf) {
        this.setFilaFinal(fi);
        this.setFilaFinal(ff);
        this.setColumnaInicial(ci);
        this.setColumnaFinal(cf);
    }
}
