package com.example.tp_mobile_5;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionAnswer extends AppCompatActivity {
    public static String question [] = {
            "1. WHO THE MADMAN OF ZAUN?",
            "2. SION DIED IN A BATTLE AGAINST THE DEMACIAN KING?",
            "3. WHO IS THE SERIAL KILLER NAME, THE 'GOLDEN DEMON'?",
            "4. WHICH CHAMPION'S REAL NAME IS TOBIAS FELIX?",
            "5. WHAT'S THE NAME OF JINX'S REPEATER GUN?"
    };

    public static String choices[][] = {
            {"ZERI","URGOT","MUNDO","SINGED"},
            {"JARVAN IV","JARVAN III","JARVAN II","JARVAN I"},
            {"JHIN","SION","FIDDLESTICK","Gianluigi SHACO"},
            {"GRAVES","TWISTED FATE","MISS FORTUNE","ILLAOI"},
            {"BANG-BANG","BOOMBER","POW-POW","PUFF-PUFF"}
    };

    public static String correctAnswers[] = {
            "MUNDO",
            "JARVAN I",
            "JHIN",
            "TWISTED FATE",
            "POW-POW"
    };
}