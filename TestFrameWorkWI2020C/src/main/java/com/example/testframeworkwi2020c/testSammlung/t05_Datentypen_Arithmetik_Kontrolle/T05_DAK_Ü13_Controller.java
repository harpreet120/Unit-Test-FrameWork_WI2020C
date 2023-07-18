package com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle;

import com.example.testframeworkwi2020c.testSammlung.Emojis;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle.Ü13.MainTester_Ü13;

public class T05_DAK_Ü13_Controller {
    /***
     * Test für die Klasse Main
     * @param jarFilePath wird an Objekt der Klasse MainTester_xy übergeben
     * @return Ausgabe an den Benutzer
     * @throws Exception Handling wird weitergereicht an höhere Ebene
     */
    public String testMain(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der Tests für die Klasse Main";
        MainTester_Ü13 mainTester = new MainTester_Ü13(jarFilePath);

        // Aufruf des Tests der Methode main() inkl. Rückmeldung an den Benutzer
        TestResult outputMain = mainTester.testMain();
        if (outputMain.isSuccess()) {
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode main() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode main() hat noch Fehler.  Es sollen Ergebnisse entsprechend dem Schema '[xy] is [not] dividable by 3' im System.out.println() ausgegeben werden. Aktuell wird "+outputMain.getReturnValue() +"ausgegeben.";
        }
        textAnUser += "\nEnde der Tests für die Klasse Main";
        return textAnUser;
    }
}
