package com.example.clicker;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by wenxinchen on 17/3/17.
 */

public class main extends AppCompatActivity {

    String name;
    TextView uname;
    public final static String EXTRA_MESSAGE = "com.example.clicker.MESSAGE";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Intent intent = getIntent();
       name = intent.getStringExtra(loginReg.EXTRA_MESSAGE);

        uname=(TextView) findViewById(R.id.txtuname);
        uname.setText("Username: "+name);

    }
    public void btnStartHandler(View v){
        Intent intent = new Intent(this,index.class);// Retrieve the string entered in the EditView 
        intent.putExtra(EXTRA_MESSAGE, name);
        startActivity(intent);
    }
    public void btnBackHandler(View v){
        Intent intent = new Intent(this,loginReg.class);// Retrieve the string entered in the EditView 
        startActivity(intent);
    }







}
