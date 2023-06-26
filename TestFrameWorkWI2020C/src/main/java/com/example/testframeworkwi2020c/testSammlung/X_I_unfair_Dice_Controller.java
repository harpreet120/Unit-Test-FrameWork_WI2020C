package com.example.testframeworkwi2020c.testSammlung;

import com.example.testframeworkwi2020c.testSammlung.x_I_unfair_dice.DealerTester;
import com.example.testframeworkwi2020c.testSammlung.x_I_unfair_dice.FairDiceTester;
import com.example.testframeworkwi2020c.testSammlung.x_I_unfair_dice.UnfairDiceTester;


public class X_I_unfair_Dice_Controller {
    public String testFairDice(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der FairDice Tests";
        FairDiceTester fairDiceTester = new FairDiceTester(jarFilePath);
        //TestGetNumber
        if (fairDiceTester.testGetNumber()) {
            textAnUser += "\ngetNumber() erfolgreich getestet :)";
        } else {
            textAnUser += "\ngetNumber() hat noch Fehler :(";
        }
        //TestRoll
        if (fairDiceTester.testRoll()){
            textAnUser += "\nroll() erfolgreich getestet :)";
        } else {
            textAnUser += "\nroll() hat noch Fehler :(  Die Methode soll Zahlen zwischen 1 und 6 zurückgeben.";
        }
        textAnUser += ("\nFair Dice tests abgeschlossen");
        return textAnUser;
    }

    public String testUnfairDice(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der UnfairDice Tests";
        UnfairDiceTester unfairDiceTester = new UnfairDiceTester(jarFilePath);
        //TestGetNumber
        if (unfairDiceTester.testGetNumber()) {
            textAnUser += "\ngetNumber() erfolgreich getestet :)";
        } else {
            textAnUser += "\ngetNumber() hat noch Fehler :(";
        }
        //TestZahl
        if (unfairDiceTester.testZahl()){
            textAnUser += "\nZahl() erfolgreich getestet :)";
        } else {
            textAnUser += "\nZahl() hat noch Fehler :(";
        }
        textAnUser += ("\nUnfair Dice tests abgeschlossen");
        return textAnUser;
    }

    public String testDealer(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der Dealer Tests";
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
