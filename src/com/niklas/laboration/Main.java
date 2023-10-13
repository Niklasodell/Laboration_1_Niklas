package com.niklas.laboration;

import javax.xml.namespace.QName;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Scanner;

public class Main {
    List<Player> players;
    Dice dice;
    Scanner scan;

    public Main(int numDice, Scanner scanner) {

        players = new ArrayList<>();
        dice = new Dice(numDice);
        scan = scanner;
    }

    public void startGame() {
        String playerName;
        int playerCount = 1;

        while (true) {
            System.out.print("Enter name of player " + playerCount + " or 'done' to begin: ");
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

            System.out.print("For another round, enter 'yes' or 'no': ");
            String response = scan.nextLine().toLowerCase();

            if (response.equalsIgnoreCase("no")) {
                break;
            }

            round++;
        }

        System.out.println("Game Over!");

        System.out.println("\nFinal Scores:");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore());
        }

        sortPlayers();

        System.out.println("Winner: " + players.get(0).getName() + " with the score of:  " + players.get(0).getScore());
    }

    public void sortPlayers() {
        Collections.sort(players, (player1, player2) ->
                Integer.compare(player2.getScore(), player1.getScore()));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the amount of dice you want to use for the game: ");
        int numDice = scanner.nextInt();
        scanner.nextLine();

        Main diceGame = new Main(numDice, scanner);
        diceGame.startGame();
        diceGame.play();

        scanner.close();
    }
}

