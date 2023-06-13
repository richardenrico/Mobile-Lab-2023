package com.example.quiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Question extends AppCompatActivity implements View.OnClickListener{
    TextView nom,que;
    Button pa,pb,pc,pd;
    User user;
    int sc = 0, totalQuestion = 5, currentQuestionIndex = 0;
    ArrayList<QuestionAnswer> dsoal;
    QuestionAnswer dkuis;
    ActivityResultLauncher<Intent> resultLauncher;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        nom = findViewById(R.id.nomor);
        que = findViewById(R.id.quest);
        pa = findViewById(R.id.pila);
        pb = findViewById(R.id.pilb);
        pc = findViewById(R.id.pilc);
        pd = findViewById(R.id.pild);

        user = new User();
        dsoal = QuestionAnswer.Quiz();

        resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result.getResultCode() == RESULT_OK){
                        assert result.getData() != null;
                        User user = result.getData().getParcelableExtra("user");
                        Intent intent = new Intent();
                        intent.putExtra("user",user);
                        setResult(RESULT_OK,intent);
                        finish();
                    }
                });

        pa.setOnClickListener(this);
        pb.setOnClickListener(this);
        pc.setOnClickListener(this);
        pd.setOnClickListener(this);

        nom.setText("Quiz " + (currentQuestionIndex+1) + " out of " + totalQuestion);
        user = getIntent().getParcelableExtra("user");
        loadNewQuest();
    }

    private void loadNewQuest() {
        if (currentQuestionIndex == totalQuestion){
            finishQuiz();
            return;
        }
        nom.setText("Quiz " + (currentQuestionIndex+1) + " out of " + totalQuestion);

        pa.setBackgroundColor(Color.rgb(255,95,162));
        pb.setBackgroundColor(Color.rgb(255,95,162));
        pc.setBackgroundColor(Color.rgb(255,95,162));
        pd.setBackgroundColor(Color.rgb(255,95,162));

        dkuis = dsoal.get(currentQuestionIndex);
        que.setText(dkuis.question);
        pa.setText(dkuis.answers[0]);
        pb.setText(dkuis.answers[1]);
        pc.setText(dkuis.answers[2]);
        pd.setText(dkuis.answers[3]);
    }

    @Override
    public void onClick(View view) {
        Button klik = (Button) view;

        selectedAnswer = String.valueOf(klik.getText());
        int correctAnswers = dkuis.getCorrectAnswers();

        if (selectedAnswer.equals(dkuis.getAnswers(correctAnswers))){
            klik.setBackgroundColor(Color.GREEN);
            sc = sc + 20;
            user.setScore(sc);
            delay();
        } else {
            klik.setBackgroundColor(Color.RED);
            sc = sc + 0;
            user.setScore(sc);
            delay();
        }
    }

    private void delay() {
        currentQuestionIndex++;

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadNewQuest();}
        }, 1000);
    }

    private void finishQuiz() {
        Intent toResult = new Intent(Question.this,QuizResult.class);
        toResult.putExtra("user",user);
        resultLauncher.launch(toResult);
    }
}