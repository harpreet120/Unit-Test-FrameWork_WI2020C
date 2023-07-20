package com.example.testframeworkwi2020c.testSammlung;

import com.example.testframeworkwi2020c.testSammlung.x_II_black_jack.ManuelPlayerTester;
import com.example.testframeworkwi2020c.testSammlung.x_II_black_jack.RiskyPlayerTester;
import com.example.testframeworkwi2020c.testSammlung.x_II_black_jack.ShyPlayerTester;

public class X_II_black_jack_Controller {

    public String testRiskyPlayer(String jarFilePath) throws Exception {
        String textAnUser = "Beginn der Tests für die Klasse RiskyPlayer";
        RiskyPlayerTester tester = new RiskyPlayerTester(jarFilePath);
        TestResult<String> testGetChoice = tester.testGetChoice();
        if (testGetChoice.isSuccess()) {
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+" Die Methode getChoice() wurde erfolgreich getestet";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode getChoice() hat noch Fehler. Die Methode soll bei einem Input von '19' 'True' zurückgeben. Aktuell wird 'False zurückgegeben.";
        }
        TestResult<Integer[]> testGetOffer = tester.testGetOffer();
        if (testGetOffer.isSuccess()) {
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+" Die Methode getOffer() wurde erfolgreich getestet";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode getOffer() hat noch Fehler. Es soll '"+testGetOffer.getReturnValue()[0]+"' zurückgegeben werden. Aktuell wird '"+testGetOffer.getReturnValue()[1]+"' zurückgegeben.";
        }
        TestResult<Integer> testInformWinning = tester.testInformWinning();
        if (testInformWinning.isSuccess()) {
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+" Die Methode informWinning() wurde erfolgreich getestet";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode informWinning() hat noch Fehler. Es soll bei einem Input von '17', '17' auf den Variablenwert 'totalBudget' addiert werden. Aktuell wird '"+(testInformWinning.getReturnValue()-17)+"' auf den Variablenwert 'totalBudget' addiert.";
        }
        textAnUser += ("\nEnde der Tests für die Klasse RiskyPlayer.");
        return textAnUser;
    }

    public String testShyPlayer(String jarFilePath) throws Exception {
        String textAnUser = "\n\nBeginn der Tests für die Klasse ShyPlayer";
        ShyPlayerTester tester = new ShyPlayerTester(jarFilePath);
        TestResult<String> testGetChoice = tester.testGetChoice();
        if (testGetChoice.isSuccess()) {
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+" Die Methode getChoice() wurde erfolgreich getestet";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode getChoice() hat noch Fehler. Die Methode soll bei einem Input von '17' 'True' zurückgeben. Aktuell wird 'False zurückgegeben.";
        }
        TestResult<Integer[]> testGetOffer = tester.testGetOffer();
        if (testGetOffer.isSuccess()) {
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+" Die Methode getOffer() wurde erfolgreich getestet";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode getOffer() hat noch Fehler. Es soll '"+testGetOffer.getReturnValue()[0]+"' zurückgegeben werden. Aktuell wird '"+testGetOffer.getReturnValue()[1]+"' zurückgegeben.";
        }
        TestResult<Integer> testInformWinning = tester.testInformWinning();
        if (testInformWinning.isSuccess()) {
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+" Die Methode informWinning() wurde erfolgreich getestet";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode informWinning() hat noch Fehler. Es soll bei einem Input von '17', '17' auf den Variablenwert 'totalBudget' addiert werden. Aktuell wird '"+(testInformWinning.getReturnValue()-17)+"' auf den Variablenwert 'totalBudget' addiert.";
        }
        textAnUser += ("\nEnde der Tests für die Klasse ShyPlayer.");
        return textAnUser;
    }

    public String testManualPlayer(String jarFilePath) throws Exception {
        String textAnUser = "\n\nBeginn der Tests für die Klasse ManualPlayer";
        ManuelPlayerTester tester = new ManuelPlayerTester(jarFilePath);
        TestResult<Boolean> testGetChoice = tester.testGetChoice();
        if (testGetChoice.isSuccess()) {
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+" Die Methode getChoice() wurde erfolgreich getestet";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode getChoice() hat noch Fehler. Die Methode soll bei einem Input von 'true' 'True' zurückgeben. Aktuell wird 'False zurückgegeben.";
        }
        TestResult<Integer[]> testGetOffer = tester.testGetOffer();
        if (testGetOffer.isSuccess()) {
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+" Die Methode getOffer() wurde erfolgreich getestet";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode getOffer() hat noch Fehler. Es soll '"+testGetOffer.getReturnValue()[0]+"' zurückgegeben werden. Aktuell wird '"+testGetOffer.getReturnValue()[1]+"' zurückgegeben.";
        }
        TestResult<Integer> testInformWinning = tester.testInformWinning();
        if (testInformWinning.isSuccess()) {
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+" Die Methode informWinning() wurde erfolgreich getestet";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode informWinning() hat noch Fehler. Es soll bei einem Input von '17', '17' auf den Variablenwert 'totalBudget' addiert werden. Aktuell wird '"+(testInformWinning.getReturnValue()-17)+"' auf den Variablenwert 'totalBudget' addiert.";
        }
        textAnUser += ("\nEnde der Tests für die Klasse ManualPlayer.");
        return textAnUser;
    }
}
