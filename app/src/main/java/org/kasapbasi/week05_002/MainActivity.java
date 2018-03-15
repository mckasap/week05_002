package org.kasapbasi.week05_002;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn;

     class myClickHandler implements View.OnClickListener{

         @Override
         public void onClick(View view) {

             Intent myInt= new Intent(MainActivity.this,MySettings.class);
             startActivity(myInt);
         }
     }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button) findViewById(R.id.btnSettings);

        btn.setOnClickListener(new myClickHandler());

    }

    /**
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are <em>not</em> resumed.  This means
     * that in some cases the previous state may still be saved, not allowing
     * fragment transactions that modify the state.  To correctly interact
     * with fragments in their proper state, you should instead override
     * {@link #onResumeFragments()}.
     */
    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        boolean first=pref.getBoolean("first",false);
        boolean second=pref.getBoolean("second",false);
        View someView = findViewById(R.id.btnSettings);
        // Find the root view
        View root = someView.getRootView();
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
