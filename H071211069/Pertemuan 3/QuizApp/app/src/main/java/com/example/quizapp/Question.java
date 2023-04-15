package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Question extends AppCompatActivity {

    public static String question[] ={
            "1. Siapa The Real GOAT?",
            "2. Siapa Pemain Bola Dengan Julukan The Tractor?",
            "3. Siapa Pemain Dibawah Ini Yang Pernah mendapat Ballon D'or?",
            "4. Siapa Pemain Dibawah Ini Pemilik Super Ballon D'or?",
            "5. Siapa Tim Dibawah Ini Yang Belum Pernah Juara Treble?"
    };

    public static String choices[][] = {
            {"CR7","Messi","Maradonna","Pele"},
            {"Javier Zanetti","Gattuso","Ruud Gullit","Arjen Robben"},
            {"Francesco Toldo","Oliver Khan","Lev Yashin","Gianluigi Buffon"},
            {"Messi","CR7","Michel Platini","Di Stefano"},
            {"Inter Milan","Barcelona","Real Madrid","PSV"}
    };

    public static String correctAnswers[] = {
            "Messi",
            "Javier Zanetti",
            "Lev Yashin",
            "Di Stefano",
            "Real Madrid"
    };
}