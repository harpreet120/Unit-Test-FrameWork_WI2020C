package com.example.testframeworkwi2020c.wuerfel;

public class Dealer {

    private int score;
    private IDice dice;

    public void setDice(IDice dice){
        this.dice = dice;
    }

    public int getScore(){
        return score;
    }

    public void rollDice(){
        dice.roll();
        int nummer = dice.getNumber();
        if (nummer == 1 || nummer == 2) {
            score += nummer;
        } else if (nummer == 3 || nummer == 4) {
            score += (2 * nummer);
        } else if (nummer == 5) {
            score += (3 * nummer);
        } else if (nummer == 6) {
            score += (6 * nummer);
        }
    }
}
