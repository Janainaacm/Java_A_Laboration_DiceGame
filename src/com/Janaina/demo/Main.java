package com.Janaina.demo;

import com.Janaina.demo.templates.Players;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        System.out.println("\u001B[35m" + "WELCOME TO THE DICE GAME!" + "\u001B[0m");

        selectPlayers();





    }


    public static void selectPlayers(){
        System.out.println("\u001B[36m" + "Firstly, how many players will be joining us?" + "\u001B[0m");
        int numberOfPlayers = scannerNumber();

        String[] arrayPlayers = new String[numberOfPlayers];

        System.out.println("\u001B[35m" + "Amazing!" + "\u001B[0m");
        System.out.println("\u001B[36m" + "Enter the players names: " + "\u001B[0m");
        for(int i=0; i<numberOfPlayers; i++) {

            arrayPlayers[i]= scannerText();
        }
        System.out.println("Player names are: ");

        for (int i=0; i<numberOfPlayers; i++){
            System.out.println(arrayPlayers[i]);

        }
    }









    public static int scannerNumber(){
        Scanner sc = new Scanner(System.in);

        return sc.nextInt();

    }


    public static String scannerText(){
        Scanner sc = new Scanner(System.in);

        return sc.nextLine();

    }


}
