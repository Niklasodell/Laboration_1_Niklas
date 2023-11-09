package com.niklas.laboration;

import java.util.Random;

public class Dice {
    public Random random;
    public int sides;
    public int numDice;

    public Dice(int sides, int numDice) {
        this.sides = sides;
        this.numDice = numDice;
        this.random = new Random();

    }

    public int roll() {
        int total = 0;

        for (int i = 0; i < numDice; i++) {
            total += random.nextInt(sides) + 1;
        }

        return total;

    }

}

