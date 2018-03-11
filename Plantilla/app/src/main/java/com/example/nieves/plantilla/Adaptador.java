package com.example.nieves.plantilla;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by nieves on 11/03/18.
 */

public class Adaptador extends Activity {
    ArrayList<Lugar> lugares = new ArrayList<>();
    ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemlist);
        insertarLugares();
    }
    public void insertarLugares(){
        lugares.add(new Lugar("mezquita", "Córdoba", "preciosa"));
        lugares.add(new Lugar("mezquita1", "Córdoba1", "preciosa2"));
        lugares.add(new Lugar("mezquita2", "Córdoba2", "preciosa3"));

        ArrayAdaptador adapter = new ArrayAdaptador(this, lugares);
        listView = (ListView) findViewById(R.id.lista);
        listView.setAdapter(adapter);
    }
}
