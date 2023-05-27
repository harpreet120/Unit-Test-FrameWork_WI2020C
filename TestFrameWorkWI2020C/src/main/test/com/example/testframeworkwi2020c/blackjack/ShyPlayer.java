package com.example.testframeworkwi2020c.blackjack;

public class ShyPlayer implements IPlayer {
    private int totalBudget;

    public ShyPlayer(){
        this.totalBudget = (int) Math.round(Math.random()*10)+30;
    }

    public int getOffer(){
        int temp = (int) Math.round(this.totalBudget / 12);
        this.totalBudget -= temp;
        return temp;
    }

    public Boolean getChoice(int score){
        if(score > 17){
            System.out.println("[PLAYER] No!");
            return false;
        } else {
            System.out.println("[PLAYER] Yes!");
            return true;
        }
    }

    public void informWinning(int profit){
        this.totalBudget += profit;
    }

    public int getTotalBudget(){
        return totalBudget;
    }
}
