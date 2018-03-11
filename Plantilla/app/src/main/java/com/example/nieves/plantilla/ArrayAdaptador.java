package com.example.nieves.plantilla;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nieves on 11/03/18.
 */

public class ArrayAdaptador extends ArrayAdapter {
    //Campos de la clase
    ArrayList<Lugar> lugares;
    int r_layout_id_view;
    Context contexto;
    public ArrayAdaptador(Context contexto, ArrayList sitios) {
        super(contexto, 0, sitios);
        lugares = sitios;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }
        Lugar lugar = lugares.get(position);
        TextView titulo = view.findViewById(R.id.nombreItem);
        TextView ciudad = view.findViewById(R.id.ciudadItem);
        TextView desc = view.findViewById(R.id.descItem);
        titulo.setText(lugar.nombre);
        ciudad.setText(lugar.ciudad);
        desc.setText(lugar.descripcion);

        return view;

    }
}
