package edu.wit.mobileapp.myhttpclient;

import android.content.Context;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "myApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetData getData = new GetData(this);
        getData.execute();
    }

    //<type> defines generic type
    class GetData extends AsyncTask<String, Void, String>{
        private Context mContext;

        GetData(Context context){
            this.mContext = context;
        }

        protected String doInBackground(String... params) {
            String result = "";
            try {
                URL url = new URL("https://www.wit.edu"); //REST api url would go here
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                StringBuffer sb = new StringBuffer();
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String read;

                while((read = br.readLine()) != null){
                    sb.append(read);
                }

                br.close();
                result = sb.toString();
            } catch (IOException e) {
                Log.d(TAG, "Error: " + e.toString());
            }
            return result;
        }

        protected void onPostExecute(String data) {
            Log.v(TAG, "data = " + data);
        }

    }//end of class

}
