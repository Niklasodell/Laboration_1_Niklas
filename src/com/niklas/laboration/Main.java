package com.niklas.laboration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public List<Player> players;
    public Dice dice;
    public Scanner scan;

    public Main(int numDiceSides) {
        players = new ArrayList<>();
        dice = new Dice(numDiceSides);
        scan = new Scanner(System.in);

        System.out.println("Welcome to my dice game, please read the instructions as they come up!");
        String playerName;
        int playerCount = 1;

        while (true) {
            System.out.print("Enter name " + playerCount + " or 'done' to start: ");
            playerName = scan.nextLine().trim();

            if (playerName.equalsIgnoreCase("done")) {
                if (players.isEmpty()) {
                    System.out.println("You need least one player to start the game.");
                    continue;
                } else {
                    break;
                }
            }

            players.add(new Player(playerName));
            playerCount++;
        }
    }

    public void play() {
        int round = 1;

        while (true) {
            System.out.println("\nRound " + round + " begins!");

            for (Player player : players) {
                int rollResult = dice.roll();
                player.addToScore(rollResult);
                System.out.println(player.getName() + " rolled a " + rollResult);
                System.out.println(player.getName() + "'s total score: " + player.getScore());
            }

            System.out.println("End of round " + round + "\n");

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scan.nextLine().toLowerCase();

            if (response.equals("no")) {
                break;
            }

            round++;
        }

        System.out.println("Game Over!");

        System.out.println("\nFinal Scores:");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore());
        }
    }

    public static void main(String[] args) {
        Main diceGame = new Main(6);
        diceGame.play();
    }
}
