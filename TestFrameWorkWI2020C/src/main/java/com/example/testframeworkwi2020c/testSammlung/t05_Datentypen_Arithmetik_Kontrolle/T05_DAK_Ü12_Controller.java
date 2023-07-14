package com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle;

import com.example.testframeworkwi2020c.testSammlung.Emojis;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle.Ü12.ExponentiatorTester;


public class T05_DAK_Ü12_Controller {
    // Tests für die Klasse Exponentiator
    public String testExponentiator(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der Tests für die Klasse Exponentiator";
        ExponentiatorTester exponentiatorTester = new ExponentiatorTester(jarFilePath);

        // Aufruf des Tests der Methode exponentiate() inkl. Rückmeldung an den Benutzer
        TestResult outputFolge = exponentiatorTester.testExponentiate();
        if (outputFolge.isSuccess()) {
            textAnUser += "\n" + Emojis.RICHTIG.getEmoji() + " Die Methode exponentiate() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n" + Emojis.FALSCH.getEmoji() + " Die Methode exponentiate() hat noch Fehler.  Es soll beispielhaft die 6er-Potenz mit '1, 6, 36, 216, 1296, 7776, 46656' im System.out.println() ausgegeben werden. Aktuell wird '" + outputFolge.getReturnValue() + "' ausgegeben.";
        }

        textAnUser += "\nEnde der Tests für die Klasse Exponentiator\n";
        return textAnUser;
    }
}
