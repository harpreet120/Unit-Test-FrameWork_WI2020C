package com.example.testframeworkwi2020c.wuerfel;

public class UnfairDice implements IDice{

    private int roll;

    @Override
    public int getNumber() {
        return roll;
    }

    @Override
    public void roll() {
        roll = 6;
    }
}
