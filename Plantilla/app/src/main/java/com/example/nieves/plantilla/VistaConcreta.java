package com.example.nieves.plantilla;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * Created by nieves on 11/03/18.
 */

public class VistaConcreta extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vistaconcreta);
        TextView tnombre = (TextView) findViewById(R.id.nombrecito);
        TextView tCiudad = (TextView) findViewById(R.id.ciudadela);
        // Extraemos datos del bundle
        Bundle bundle = this.getIntent().getExtras();
        tnombre.setText(bundle.getString("NOMBRE1"));
        tCiudad.setText(bundle.getString("CIUDAD1"));
    }
}
