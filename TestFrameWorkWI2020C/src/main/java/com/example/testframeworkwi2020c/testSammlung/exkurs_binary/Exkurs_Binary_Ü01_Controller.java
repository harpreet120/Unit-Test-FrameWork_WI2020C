package com.example.testframeworkwi2020c.testSammlung.exkurs_binary;

import com.example.testframeworkwi2020c.testSammlung.Emojis;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import com.example.testframeworkwi2020c.testSammlung.exkurs_binary.Ü01.MainTester;

public class Exkurs_Binary_Ü01_Controller {
    /***
     * Test für die Klasse Main: Umwandlung einer Ganzzahl in Binär
     * @param jarFilePath wird an Objekt der Klasse MainTester übergeben
     * @return Ausgabe an den Benutzer
     * @throws Exception Handling wird weitergereicht an höhere Ebene
     */
    public String testMain(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der Tests für die Klasse Main";
        MainTester mainTester = new MainTester(jarFilePath);

        // Aufruf des Tests der Methode main() inkl. Rückmeldung an den Benutzer
        TestResult outputMain = mainTester.testMain();
        if (outputMain.isSuccess()) {
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode main() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode main() hat noch Fehler.  Es sollen die Zahl 6  in Binärform im System.out.println() ausgegeben werden. Aktuell wird "+outputMain.getReturnValue() +"ausgegeben.";
        }
        textAnUser += "\nEnde der Tests für die Klasse Main";
        return textAnUser;
    }
}
