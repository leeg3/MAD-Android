package edu.wit.mobileapp.applicationlifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    static String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "onCreate() is called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "onStart() is called");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "onStop() is called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "onDestroy() is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "onPause is called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "onResume() is called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG, "onRestart() is called");
    }
}
