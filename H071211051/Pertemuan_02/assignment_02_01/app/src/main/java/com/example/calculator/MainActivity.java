package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView inputText;
    Boolean isNewOp = true;
    String op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputText = findViewById(R.id.inputNumber);
    }
    public void numberEvent(View view) {
        if(isNewOp){
            inputText.setText("0");
            isNewOp = false;
        }
        String number = inputText.getText().toString();
        switch (view.getId()){
            case R.id.btn0:
                if(!number.substring(0,1).equalsIgnoreCase("0")) {
                    number += "0";
                }
                break;
            case R.id.btn1:
                number += "1";
                break;
            case R.id.btn2:
                number += "2";
                break;
            case R.id.btn3:
                number += "3";
                break;
            case R.id.btn4:
                number += "4";
                break;
            case R.id.btn5:
                number += "5";
                break;
            case R.id.btn6:
                number += "6";
                break;
            case R.id.btn7:
                number += "7";
                break;
            case R.id.btn8:
                number += "8";
                break;
            case R.id.btn9:
                number += "9";
                break;
        }
        if(number.substring(0,1).equalsIgnoreCase("0")) {
            number = number.substring(1);
        }
        inputText.setText(number);
    }
    public void operatorEvent(View view) {
        switch (view.getId()){
            case R.id.btnBagi: op = "/";
            break;
            case R.id.btnKali: op = "x";
            break;
            case R.id.btnTambah: op = "+";
            break;
            case R.id.btnMinus: op = "-";
        }

        String temp = inputText.getText().toString();
        System.out.println(temp.substring(temp.length() - 1));
        String[] operators = {"x","/","-","+"};
        boolean isContain = true;

        System.out.println(temp.length());
        for(String s: operators){
            if(temp.substring(temp.length() - 1).contains(s)){
                inputText.setText(temp.substring(0, temp.length() - 1) + op);
                isContain = false;
            }
        }
        if (isContain){
            inputText.setText(inputText.getText().toString() + op);
        }
    }
    public void equalEvent(View view) {
        String[] data = inputText.getText().toString().split("[x\\+\\-\\/]");
        isNewOp = true;
        Integer result = 0;
        Double result2 = 0.0;
        switch (op) {
            case "+":
                try {
                    int number1 = Integer.parseInt(data[0]);
                    int number2 = Integer.parseInt(data[1]);
                    result = number1 + number2;
                    inputText.setText(String.valueOf(result));
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Can't calculate number more than 32 byte", Toast.LENGTH_SHORT).show();
                }
                inputText.setText(result + "");
                break;
            case "/":
                try {
                    double number1 = Double.parseDouble(data[0]);
                    double number2 = Double.parseDouble(data[1]);
                    result2 = number1 / number2;
                    inputText.setText(String.valueOf(result2));
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Can't calculate number more than 32 byte", Toast.LENGTH_SHORT).show();
                }
                inputText.setText(result2 + "");
                break;
            case "x":
                try {
                    int number1 = Integer.parseInt(data[0]);
                    int number2 = Integer.parseInt(data[1]);
                    result = number1 * number2;
                    inputText.setText(String.valueOf(result));
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Can't calculate number more than 32 byte", Toast.LENGTH_SHORT).show();
                }
                inputText.setText(result + "");
                break;
            case "-":
                try {
                    int number1 = Integer.parseInt(data[0]);
                    int number2 = Integer.parseInt(data[1]);
                    result = number1 - number2;
                    inputText.setText(String.valueOf(result));
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Can't calculate number more than 32 byte", Toast.LENGTH_SHORT).show();
                }
                inputText.setText(result + "");
                break;
        }
    }
    public void AcEvent(View view){
        inputText.setText("0");
        isNewOp = true;
    }
    public void delEvent(View view){
        String del;
        if (inputText.getText().length() > 0){
            StringBuilder stringBuilder = new StringBuilder(inputText.getText());
            stringBuilder.deleteCharAt(inputText.getText().length() - 1);
            del = stringBuilder.toString();
            if(del == ""){
                inputText.setText("0");
                isNewOp = true;
            } else {
                inputText.setText(del);
            }
        }
    }
}