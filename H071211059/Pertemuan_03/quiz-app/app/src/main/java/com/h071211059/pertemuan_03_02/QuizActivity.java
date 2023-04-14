package com.h071211059.pertemuan_03_02;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.h071211059.pertemuan_03_02.databinding.ActivityQuizBinding;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class QuizActivity extends AppCompatActivity {
    String rightAnswer;
    long startTime;
    int score = 0;
    int quizCount = 0;
    private ActivityQuizBinding binding;
    Stack<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        createNewSetOfQuestions();

        // first round
        updateRound();

        // set listener
        binding.option0.setOnClickListener(this::checkAnswer);
        binding.option1.setOnClickListener(this::checkAnswer);
        binding.option2.setOnClickListener(this::checkAnswer);
        binding.option3.setOnClickListener(this::checkAnswer);
    }

    private void createNewSetOfQuestions() {
        Question[] questionsData = (Question[]) getIntent().getSerializableExtra("questions");
        Collections.shuffle(Arrays.asList(questionsData));
        Question[] randomQuestions = Arrays.copyOfRange(questionsData, 0, 5);
        Stack<Question> questions = new Stack<>();
        for (Question question : randomQuestions) {
            questions.push(question);
        }

        this.questions = questions;
    }

    private void checkAnswer(View userAnswer) {
        RelativeLayout answer = (RelativeLayout) userAnswer;
        String answerText = String.valueOf(((TextView) answer.getChildAt(0)).getText());
        ImageView ivOptionValue = (ImageView) answer.getChildAt(1);
        boolean isCorrect = answerText.equals(rightAnswer);

        updateAnswerImage(ivOptionValue, isCorrect);
        if (isCorrect) updateScore(System.currentTimeMillis());

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            ivOptionValue.setImageDrawable(null);
            updateRound();
        }, 1200);
    }

    private void updateScore(long endTime) {
        int timeTaken = (int) ((endTime - startTime) / 1000);
        if (timeTaken < 10) {
            score += 20;
        } else if (timeTaken < 15) {
            score += 10;
        } else {
            score += 1;
        }
    }

    private void updateAnswerImage(ImageView ivOptionValue, boolean isCorrect) {
        ivOptionValue.setImageDrawable(ResourcesCompat.getDrawable(getResources(),
                isCorrect ? R.drawable.ic_right : R.drawable.ic_wrong, null));
    }

    private void updateRound() {
        if (questions.isEmpty()) {
//            showScore();
            User user = getIntent().getParcelableExtra(MenuActivity.EXTRA_USER);
            Intent intent = new Intent(QuizActivity.this, ScoreActivity.class);
            intent.putExtra(ScoreActivity.EXTRA_SCORE, score);
            intent.putExtra(MenuActivity.EXTRA_USER, user);
            finish();
            startActivity(intent);
        } else {
            Question questionData = questions.pop();

            updateQuestion(questionData);
            updateOptions(questionData);
            updateQuizCount();
            this.startTime = System.currentTimeMillis();
        }
    }


    private void updateQuestion(Question questionData) {
        String question = questionData.getClubs();
        int id = getResources().getIdentifier(question, "drawable", getPackageName());
        this.rightAnswer = questionData.getName();

        binding.ivQuestions.setImageDrawable(ResourcesCompat.getDrawable(getResources(),
                id, null));
    }

    private void updateOptions(Question questions) {
        String[] options = questions.getOptions();
        Collections.shuffle(Arrays.asList(options));
        binding.option0Text.setText(options[0]);
        binding.option1Text.setText(options[1]);
        binding.option2Text.setText(options[2]);
        binding.option3Text.setText(options[3]);
    }

    private void updateQuizCount() {
        quizCount++;
        binding.quizNumber.setText(getString(R.string.quiz_number, quizCount));
    }
}