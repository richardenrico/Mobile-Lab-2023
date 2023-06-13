package com.example.quiz;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionAnswer {

    String question;
    String[] answers;
    int correctAnswers;

    public QuestionAnswer(String question,String[] answers, int correctAnswers) {
        this.question = question;
        this.answers = answers;
        this.correctAnswers = correctAnswers;
    }

    static ArrayList<QuestionAnswer> Quiz() {
        ArrayList soal = new ArrayList<QuestionAnswer>();

        soal.add(new QuestionAnswer("Siapakah leader dari TWICE?",new String[]{"Mina","Sana","Jihyo","Jeongyeon"}, 2));
        soal.add(new QuestionAnswer("TWICE dibentuk melalui survival show yang berjudul?",new String[]{"Sixteen", "Treasure BOX", "No Mercy", "Produce 101"}, 0));
        soal.add(new QuestionAnswer("Debut TWICE pada tahun?",new String[]{"2014","2018","2017","2015"}, 3));
        soal.add(new QuestionAnswer("Siapakah maknae dari TWICE?",new String[]{"Momo","Tzuyu","Chaeyoung","Nayeon"}, 1));
        soal.add(new QuestionAnswer("Apakah judul lagu dari TWICE yang dirilis pada 10 Maret 2023?",new String[]{"Alcohol-Free","The Feels","Set Me Free","Talk That Talk"}, 2));

        Collections.shuffle(soal);
        return soal;
//        return(ArrayList[]) soal.toArray(new ArrayList[]{});
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public String getAnswers(int correctAnswers) {
        return answers[correctAnswers];
    }
}
