package com.Janaina.demo;

import com.Janaina.demo.templates.Player;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        System.out.println("\u001B[35m" + "WELCOME TO THE DICE GAME!" + "\u001B[0m");

        System.out.println("\u001B[36m" + "Firstly, how many players will be joining us?" + "\u001B[0m");
        int numberOfPlayers = scannerNumber();

        var arrayPlayers = new ArrayList<Player>();

        System.out.println("\u001B[35m" + "Amazing!" + "\u001B[0m");

        System.out.println("\u001B[36m" + "How many dice do you want each player to throw? " + "\u001B[0m");
        int numberOfDice = scannerNumber();

        System.out.println("\u001B[36m" + "Enter the players names: " + "\u001B[0m");

        for (int i = 0; i < numberOfPlayers; i++) {
            String playerNames = scannerText();
            arrayPlayers.add(new Player(playerNames, numberOfDice));
        }

        System.out.println("\u001B[35m" + "NOW LET'S BEGIN!" + "\u001B[0m");


        playTheGame(numberOfPlayers, arrayPlayers, numberOfDice);

        findTheWinner(arrayPlayers, numberOfDice);


    }

    public static void playTheGame(int numberOfPlayers, ArrayList<Player> arrayPlayers, int numberOfDice) {


        boolean isPlaying = true;

        for (int i = 0; i < numberOfPlayers; i++) {


            do {

                System.out.println("\u001B[36m" + arrayPlayers.get(i).name + "! Type 'go' to throw your dice, or 'stop' to exit game..." + "\u001B[0m");
                String action = scannerText();

                if (Objects.equals(action, "stop")){
                    isPlaying = false;

                } else if (Objects.equals(action, "go")){
                System.out.println("PLAYING!");
                int score = rollTheDice(1, 6) * numberOfDice;
                arrayPlayers.get(i).setScore(score);
                System.out.println("\u001B[31m" + "Your score is: " + arrayPlayers.get(i).score + "\u001B[0m");

                } else {
                    System.out.println("Wrong input, try again!");
                }


            } while (isPlaying);


        }

    }


    public static int rollTheDice(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


    private static void findTheWinner(ArrayList<Player> arrayPlayers, int numberOfDice) {

        var winner = new Player("", -0);
        var winnerOrTie = new ArrayList<Player>();

        for (Player p : arrayPlayers) {
            if (p.score > winner.score) {
                winner = p;
                var removeOldWinners = winnerOrTie
                        .stream()
                        .filter(player -> player.score < p.score)
                        .toList();
                removeOldWinners.forEach(
                        winnerOrTie::remove
                );
                winnerOrTie.add(winner);
            } else if (p.score == winner.score) {
                winnerOrTie.add(p);

            }
        }

        if (winnerOrTie.size() > 1) {

            System.out.println("\u001B[35m" + "We have a tie between players: " + "\u001B[0m");
            winnerOrTie.forEach(
                    player -> System.out.println("\u001B[36m" + player.name + " with score: " + player.score + " \n" + "\u001B[0m")
            );
            System.out.println("\u001B[35m" + "let play again to tiebreaker and find a winner." + "\u001B[0m");


            playTheGame(winnerOrTie.size(), winnerOrTie, numberOfDice);
            findTheWinner(winnerOrTie, numberOfDice);

        } else {
            System.out.println("\u001B[35m" + "A round of applause for your winner " + winner.name + " with a score of: " + winner.score + "!!" + "\u001B[0m");
        }

    }


    public static int scannerNumber() {
        Scanner sc = new Scanner(System.in);

        return sc.nextInt();

    }


    public static String scannerText() {
        Scanner sc = new Scanner(System.in);

        return sc.nextLine();

    }


}