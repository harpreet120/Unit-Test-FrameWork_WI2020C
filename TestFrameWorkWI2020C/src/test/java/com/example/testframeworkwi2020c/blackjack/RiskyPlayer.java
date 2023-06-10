package com.example.testframeworkwi2020c.blackjack;

public class RiskyPlayer implements IPlayer {
    private int totalBudget;

    public RiskyPlayer(){
        this.totalBudget = (int)Math.round(Math.random()*50)+50;
    }

    public int getOffer(){
        int temp = (int) Math.round(this.totalBudget / 4);
        this.totalBudget -= temp;
        return temp;
    }

    public Boolean getChoice(int score){
        if(score < 20){
            System.out.println("[PLAYER] Yes!");
            return true;
        } else {
            System.out.println("[PLAYER] No!");
            return false;
        }
    }

    public void informWinning(int profit){
        this.totalBudget += profit;
    }

    public int getTotalBudget() {
        return totalBudget;
    }
}
