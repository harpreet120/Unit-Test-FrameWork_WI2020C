package com.example.testframeworkwi2020c.testSammlung.t07_Arrays;

import com.example.testframeworkwi2020c.testSammlung.Emojis;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import com.example.testframeworkwi2020c.testSammlung.t07_Arrays.Ü02.MainTesterArr2;

public class T07_Arrays_Ü02_Controller {

    /***
     * Tests für die Klasse Main
     * @param jarFilePath an MainTesterArr2 weitergeben
     * @return Rückgabe an den Benutzer
     * @throws Exception Handling an die nächst höhere Ebene übergeben
     */
    public String testMain(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der Tests für die Klasse Main";
        MainTesterArr2 mainTester= new MainTesterArr2(jarFilePath);

        // Aufruf des Tests der Methode main() inkl. Rückmeldung an den Benutzer
        TestResult outputMain = mainTester.testMain();
        if (outputMain.isSuccess()) {
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode main() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode main() hat noch Fehler.  Es sollen 10 Zahlen eines Arrays aufsteigend im System.out.println() ausgegeben werden. Aktuell werden die Zahlen "+outputMain.getReturnValue() +" ausgegeben.";
        }
        textAnUser += "\nEnde der Tests für die Klasse Main";
        return textAnUser;
    }
}
