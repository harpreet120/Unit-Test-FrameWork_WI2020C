package com.example.testframeworkwi2020c.wuerfel;

public class Main {

    public static void main(String[] args) {
        Dealer dealer = new Dealer();

        dealer.setDice(new FairDice());
        do {
            dealer.rollDice();
            System.out.println(dealer.getScore());
        } while (dealer.getScore() <= 150);

        dealer = new Dealer();
        dealer.setDice(new UnfairDice());
        do {
            dealer.rollDice();
            System.out.println(dealer.getScore());
        } while (dealer.getScore() <= 150);
    }
}
