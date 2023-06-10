package com.example.tp_mobile_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    Button A,B,C,D;

    int score = 0;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    private SharedPreferences sharedPreferences;
    int bestScore = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        A = findViewById(R.id.ans_A);
        B = findViewById(R.id.ans_B);
        C = findViewById(R.id.ans_C);
        D = findViewById(R.id.ans_D);

        sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        bestScore = sharedPreferences.getInt("best_score", 0);

        A.setOnClickListener(this);
        B.setOnClickListener(this);
        C.setOnClickListener(this);
        D.setOnClickListener(this);


        totalQuestionsTextView.setText("Total questions : "+totalQuestion);
        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {
        A.setEnabled(false);
        B.setEnabled(false);
        C.setEnabled(false);
        D.setEnabled(false);

        final Button clickedButton = (Button) view;
        selectedAnswer = clickedButton.getText().toString();

        if (selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])) {
            score++;
            A.setBackgroundColor(Color.RED);
            B.setBackgroundColor(Color.RED);
            C.setBackgroundColor(Color.RED);
            D.setBackgroundColor(Color.RED);
            clickedButton.setBackgroundColor(Color.GREEN);
        } else {
            if (A.getText().toString().equals(QuestionAnswer.correctAnswers[currentQuestionIndex])) {
                A.setBackgroundColor(Color.GREEN);
                B.setBackgroundColor(Color.RED);
                C.setBackgroundColor(Color.RED);
                D.setBackgroundColor(Color.RED);
            } else if (B.getText().toString().equals(QuestionAnswer.correctAnswers[currentQuestionIndex])) {
                A.setBackgroundColor(Color.RED);
                B.setBackgroundColor(Color.GREEN);
                C.setBackgroundColor(Color.RED);
                D.setBackgroundColor(Color.RED);
            } else if (C.getText().toString().equals(QuestionAnswer.correctAnswers[currentQuestionIndex])) {
                A.setBackgroundColor(Color.RED);
                B.setBackgroundColor(Color.RED);
                C.setBackgroundColor(Color.GREEN);
                D.setBackgroundColor(Color.RED);
            } else if (D.getText().toString().equals(QuestionAnswer.correctAnswers[currentQuestionIndex])) {
                A.setBackgroundColor(Color.RED);
                B.setBackgroundColor(Color.RED);
                C.setBackgroundColor(Color.RED);
                D.setBackgroundColor(Color.GREEN);
            }
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                A.setEnabled(true);
                B.setEnabled(true);
                C.setEnabled(true);
                D.setEnabled(true);

                A.setBackgroundColor(Color.WHITE);
                B.setBackgroundColor(Color.WHITE);
                C.setBackgroundColor(Color.WHITE);
                D.setBackgroundColor(Color.WHITE);

                currentQuestionIndex++;
                if (currentQuestionIndex < totalQuestion) {
                    loadNewQuestion();
                } else {
                    finishQuiz();
                }
            }
        }, 1000);
    }


    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion ){
            finishQuiz();
            return;
        }
        selectedAnswer = "";

        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        A.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        B.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        C.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        D.setText(QuestionAnswer.choices[currentQuestionIndex][3]);

    }

    void finishQuiz(){
        if (score >= bestScore) {
            bestScore = score;

            String name = getIntent().getStringExtra("Name");
            Uri selectedImage1 = getIntent().getParcelableExtra("Image");
            Intent intent = new Intent(getApplicationContext(), MainActivity4.class);

            if (score >= totalQuestion * 0.60) {
                String passStatus = "GOOD!!";
                intent.putExtra("status", passStatus);
            } else {
                String passStatus = "Nice Try";
                intent.putExtra("status", passStatus);
            }
            intent.putExtra("Image", selectedImage1);
            intent.putExtra("Name", name);
            intent.putExtra("Score", score * 20);
            intent.putExtra("best_score", score * 20);
            startActivity(intent);
        } else if(score < bestScore){
            String name = getIntent().getStringExtra("Name");
            Uri selectedImage1 = getIntent().getParcelableExtra("Image");
            int bestScore = getIntent().getIntExtra("best_score",0);
            Intent intent = new Intent(getApplicationContext(),MainActivity4.class);

            if (score >= totalQuestion*0.60){
                String passStatus = "GOOD!!";
                intent.putExtra("status" , passStatus);
            }else {
                String passStatus = "Nice Try";
                intent.putExtra("status" , passStatus);
            }
            intent.putExtra("Image" , selectedImage1);
            intent.putExtra("Name" , name);
            intent.putExtra("Score", score*20);
            intent.putExtra("best_score", bestScore);
            startActivity(intent);
        }

    }

}