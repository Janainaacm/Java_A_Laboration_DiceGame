package com.Janaina.test;

import com.Janaina.demo.templates.GetInput;
import com.Janaina.demo.templates.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.Janaina.demo.Main.findTheWinner;
import static com.Janaina.demo.templates.PlayTheGame.rollTheDice;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DiceGameTest {

    @Test
    public void testRollDiceWithOneDice() {

        int diceNumber = 1;

        for (int i = 0; i < 10; i++) {
            int diceRoll = rollTheDice(diceNumber);

            assertTrue(diceRoll >= 1 && diceRoll <= 6);
        }
    }

    @Test
    public void testRollDiceWithTwoDice() {

        int diceNumber = 2;

        for (int i = 0; i < 30; i++) {
            int diceRoll = rollTheDice(diceNumber);

            assertTrue(diceRoll >= 2 && diceRoll <= 12);
        }
    }

    @Test
    public void  testFindTheWinner(){
        GetInput sc = new GetInput();
        Player benny = new Player("Benny", 4);
        Player dom = new Player("Dom", 5);
        Player elvis = new Player("Elvis", 6);

        List<Player> listOfPlayers = List.of(benny, dom, elvis);

        ArrayList<Player> roundResult = new ArrayList<>(listOfPlayers);

        Player winner = findTheWinner(roundResult, 1, sc);

        assertEquals(elvis, winner);

    }

}