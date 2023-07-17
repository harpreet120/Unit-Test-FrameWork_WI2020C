package com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle;

import com.example.testframeworkwi2020c.testSammlung.Emojis;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle.Ü04.CalculatorTester;


public class T05_DAK_Ü04_Controller {

    /***
     * Tests für die Klasse Calculator
     * @param jarFilePath wird an Instanz der Klasse Calculator übergeben
     * @return Ausgabe an den Benutzer
     * @throws Exception Handling wird weitergereicht
     */
    public String testCalculator(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der Tests für die Klasse Calculator";
        CalculatorTester calculatorTester = new CalculatorTester(jarFilePath);

        // Aufruf des Tests der Methode add() inkl. Rückmeldung an den Benutzer
        TestResult outputAdd = calculatorTester.testAdd();
        if (outputAdd.isSuccess()) {
            textAnUser += "\n" + Emojis.RICHTIG.getEmoji() + " Die Methode add() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n" + Emojis.FALSCH.getEmoji() + " Die Methode add() hat noch Fehler.  Es soll der korrekte Wert der Addition mit den Parametern a=3 und b=5 zurückgegeben werden. Aktuell wird " + outputAdd.getReturnValue() + " zurückgegeben.";
        }

        // Aufruf des Tests der Methode sub() inkl. Rückmeldung an den Benutzer
        TestResult outputSub = calculatorTester.testSub();
        if (outputSub.isSuccess()) {
            textAnUser += "\n" + Emojis.RICHTIG.getEmoji() + " Die Methode sub() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n" + Emojis.FALSCH.getEmoji() + " Die Methode sub() hat noch Fehler.  Es soll der korrekte Wert der Substraktion mit den Parametern a=5 und b=3 zurückgegeben werden. Aktuell wird " + outputSub.getReturnValue() + " zurückgegeben.";
        }

        // Aufruf des Tests der Methode mul() inkl. Rückmeldung an den Benutzer
        TestResult outputMul = calculatorTester.testMul();
        if (outputMul.isSuccess()) {
            textAnUser += "\n" + Emojis.RICHTIG.getEmoji() + " Die Methode mul() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n" + Emojis.FALSCH.getEmoji() + " Die Methode mul() hat noch Fehler.  Es soll der korrekte Wert der Multiplikation mit den Parametern a=5 und b=3 zurückgegeben werden. Aktuell wird " + outputMul.getReturnValue() + " zurückgegeben.";
        }

        // Aufruf des Tests der Methode div() inkl. Rückmeldung an den Benutzer
        TestResult outputDiv= calculatorTester.testDiv();
        if (outputDiv.isSuccess()) {
            textAnUser += "\n" + Emojis.RICHTIG.getEmoji() + " Die Methode div() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n" + Emojis.FALSCH.getEmoji() + " Die Methode div() hat noch Fehler.  Es soll der korrekte Wert der Division mit den Parametern a=12 und b=3 zurückgegeben werden. Aktuell wird " + outputDiv.getReturnValue() + " zurückgegeben.";
        }
        textAnUser += "\nEnde der Tests für die Klasse Calculator\n";
        return textAnUser;
    }
}
