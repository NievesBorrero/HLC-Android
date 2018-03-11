package com.example.nieves.plantilla;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by nieves on 11/03/18.
 */

public class Confirmar extends Activity {
    TextView tnombre;
    TextView tCiudad;
    TextView tDesc;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmar);
        tnombre = (TextView) findViewById(R.id.name);
        tCiudad = (TextView) findViewById(R.id.city);
        tDesc = (TextView) findViewById(R.id.desc);
        // Extraemos datos del bundle
        Bundle bundle = this.getIntent().getExtras();
        tnombre.setText(bundle.getString("NOMBRE"));
        tCiudad.setText(bundle.getString("CIUDAD"));
        tDesc.setText(bundle.getString("DESCRIPCION"));
        // Toast
        Toast.makeText(getApplicationContext(), "Todo guay", Toast.LENGTH_SHORT).show();

    }

    // Para que no se pierdan los datos al girar la pantalla (aunque aquí no hace falta)


    @Override
    protected void onSaveInstanceState(Bundle guardarInfo) {
        super.onSaveInstanceState(guardarInfo);
        guardarInfo.putString("NOMBRE", tnombre.getText().toString());
        guardarInfo.putString("CIUDAD", tCiudad.getText().toString());
        guardarInfo.putString("DESCRIPCION", tDesc.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle recuperarInfo) {
        super.onRestoreInstanceState(recuperarInfo);
        tnombre.setText(recuperarInfo.getString("NOMBRE"));
        tCiudad.setText(recuperarInfo.getString("CIUDAD"));
        tDesc.setText(recuperarInfo.getString(("DESCRIPCION")));

    }
}
