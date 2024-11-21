package com.example.assmt02_reyes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class BasicCalc extends AppCompatActivity {

    private Button backBtn, ceBtn, cBtn, sevenBtn, eightBtn, nineBtn, divideBtn, fourBtn, fiveBtn, sixBtn, multiplyBtn, oneBtn, twoBtn,
            threeBtn, subtractBtn, zeroBtn, pointBtn, equalBtn, addBtn;
    private EditText editText;
    private String input = "";
    private double firstValue = 0;
    private double secondValue = 0;
    private String operation = "";
    private boolean isOperationClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_calc);

        editText = findViewById(R.id.editTextNumber3);

        zeroBtn = findViewById(R.id.button22);
        oneBtn = findViewById(R.id.button18);
        twoBtn = findViewById(R.id.button19);
        threeBtn = findViewById(R.id.button20);
        fourBtn = findViewById(R.id.button14);
        fiveBtn = findViewById(R.id.button15);
        sixBtn = findViewById(R.id.button16);
        sevenBtn = findViewById(R.id.button10);
        eightBtn = findViewById(R.id.button11);
        nineBtn = findViewById(R.id.button12);

        addBtn = findViewById(R.id.button25);
        subtractBtn = findViewById(R.id.button21);
        multiplyBtn = findViewById(R.id.button17);
        divideBtn = findViewById(R.id.button13);
        equalBtn = findViewById(R.id.button24);
        cBtn = findViewById(R.id.button9);
        pointBtn = findViewById(R.id.button23);
        backBtn = findViewById(R.id.button7);
        ceBtn = findViewById(R.id.button8);

        zeroBtn.setOnClickListener(v -> appendNumber("0"));
        oneBtn.setOnClickListener(v -> appendNumber("1"));
        twoBtn.setOnClickListener(v -> appendNumber("2"));
        threeBtn.setOnClickListener(v -> appendNumber("3"));
        fourBtn.setOnClickListener(v -> appendNumber("4"));
        fiveBtn.setOnClickListener(v -> appendNumber("5"));
        sixBtn.setOnClickListener(v -> appendNumber("6"));
        sevenBtn.setOnClickListener(v -> appendNumber("7"));
        eightBtn.setOnClickListener(v -> appendNumber("8"));
        nineBtn.setOnClickListener(v -> appendNumber("9"));

        addBtn.setOnClickListener(v -> setOperation("+"));
        subtractBtn.setOnClickListener(v -> setOperation("-"));
        multiplyBtn.setOnClickListener(v -> setOperation("*"));
        divideBtn.setOnClickListener(v -> setOperation("/"));

        equalBtn.setOnClickListener(this::calculateResult);
        cBtn.setOnClickListener(v -> clearInput());
        pointBtn.setOnClickListener(v -> appendNumber("."));
        backBtn.setOnClickListener(v -> removeLastCharacter());
        ceBtn.setOnClickListener(v -> clearEntry());
    }

    private void appendNumber(String number) {
        if (isOperationClicked) {
            input += number;
            isOperationClicked = false;
        } else {
            input += number;
        }
        editText.setText(input);
    }

    private void setOperation(String op) {
        if (!input.isEmpty() && !isOperationClicked) {
            input += " " + op + " ";
            operation = op;
            isOperationClicked = true;
        }
        editText.setText(input);
    }

    private void calculateResult(View v) {
        String[] parts = input.split(" ");
        if (parts.length == 3) {
            try {
                firstValue = Double.parseDouble(parts[0]);
                secondValue = Double.parseDouble(parts[2]);
                double result = 0;

                switch (parts[1]) {
                    case "+":
                        result = firstValue + secondValue;
                        break;
                    case "-":
                        result = firstValue - secondValue;
                        break;
                    case "*":
                        result = firstValue * secondValue;
                        break;
                    case "/":
                        if (secondValue != 0) {
                            result = firstValue / secondValue;
                        } else {
                            editText.setText("Error");
                            return;
                        }
                        break;
                }
                editText.setText(String.format("%.2f", result));
                input = String.format("%.2f", result);
                operation = "";
                isOperationClicked = false;

            } catch (NumberFormatException e) {
                editText.setText("Error");
            }
        }
    }

    private void clearInput() {
        input = "";
        editText.setText(input);
    }

    private void removeLastCharacter() {
        if (!input.isEmpty()) {
            input = input.substring(0, input.length() - 1);
            editText.setText(input);
        }
    }

    private void clearEntry() {
        int lastSpaceIndex = input.lastIndexOf(" ");
        if (lastSpaceIndex != -1) {
            input = input.substring(0, lastSpaceIndex).trim();
        } else {
            input = "";
        }
        editText.setText(input);
    }
}
