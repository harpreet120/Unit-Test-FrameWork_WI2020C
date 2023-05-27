package com.example.testframeworkwi2020c.blackjack;

public interface IPlayer {
    int getOffer();
    Boolean getChoice(int punktestand);
    void informWinning(int gewinnsumme);
}
