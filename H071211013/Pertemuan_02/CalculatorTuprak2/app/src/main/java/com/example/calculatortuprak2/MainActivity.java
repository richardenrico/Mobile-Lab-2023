package com.example.calculatortuprak2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView hasil;
    private Button btnbagi,btntambah,btnkali,btnkurang,btnequal,btnac,btndel,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;
    private boolean isNew = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hasil = findViewById(R.id.hasil);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnac = findViewById(R.id.ac);
        btndel = findViewById(R.id.del);
        btnequal = findViewById(R.id.equal);
        btnbagi = findViewById(R.id.bagi);
        btntambah = findViewById(R.id.tambah);
        btnkali = findViewById(R.id.kali);
        btnkurang = findViewById(R.id.kurang);
    }

    private enum Operation {
        ADD, SUB, MUL, DIV
    }

    private double operandOne;
    private double operandTwo;
    private Operation operationMode;

    public void onButtonClick(View view) {
        Button button = (Button) view;
        String tombol = button.getText().toString();
        if (isNew){
            hasil.setText("");
            isNew = false;
        }
        String result = hasil.getText().toString();
        if (hasil.getText().toString().equals("0")){
            hasil.setText(tombol);
        } else {
            hasil.setText(result + tombol);
        }
    }

    public void onOperationClick(View view) {
        String operator = "";
        Button button = (Button) view;
        String operation = button.getText().toString();
        String result = hasil.getText().toString();
        double hasilop = 0;

        switch (operation) {
            case "+":
                if (!result.equals("")){
                    if (isOperator()) {
                        operator = "\\+";
                        operandOne = hasilop;
                        hasil.setText(result.substring(0,result.length()-1)+"+");
                        operationMode = Operation.ADD;
                    } else {
                        operator = "\\+";
                        operandOne = hasilop;
                        hasil.setText(result + "+");
                        operationMode = Operation.ADD;
                    }
                }
                break;
            case "-":
                if (!result.equals("")){
                    if (isOperator()) {
                        operator = "-";
                        operandOne = hasilop;
                        hasil.setText(result.substring(0,result.length()-1)+"-");
                        operationMode = Operation.SUB;
                    } else {
                        operator = "-";
                        operandOne = hasilop;
                        hasil.setText(result + "-");
                        operationMode = Operation.SUB;
                    }
                }
                break;
            case "×":
                if (!result.equals("")) {
                    if (isOperator()) {
                        operator = "×";
                        operandOne = hasilop;
                        hasil.setText(result.substring(0,result.length()-1)+"×");
                        operationMode = Operation.MUL;
                    } else {
                        operator = "×";
                        operandOne = hasilop;
                        hasil.setText(result + "×");
                        operationMode = Operation.MUL;
                    }
                }
                break;
            case "/":
                if (!result.equals("")){
                    if (isOperator()) {
                        operator = "/";
                        operandOne = hasilop;
                        hasil.setText(result.substring(0,result.length()-1)+"/");
                        operationMode = Operation.DIV;
                    } else {
                        operator = "/";
                        operandOne = hasilop;
                        hasil.setText(result + "/");
                        operationMode = Operation.DIV;
                    }
                }
                break;
            case "=":
                if (!hasil.getText().toString().equals("") && !isOperator()){
                    String a[]= result.split("[×+/-]");
                    operandOne = Double.parseDouble(a[0]);
                    operandTwo = Double.parseDouble(a[1]);
                    isNew = true;

                    if (operationMode == Operation.ADD) {
                        hasilop = operandOne + operandTwo;
                    } else if (operationMode == Operation.SUB) {
                        hasilop = operandOne - operandTwo;
                    } else if (operationMode == Operation.MUL) {
                        hasilop = operandOne * operandTwo;
                    } else if (operationMode == Operation.DIV) {
                        hasilop = operandOne / operandTwo;
                    }
                    hasil.setText(String.valueOf(hasilop));
                }
                break;
            case "AC":
                hasil.setText("");
                operation = "";
                operandOne = 0;
                operandTwo = 0;
                break;
            case "DEL":
                if(result.length() > 1 ){
                    hasil.setText(hasil.getText().toString().substring(0,hasil.getText().toString().length()-1));
                } else {
                    hasil.setText("0");
                }
                break;
        }
    }
    private boolean isOperator() {
        String check = hasil.getText().toString();
        String last = check.substring(check.length()-1);
        if(last.matches("[×+/-]")) return true;
        return false;
    }
}