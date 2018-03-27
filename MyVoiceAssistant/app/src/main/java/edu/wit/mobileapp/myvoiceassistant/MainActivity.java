package edu.wit.mobileapp.myvoiceassistant;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Build;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Locale;
import static java.lang.Boolean.TRUE;

public class MainActivity extends AppCompatActivity {
    final static String TAG = "myApp";

    // global variable declaration
    private TextToSpeech textToSpeech;
    private Button readVoiceInput;
    private Button speakButton;
    private TextView voiceOutput;
    private final int REQ_CODE_SPEECH_INPUT = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "onCreate");

        //init buttons and textview
        readVoiceInput = (Button) findViewById(R.id.ButtonRead);
        speakButton = (Button) findViewById(R.id.ButtonRecord);
        voiceOutput = (TextView) findViewById(R.id.TextSaid);

        //When speak Button is clicked, prompt for speech input
        speakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Speak button pressed");
                askSpeechInput();
            }
        });

        //init text to speech and set language to English.
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int language = textToSpeech.setLanguage(Locale.ENGLISH);

                    if (language == TextToSpeech.LANG_MISSING_DATA || language == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e(TAG, "Language not supported");
                    }
                    else {
                        readVoiceInput.setEnabled(TRUE);
                    }
                }
                else {
                    Log.e(TAG, "Init failed");
                }
            }
        });

        //When button is pressed, read the text that was inputted into the app from the speech input button
        readVoiceInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "readVoiceInput button pressed");
                String result = voiceOutput.getText().toString();

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    textToSpeech.speak(result, TextToSpeech.QUEUE_FLUSH, null, null);
                } else {
                    textToSpeech.speak(result, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });
    }

    // Display google speech input dialog box
    private void askSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
        }
    }

    // Receive speech input
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> input = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    voiceOutput.setText(input.get(0));
                }
                break;
            }
        }
    }
}