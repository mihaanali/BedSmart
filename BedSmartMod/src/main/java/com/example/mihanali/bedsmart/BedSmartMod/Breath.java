package com.example.mihanali.bedsmart.BedSmartMod;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Breath extends AppCompatActivity {
    ListView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        Bundle bundle = getIntent().getExtras();

        tv = (ListView)findViewById(R.id.listview);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        String datetime = dateformat.format(c.getTime());
        System.out.println(datetime);
        Log.d("Date",datetime);
        //String dt="2018-12-04";
        BreathTask yr= new BreathTask(Breath.this,tv,datetime);

        yr.doInBackground();
        yr.onPostExecute("DONE SUCCESSFULLY");


    }
}
