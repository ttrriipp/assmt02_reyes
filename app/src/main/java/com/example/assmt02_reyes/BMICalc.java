package com.example.assmt02_reyes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BMICalc extends AppCompatActivity {

    private Button calcBtn, resetBtn;
    private TextView bmiNo, bmiCategory;
    private EditText height, weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalc);

        calcBtn = (Button) findViewById(R.id.button4);
        resetBtn = (Button) findViewById(R.id.button5);

        bmiNo = (TextView) findViewById(R.id.textView9);
        bmiCategory = (TextView) findViewById(R.id.textView10);

        height = (EditText) findViewById(R.id.editTextNumber);
        weight = (EditText) findViewById(R.id.editTextNumber2);

    }

    public void calculateBmi(View v){
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if (!heightStr.isEmpty() && !weightStr.isEmpty()) {
            double height = Double.parseDouble(heightStr); // Height in meters
            double weight = Double.parseDouble(weightStr); // Weight in kilograms
            double bmi = weight / (height * height);
            bmiNo.setText(String.format("%.2f", bmi));
            bmiCategory.setText(getBmiCategory(bmi));


        }
    }

    private String getBmiCategory(double bmi) {
        if (bmi < 20) {
            return "Under Weight";
        } else if (bmi >= 20 && bmi < 25) {
            return "Normal";
        } else if (bmi >= 25 && bmi < 30) {
            return "Over Weight";
        } else if (bmi >= 30 && bmi < 40) {
            return "Obese";
        } else {
            return "Morbidly Obese";
        }
    }


    public void resetResults(View v){
        bmiNo.setText("");
        bmiCategory.setText("");
        bmiNo.setText("0.00");
        bmiCategory.setText("CATEGORY");
    }



}