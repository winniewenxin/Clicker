package com.example.clicker;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import android.content.Intent;
import java.io.*;





public class loginReg extends AppCompatActivity {

    EditText txtname, txtpw;
    Button btnReg,btnLogin;
    String name=null, password=null,urlreg,urllog,task;
    Context ctx = this;

    public final static String EXTRA_MESSAGE = "com.example.clicker.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtname = (EditText) findViewById(R.id.txtname);
        txtpw = (EditText) findViewById(R.id.txtpw);
        btnReg = (Button) findViewById(R.id.btnReg);
        btnLogin=(Button)findViewById(R.id.btnlogin);



    }



    public void btnRegHandler(View v) {
        name=txtname.getText().toString();
        password=txtpw.getText().toString();
         task="reg";
       //urlreg="http://192.168.0.102:9999/Clicker/reg?name=" + name + "&password=" + password;
        urlreg="http://10.27.18.219:9999/Clicker/reg?name=" + name + "&password=" + password;
       valiInput(task);
    }

    public void btnlogHandler(View v){
        name=txtname.getText().toString();
        password=txtpw.getText().toString();
        task="login";
       // urllog="http://192.168.0.102:9999/Clicker/log?name=" + name + "&password=" + password;
        urllog="http://10.27.18.219:9999/Clicker/log?name=" + name + "&password=" + password;
        valiInput(task);
    }


    public void valiInput(String task){
        if(name.equals("")&& password.equals("")) {Toast.makeText(ctx,"Please enter username and password", Toast.LENGTH_LONG).show();
        } else if(password.equals("")){Toast.makeText(ctx,"Please enter password", Toast.LENGTH_LONG).show();}
        else if(name.equals("")){Toast.makeText(ctx,"Please enter username", Toast.LENGTH_LONG).show();
        }else{
            if(task.equals("reg")) {
                new HttpRegLogTask().execute(urlreg, task); // BackGround b = new BackGround(); // b.execute(Name, Password, Email);}
            }else{
                new HttpRegLogTask().execute(urllog,task);
              }
            }
    }

    private class HttpRegLogTask extends AsyncTask<String,String,String> {
        @Override
        protected String doInBackground(String... params) {
            String urlreglog=params[0];
            String task=params[1];

            HttpURLConnection conn;

              try {
                  URL url = new URL(urlreglog);
                  conn = (HttpURLConnection) url.openConnection();

                  //start to get response from the servlet

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
                  if(task.equals("reg")) {
                      if (!result.equals("successful")) {  // 200
                      return "username occupied. You can try to login/try to use other username.";

                      } else {
                      return "Registration Successfully";
                      }
                  }else{  //login response


                      if (result.equals("sucessful")) {  // 200
                          return "Login Successfully";

                      } else {
                          return "Login Failure";

                      }
                  }


          }catch (IOException e) {
                  return "Unable to retrieve web page. URL may be invalid.";
              }

        }
        @Override
        protected void onPostExecute(String exe) {
             if(exe=="Registration Successfully"|| exe=="Login Successfully"){
                 Intent intent = new Intent(ctx,main.class);// Retrieve the string entered in the EditView 
                 intent.putExtra(EXTRA_MESSAGE, name);
                 startActivity(intent);

             }
            Toast.makeText(ctx, exe, Toast.LENGTH_LONG).show();
        }
    }



}
