package com.example.testframeworkwi2020c.testSammlung.t04_OOP;

import com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü05.CircleTester;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü06.GueterzugTester;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü06.PersonenzugTester;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü06.SpezialZugTester;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü06.ZugTester;

public class T04_OOP_Ü06_Controller {

    // Tests für die Klasse Zug
    public String testZug(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der Zug Tests";
        ZugTester zugTester = new ZugTester(jarFilePath);

        // Aufruf des Tests der Methode getWagons() inkl. Rückmeldung an den Benutzer
        if (zugTester.testGetWagons()) {
            textAnUser += "\ngetWagons() erfolgreich getestet :)";
        } else {
            textAnUser += "\ngetWagons() hat noch Fehler. Bitte achte darauf, dass die korrekte Wagenanzahl von 3 (als Int-Wert) zurückgegeben wird.";
        }
        textAnUser += "\nEnde der Zug Tests";
        return textAnUser;
    }

    // Tests für die Klasse Gueterzug
    public String testGueterzug(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der Güterzug Tests";
        GueterzugTester zugTester = new GueterzugTester(jarFilePath);

        // Aufruf des Tests der Methode beladen() inkl. Rückmeldung an den Benutzer
        if (zugTester.testBeladen()) {
            textAnUser += "\nbeladen() erfolgreich getestet :)";
        } else {
            textAnUser += "\nbeladen() hat noch Fehler. Bitte achte darauf, dass \"tue rein...\" in System.out.println() geschrieben wird.";
        }
        // Aufruf des Tests der Methode entladen() inkl. Rückmeldung an den Benutzer
        if (zugTester.testEntladen()) {
            textAnUser += "\nentladen() erfolgreich getestet :)";
        } else {
            textAnUser += "\nentladen() hat noch Fehler. Bitte achte darauf, dass \"raus damit...\" in System.out.println() geschrieben wird.";
        }
        textAnUser += "\nEnde der Güterzug Tests";
        return textAnUser;
    }

    // Tests für die Klasse Spezialzug
    public String testSpezialzug(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der Spezialzug Tests";
        SpezialZugTester spezialZugTester = new SpezialZugTester(jarFilePath);

        // Aufruf des Tests der Methode sichern() inkl. Rückmeldung an den Benutzer
        if (spezialZugTester.testSichern()) {
            textAnUser += "\nsichern() erfolgreich getestet :)";
        } else {
            textAnUser += "\nsichern() hat noch Fehler. Bitte achte darauf, dass \"Ich checke...\" in System.out.println() geschrieben wird.";
        }
        textAnUser += "\nEnde der Spezialzug Tests";
        return textAnUser;
    }

    // Tests für die Klasse Personenzug
    public String testPersonenzug(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der Personenzug Tests";
        PersonenzugTester personenzugTester = new PersonenzugTester(jarFilePath);

        // Aufruf des Tests der Methode essen() inkl. Rückmeldung an den Benutzer
        if (personenzugTester.testEssen()) {
            textAnUser += "\nessen() erfolgreich getestet :)";
        } else {
            textAnUser += "\nessen() hat noch Fehler. Bitte achte darauf, dass \"Mpf Mpf\" in System.out.println() geschrieben wird.";
        }

        // Aufruf des Tests der Methode getWagons() inkl. Rückmeldung an den Benutzer
        if (personenzugTester.testEssen()) {
            textAnUser += "\ngetWagons() erfolgreich getestet :)";
        } else {
            textAnUser += "\ngetWagons() hat noch Fehler. Bitte achte darauf, dass der Wert 10 (als int) zurückgegeben wird.";
        }
        textAnUser += "\nEnde der Personenzug Tests";
        return textAnUser;
    }
}
