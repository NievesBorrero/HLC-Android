package com.example.nieves.visitarcordoba;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Place> datos = new ArrayList<Place>();
    ListView listView;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        insertElements();

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        TextView tview = (TextView) view.findViewById(R.id.subtitulo);
                        Toast toast = Toast.makeText(getApplicationContext(), tview.getText().toString(), Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
        );
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void insertElements() {
        datos.add(new Place("Mezquita-Catedral", "Crisol de culturas", "Calle Cardenal Herrero, 1", getDrawable(R.drawable.mezquita)));
        datos.add(new Place("Palacio de Viana", "Belleza en cada rincón","Plaza de Don Gome, 2", getDrawable(R.drawable.viana)));
        datos.add(new Place("Zoco Municipal", "Artesanía típica de Córdoba","Calle Judíos, s/n", getDrawable(R.drawable.zoco)));
        datos.add(new Place("Cervezas Califa", "Cerveza artesana de Córdoba", "Calle Juan Valera, 3",getDrawable(R.drawable.califa)));
        datos.add(new Place("Alcázar de los Reyes Católicos", "Arte e Historia", " Plaza Campo Santo de los Mártires, s/n",getDrawable(R.drawable.alcazar)));
        Adaptador adaptador = new Adaptador(this,datos);
        listView = (ListView) findViewById(R.id.listaElementos);
        listView.setAdapter(adaptador);
    }


}
