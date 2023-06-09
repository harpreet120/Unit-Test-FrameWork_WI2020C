package com.example.testframeworkwi2020c.wuerfel;

public class FairDice implements IDice{
    private int eyes = 0;

    public int getNumber(){
        return this.eyes;
    }

    public void roll(){
        this.eyes = (int)Math.round(Math.random()*5)+1;
    }
}