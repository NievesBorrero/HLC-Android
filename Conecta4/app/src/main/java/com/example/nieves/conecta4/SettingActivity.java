package com.example.nieves.conecta4;

import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;

/**
 * Created by nieves on 11/03/18.
 */

public class SettingActivity extends PreferenceActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if( Build.VERSION.SDK_INT == 11 )
            addPreferencesFromResource(R.xml.preferences);
        else
            getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingFragment()).commit();
    }
    public static class SettingFragment extends PreferenceFragment {
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }

    }
}
