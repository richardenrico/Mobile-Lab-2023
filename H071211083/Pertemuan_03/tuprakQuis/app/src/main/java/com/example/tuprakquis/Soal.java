package com.example.tuprakquis;

public class Soal {
    private String pertanyaan;

    private String [] opsi;
    private int benar;
    private int score;

    public Soal(String pertanyaan, String[] opsi, int benar, int score) {
        this.pertanyaan = pertanyaan;
        this.opsi = opsi;
        this.benar = benar;
        this.score = score;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }

    public String[] getOpsi() {
        return opsi;
    }

    public int getBenar() {
        return benar;
    }

    public int getScore() {
        return score;
    }
}
