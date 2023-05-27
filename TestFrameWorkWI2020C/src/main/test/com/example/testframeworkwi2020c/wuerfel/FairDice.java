package com.example.testframeworkwi2020c.wuerfel;

public class FairDice implements IDice {

    private int augenzahl;

    @Override
    public int getNumber() {
        return augenzahl;
    }

    @Override
    public void roll() {
        augenzahl = (int) (Math.random() * 6 + 1);
    }
}
