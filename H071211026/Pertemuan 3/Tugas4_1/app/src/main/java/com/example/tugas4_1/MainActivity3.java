package com.example.tugas4_1;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.tugas4_1.databinding.ActivityMain3Binding;

import java.util.List;
import java.util.Stack;

public class MainActivity3 extends AppCompatActivity {

    private ActivityMain3Binding binding;
    private Stack<Soal> setPertanyaan;
    private Soal soal;
    public int score = 0;
    private String username;

    private Boolean periksaJawaban = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<Soal> listPertanyaan = Soal.pertanyaan;

        setPertanyaan = new Stack<>();
        for (Soal soal:
             listPertanyaan) {
            setPertanyaan.push(soal);
        }
        updateSoal();
        setListeners();
    }
    @SuppressLint("ResourceAsColor")
    private void updateSoal(){
        if(!setPertanyaan.isEmpty()){
            soal = setPertanyaan.pop();
            binding.soal.setText(soal.getSoal());
            binding.opsi1.setText(soal.getOpsi()[0]);
            binding.opsi2.setText(soal.getOpsi()[1]);
            binding.opsi3.setText(soal.getOpsi()[2]);
            binding.opsi4.setText(soal.getOpsi()[3]);

        }
        else {
            Intent intent = new Intent(this, MainActivity4.class);
            username = getIntent().getStringExtra("username");
            String bestScore = getIntent().getStringExtra("bestScore");
            intent.putExtra("score", score);
            intent.putExtra("username", username);
            intent.putExtra("bestScore", bestScore);
            startActivity(intent);
        }
    }

    @SuppressLint("ResourceAsColor")
    private void setListeners(){
        binding.opsi1.setOnClickListener(view -> {
            Handler handler = new Handler();
            String jawaban = binding.opsi1.getText().toString();
            cekJawaban(jawaban, soal.getJawaban());
            if(periksaJawaban){
                binding.opsi1.setBackgroundColor(getColor(R.color.green));
            }
            else {
                binding.opsi1.setBackgroundColor(getColor(R.color.red));
            }
            handler.postDelayed(() ->{
                updateSoal();
                binding.opsi1.setBackgroundColor(getColor(R.color.teal_200));
            }, 1000);
        });

        binding.opsi2.setOnClickListener(view -> {
            Handler handler = new Handler();
            String jawaban = binding.opsi2.getText().toString();
            cekJawaban(jawaban, soal.getJawaban());
            if(periksaJawaban){
                binding.opsi2.setBackgroundColor(getColor(R.color.green));
            }
            else {
                binding.opsi2.setBackgroundColor(getColor(R.color.red));
            }
            handler.postDelayed(() ->{
                updateSoal();
                binding.opsi2.setBackgroundColor(getColor(R.color.teal_200));
            }, 1000);
        });

        binding.opsi3.setOnClickListener(view -> {
            Handler handler = new Handler();
            String jawaban = binding.opsi3.getText().toString();
            cekJawaban(jawaban, soal.getJawaban());
            if(periksaJawaban){
                binding.opsi3.setBackgroundColor(getColor(R.color.green));
            }
            else {
                binding.opsi3.setBackgroundColor(getColor(R.color.red));
            }
            handler.postDelayed(() ->{
                updateSoal();
                binding.opsi3.setBackgroundColor(getColor(R.color.teal_200));
            }, 1000);
        });

        binding.opsi4.setOnClickListener(view -> {
            Handler handler = new Handler();
            String jawaban = binding.opsi4.getText().toString();
            cekJawaban(jawaban, soal.getJawaban());
            if(periksaJawaban){
                binding.opsi4.setBackgroundColor(getColor(R.color.green));
            }
            else {
                binding.opsi4.setBackgroundColor(getColor(R.color.red));
            }
            handler.postDelayed(() ->{
                updateSoal();
                binding.opsi4.setBackgroundColor(getColor(R.color.teal_200));
            }, 1000);
        });

    }
    public void cekJawaban(String opsi, String jawaban){
        int nomor = Integer.parseInt(binding.nomor.getText().toString());
        if (nomor <= 5){
            int nomorNext = nomor + 1;
            binding.nomor.setText(String.valueOf(nomorNext));
        }
        else {
            binding.nomor.setText(String.valueOf(nomor));
        }

        if(opsi.equals(jawaban)){
            score += 100;
            periksaJawaban = true;
        }
        else {
            periksaJawaban = false;
        }
    }
}