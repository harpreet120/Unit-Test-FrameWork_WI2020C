package com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle;

import com.example.testframeworkwi2020c.testSammlung.Emojis;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle.Ü03.KreisTester;
import com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle.Ü10.FibonacciTester;

public class T05_DAK_Ü10_Controller {
    // Tests für die Klasse Fibonacci
    public String testFibonacci(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der Tests für die Klasse Fibonacci";
        FibonacciTester fibonacciTester = new FibonacciTester(jarFilePath);

        // Aufruf des Tests der Methode folge() inkl. Rückmeldung an den Benutzer
        TestResult outputFolge = fibonacciTester.testFolge();
        if (outputFolge.isSuccess()) {
            textAnUser += "\n" + Emojis.RICHTIG.getEmoji() + " Die Methode folge() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n" + Emojis.FALSCH.getEmoji() + " Die Methode folge() hat noch Fehler.  Es soll '1, 2, 3, 5, 8, 13, 21, 34, 55' im System.out.println() ausgegeben werden. Aktuell wird " + outputFolge.getReturnValue() + " ausgegeben.";
        }
        // Aufruf des Tests der Methode folge() inkl. Rückmeldung an den Benutzer
        TestResult outputFolge2 = fibonacciTester.testFolge2();
        if (outputFolge2.isSuccess()) {
            textAnUser += "\n" + Emojis.RICHTIG.getEmoji() + " Die Methode folge() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n" + Emojis.FALSCH.getEmoji() + " Die Methode folge() hat noch Fehler.  Es soll '1, 1, 2, 3, 5, 8, 13, 21, 34, 55' im System.out.println() ausgegeben werden. Aktuell wird " + outputFolge2.getReturnValue() + " ausgegeben.";
        }

        textAnUser += "\nEnde der Tests für die Klasse Fibonacci\n";
        return textAnUser;
    }
}
