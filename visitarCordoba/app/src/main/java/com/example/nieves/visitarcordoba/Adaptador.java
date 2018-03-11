package com.example.nieves.visitarcordoba;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nieves on 4/02/18.
 */

public class Adaptador extends ArrayAdapter {
    ArrayList<Place> places;
    int layoutIdView;
    Context context;

    public Adaptador(@NonNull Context context, ArrayList<Place> sites) {
        super(context, 0, sites);
         places = sites;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }
        Place place = places.get(position);
        TextView tittle = convertView.findViewById(R.id.titulo);
        TextView subtittle = convertView.findViewById(R.id.subtitulo);
        TextView direccion = convertView.findViewById(R.id.direccion);
        ImageView image = convertView.findViewById(R.id.image);

        tittle.setText(place.titulo);
        direccion.setText(place.direccion);
        subtittle.setText(place.subtitulo);
        image.setImageDrawable(place.idImagen);

        return convertView;
    }
}
