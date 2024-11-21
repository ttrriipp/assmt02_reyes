package com.example.assmt02_reyes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button bmiBtn, cshopBtn, calcBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bmiBtn = (Button) findViewById(R.id.button);
        cshopBtn = (Button) findViewById(R.id.button2);
        calcBtn = (Button) findViewById(R.id.button3);

    }
    public void openBmi(View v){
        Intent intent = new Intent(this, BMICalc.class);
        startActivity(intent);
    }

    public void openCshop(View v){
        Intent intent = new Intent(this, CoffeeShop.class);
        startActivity(intent);
    }

    public void openCalc(View v){
        Intent intent = new Intent(this, BasicCalc.class);
        startActivity(intent);
    }
}