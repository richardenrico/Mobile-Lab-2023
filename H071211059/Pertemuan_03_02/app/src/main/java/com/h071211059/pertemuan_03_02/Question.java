package com.h071211059.pertemuan_03_02;

import java.io.Serializable;

public class Question implements Serializable {
    private String name;
    private String[] options;
    private String clubs;

    public Question(String name, String[] options, String clubs) {
        this.name = name;
        this.options = options;
        this.clubs = clubs;
    }

    public String getName() {
        return name;
    }

    public String[] getOptions() {
        return options;
    }

    public String getClubs() {
        return clubs;
    }
}
