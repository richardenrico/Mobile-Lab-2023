package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kalkulator.databinding.ActivityMainBinding;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    String process;
    String operator;
    int lenghtsecondNumber;
    private ActivityMainBinding binding;
    private boolean firstOperator = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstOperator = false;
                binding.input.angkaMasuk.setText("");
                binding.input.angkaKeluar.setText("");
                operator = null;
                binding.button.btnBagi.setEnabled(true);
                binding.button.btnKurang.setEnabled(true);
                binding.button.btnkali.setEnabled(true);
                binding.button.btnTambah.setEnabled(true);
                lenghtsecondNumber=0;
            }
        });


        binding.button.btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstOperator == false) {
                    firstOperator = true;
                }
                process = binding.input.angkaMasuk.getText().toString();

                if (process.length() == 1 && process.equals("0")) {
                    binding.input.angkaMasuk.setText(process.replace("0","0"));
                } else {
                    binding.input.angkaMasuk.setText(process + "0");
                }

                if (operator != null) {
                    lenghtsecondNumber++;
                }
            }

        });

        binding.button.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstOperator == false) {
                    firstOperator = true;
                }
                process = binding.input.angkaMasuk.getText().toString();

                if (process.length() == 1 && process.equals("0")) {
                    binding.input.angkaMasuk.setText(process.replace("0","1"));
                } else {
                    binding.input.angkaMasuk.setText(process + "1");
                }

                if (operator != null) {
                    lenghtsecondNumber++;
                }
            }
        });

        binding.button.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstOperator == false){
                    firstOperator = true;
                }
                process = binding.input.angkaMasuk.getText().toString();

                if (process.length() == 1 && process.equals("0")) {
                    binding.input.angkaMasuk.setText(process.replace("0","2"));
                } else {
                    binding.input.angkaMasuk.setText(process + "2");
                }

                if (operator != null) {
                    lenghtsecondNumber++;
                }
            }
        });

        binding.button.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstOperator == false) {
                    firstOperator = true;
                }
                process = binding.input.angkaMasuk.getText().toString();

                if (process.length() == 1 && process.equals("0")) {
                    binding.input.angkaMasuk.setText(process.replace("0","3"));
                } else {
                    binding.input.angkaMasuk.setText(process + "3");
                }

                if (operator != null){
                    lenghtsecondNumber++;
                }
            }
        });

        binding.button.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstOperator == false) {
                    firstOperator = true;
                }
                process = binding.input.angkaMasuk.getText().toString();

                if (process.length() == 1 && process.equals("0")) {
                    binding.input.angkaMasuk.setText(process.replace("0","4"));
                } else {

                    binding.input.angkaMasuk.setText(process + "4");
                }

                if (operator != null){
                    lenghtsecondNumber++;
                }
            }
        });

        binding.button.btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstOperator == false) {
                    firstOperator = true;
                }
                process = binding.input.angkaMasuk.getText().toString();

                if (process.length() == 1 && process.equals("0")) {
                    binding.input.angkaMasuk.setText(process.replace("0","5"));
                } else {
                    binding.input.angkaMasuk.setText(process + "5");
                }

                if (operator != null){
                    lenghtsecondNumber++;
                }
            }
        });

        binding.button.btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstOperator == false) {
                    firstOperator = true;
                }
                process = binding.input.angkaMasuk.getText().toString();

                if (process.length() == 1 && process.equals("0")) {
                    binding.input.angkaMasuk.setText(process.replace("0","6"));
                } else {
                    binding.input.angkaMasuk.setText(process + "6");
                }

                if (operator != null) {
                    lenghtsecondNumber++;
                }
            }
        });

        binding.button.btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstOperator == false) {
                    firstOperator = true;
                }
                process = binding.input.angkaMasuk.getText().toString();

                if (process.length() == 1 && process.equals("0")) {
                    binding.input.angkaMasuk.setText(process.replace("0", "7"));
                } else {
                    binding.input.angkaMasuk.setText(process + "7");
                }

                if (operator != null) {
                    lenghtsecondNumber++;
                }
            }
        });

        binding.button.btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstOperator == false) {
                    firstOperator = true;
                }
                process = binding.input.angkaMasuk.getText().toString();

                if (process.length() == 1 && process.equals("0")) {
                    binding.input.angkaMasuk.setText(process.replace("0","8"));
                } else {
                    binding.input.angkaMasuk.setText(process + "8");
                }

                if (operator != null){
                    lenghtsecondNumber++;
                }
            }
        });

        binding.button.btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstOperator == false) {
                    firstOperator = true;
                }
                process = binding.input.angkaMasuk.getText().toString();

                if (process.length() == 1 && process.equals("0")) {
                    binding.input.angkaMasuk.setText(process.replace("0","9"));
                } else {
                    binding.input.angkaMasuk.setText(process + "9");
                }

                if (operator != null){
                    lenghtsecondNumber++;
                }
            }
        });

        binding.button.btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstOperator==true) {
                    if (lenghtsecondNumber == 0) {
                        process = binding.input.angkaMasuk.getText().toString();
                        if(operator == null) {
                            binding.input.angkaMasuk.setText(process + "+");
                        }else {
                            binding.input.angkaMasuk.setText(process.substring(0,process.length()-1)+ "+");
                        }
                        operator = "+";

                    } else {
                        binding.button.btnBagi.setEnabled(false);
                        binding.button.btnKurang.setEnabled(false);
                        binding.button.btnkali.setEnabled(false);
                    }
                }
            }
        });

        binding.button.btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstOperator==true) {
                    if (lenghtsecondNumber == 0) {
                        process = binding.input.angkaMasuk.getText().toString();
                        if (operator == null) {
                            binding.input.angkaMasuk.setText(process + "-");
                        } else {
                            binding.input.angkaMasuk.setText(process.substring(0, process.length() - 1) + "-");
                        }
                        operator = "-";

                    } else {
                        binding.button.btnTambah.setEnabled(false);
                        binding.button.btnBagi.setEnabled(false);
                        binding.button.btnkali.setEnabled(false);
                    }
                }
            }
        });

        binding.button.btnkali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstOperator==true) {
                    if (lenghtsecondNumber == 0) {
                        process = binding.input.angkaMasuk.getText().toString();
                        if (operator == null) {
                            binding.input.angkaMasuk.setText(process + "×");
                        } else {
                            binding.input.angkaMasuk.setText(process.substring(0, process.length() - 1) + "×");
                        }
                        operator = "×";

                    } else {
                        binding.button.btnTambah.setEnabled(false);
                        binding.button.btnKurang.setEnabled(false);
                        binding.button.btnBagi.setEnabled(false);
                    }
                }
            }
        });

        binding.button.btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstOperator==true) {
                    if (lenghtsecondNumber == 0) {
                        process = binding.input.angkaMasuk.getText().toString();
                        if (operator == null) {
                            binding.input.angkaMasuk.setText(process + "÷");
                        } else {
                            binding.input.angkaMasuk.setText(process.substring(0, process.length() - 1) + "÷");
                        }
                        operator = "÷";

                    } else {
                        binding.button.btnTambah.setEnabled(false);
                        binding.button.btnKurang.setEnabled(false);
                        binding.button.btnkali.setEnabled(false);
                    }
                }
            }
        });

        binding.button.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word = binding.input.angkaMasuk.getText().toString();
                int input = word.length();
                if (input > 0) {
                    binding.input.angkaMasuk.setText(word.substring(0, input -1));

                    if (lenghtsecondNumber==0){
                        operator=null;
                        lenghtsecondNumber=0;
                        binding.button.btnBagi.setEnabled(true);
                        binding.button.btnKurang.setEnabled(true);
                        binding.button.btnkali.setEnabled(true);
                        binding.button.btnTambah.setEnabled(true);
                    } else {
                        lenghtsecondNumber--;
                    }
                }
            }
        });

        binding.button.btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double finalResult=0;
                int finalResult2=0;
                process = binding.input.angkaMasuk.getText().toString();
                String hasil[] = process.split("[÷×+-]");

                try {
                    System.out.println(process);
                    double satu = Double.parseDouble(hasil[0]);
                    double dua = Double.parseDouble(hasil[1]);

                    System.out.println((int)dua);
//                    if ((int)dua == 0){
//                        throw new Exception();
//                    }

                    if (operator == "×") {
                        finalResult2 = (int) satu * (int) dua;
                        binding.input.angkaKeluar.setText(String.valueOf(finalResult2));
                    } else if (operator == "-") {
                        finalResult2 = (int) satu - (int) dua;
                        binding.input.angkaKeluar.setText(String.valueOf(finalResult2));
                    } else if (operator == "+") {
                        finalResult2 = (int) satu + (int) dua;
                        binding.input.angkaKeluar.setText(String.valueOf(finalResult2));
                    } else if (operator == "÷") {

                        if (dua > 0) {
                            finalResult = satu / dua;
                            DecimalFormat format = new DecimalFormat("0.#");
                            String Tiga = (format.format(finalResult));
                            binding.input.angkaKeluar.setText(Tiga);
                        } else {
                            binding.input.angkaKeluar.setText("Undefined");
                        }

                    }
                } catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Input Error",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}