package com.Janaina.demo;

import com.Janaina.demo.templates.GetInput;
import com.Janaina.demo.templates.Player;

import java.util.ArrayList;
import java.util.List;

import static com.Janaina.demo.templates.PlayTheGame.playTheGame;


public class Main {


    public static void main(String[] args) {

        GetInput sc = new GetInput();

        System.out.println("\u001B[35m" + "WELCOME TO THE DICE GAME!" + "\u001B[0m");

        System.out.println("\u001B[36m" + "Firstly, how many players will be joining us?" + "\u001B[0m");
        int numberOfPlayers = sc.scannerNumber();

        ArrayList<Player> arrayPlayers = new ArrayList<>();

        System.out.println("\u001B[35m" + "Amazing!" + "\u001B[0m");

        System.out.println("\u001B[36m" + "How many dice do you want each player to throw? " + "\u001B[0m");
        int numberOfDice = sc.scannerNumber();

        System.out.println("\u001B[36m" + "Enter the players names: " + "\u001B[0m");

        for (int i = 0; i < numberOfPlayers; i++) {
            String playerNames = sc.scannerText();
            arrayPlayers.add(new Player(playerNames, numberOfDice));
        }

        System.out.println("\u001B[35m" + "NOW LET'S BEGIN!" + "\u001B[0m");


        boolean stopPlaying = playTheGame(numberOfPlayers, arrayPlayers, numberOfDice, true, sc);

        if (!stopPlaying) {
            findTheWinner(arrayPlayers, numberOfDice, sc);
        } else {
            System.out.println("\u001B[30m" + "Game over" + "\u001B[0m");

        }


    }


    public static Player findTheWinner(ArrayList<Player> arrayPlayers, int numberOfDice, GetInput sc) {

        Player winner = new Player("", -0);
        ArrayList<Player> winnerOrTie = new ArrayList<Player>();

        for (Player p : arrayPlayers) {
            if (p.score > winner.score) {
                winner = p;
                List<Player> removeOldWinners = winnerOrTie
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


            playTheGame(winnerOrTie.size(), winnerOrTie, numberOfDice, true, sc);

            return findTheWinner(winnerOrTie, numberOfDice, sc);

        } else {
            System.out.println("\u001B[35m" + "A round of applause for your winner " + winner.name + " with a score of: " + winner.score + "!!" + "\u001B[0m");
            return winner;

        }



    }



}