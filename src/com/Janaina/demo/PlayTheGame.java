package com.Janaina.demo;

import com.Janaina.demo.templates.GetInput;
import com.Janaina.demo.templates.Player;

import java.util.ArrayList;

import static com.Janaina.demo.Main.rollTheDice;

public class PlayTheGame {


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
                        int score = rollTheDice(1, 6) * numberOfDice;
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
