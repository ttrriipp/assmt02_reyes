package com.example.assmt02_reyes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CoffeeShop extends AppCompatActivity {

    private Button payBtn;
    private RadioButton decaf, espresso, colombian;
    private CheckBox creamer, sugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffe_shop);

        payBtn = (Button) findViewById(R.id.button6);

        decaf = (RadioButton) findViewById(R.id.radioButton3);
        espresso = (RadioButton) findViewById(R.id.radioButton2);
        colombian = (RadioButton) findViewById(R.id.radioButton);

        creamer = (CheckBox) findViewById(R.id.checkBox2);
        sugar = (CheckBox) findViewById(R.id.checkBox3);
    }

    public void payAction(View v){
        double coffeePrice = 0;


        if (decaf.isChecked()){
        coffeePrice = 110.00;
        } else if (espresso.isChecked()){
        coffeePrice = 145.00;
        } else if (colombian.isChecked()){
        coffeePrice = 125.00;
        }

        double addonPrice = 0;
        if (creamer.isChecked() && sugar.isChecked()){
            addonPrice += 35.00;
        } else if (sugar.isChecked()) {
            addonPrice += 20.00;
        } else if (creamer.isChecked()) {
            addonPrice += 15.00;
    }



    double totalPrice = coffeePrice + addonPrice;

    String formattedPrice = String.format("Total: P %.2f", (double) totalPrice);

    Toast.makeText(this, formattedPrice, Toast.LENGTH_LONG).show();

}

}