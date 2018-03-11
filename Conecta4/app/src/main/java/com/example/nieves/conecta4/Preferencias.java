package com.example.nieves.conecta4;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

/**
 * Created by nieves on 11/03/18.
 */

public class Preferencias extends Activity {
    private static final String SHOW_EXIT_DIALOG = "SHOW_EXIT_DIALOG";
    private static final boolean SHOW_EXIT_DIALOG_DEF = true;
    public final static String PLAY_MUSIC_KEY = "music";
    public final static boolean PLAY_MUSIC_DEFAULT = true;
    public final static String PLAYER_KEY = "playerName";
    public final static String PLAYER_DEFAULT = "";

    public final static String COLORES_KEY = "color_list";
    public final static String COLORES_DEFAULT = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefs_void);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.content, new PreferenciasFragment());

        ft.commit();
    }
    /**
     *
     * @param context
     * @return
     */
    static boolean getShowCloseDialogPreference(Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getBoolean(SHOW_EXIT_DIALOG, SHOW_EXIT_DIALOG_DEF);
    }

    /**
     *  Situamos la clase del fragmento de preferencias internamente a la actividad
     *  de preferencias para evitar tener demasiados ficheros.
     *
     */
    public static class PrefFragment extends PreferenciasFragment {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            addPreferencesFromResource(R.xml.preferences);
        }

    }
}