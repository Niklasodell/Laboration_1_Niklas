package com.niklas.laboration;

import java.util.Random;

public class Dice {
    public Random random;
    public int sides;

    public Dice(int sides) {
        this.sides = sides;
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(sides) + 1;
    }
}