package com.powernode.entity;

public class Student {
    public String name;
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private String sayHello(String s,int i) {
        return "Hello " + s+i;
    }
}
