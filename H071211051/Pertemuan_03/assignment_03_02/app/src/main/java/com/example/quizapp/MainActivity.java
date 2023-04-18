package com.example.quizapp;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.example.quizapp.databinding.ActivityApplyBinding;
import com.example.quizapp.databinding.ActivityMainBinding;
import com.example.quizapp.models.Players;
import com.example.quizapp.models.Question;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int currentIndex = 0, userScore = 0;
    private List<Question> questionList;
    public static final String EXTRA_PLAYERS = "extra_players";
    private MaterialButton[] btnChoices;
    private boolean isClicked = true;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        questionList = Question.getAllQuestions();

        btnChoices = new MaterialButton[] {binding.choice1, binding.choice2, binding.choice3, binding.choice4};
        renderQuestion();
        btnChoices[0].setOnClickListener(view -> onAnswerClicked(0));
        btnChoices[1].setOnClickListener(view -> onAnswerClicked(1));
        btnChoices[2].setOnClickListener(view -> onAnswerClicked(2));
        btnChoices[3].setOnClickListener(view -> onAnswerClicked(3));

    }

    private void renderQuestion() {
        Question question = questionList.get(currentIndex);
        binding.textView2.setText(String.format("Quiz %d of 5", currentIndex + 1));
        binding.questionText.setText(question.getQuestion());
        for (int i = 0; i < btnChoices.length; i++) {
            btnChoices[i].setText(question.getAnswers()[i]);
            btnChoices[i].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#D3FFFFFF")));
        }
    }

    private void onAnswerClicked(int index) {
        if (isClicked) {
            isClicked = false;
            Question question = questionList.get(currentIndex);
            boolean isTrue = index == question.getCorrectAnswer();
            userScore += isTrue ? question.getScore() : 0;

            if (index == question.getCorrectAnswer()) {
                btnChoices[index].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00ff00")));
            } else {
                btnChoices[index].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#Ff0000")));
            }

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (currentIndex == 4) {
                        Players players = getIntent().getParcelableExtra(EXTRA_PLAYERS);
                        Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                        intent.putExtra(ResultActivity.EXTRA_SCORE, userScore);
                        intent.putExtra(EXTRA_PLAYERS, players);
                        startActivity(intent);
                    } else {
                        currentIndex++;
                        renderQuestion();
                        isClicked = true;
                    }
                }
            }, 1000);
        }
    }
}