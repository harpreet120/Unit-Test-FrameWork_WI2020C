package com.example.testframeworkwi2020c.testSammlung.exkurs_binary;

import com.example.testframeworkwi2020c.testSammlung.Emojis;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import com.example.testframeworkwi2020c.testSammlung.exkurs_binary.Ü01.MainTester;
import com.example.testframeworkwi2020c.testSammlung.exkurs_binary.Ü02.BinaryHelperTester;

public class Exkurs_Binary_Ü02_Controller {
    /***
     * Test für die Klasse BinaryHelper: Wahrheitstabellen ausgeben überprüfen und entsprechende Rückmeldungen
     * @param jarFilePath wird an Objekt der Klasse MainTester übergeben
     * @return Ausgabe an den Benutzer
     * @throws Exception Handling wird weitergereicht an höhere Ebene
     */
    public String testBinaryHelper(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der Tests für die Klasse BinaryHelper";
        BinaryHelperTester binaryHelperTester = new BinaryHelperTester(jarFilePath);

        // Aufruf des Tests der Methode and() inkl. Rückmeldung an den Benutzer
        TestResult outputAnd = binaryHelperTester.testAnd();
        if (outputAnd.isSuccess()) {
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode and() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode and() hat noch Fehler.  Es soll die Wahrheitstabelle entsprechend dem Schema 'A & B = C' im System.out.println() ausgegeben werden. Aktuell wird \n"+outputAnd.getReturnValue() +"ausgegeben.";
        }

        // Aufruf des Tests der Methode and() inkl. Rückmeldung an den Benutzer
        TestResult outputOr = binaryHelperTester.testOr();
        if (outputOr.isSuccess()) {
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode or() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode or() hat noch Fehler.  Es soll die Wahrheitstabelle entsprechend dem Schema 'A | B = C' im System.out.println() ausgegeben werden. Aktuell wird \n"+outputOr.getReturnValue() +"ausgegeben.";
        }

        // Aufruf des Tests der Methode and() inkl. Rückmeldung an den Benutzer
        TestResult outputXor = binaryHelperTester.testXor();
        if (outputXor.isSuccess()) {
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode xor() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode xor() hat noch Fehler.  Es soll die Wahrheitstabelle entsprechend dem Schema 'A ^ B = C' im System.out.println() ausgegeben werden. Aktuell wird \n"+outputXor.getReturnValue() +"ausgegeben.";
        }

        textAnUser += "\nEnde der Tests für die Klasse BinaryHelper";
        return textAnUser;
    }
}
