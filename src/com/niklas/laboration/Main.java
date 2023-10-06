package com.niklas.laboration;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Scanner;

public class Main {
    List<Player> players;
    Dice dice;
    Scanner scan;

    public Main(int numDice) {

        players = new ArrayList<>();
        dice = new Dice(numDice);
        scan = new Scanner(System.in);
        

        String playerName;
        int playerCount = 1;

        while (true) {
            System.out.print("Enter name " + playerCount + " or 'done' to begin: ");
            playerName = scan.nextLine().trim();

            if (playerName.equalsIgnoreCase("done")) {
                if (players.isEmpty()) {
                    System.out.println("You need atleast one player to start the game.");
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

            System.out.print("If you want to play another round enter 'yes' or 'no': ");
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

            List<Player> sortedList = players.stream().sorted().collect(Collectors.toList());
            System.out.println(sortedList);
        }
    }

    public static void main(String[] args) {
        Main diceGame = new Main(6);
        diceGame.play();
    }
}
