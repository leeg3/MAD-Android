package edu.wit.mobileapp.activityswitch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_1);
        Button activity1_btn = (Button)findViewById(R.id.activity1_button);

        activity1_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.v("myApp", "Activity1 button is clicked");

                //add in going back to activity 1 from activity 2
                Intent intent = new Intent(Activity1.this, Activity2.class);

                Bundle bundle = new Bundle();
                bundle.putString("name", "Greg");
                bundle.putInt("age", 21);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }


}
