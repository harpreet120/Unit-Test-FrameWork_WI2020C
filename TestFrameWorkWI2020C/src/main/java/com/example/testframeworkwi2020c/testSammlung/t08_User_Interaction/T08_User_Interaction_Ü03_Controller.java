package com.example.testframeworkwi2020c.testSammlung.t08_User_Interaction;

import com.example.testframeworkwi2020c.testSammlung.Emojis;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import com.example.testframeworkwi2020c.testSammlung.t08_User_Interaction.Ü03.MainTester;

public class T08_User_Interaction_Ü03_Controller {
    /***
     * Tests für die Klasse Fibonacci
     * @param jarFilePath wird an Objekt der Klasse Fibonacci übergeben
     * @return Ausgabe an den Benutzer
     * @throws Exception Handling an nächsthöhere Instanz
     */
    public String testMain(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der Tests für die Klasse Main";
        MainTester mainTester = new MainTester(jarFilePath);

        // Aufruf des Tests der Methode folge() inkl. Rückmeldung an den Benutzer
        TestResult testResult = mainTester.testMain();
        if (testResult.isSuccess()) {
            textAnUser += "\n" + Emojis.RICHTIG.getEmoji() + " Die Methode main() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n" + Emojis.FALSCH.getEmoji() + " Die Methode main() hat noch Fehler. Bitte stelle sicher, dass der Scanner richtig implementiert wurde sodass für den Input \"a\" und \"haaaalo\" 4 zurückgegeben wird. Aktuell wird: " + testResult.getReturnValue() + " zurückgegeben.";
        }

        textAnUser += "\nEnde der Tests für die Klasse Main\n";
        return textAnUser;
    }
}
