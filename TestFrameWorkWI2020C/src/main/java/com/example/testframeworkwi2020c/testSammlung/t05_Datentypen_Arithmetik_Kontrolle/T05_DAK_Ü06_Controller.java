package com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle;

import com.example.testframeworkwi2020c.testSammlung.Emojis;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle.Ü06.MainTester;

public class T05_DAK_Ü06_Controller {
    /***
     * Tests für die Klasse Main
     * @param jarFilePath wird an Instanz der Klasse MainTester übergeben
     * @return Ausgabe an den Benutzer
     * @throws Exception Handling wird an die nächsthöhere Ebene weitergereicht
     */
    public String testMain(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der Tests für die Klasse Main";
        MainTester mainTester = new MainTester(jarFilePath);

        // Aufruf des Tests der Methode main() inkl. Rückmeldung an den Benutzer
        TestResult outputMain = mainTester.testMain();
        if (outputMain.isSuccess()) {
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode main() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode main() hat noch Fehler.  Es sollen solange Zahlen zwischen 30 und 100 im System.out.println() ausgegeben werden, bis eine durch 7 teilbare Zahl ausgegeben wird. Aktuell werden die Zahlen "+outputMain.getReturnValue() +" ausgegeben.";
        }
        textAnUser += "\nEnde der Tests für die Klasse Main";
        return textAnUser;
    }
}
