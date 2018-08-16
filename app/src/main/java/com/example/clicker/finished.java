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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.net.Uri;

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

public class finished extends AppCompatActivity {

    String name, email, commentstring, url,urlcomment,task,timePush;

    TextView uname;
    long time, endtime,period;
    Chronometer clkend;
    EditText emailaddress, commenttxt;
    Context conx = this;
    Button btncomment,btnend;

    public final static String EXTRA_MESSAGE = "com.example.clicker.MESSAGE";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished);
        Intent intent = getIntent();
        name = intent.getStringExtra(index.EXTRA_MESSAGE);
        time = intent.getLongExtra(index.EXTRA_TIME, time);


        uname = (TextView) findViewById(R.id.txtuname);
        uname.setText("Username: " + name);
        clkend = (Chronometer) findViewById(R.id.chronometerEnd);
        clkend.setBase(time + SystemClock.elapsedRealtime());

        clkend.start();
        emailaddress = (EditText) findViewById(R.id.email);
        commenttxt = (EditText) findViewById(R.id.txtcomment);
        btncomment=(Button) findViewById(R.id.btnComment);
        btnend=(Button) findViewById(R.id.btnEnd);

    }

    public void btnEndHandler(View v) {

        clkend.stop();
        endtime = clkend.getBase();
        period= SystemClock.elapsedRealtime() - clkend.getBase();

        int hours = (int) (period / 3600000);
        int minutes = (int) (period - hours * 3600000) / 60000;
        int seconds = (int) (period - hours * 3600000 - minutes * 60000) / 1000;
        timePush= hours+":"+minutes+":"+seconds;
        task="end";
        url = "http://10.27.18.219:9999/Clicker/quiz?name="+name+"&period="+timePush;
        //  url = "http://192.168.0.102:9999/Clicker/quiz?name="+name+"&period="+timePush;

        new finished.HttpTask().execute(url);
        btnend.setEnabled(false);
        //endtime
    }

    public void btnCommentHandler(View view) {
        commentstring = commenttxt.getText().toString();
        task="comment";
        urlcomment = "http://10.27.18.219:9999/Clicker/comment?name="+name+"&comment="+commentstring;
       // urlcomment = "http://192.168.0.102:9999/Clicker/comment?name="+name+"&comment="+commentstring;

        if(commentstring.equals("")){Toast.makeText(conx,"Please enter comment", Toast.LENGTH_LONG).show();
        }else{
        new finished.HttpTask().execute(urlcomment);
        }
    }


    public void btnEmailHandler(View v) {
        email = emailaddress.getText().toString();
        //Toast.makeText(this, "send to server and write a email servlet", Toast.LENGTH_LONG).show();
        String[] TO = {email};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);

        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "*Clicker*Let your friend to do this Quiz!");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Please Download Clicker to do quiz,win the prize.");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));

        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }

    }

    private class HttpTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... params) {
            String urlinsert = params[0];

            HttpURLConnection connnection;

            try {
                URL url = new URL(urlinsert);
                connnection = (HttpURLConnection) url.openConnection();

                InputStream in = new BufferedInputStream(connnection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder sb = new StringBuilder();

                String lines = null;

                try {
                    while ((lines = reader.readLine()) != null) {
                        sb.append(lines);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                    String result = "" + sb;
              if(task.equals("comment")){
                    if (result.equals("successful")) {  // 200

                        return "Nice!Thank you for your comment";

                    } else {

                        return "Failure to connect the server.Comment upload failed";
                    }
                    }
                    else{

    if (result.equals("successful")) {  // 200

        return "Nice!You have done the test.";

    } else {

        return "Failure to connect the server.Comment upload failed";
    }
}

                } catch(IOException e){
                    return "Unable to retrieve web page. URL may be invalid.";
                }


        }
        protected void onPostExecute(String exe) {
            if(exe.equals("Nice!Thank you for your comment")){
             btncomment.setEnabled(false);}
            Toast.makeText(conx, exe, Toast.LENGTH_LONG).show();
        }

    }
}
