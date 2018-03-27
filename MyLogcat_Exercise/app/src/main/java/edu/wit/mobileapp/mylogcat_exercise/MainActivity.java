package edu.wit.mobileapp.mylogcat_exercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    Integer arraySize = 10;
    //error 1: private TextView text = (TextView)findViewById(R.id.text);
    //fix
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView)findViewById(R.id.text);

        Integer[] results = generateRandomArray(arraySize);

        String outputData = "[ ";
        for(int i=0;i<=results.length;i++){
            outputData += i;

            if(i!=results.length) outputData += ", ";
        }
        outputData += " ]";

        text.setText(outputData);
    }

    private static Integer[] generateRandomArray(int size)
    {
        Integer result[] = new Integer[size];
        Random generator = new Random();

        for(int i = 0; i <= size; i++){
            int value = generator.nextInt(size);
        }

        return result;
    }
}
