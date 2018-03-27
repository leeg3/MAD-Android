package edu.wit.mobileapp.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Calculator extends AppCompatActivity {

    //init variables to hold the buttons, radioButtons and text fields
    private RadioButton radioButton_Male;
    private RadioButton radioButton_Female;
    private EditText feet_field;
    private EditText inches_field;
    private String radioResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        //init button
        Button activity1_btn = (Button)findViewById(R.id.myBtn);

        //assign view to the variables to store the inputted height in feet and inches
        feet_field = findViewById(R.id.feet);
        inches_field = findViewById(R.id.inches);

        //assign views to the variables to store the gender
        radioButton_Male = findViewById(R.id.radioButton_Male);   //male
        radioButton_Female = findViewById(R.id.radioButton_Female);  //female

        //init a listener for the button
        activity1_btn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                //Log.v("Edit Text", field1.getText().toString());
                //Log.v("Edit Text", field2.getText().toString());
                // get the values inputted by the user and store them into val1 and val2
                int feet = Integer.valueOf(feet_field.getText().toString());
                int inch = Integer.valueOf(inches_field.getText().toString());

                if (radioButton_Male.isChecked())
                {
                    radioResult = "Male";
                }
                else if (radioButton_Female.isChecked())
                {
                    radioResult = "Female";
                }

                //Log.v("Radio Button", radioResult);

                Intent intent = new Intent(Calculator.this, Result.class);
                Bundle bundle = new Bundle();
                bundle.putString("gender", radioResult);
                bundle.putInt("height_feet", feet);
                bundle.putInt("height_inch", inch);

                intent.putExtras(bundle);
                startActivity(intent);

            }

        });

    }//end of on create

}//end of class






















