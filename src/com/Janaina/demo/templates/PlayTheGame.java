package com.Janaina.demo.templates;

import java.util.ArrayList;
import java.util.Random;


public class PlayTheGame {

    static Random random = new Random();

    public static int rollTheDice(int diceQuantity) {
        int sum = 0;
        for (int i = 1; i <= diceQuantity; i++) {
            int roll = random.nextInt(1, 7);
            sum = roll + sum;
        }
        return sum;
    }

    public static boolean playTheGame(int numberOfPlayers, ArrayList<Player> arrayPlayers, int numberOfDice, boolean isPlaying, GetInput sc) {


        do {

            for (int i = 0; i < numberOfPlayers; i++) {

                System.out.println("\u001B[36m" + arrayPlayers.get(i).name + "! Type 'go' to throw your dice, or 'stop' to exit game..." + "\u001B[0m");
                String action = sc.scannerText();

                switch (action) {
                    case "stop":
                        return isPlaying = true;
                    case "go":
                        System.out.println("PLAYING!");
                        int score = rollTheDice(numberOfDice);
                        arrayPlayers.get(i).setScore(score);
                        System.out.println("\u001B[31m" + "Your score is: " + arrayPlayers.get(i).score + "\u001B[0m");
                        isPlaying = false;
                        break;
                    default:
                        System.out.println("Wrong input");
                        break;


                }

            }


        } while (isPlaying);

        return isPlaying;


    }






}
