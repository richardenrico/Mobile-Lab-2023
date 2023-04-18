package com.example.quizapp.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {
    private String question;
    private String[] answers;
    private int correctAnswer;
    private int score;

    public Question(String question, String[] answers, int correctAnswer, int score) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
        this.score = score;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public int getScore() {
        return score;
    }

    public static List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question("'At least as deep as the pacific ocean,...' sambungan dari potongan lirik tersebut adalah...",
                new String[] {"You call the shots, babe", "Now i wanna be yours", "Secrets i have held in my heart", "if you like your coffee hot"}, 1, 100));
        questions.add(new Question("Nama lead vocalist dari band Chase Atlantic adalah...",
                new String[] {"Mitchel Cave", "Alex Turner", "Clinton Cave", "Abel Tesfaye"}, 0, 100));
        questions.add(new Question("Pemilik lagu berjudul 'I Wanna be Yours' adalah...",
                new String[] {"Chase Atlantic", "Lana del Rey", "The Weeknd", "Arctic Monkeys"}, 3, 100));
        questions.add(new Question("Salah satu lagu dari band 'Chase Atlantic adalah...",
                new String[] {"R U Mine?", "West Coast", "Church", "Is There Someone Else?"}, 2, 100));
        questions.add(new Question("'It's so sweet, knowing that you love me', adalah potongan lirik dari lagu berjudul...",
                new String[] {"Dark Paradise - Lana Del Rey", "Sweet - Cigarettes After Sex", "Reminder - The Weeknd", "Do I Wanna Know - Arctic Monkeys"}, 1, 100));
        questions.add(new Question("Salah satu lagu terpopuler dari band Chase Atlantic di spotify adalah...",
                new String[] {"Dancer in The Dark", "Consume", "Swim", "Heaven And Back"}, 2, 100));
        questions.add(new Question("Dibawah ini yang merupakan salah satu lagu dari penyanyi Lana del Rey adalah...",
                new String[] {"Ultraviolence", "Into It", "Call Out My Name", "Why'd You Only Call Me When You're High"}, 0, 100));

        Collections.shuffle(questions);

        return questions.subList(0, 5);
    }
}
