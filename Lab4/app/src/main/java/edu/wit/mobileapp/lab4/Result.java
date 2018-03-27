package edu.wit.mobileapp.lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        //init bundle
        Bundle bundle = this.getIntent().getExtras();
        //get textView names of each of the 3 output fields
        TextView gender_view = (TextView)findViewById(R.id.gender);
        TextView height_view = (TextView)findViewById(R.id.height);
        TextView weight_view = (TextView)findViewById(R.id.weight);

        //store gender, feet and inches into local variables
        String gender = bundle.getString("gender");
        int height_feet = bundle.getInt("height_feet");
        int height_inch = bundle.getInt("height_inch");

        //set the text of the gender view to the inputted gender
        gender_view.setText("You are " + gender);

        //set the text of the height_view to the inputted height in feet and inches
        height_view.setText("Your height is " + height_feet + "\'" + height_inch + "\"");

        // init variables to store the calculated ideal body weight
        double calc_weight;

        //convert height from feet and inches into only inches
        double height_total = (height_feet * 12) + height_inch;

        //if the gender is male then do the following calculation, otherwise do the next calculation (female)
        if(gender.equals("Male"))
        {
            calc_weight = 50 + 2.3 * (height_total - 60);
        }
        else
        {
            calc_weight = 45.5 + 2.3 * (height_total - 60);
        }

        //set the weight_view to output the calculated ideal weight 
        weight_view.setText("The standard weight is " + calc_weight + " kg");




        //Log.v("Results:", gender + " is " + height_feet + "' " + height_inch + "\"");

    }
}
