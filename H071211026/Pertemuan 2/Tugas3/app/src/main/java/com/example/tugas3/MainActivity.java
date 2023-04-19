package com.example.tugas3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class MainActivity extends AppCompatActivity {
    String[] op = {"+", "/", "-", "x"};
    boolean isNewOp = true;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btnHasil = findViewById(R.id.btnHasil);
        Button btnReset = findViewById(R.id.btnReset);
        Button btnHapus = findViewById(R.id.btnHapus);
        Button btnTambah = findViewById(R.id.btnTambah);
        Button btnKurang = findViewById(R.id.btnKurang);
        Button btnKali = findViewById(R.id.btnKali);
        Button btnBagi = findViewById(R.id.btnBagi);
        TextView angkaMasuk = findViewById(R.id.angkaMasuk);
        TextView angkaKeluar = findViewById(R.id.angkaKeluar);

        AtomicReference<String> operator = new AtomicReference<>("");

        btn0.setOnClickListener(view -> {
            if (isNewOp) {
                angkaMasuk.setText("");
                operator.set("");
                isNewOp = false;
            }
            angkaMasuk.setText(angkaMasuk.getText() + "0");
        });

        btn1.setOnClickListener(view -> {
            if (isNewOp) {
                operator.set("");
                angkaMasuk.setText("");
                isNewOp = false;
            }
            angkaMasuk.setText(angkaMasuk.getText() + "1");
        });

        btn2.setOnClickListener(view -> {
            if (isNewOp) {
                operator.set("");
                angkaMasuk.setText("");
                isNewOp = false;
            }
            angkaMasuk.setText(angkaMasuk.getText() + "2");
        });

        btn3.setOnClickListener(view -> {
            if (isNewOp) {
                operator.set("");
                angkaMasuk.setText("");
                isNewOp = false;
            }
            angkaMasuk.setText(angkaMasuk.getText() + "3");
        });

        btn4.setOnClickListener(view -> {
            if (isNewOp) {
                operator.set("");
                angkaMasuk.setText("");
                isNewOp = false;
            }
            angkaMasuk.setText(angkaMasuk.getText() + "4");
        });

        btn5.setOnClickListener(view -> {
            if (isNewOp) {
                operator.set("");
                angkaMasuk.setText("");
                isNewOp = false;
            }
            angkaMasuk.setText(angkaMasuk.getText() + "5");
        });
        btn6.setOnClickListener(view -> {
            if (isNewOp) {
                operator.set("");
                angkaMasuk.setText("");
                isNewOp = false;
            }
            angkaMasuk.setText(angkaMasuk.getText() + "6");
        });

        btn7.setOnClickListener(view -> {
            if (isNewOp) {
                operator.set("");
                angkaMasuk.setText("");
                isNewOp = false;
            }
            angkaMasuk.setText(angkaMasuk.getText() + "7");
        });

        btn8.setOnClickListener(view -> {
            if (isNewOp) {
                operator.set("");
                angkaMasuk.setText("");
                isNewOp = false;
            }
            angkaMasuk.setText(angkaMasuk.getText() + "8");
        });

        btn9.setOnClickListener(view -> {
            if (isNewOp) {
                operator.set("");
                angkaMasuk.setText("");
                isNewOp = false;
            }
            angkaMasuk.setText(angkaMasuk.getText() + "9");
        });

        btnTambah.setOnClickListener(view -> {
            String cek = angkaMasuk.getText().toString();
            boolean isContain = false;

            if(cek.length() > 0){
                for (String s :
                        op) {
                    if (cek.endsWith(s)) {
                        angkaMasuk.setText(cek.substring(0, cek.length() - 1) + "+");
                        operator.set("+");
                        cek = cek.substring(0, cek.length() - 1) + "+";
                    }
                }
                if (operator.get().equals("")){
                    angkaMasuk.setText(angkaMasuk.getText() + "+");
                    operator.set("+");
                }
                else {
                    angkaMasuk.setText(cek);
                }
            }
            else {
                angkaMasuk.setText("");
            }
        });

        btnKurang.setOnClickListener(view -> {
            String cek = angkaMasuk.getText().toString();
            if(cek.length() > 0){
                for (String s :
                        op) {
                    if (cek.endsWith(s)) {
                        angkaMasuk.setText(cek.substring(0, cek.length() - 1) + "-");
                        operator.set("-");
                        cek = cek.substring(0, cek.length() - 1) + "-";
                    }
                }
                if (operator.get().equals("")){
                    angkaMasuk.setText(angkaMasuk.getText() + "-");
                    operator.set("-");
                }
                else {
                    angkaMasuk.setText(cek);
                }
            }
            else {
                angkaMasuk.setText("");
            }
        });

        btnKali.setOnClickListener(view -> {
            String cek = angkaMasuk.getText().toString();
            if(cek.length() > 0 ){
                for (String s :
                        op) {
                    if (cek.endsWith(s)) {
                        angkaMasuk.setText(cek.substring(0, cek.length() - 1) + "x");
                        operator.set("x");
                        cek = cek.substring(0, cek.length() - 1) + "x";
                    }
                }
                if (operator.get().equals("")){
                    angkaMasuk.setText(angkaMasuk.getText() + "x");
                    operator.set("x");
                }
                else {
                    angkaMasuk.setText(cek);
                }
            }
            else {
                angkaMasuk.setText("");
            }
        });

        btnBagi.setOnClickListener(view -> {
            String cek = angkaMasuk.getText().toString();
            if(cek.length() > 0){
                for (String s :
                        op) {
                    if (cek.endsWith(s)) {
                        angkaMasuk.setText(cek.substring(0, cek.length() - 1) + "/");
                        operator.set("/");
                        cek = cek.substring(0, cek.length() - 1) + "/";
                    }
                }
                if (operator.get().equals("")){
                    angkaMasuk.setText(angkaMasuk.getText() + "/");
                    operator.set("/");
                }
                else {
                    angkaMasuk.setText(cek);
                }
            }
            else {
                angkaMasuk.setText("");
            }
        });

        btnReset.setOnClickListener(view -> {
            angkaMasuk.setText("");
            angkaKeluar.setText("");
            operator.set("");
        });

        btnHapus.setOnClickListener(view -> {
            String a = angkaMasuk.getText().toString();
            if(a.length() > 0){
                String b = a.substring(0, a.length() - 1);
                angkaMasuk.setText(b);

                for (String op : op) {
                    if (operator.get().equals(op)) {
                        operator.set("");
                        break;
                    }
                }
                if (angkaMasuk.getText().toString().length() == 0) {
                    angkaMasuk.setText("");
                    operator.set("");
                }
            }
        });

        btnHasil.setOnClickListener(view -> {
            if(angkaMasuk.length() > 0){
                boolean isContain = true;
                for (String s : op) {
                    if (angkaMasuk.getText().toString().substring(angkaMasuk.getText().length() - 1).contains(s)) {
                        isContain = false;
                        break;
                    }
                }

                if (isContain && !operator.get().equals("")) {
                    String[] a;
                    if (operator.get().equalsIgnoreCase("+")) {
                        a = angkaMasuk.getText().toString().split("\\+");
                    } else {
                        a = angkaMasuk.getText().toString().split(operator.get());
                    }
                    int[] angka = new int[a.length];

                    angka[0] = Integer.parseInt(a[0]);
                    angka[1] = Integer.parseInt(a[1]);

                    float hasil = 0;

                    if (operator.get().equals("+")) {
                        hasil = angka[0] + angka[1];
                    }
                    else if (operator.get().equals("-")) {
                        hasil = angka[0] - angka[1];
                    }
                    else if (operator.get().equals("x")) {
                        hasil = angka[0] * angka[1];
                    }
                    else if (operator.get().equals("/")) {
                        hasil = angka[0] / angka[1];
                    }

                    isNewOp = true;
                    angkaKeluar.setText(String.valueOf(hasil));
                }
            }
            else {
                angkaMasuk.setText("");
            }
        });
    }


}