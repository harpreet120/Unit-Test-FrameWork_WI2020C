package com.example.testframeworkwi2020c.testSammlung;

import com.example.testframeworkwi2020c.testSammlung.x_I_unfair_dice.DealerTester;
import com.example.testframeworkwi2020c.testSammlung.x_I_unfair_dice.FairDiceTester;
import com.example.testframeworkwi2020c.testSammlung.x_I_unfair_dice.UnfairDiceTester;

import java.nio.charset.Charset;


public class X_I_unfair_Dice_Controller {
    public String testFairDice(String jarFilePath) throws Exception {
        String textAnUser = "Beginn der FairDice Tests";
        FairDiceTester fairDiceTester = new FairDiceTester(jarFilePath);
        //TestGetNumber
        if (fairDiceTester.testGetNumber()) {
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+" getNumber() erfolgreich getestet :)";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" getNumber() hat noch Fehler :(";
        }
        //TestRoll
        if (fairDiceTester.testRoll()){
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+" roll() erfolgreich getestet :)";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" roll() hat noch Fehler :(  Die Methode soll Zahlen zwischen 1 und 6 generieren. ";
        }
        textAnUser += ("\nFair Dice tests abgeschlossen");
        return textAnUser;
    }

    public String testUnfairDice(String jarFilePath) throws Exception {
        String textAnUser = "\n\nBeginn der UnfairDice Tests";
        UnfairDiceTester unfairDiceTester = new UnfairDiceTester(jarFilePath);
        //TestGetNumber
        if (unfairDiceTester.testGetNumber()) {
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+" getNumber() erfolgreich getestet :)";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" getNumber() hat noch Fehler :(";
        }
        //TestZahl
        if (unfairDiceTester.testZahl()){
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+" Zahl() erfolgreich getestet :)";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Zahl() hat noch Fehler :(";
        }
        textAnUser += ("\nUnfair Dice tests abgeschlossen");
        return textAnUser;
    }

    public String testDealer(String jarFilePath) throws Exception {
        String textAnUser = "\n\nBeginn der Dealer Tests";
        DealerTester dealerTester = new DealerTester(jarFilePath);
        //TestRollDice
        if (dealerTester.testRollDice()) {
            textAnUser += "\nRollDice() erfolgreich getestet :)";
        } else {
            textAnUser += "\nRollDice() hat noch Fehler :(";
        }
        return textAnUser;
    }
}
