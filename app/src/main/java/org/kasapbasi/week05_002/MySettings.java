package org.kasapbasi.week05_002;

import android.content.SharedPreferences;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MySettings extends AppCompatPreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_my_settings);
        addPreferencesFromResource(R.xml.prefs);

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        boolean first=pref.getBoolean("first",false);
        boolean second=pref.getBoolean("second",false);
      //  View someView =  findViewById(R.id.btnSettings);
        // Find the root view
        View root = getWindow().getDecorView();
        // Set the color

        if(first) {
            root.setBackgroundColor(getResources().getColor(android.R.color.background_dark));
            Toast.makeText(this, " \"First\" clicked", Toast.LENGTH_LONG).show();
        }
        else
            root.setBackgroundColor(getResources().getColor(android.R.color.background_light));

        if(second)
            Toast.makeText(this, " \"Second\" clicked",Toast.LENGTH_LONG).show();

    }
}
