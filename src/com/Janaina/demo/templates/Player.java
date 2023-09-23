package com.Janaina.demo.templates;

public class Player {

    public String name;
    public int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore (){
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }



/*
switch (action) {
                    case "stop" -> isPlaying = false;
                    case "go" -> {
                        System.out.println("PLAYING!");
                        int score = rollTheDice(1, 6) * numberOfDice;
                        arrayPlayers.get(i).setScore(score);
                        System.out.println("\u001B[31m" + "Your score is: " + arrayPlayers.get(i).score + "\u001B[0m");
                        isPlaying = false;
                    }
                    default -> System.out.println("Wrong input");
                }
 */












}


