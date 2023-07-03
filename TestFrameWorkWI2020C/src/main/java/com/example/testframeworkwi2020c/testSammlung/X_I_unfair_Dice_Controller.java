package com.example.testframeworkwi2020c.testSammlung;

import com.example.testframeworkwi2020c.testSammlung.x_I_unfair_dice.DealerTester;
import com.example.testframeworkwi2020c.testSammlung.x_I_unfair_dice.FairDiceTester;
import com.example.testframeworkwi2020c.testSammlung.x_I_unfair_dice.UnfairDiceTester;


public class X_I_unfair_Dice_Controller {
    public String testFairDice(String jarFilePath) throws Exception {
        String textAnUser = "Beginn der FairDice Tests";
        FairDiceTester fairDiceTester = new FairDiceTester(jarFilePath);
        //TestGetNumber
        TestResult<Integer> getNumberResult = fairDiceTester.testGetNumber();
        if (getNumberResult.isSuccess()) {
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+" Die Methode getNumber() wurde erfolgreich getestet";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode getNumber() hat noch Fehler. Die Methode gibt keinen Integer zurück.";
        }
        //TestRoll
        TestResult<Integer> getRollResult = fairDiceTester.testRoll();
        if (getRollResult.isSuccess()){
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+" Die Methode roll() wurde erfolgreich getestet :)";
        } else {
            if (getRollResult.getReturnValue() < 1 || getRollResult.getReturnValue() > 6) {
                textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode roll() hat noch Fehler. Es sollen die Zahlen 1 bis 6 als Variablenwert für 'augenzahl' gespeichert werden. Aktuell wird " + getRollResult.getReturnValue() + " als Variablenwert für 'augenzahl' gespeichert.";
            } else {
                textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode roll() hat noch Fehler. Es sollen die Zahlen 1 bis 6 als Variablenwert für 'augenzahl' gespeichert werden. Aktuell wird " + getRollResult.getReturnValue() + " nicht als Variablenwert für 'augenzahl' gespeichert.";
            }
        }
        textAnUser += ("\nEnde der Tests für die Klasse FairDice.");
        return textAnUser;
    }

    public String testUnfairDice(String jarFilePath) throws Exception {
        String textAnUser = "\n\nBeginn der UnfairDice Tests";
        UnfairDiceTester unfairDiceTester = new UnfairDiceTester(jarFilePath);
        //TestGetNumber
        TestResult<Integer> getNumberResult = unfairDiceTester.testGetNumber();
        if (getNumberResult.isSuccess()) {
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+" Die Methode getNumber() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode getNumber() hat noch Fehler. Die Methode gibt keinen Integer zurück.";
        }
        //TestZahl
        TestResult<Integer> getTestZahl = unfairDiceTester.testZahl();
        if (getTestZahl.isSuccess()){
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+" Die Methode Zahl() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode Zahl() hat noch Fehler. Es soll 6 zurückgegeben werden. Aktuell wird " + getTestZahl.getReturnValue() + " zurückgegeben.";
        }
        textAnUser += ("\nEnde der Tests für die Klasse UnfairDice.");
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
