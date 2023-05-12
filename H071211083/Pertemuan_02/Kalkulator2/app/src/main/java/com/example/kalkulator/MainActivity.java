package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.kalkulator.databinding.ActivityMainBinding;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private boolean isNewOp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btn0.setOnClickListener(view -> selectAction(view));
        binding.btn1.setOnClickListener(view -> selectAction(view));
        binding.btn2.setOnClickListener(view -> selectAction(view));
        binding.btn3.setOnClickListener(view -> selectAction(view));
        binding.btn4.setOnClickListener(view -> selectAction(view));
        binding.btn5.setOnClickListener(view -> selectAction(view));
        binding.btn6.setOnClickListener(view -> selectAction(view));
        binding.btn7.setOnClickListener(view -> selectAction(view));
        binding.btn8.setOnClickListener(view -> selectAction(view));
        binding.btn9.setOnClickListener(view -> selectAction(view));
        binding.btnac.setOnClickListener(view -> selectAction(view));
        binding.btnbg.setOnClickListener(view -> selectAction(view));
        binding.btndel.setOnClickListener(view -> selectAction(view));
        binding.btnkrg.setOnClickListener(view -> selectAction(view));
        binding.btnSD.setOnClickListener(view -> selectAction(view));
        binding.btntbh.setOnClickListener(view -> selectAction(view));
        binding.btnX.setOnClickListener(view -> selectAction(view));
        binding.hasil.setOnClickListener(view -> selectAction(view));
    }

    private void selectAction(View view) {
        isNewOp = false;
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = binding.hasil.getText().toString();

        switch (buttonText) {
            case "AC":
                binding.hasil.setText("0");
                isNewOp = true;
                break;
            case "DEL":
                if (dataToCalculate.length() > 1) {
                    dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length() - 1);
                    binding.hasil.setText(dataToCalculate);
                } else {
                    binding.hasil.setText("0");
                    isNewOp = true;
                }
                break;
            case "=":
                String hasil = binding.hasil.getText().toString();

                String[] beda = hasil.split("[X+-/]");
                if (beda.length > 1){
                    String bilangan1 = beda[0];
                    String bilangan2 = beda[1];
                    char operator = hasil.charAt(bilangan1.length());
                    double hasilfinal = 0;

                    switch (String.valueOf(operator)) {
                        case "+":
                            hasilfinal = Double.parseDouble(bilangan1) + Double.parseDouble(bilangan2);
                            break;
                        case "-":
                            hasilfinal = Double.parseDouble(bilangan1) - Double.parseDouble(bilangan2);
                            break;
                        case "X":
                            hasilfinal = Double.parseDouble(bilangan1) * Double.parseDouble(bilangan2);
                            break;
                        case "/":
                            hasilfinal = Double.parseDouble(bilangan1) / Double.parseDouble(bilangan2);
                            break;
                    }
                    if (hasilfinal%1 == 0){
                        binding.hasil.setText(String.valueOf((int) hasilfinal));
                    }else {
                        binding.hasil.setText(String.valueOf((hasilfinal)));
                    }

                }
                break;
            default:
                dataToCalculate += buttonText;
                System.out.println(dataToCalculate);
                String[] operators = {"X", "-", "+", "/"};
                boolean isContain = true;

                for (String s: operators) {
                    if (dataToCalculate.substring(1, 2).contains(s)) {
                        for (String op3 : operators){
                            if (dataToCalculate.length() > 2) {
                                if (dataToCalculate.substring(2).contains(op3)) {
                                    System.out.println("barbarbar");
                                    System.out.println(dataToCalculate);
                                    dataToCalculate = dataToCalculate.replace(dataToCalculate.substring(1, 2), "");
                                    System.out.println(dataToCalculate);
                                }
                            }
                        }
                        isContain = false;
                    }

                    if (!dataToCalculate.substring(0,1).equalsIgnoreCase("0")) {
                        if (dataToCalculate.substring(dataToCalculate.length() - 1 ).contains(s)) {
                            for (String op2 : operators) {
                                if (dataToCalculate.substring(dataToCalculate.length() - 2, dataToCalculate.length() - 1).contains(op2)){
                                    dataToCalculate = dataToCalculate.replace(dataToCalculate.substring(dataToCalculate.length() - 2, dataToCalculate.length() - 1), "");
                                }

                            }
                        }
                    }
                }
                if (isContain && dataToCalculate.substring(0,1).equalsIgnoreCase("0")){
                    dataToCalculate = dataToCalculate.substring(1);
                }
                binding.hasil.setText(dataToCalculate);

                break;
            }
        }
    }
