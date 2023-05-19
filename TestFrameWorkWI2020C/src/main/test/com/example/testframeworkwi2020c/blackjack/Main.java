package com.example.testframeworkwi2020c.blackjack;

import java.util.*;

public class Main {
    public static void main(String[] args){
        System.out.println("Which Player do you want to use?");
        System.out.println("1 - RiskyPlayer");
        System.out.println("2 - ShyPlayer");
        System.out.println("3 - ManualPlayer");

        IPlayer player = null;


        Scanner input = new Scanner(System.in);
        switch(input.nextInt()){
            case 1: player = new RiskyPlayer();
                break;
            case 2: player = new ShyPlayer();
                break;
            case 3: player = new ManualPlayer();
                break;
        }

        Game myGame = new Game(player);

        int Budget = 0; //offer by player
        boolean OutOfMoney = false;

        do {
            System.out.println("New Round - Getting Offer");
            Budget = player.getOffer();
            System.out.println("Player Offered "+Budget);
            if(Budget == 0){
                OutOfMoney = true;
                System.out.println("Player is out of money!");
            } else {
                if(myGame.play() == 1){
                    player.informWinning(Budget*2);
                }
            }
        }while(OutOfMoney != true);


    }
}
