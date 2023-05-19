package com.example.testframeworkwi2020c.blackjack;

import java.util.Scanner;

public class ManualPlayer implements IPlayer {
    private int totalBudget;

    ManualPlayer(){
        System.out.println("How many Budget do you have?:");
        Scanner input = new Scanner(System.in);
        this.getChoice(10);
        this.totalBudget = input.nextInt();
    }

    public int getOffer(){
        System.out.println("You have "+this.totalBudget+" - how many do you want to place:");
        Scanner input = new Scanner(System.in);
        int temp = input.nextInt();
        this.totalBudget -= temp;
        return temp;
    }

    public Boolean getChoice(int score){
        System.out.println("Whats your choice (true/false)?");
        Scanner input = new Scanner(System.in);
        return input.nextBoolean();
    }

    public void informWinning(int profit){
        this.totalBudget += profit;
        System.out.println("Your new total Budget is "+this.totalBudget);
    }
}