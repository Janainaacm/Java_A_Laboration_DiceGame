package com.Janaina.demo;

import com.Janaina.demo.templates.Player;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        System.out.println("\u001B[35m" + "WELCOME TO THE DICE GAME!" + "\u001B[0m");

        System.out.println("\u001B[36m" + "Firstly, how many players will be joining us?" + "\u001B[0m");
        int numberOfPlayers = scannerNumber();

        Player[] arrayPlayers = new Player[numberOfPlayers];

        System.out.println("\u001B[35m" + "Amazing!" + "\u001B[0m");

        System.out.println("\u001B[36m" + "How many dice do you want each player to throw? " + "\u001B[0m");
        int numberOfDice = scannerNumber();

        System.out.println("\u001B[36m" + "Enter the players names: " + "\u001B[0m");

        for (int i = 0; i < numberOfPlayers; i++) {

            String playerNames = scannerText();
            arrayPlayers[i] = new Player(playerNames, numberOfDice);

        }


        System.out.println("\u001B[35m" + "NOW LET'S BEGIN!" + "\u001B[0m");
        Random random = new Random();

        
        for (int i = 0; i <= numberOfPlayers; i++) {
            if (i == numberOfPlayers){
                Player winner = null;

                for (Player p : arrayPlayers) {
                    winner = new Player(p.name, 0);
                    while (winner.score < p.score) {
                        winner = p;
                    }
                }
                System.out.println("The winner of this round is: " + winner.name + winner.score);
            }

            boolean isPlaying = true;

            do {

                System.out.println("\u001B[36m" + arrayPlayers[i].name + "! Type 'go' to throw your dice, or 'stop' to quit game..." + "\u001B[0m");
                String action = scannerText();

                switch(action){
                    case "stop":
                        isPlaying = false;
                        break;
                    case "go":
                        System.out.println("PLAYING!");

                        arrayPlayers[i].score = random.nextInt(6 - 1 ) * numberOfDice;
                        System.out.println("Your score is: " + arrayPlayers[i].score);

                        isPlaying = false;
                        break;
                    default:
                        System.out.println("Wrong input");
                        break;
                }

            } while (isPlaying);

        }


    }


/*
  System.out.println("Player names are: ");

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println(arrayPlayers[i]);

        }


 */

    public static int scannerNumber() {
        Scanner sc = new Scanner(System.in);

        return sc.nextInt();

    }


    public static String scannerText() {
        Scanner sc = new Scanner(System.in);

        return sc.nextLine();

    }


}
