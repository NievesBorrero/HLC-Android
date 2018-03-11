package com.example.nieves.visitarcordoba;

import android.graphics.drawable.Drawable;

/**
 * Created by nieves on 25/01/18.
 */

public class Place {
    String titulo;
    String subtitulo;
    String direccion;
    Drawable idImagen;

    public Place(String titulo, String subtitulo, String direccion, Drawable idImagen){
        this.titulo = titulo;
        this.idImagen = idImagen;
        this.subtitulo = subtitulo;
        this.direccion = direccion;
    }
}
