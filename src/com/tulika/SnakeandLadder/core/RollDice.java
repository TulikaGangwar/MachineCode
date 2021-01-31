package com.tulika.SnakeandLadder.core;
import java.util.Random;
public class RollDice {
    private int diceRoll;
    public int getDiceRoll() {
        return new Random().nextInt(6) + 1;
    }
}
