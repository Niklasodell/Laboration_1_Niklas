package com.niklas.laboration;

public class Player {
    public String name;
    public int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addToScore(int points) {
        score += points;
    }

}

