package com.example.testframeworkwi2020c.blackjack;

public class Game {
    private IPlayer player;

    Game(IPlayer player){
        this.player = player;
    }

    public int play(){
        int scoreBank = 0;
        int scorePlayer = 0;
        int card = 0;
        boolean playerPassed = false;
        boolean bankPassed = false;
        do {

            if(!bankPassed && scoreBank < 16){
                scoreBank += (int)Math.round(Math.random()*9)+2;
            }
            else
            {
                bankPassed = true;
            }

            System.out.println("[BANK] Your current score: "+scorePlayer);
            if(!playerPassed && this.player.getChoice(scorePlayer)){
                card = (int)Math.round(Math.random()*9)+2;
                System.out.println("[BANK] You got an "+card);
                scorePlayer += card;
            }
            else
            {
                playerPassed = true;
            }
        }while(!bankPassed || !playerPassed);

        if(scorePlayer < 22 && (scorePlayer > scoreBank || scoreBank > 21)){
            System.out.println("[BANK] Player won!");
            return 1;
        }
        else
        {
            System.out.println("[BANK] Bank won with "+scoreBank+"!");
            return 0;
        }
    }
}