package com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle;

import com.example.testframeworkwi2020c.testSammlung.Emojis;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle.Ü03.KreisTester;
import com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle.Ü03.QuadratTester;

public class T05_DAK_Ü03_Controller {

    // Tests für die Klasse KreisTester
    public String testKreis(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der Tests für die Klasse Kreis";
        KreisTester kreisTester = new KreisTester(jarFilePath);

        // Aufruf des Tests der Methode getArea() inkl. Rückmeldung an den Benutzer
        TestResult outputGetArea = kreisTester.testGetArea();
        if (outputGetArea.isSuccess()) {
            textAnUser += "\n" + Emojis.RICHTIG.getEmoji() + " Die Methode getArea() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n" + Emojis.FALSCH.getEmoji() + " Die Methode getArea() hat noch Fehler.  Es soll der korrekte Wert aus der Berechnung pi*r^2 im System.out.println() ausgegeben werden. Aktuell wird " + outputGetArea.getReturnValue() + " ausgegeben.";
        }

        // Aufruf des Tests der Methode getCircumference() inkl. Rückmeldung an den Benutzer
        TestResult outputGetCircumference = kreisTester.testGetCircumference();
        if (outputGetCircumference.isSuccess()) {
            textAnUser += "\n" + Emojis.RICHTIG.getEmoji() + " Die Methode getCircumference() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n" + Emojis.FALSCH.getEmoji() + " Die Methode getCircumference() hat noch Fehler.  Es soll der korrekte Wert aus der Berechnung 2*pi*r im System.out.println() ausgegeben werden. Aktuell wird " + outputGetCircumference.getReturnValue() + " ausgegeben.";
        }
        textAnUser += "\nEnde der Tests für die Klasse Kreis\n";
        return textAnUser;
    }

    // Tests für die Klasse QuadratTester
    public String testQuadrat(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der Tests für die Klasse Quadrat";
        QuadratTester quadratTester = new QuadratTester(jarFilePath);

        // Aufruf des Tests der Methode getArea() inkl. Rückmeldung an den Benutzer
        TestResult outputGetArea = quadratTester.testGetArea();
        if (outputGetArea.isSuccess()) {
            textAnUser += "\n" + Emojis.RICHTIG.getEmoji() + " Die Methode getArea() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n" + Emojis.FALSCH.getEmoji() + " Die Methode getArea() hat noch Fehler.  Es soll der korrekte Wert aus der Berechnung a^2 im System.out.println() ausgegeben werden. Aktuell wird " + outputGetArea.getReturnValue() + " ausgegeben.";
        }

        // Aufruf des Tests der Methode getCircumference() inkl. Rückmeldung an den Benutzer
        TestResult outputGetCircumference = quadratTester.testGetCircumference();
        if (outputGetCircumference.isSuccess()) {
            textAnUser += "\n" + Emojis.RICHTIG.getEmoji() + " Die Methode getCircumference() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n" + Emojis.FALSCH.getEmoji() + " Die Methode getCircumference() hat noch Fehler.  Es soll der korrekte Wert aus der Berechnung 4*a im System.out.println() ausgegeben werden. Aktuell wird " + outputGetCircumference.getReturnValue() + " ausgegeben.";
        }
        textAnUser += "\nEnde der Tests für die Klasse Quadrat\n";
        return textAnUser;
    }
}

