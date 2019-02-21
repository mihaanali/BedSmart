package com.example.mihanali.bedsmart.BedSmartMod;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1c2833")));

    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
    public void showHeart(View view) {
        displayToast(getString(R.string.firstopt));
        Intent intent = new Intent(MainActivity.this, Heart.class);
        startActivity(intent);
    }
    public void showTemp(View view) {
        displayToast(getString(R.string.secondopt));

            Intent intent = new Intent(MainActivity.this, Temp.class);
            startActivity(intent);


    }
    public void showBreath(View view) {
        displayToast(getString(R.string.thirdopt));
        Intent intent = new Intent(MainActivity.this, Breath.class);
        startActivity(intent);

    }


}

