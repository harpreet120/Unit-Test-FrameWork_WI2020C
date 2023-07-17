package com.example.testframeworkwi2020c.testSammlung.t04_OOP;

import com.example.testframeworkwi2020c.testSammlung.Emojis;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü05.CircleTester;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü06.GueterzugTester;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü06.PersonenzugTester;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü06.SpezialZugTester;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü06.ZugTester;

public class T04_OOP_Ü06_Controller {

    /***
     * Tests für die Klasse Zug
     * @param jarFilePath Wird an ein Objekt der Klasse Zugtester weitergegeben
     * @return Ausgabe an den Benutzer
     * @throws Exception Handling wird an nächsthöhere Ebene weitergereicht
     */
    public String testZug(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der Tests für die Klasse Zug";
        ZugTester zugTester = new ZugTester(jarFilePath);
        TestResult outputGetWagons = zugTester.testGetWagons();

        // Aufruf des Tests der Methode getWagons() inkl. Rückmeldung an den Benutzer
        if (outputGetWagons.isSuccess()) {
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode getWagons() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode getWagons() hat noch Fehler. Es soll die korrekte Wagenanzahl von 3 (als Int-Wert) zurückgegeben werden. Aktuell wird '"+outputGetWagons.getReturnValue() +"' zurückgegeben.";
        }
        textAnUser += "\nEnde der Tests für die Klasse Zug \n";
        return textAnUser;
    }

    /***
     * Tests für die Klasse Gueterzug
     * @param jarFilePath Wird an ein Objekt der Klasse GueterzugTester weitergegeben
     * @return Ausgabe an den Benutzer
     * @throws Exception Handling wird an nächsthöhere Ebene weitergereicht
     */
    public String testGueterzug(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der Tests für die Klasse Güterzug ";
        GueterzugTester zugTester = new GueterzugTester(jarFilePath);

        // Aufruf des Tests der Methode beladen() inkl. Rückmeldung an den Benutzer
        TestResult outputBeladen = zugTester.testBeladen();
        if (outputBeladen.isSuccess()) {
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode beladen() wurde erfolgreich getestet.";
        } else {
            textAnUser +=  "\n"+Emojis.FALSCH.getEmoji()+"Die Methode beladen() hat noch Fehler. Es soll 'tue rein...' in  System.out.println() ausgegeben werden. Aktuell wird '"+outputBeladen.getReturnValue()+"' ausgegeben.";
        }
        // Aufruf des Tests der Methode entladen() inkl. Rückmeldung an den Benutzer
        TestResult outputEntladen = zugTester.testEntladen();
        if (outputEntladen.isSuccess()) {
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode entladen() wurde erfolgreich getestet.";
        } else {
            textAnUser +=  "\n"+Emojis.FALSCH.getEmoji()+"Die Methode entladen() hat noch Fehler. Es soll 'raus damit...' in  System.out.println() ausgegeben werden. Aktuell wird '"+outputEntladen.getReturnValue()+"' ausgegeben.";
        }
        textAnUser += "\nEnde der Tests für die Klasse Güterzug \n";
        return textAnUser;
    }

    /***
     * Tests für die Klasse Spezialzug
     * @param jarFilePath Wird an ein Objekt der Klasse SpezialZugTester weitergegeben
     * @return Ausgabe an den Benutzer
     * @throws Exception Handling wird an nächsthöhere Ebene weitergereicht
     */
    public String testSpezialzug(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der Tests für die Klasse Spezialzug ";
        SpezialZugTester spezialZugTester = new SpezialZugTester(jarFilePath);

        // Aufruf des Tests der Methode sichern() inkl. Rückmeldung an den Benutzer
        TestResult outputSichern = spezialZugTester.testSichern();
        if (outputSichern.isSuccess()) {
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode sichern() wurde erfolgreich getestet.";
        } else {
            textAnUser +=  "\n"+Emojis.FALSCH.getEmoji()+"Die Methode sichern() hat noch Fehler. Es soll 'Ich checke...' in  System.out.println() ausgegeben werden. Aktuell wird '"+outputSichern.getReturnValue()+"' ausgegeben.";
        }
        textAnUser += "\nEnde der Tests für die Klasse Spezialzug  \n";
        return textAnUser;
    }

    /***
     * Tests für die Klasse Personenzug
     * @param jarFilePath Wird an ein Objekt der Klasse PersonenzugTester weitergegeben
     * @return Ausgabe an den Benutzer
     * @throws Exception Handling wird an nächsthöhere Ebene weitergereicht
     */
    public String testPersonenzug(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der Personenzug Tests";
        PersonenzugTester personenzugTester = new PersonenzugTester(jarFilePath);

        // Aufruf des Tests der Methode essen() inkl. Rückmeldung an den Benutzer
        TestResult<String> outputEssen = personenzugTester.testEssen();
        if (outputEssen.isSuccess()) {
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode essen() wurde erfolgreich getestet.";
        } else {
            textAnUser +=  "\n"+Emojis.FALSCH.getEmoji()+"Die Methode essen() hat noch Fehler. Es soll 'Mpf Mpf' in  System.out.println() ausgegeben werden. Aktuell wird '"+outputEssen.getReturnValue()+"' ausgegeben.";
        }

        // Aufruf des Tests der Methode getWagons() inkl. Rückmeldung an den Benutzer
        TestResult outputWagons = personenzugTester.testGetWagons();
        if (outputWagons.isSuccess()) {
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode getWagons() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode getWagons() hat noch Fehler. Es soll die korrekte Wagenanzahl von 10 (als Int-Wert) zurückgegeben werden. Aktuell wird "+outputWagons.getReturnValue() +" zurückgegeben.";
        }
        textAnUser += "\nEnde der Tests für die Klasse Personenzug  \n";
        return textAnUser;
    }
}
