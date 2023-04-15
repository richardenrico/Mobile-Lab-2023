package com.example.task3calc;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText mEdit;
    Button btAC, btDel;
    Button btDiv, btMulti, btMin, btAdd, btEq;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
    String Process,res;
    boolean operator = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdit = (EditText) findViewById(R.id.etext);
        b1 = findViewById(R.id.bOne);
        b2 = findViewById(R.id.bTwo);
        b3 = findViewById(R.id.bThree);
        b4 = findViewById(R.id.bFour);
        b5 = findViewById(R.id.bFive);
        b6 = findViewById(R.id.bSix);
        b7 = findViewById(R.id.bSeven);
        b8 = findViewById(R.id.bEight);
        b9 = findViewById(R.id.bNine);
        b0 = findViewById(R.id.bZero);

        btAC = findViewById(R.id.bAC);
        btDel = findViewById(R.id.bDel);

        btDiv = findViewById(R.id.bDiv);
        btMulti = findViewById(R.id.bMulti);
        btMin = findViewById(R.id.bMin);
        btAdd = findViewById(R.id.bAdd);
        btEq = findViewById(R.id.bEqual);

        Process = "";
        res = "";

        btAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
                displayOne();
                displayTwo();
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!res.isEmpty()){
                    clear();
                    Process = Process + "0";
                    displayOne();
                } else if (Process.equals("0")) {
                    displayOne();
                } else {
                    Process = Process + "0";
                    displayOne();
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!res.isEmpty() && Process.equals("0")){
                    clear();
                    Process = Process + "1";
                    displayOne();
                } else if (Process.equals("0")) {
                    clear();
                    Process = Process + "1";
                    displayOne();
                } else {
                    Process = Process + "1";
                    displayOne();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!res.isEmpty() && Process.equals("0")){
                    clear();
                    Process = Process + "2";
                    displayOne();
                }else if (Process.equals("0")) {
                    clear();
                    Process = Process + "2";
                    displayOne();
                }
                else {
                    Process = Process + "2";
                    displayOne();
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!res.isEmpty() && Process.equals("0")){
                    clear();
                    Process = Process + "3";
                    displayOne();
                }else if (Process.equals("0")) {
                    clear();
                    Process = Process + "3";
                    displayOne();
                }
                else {
                    Process = Process + "3";
                    displayOne();
                }
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!res.isEmpty() && Process.equals("0")){
                    clear();
                    Process = Process + "4";
                    displayOne();
                }else if (Process.equals("0")) {
                    clear();
                    Process = Process + "4";
                    displayOne();
                }else {
                    Process = Process + "4";
                    displayOne();
                }
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!res.isEmpty() && Process.equals("0")){
                    clear();
                    Process = Process + "5";
                    displayOne();
                }else if (Process.equals("0")) {
                    clear();
                    Process = Process + "5";
                    displayOne();
                }else {
                    Process = Process + "5";
                    displayOne();
                }
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!res.isEmpty() && Process.equals("0")){
                    clear();
                    Process = Process + "6";
                    displayOne();
                }else if (Process.equals("0")) {
                    clear();
                    Process = Process + "6";
                    displayOne();
                }else {
                    Process = Process + "6";
                    displayOne();
                }
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!res.isEmpty() && Process.equals("0")){
                    clear();
                    Process = Process + "7";
                    displayOne();
                }else if (Process.equals("0")) {
                    clear();
                    Process = Process + "7";
                    displayOne();
                }else {
                    Process = Process + "7";
                    displayOne();
                }
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!res.isEmpty() && Process.equals("0")){
                    clear();
                    Process = Process + "8";
                    displayOne();
                }else if (Process.equals("0")) {
                    clear();
                    Process = Process + "8";
                    displayOne();
                }else {
                    Process = Process + "8";
                    displayOne();
                }
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!res.isEmpty() && Process.equals("0")){
                    clear();
                    Process = Process + "9";
                    displayOne();
                }else if (Process.equals("0")) {
                    clear();
                    Process = Process + "9";
                    displayOne();
                }else {
                    Process = Process + "9";
                    displayOne();
                }
            }
        });

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Process.isEmpty()){
                } else if (Process.endsWith(" + ") || Process.endsWith(" - ") || Process.endsWith(" × ") || Process.endsWith(" / ")) {
                    Process = Process.substring(0, Process.length() - 3);
                    Process = Process + " + ";
                } else {
                    Process = Process + " + ";
                }
                operator = true;
                displayOne();
            }
        });

        btMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Process.isEmpty()){
                } else if (Process.endsWith(" - ") || Process.endsWith(" + ") || Process.endsWith(" × ") || Process.endsWith(" / ")) {
                    Process = Process.substring(0, Process.length() - 3);
                    Process = Process + " - ";
                } else {
                    Process = Process + " - ";
                }
                operator = true;
                displayOne();
            }
        });

        btMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Process.isEmpty()){
                } else if (Process.endsWith(" + ") || Process.endsWith(" - ") || Process.endsWith(" × ") || Process.endsWith(" / ")) {
                    Process = Process.substring(0, Process.length() - 3);
                    Process = Process + " × ";
                } else {
                    Process = Process + " × ";
                }
                operator = true;
                displayOne();
            }
        });

        btDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Process.isEmpty()){
                } else if (Process.endsWith(" + ") || Process.endsWith(" - ") || Process.endsWith(" × ") || Process.endsWith(" / ")) {
                    Process = Process.substring(0, Process.length() - 3);
                    Process = Process + " / ";
                } else {
                    Process = Process + " / ";
                }
                operator = true;
                displayOne();
            }
        });


        btDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!res.isEmpty()){
                    clear();
                } else{
                    del();
                    displayOne();
                }
            }
        });
        btEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operator && Process.equals("") ){
                        operator = false;
                }
                if (operator == true && !Process.substring(Process.length()-1,Process.length()).equals(" ")){
                    String [] tokens = Process.split(" ");
                    switch (tokens[1].charAt(0)){
                        case '+':
                            res = Double.toString(Double.parseDouble(tokens[0]) + Double.parseDouble(tokens[2]));
                            break;
                        case '/':
                            res = Double.toString(Double.parseDouble(tokens[0]) / Double.parseDouble(tokens[2]));
                            break;
                        case '×':
                            res = Double.toString(Double.parseDouble(tokens[0]) * Double.parseDouble(tokens[2]));
                            break;
                        case '-':
                            res = Double.toString(Double.parseDouble(tokens[0]) - Double.parseDouble(tokens[2]));
                            break;
                    }
                    displayTwo();

                }

            }
        });

    }
    public void displayOne(){
        mEdit.setText(Process);
    }
    public void displayTwo(){
        mEdit.setText(res);
    }

    public void clear(){
        res = "";
        Process = "";
        operator = false;
    }

    public void del(){
        if (!Process.isEmpty()){
            if (Process.substring(Process.length()-1,Process.length()).equals(" ")){
                Process = Process.substring(0, Process.length()-3);
                operator = false;
            }else {
                Process = Process.substring(0, Process.length() - 1);
            }
        }
    }

}