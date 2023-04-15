package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;

    int score = 0;
    int totalQuestion = Question.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";


    int bestScore = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);


        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);


        totalQuestionsTextView.setText("Total questions : " + totalQuestion);

        loadNewQuestion();


    }

    @Override
    public void onClick(View view) {
        ansA.setEnabled(false);
        ansB.setEnabled(false);
        ansC.setEnabled(false);
        ansD.setEnabled(false);

        final Button clickedButton = (Button) view;
        selectedAnswer = clickedButton.getText().toString();

        if (selectedAnswer.equals(Question.correctAnswers[currentQuestionIndex])) {
            score++;
            clickedButton.setBackgroundColor(Color.GREEN);
        } else {
            clickedButton.setBackgroundColor(Color.RED);
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ansA.setEnabled(true);
                ansB.setEnabled(true);
                ansC.setEnabled(true);
                ansD.setEnabled(true);

                ansA.setBackgroundColor(Color.WHITE);
                ansB.setBackgroundColor(Color.WHITE);
                ansC.setBackgroundColor(Color.WHITE);
                ansD.setBackgroundColor(Color.WHITE);

                currentQuestionIndex++;
                if (currentQuestionIndex < totalQuestion) {
                    loadNewQuestion();
                } else {
                    finishQuiz();
                }
            }
        }, 1000);
    }


    void loadNewQuestion() {

        if (currentQuestionIndex == totalQuestion) {
            finishQuiz();
            return;
        }
        selectedAnswer = "";

        questionTextView.setText(Question.question[currentQuestionIndex]);
        ansA.setText(Question.choices[currentQuestionIndex][0]);
        ansB.setText(Question.choices[currentQuestionIndex][1]);
        ansC.setText(Question.choices[currentQuestionIndex][2]);
        ansD.setText(Question.choices[currentQuestionIndex][3]);


    }


    void finishQuiz() {
        String name = getIntent().getStringExtra("Fname");
        Uri selectedImage1 = getIntent().getParcelableExtra("image");
        Intent intent = new Intent(getApplicationContext(), Result.class);

        if (score >= totalQuestion * 0.60) {
            String passStatus = "GOOD!!";
            intent.putExtra("status", passStatus);
        } else {
            String passStatus = "Nice Try";
            intent.putExtra("status", passStatus);
        }
        intent.putExtra("image", selectedImage1);
        intent.putExtra("Name", name);
        intent.putExtra("Score", score * 20);

        int currentBestScore = getIntent().getIntExtra("best_score", 0);
        if (score > currentBestScore) {
            bestScore = score * 20;
        } else {
            bestScore = currentBestScore;
        }
        intent.putExtra("best_score", bestScore);
        startActivity(intent);
    }


}