package com.example.clicker;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Button;
import android.os.SystemClock;
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
import android.net.Uri;
import android.widget.VideoView;
import android.widget.MediaController;

/**
 * Created by wenxinchen on 17/3/17.
 */

public class index extends AppCompatActivity {

    TextView uname;

    Button btn1a, btn1b,btn2a,btn2b,btn3a,btn3b,btn4a,btn4b,btn5a,btn5b,btn5c,btn5d;
    ImageButton btnstop1,btnresume1, btnstop2,btnresume2,btnstop3,btnresume3,btnstop4,btnresume4,btnstop5,btnresume5;
    Chronometer clk1,clk2,clk3,clk4,clk5;
    long passTime,stopTime,stopTime2,stopTime3,stopTime4,stopTime5;
    ImageView topImage1,topImage2,topImage3,topImage4,topImage5;
    String name,url;
    Context conx = this;


    public final static String EXTRA_MESSAGE = "com.example.clicker.MESSAGE";
    public final static String EXTRA_TIME = "com.example.clicker.EXTRA_TIME";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qn1);
        Intent intent = getIntent();
        name = intent.getStringExtra(loginReg.EXTRA_MESSAGE);
        clk1 = (Chronometer) findViewById(R.id.chronometer2);
        clk1.start();


        btn1a = (Button) findViewById(R.id.btn1a);
        btn1b = (Button) findViewById(R.id.btn1b);
        btnstop1=(ImageButton) findViewById(R.id.btnStop1);
        btnresume1=(ImageButton)findViewById(R.id.btnResume1);
        topImage1=(ImageView) findViewById(R.id.stopImage1);
        uname=(TextView) findViewById(R.id.txtuname);
        uname.setText("Username: "+name);





    }





    public void btn1aHandler(View v){
        //nclicked=true;
       url="http://10.27.18.219:9999/Clicker/ans?name="+name+"&id=1&option=yes";
      //  url="http://192.168.0.102:9999/Clicker/ans?name="+name+"&id=1&option=yes";
        new HttpinsertTask().execute(url);
        Clickedqn1();

    }

    public void btn1bHandler(View v){
        //yclicked=true;
        url="http://10.27.18.219:9999/Clicker/ans?name="+name+"&id=1&option=no";
       // url="http://192.168.0.102:9999/Clicker/ans?name="+name+"&id=1&option=no";
        new HttpinsertTask().execute(url);
        Clickedqn1();
    }




    public void btn2aHandler(View v){
        url="http://10.27.18.219:9999/Clicker/ans?name="+name+"&id=2&option=yes";
       // url="http://192.168.0.102:9999/Clicker/ans?name="+name+"&id=2&option=yes";
        new HttpinsertTask().execute(url);
       // qn2Insert();
        Clickedqn2();
    }
    public void btn2bHandler(View v){

        url="http://10.27.18.219:9999/Clicker/ans?name="+name+"&id=2&option=no";
      //  url="http://192.168.0.102:9999/Clicker/ans?name="+name+"&id=2&option=no";
        new HttpinsertTask().execute(url);
        Clickedqn2();
    }

    public void btn3aHandler(View v){
        url="http://10.27.18.219:9999/Clicker/ans?name="+name+"&id=3&option=yes";
      //  url="http://192.168.0.102:9999/Clicker/ans?name="+name+"&id=3&option=yes";
        new HttpinsertTask().execute(url);
        Clickedqn3();


    }
    public void btn3bHandler(View v){
       url="http://10.27.18.219:9999/Clicker/ans?name="+name+"&id=3&option=no";
       // url="http://192.168.0.102:9999/Clicker/ans?name="+name+"&id=3&option=no";
        new HttpinsertTask().execute(url);
        Clickedqn3();

    }

    public void btn4aHandler(View v){
       url="http://10.27.18.219:9999/Clicker/ans?name="+name+"&id=4&option=yes";
       // url="http://192.168.0.102:9999/Clicker/ans?name="+name+"&id=4&option=yes";
        new HttpinsertTask().execute(url);
        Clickedqn4();


    }
    public void btn4bHandler(View v){

        url="http://10.27.18.219:9999/Clicker/ans?name="+name+"&id=4&option=no";
       // url="http://192.168.0.102:9999/Clicker/ans?name="+name+"&id=4&option=no";
        new HttpinsertTask().execute(url);
        Clickedqn4();

    }


    public void btn5aHandler(View v){
          url="http://10.27.18.219:9999/Clicker/ans?name="+name+"&id=5&option=a";
      //  url="http://192.168.0.102:9999/Clicker/ans?name="+name+"&id=5&option=a";
        new HttpinsertTask().execute(url);
        Clickedqn5();


    }
    public void btn5bHandler(View v){

         url="http://10.27.18.219:9999/Clicker/ans?name="+name+"&id=5&option=b";
       // url="http://192.168.0.102:9999/Clicker/ans?name="+name+"&id=5&option=b";
        new HttpinsertTask().execute(url);
        Clickedqn5();

    }
    public void btn5cHandler(View v){
        url="http://10.27.18.219:9999/Clicker/ans?name="+name+"&id=5&option=c";
        //url="http://192.168.0.102:9999/Clicker/ans?name="+name+"&id=5&option=c";
        new HttpinsertTask().execute(url);
        Clickedqn5();


    }
    public void btn5dHandler(View v){

        url="http://10.27.18.219:9999/Clicker/ans?name="+name+"&id=5&option=d";
        //url="http://192.168.0.102:9999/Clicker/ans?name="+name+"&id=5&option=d";
        new HttpinsertTask().execute(url);
        Clickedqn5();

    }

    private class HttpinsertTask extends AsyncTask<String,String,String> {
        @Override
        protected String doInBackground(String... params) {
            String urlinsert=params[0];

            HttpURLConnection conn;

            try {
                URL url = new URL(urlinsert);
                conn = (HttpURLConnection) url.openConnection();

                //start to get response from the servlet
                int responseCode = conn.getResponseCode();
                InputStream in = new BufferedInputStream(conn.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder sb = new StringBuilder();

                String lines=null;
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

               String result=""+sb;
                //end of getting response

                //register response

                if (result.equals("successful")) {  // 200
                    //inserted=true;

                    return "Nice!";



                } else {
                   // inserted=false;

                     Intent intent = new Intent(conx,index.class); //when server/ database error, it will jump back to the login page,will show error msg
                    startActivity(intent);
                    return "Failure to connect the server.";
                }




            }catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }


        }
        protected void onPostExecute(String exe) {
           // if(exe="Nice!Going to Next question"){
                //Intent intent = new Intent(conx,index.class);// Retrieve the string entered in the EditView 
                //intent.putExtra(EXTRA_MESSAGE, name);
                //startActivity(intent);

            //}
            Toast.makeText(conx, exe, Toast.LENGTH_LONG).show();
        }


    }



    // To diffferentiate the different Option chose, will call to different URL
       // but whatever option select  it will go to the next question
    public void Clickedqn1() {



            passTime=clk1.getBase()-SystemClock.elapsedRealtime();
            setContentView(R.layout.activity_qn2);
            uname=(TextView) findViewById(R.id.txtuname);
            uname.setText("Username: "+name);
            clk2 = (Chronometer) findViewById(R.id.chronometer2);
            clk2.setBase(passTime+SystemClock.elapsedRealtime());
            clk2.start();
            btn2a = (Button) findViewById(R.id.btn2a);
            btn2b = (Button) findViewById(R.id.btn2b);
            btnstop2=(ImageButton) findViewById(R.id.btnstop2);
            btnresume2=(ImageButton)findViewById(R.id.btnresume2);
            topImage2=(ImageView) findViewById(R.id.stopimage2);


    }

    public void Clickedqn2() {

        // if(nclicked=true){
        //start to declar the qn2

        passTime=clk2.getBase()-SystemClock.elapsedRealtime();
        setContentView(R.layout.activity_qn3);
        uname=(TextView) findViewById(R.id.txtuname);
        uname.setText("Username: "+name);
        clk3 = (Chronometer) findViewById(R.id.chronometer3);
        clk3.setBase(passTime+SystemClock.elapsedRealtime());
        clk3.start();
        btn3a = (Button) findViewById(R.id.btn3a);
        btn3b = (Button) findViewById(R.id.btn3b);
        btnstop3=(ImageButton) findViewById(R.id.btnstop3);
        btnresume3=(ImageButton)findViewById(R.id.btnresume3);
        topImage3=(ImageView) findViewById(R.id.stopimage3);
        //end to declar qn2
        // }

    }
    public void Clickedqn3() {

        // if(nclicked=true){
        //start to declar the qn3

        passTime=clk3.getBase()-SystemClock.elapsedRealtime();
        setContentView(R.layout.activity_qn4);
        uname=(TextView) findViewById(R.id.txtuname);
        uname.setText("Username: "+name);
        clk4 = (Chronometer) findViewById(R.id.chronometer4);
        clk4.setBase(passTime+SystemClock.elapsedRealtime());
        clk4.start();
        btn4a = (Button) findViewById(R.id.btn4a);
        btn4b = (Button) findViewById(R.id.btn4b);
        btnstop4=(ImageButton) findViewById(R.id.btnstop4);
        btnresume4=(ImageButton)findViewById(R.id.btnresume4);
        topImage4=(ImageView) findViewById(R.id.stopimage4);


        VideoView videoView = (VideoView)
                findViewById(R.id.videoView);

        videoView.setVideoPath("http://www.ebookfrenzy.com/android_book/movie.mp4");

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
        //end to declar qn3
        // }

    }
    public void Clickedqn4() {

        // if(nclicked=true){
        //start to declar the qn4

        passTime=clk4.getBase()-SystemClock.elapsedRealtime();
        setContentView(R.layout.activity_qn5);
        uname=(TextView) findViewById(R.id.txtuname);
        uname.setText("Username: "+name);
        clk5 = (Chronometer) findViewById(R.id.chronometer5);
        clk5.setBase(passTime+SystemClock.elapsedRealtime());
        clk5.start();
        btn5a = (Button) findViewById(R.id.btn5a);
        btn5b = (Button) findViewById(R.id.btn5b);
        btn5c = (Button) findViewById(R.id.btn5d);
        btn5d = (Button) findViewById(R.id.btn5d);

        btnstop5=(ImageButton) findViewById(R.id.btnstop5);
        btnresume5=(ImageButton)findViewById(R.id.btnresume5);
        topImage5=(ImageView) findViewById(R.id.stopimage5);



    }
    public void Clickedqn5() {
        passTime=clk5.getBase()-SystemClock.elapsedRealtime();
        Intent intent = new Intent(this, finished.class);// Retrieve the string entered in the EditView 
        intent.putExtra(EXTRA_MESSAGE, name);
        intent.putExtra(EXTRA_TIME,passTime);
        startActivity(intent);
    }

    public void btnStop1Handler(View v){
        disVisible(btnstop1,btnresume1,topImage1,btn1a,btn1b);
        stopTime=clk1.getBase()-SystemClock.elapsedRealtime();
        clk1.stop();



    }
    public void btnResume1Handler (View v){
        clk1.setBase(stopTime+SystemClock.elapsedRealtime());
        clk1.start();
        Visible(btnstop1,btnresume1,topImage1,btn1a,btn1b);
    }
    //qn2 stop
    public void btnstop2Handler(View v){
        disVisible(btnstop2,btnresume2,topImage2,btn2a,btn2b);
        stopTime2=clk2.getBase()-SystemClock.elapsedRealtime();
        clk2.stop();
    }

    //qn2 resume
    public void btnresume2Handler (View v){

        clk2.setBase(stopTime2+SystemClock.elapsedRealtime());
        clk2.start();
        Visible(btnstop2,btnresume2,topImage2,btn2a,btn2b);
    }

    //qn2 stop
    public void btnstop3Handler(View v){
        disVisible(btnstop3,btnresume3,topImage3,btn3a,btn3b);
        stopTime3=clk3.getBase()-SystemClock.elapsedRealtime();
        clk3.stop();
    }

    //qn2 resume
    public void btnresume3Handler (View v){

        clk3.setBase(stopTime3+SystemClock.elapsedRealtime());
        clk3.start();
        Visible(btnstop3,btnresume3,topImage3,btn3a,btn3b);
    }


    public void btnstop4Handler(View v){
        disVisible(btnstop4,btnresume4,topImage4,btn4a,btn4b);
        stopTime4=clk4.getBase()-SystemClock.elapsedRealtime();
        clk4.stop();
    }


    public void btnresume4Handler (View v){

        clk4.setBase(stopTime4+SystemClock.elapsedRealtime());
        clk4.start();
        Visible(btnstop4,btnresume4,topImage4,btn4a,btn4b);
    }

    public void btnstop5Handler(View v){
        disVisible(btnstop5,btnresume5,topImage5,btn5a,btn5b,btn5c,btn5d);
        stopTime5=clk5.getBase()-SystemClock.elapsedRealtime();
        clk5.stop();
    }


    public void btnresume5Handler (View v){

        clk5.setBase(stopTime5+SystemClock.elapsedRealtime());
        clk5.start();
        Visible(btnstop5,btnresume5,topImage5,btn5a,btn5b,btn5c,btn5d);
    }
    //when the Timer Stop Button onClicked, it will let all the Content to divisible.
    public void disVisible(ImageButton btnstop,ImageButton btnresume,ImageView topImage,Button opa,Button opb){

        btnstop.setVisibility(View.GONE);
        btnresume.setVisibility(View.VISIBLE);
        topImage.setVisibility(View.VISIBLE);
        opa.setVisibility(View.GONE);
        opb.setVisibility(View.GONE);

    }
      //when the Timer Resume Button onClicked, it will let all the Content back to visible.
    public void Visible(ImageButton btnstop,ImageButton btnresume,ImageView topImage,Button opa,Button opb){
        btnresume.setVisibility(View.GONE);
        btnstop.setVisibility(View.VISIBLE);
        topImage.setVisibility(View.GONE);
        opa.setVisibility(View.VISIBLE);
        opb.setVisibility(View.VISIBLE);


    }

    public void disVisible(ImageButton btnstop,ImageButton btnresume,ImageView topImage,Button opa,Button opb,Button opc,Button opd){

        btnstop.setVisibility(View.GONE);
        btnresume.setVisibility(View.VISIBLE);
        topImage.setVisibility(View.VISIBLE);
        opa.setVisibility(View.GONE);
        opb.setVisibility(View.GONE);
        opd.setVisibility(View.GONE);
        opd.setVisibility(View.GONE);

    }
    //when the Timer Resume Button onClicked, it will let all the Content back to visible.
    public void Visible(ImageButton btnstop,ImageButton btnresume,ImageView topImage,Button opa,Button opb,Button opc,Button opd){
        btnresume.setVisibility(View.GONE);
        btnstop.setVisibility(View.VISIBLE);
        topImage.setVisibility(View.GONE);
        opa.setVisibility(View.VISIBLE);
        opb.setVisibility(View.VISIBLE);
        opc.setVisibility(View.VISIBLE);
        opd.setVisibility(View.VISIBLE);

    }





}
