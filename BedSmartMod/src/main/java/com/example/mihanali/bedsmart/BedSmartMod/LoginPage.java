package com.example.mihanali.bedsmart.BedSmartMod;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.lang.*;

public class LoginPage extends AppCompatActivity {

    private EditText uid;
    private EditText pword;

    private Button log;
    private int counter=5;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        uid=(EditText) findViewById(R.id.usid);
        pword=(EditText) findViewById(R.id.pword);

        log=(Button) findViewById(R.id.login);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    validate(uid.getText().toString(),pword.getText().toString());
                }

        });
    }

    private void validate(String name,String pword){
        if((name.equals("admin")) && (pword .equals("1234"))){
            Intent in=new Intent(LoginPage.this, MainActivity.class);
            startActivity(in);

        }

    }
}
