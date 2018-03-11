package com.example.nieves.conecta4;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by nieves on 11/01/18.
 */

public class PreferenciasFragment extends PreferenceFragment {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
