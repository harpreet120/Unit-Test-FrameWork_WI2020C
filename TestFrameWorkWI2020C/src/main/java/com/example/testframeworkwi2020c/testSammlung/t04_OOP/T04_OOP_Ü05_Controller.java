package com.example.testframeworkwi2020c.testSammlung.t04_OOP;

import com.example.testframeworkwi2020c.testSammlung.Emojis;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü05.CircleTester;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü05.QuadratTester;

public class T04_OOP_Ü05_Controller {
    /***
     * Tests für die Klasse Circle
     * @param jarFilePath wird bei der Instanziierung der Klasse CircleTester mitgegeben
     * @return Ausgabe an den Benutzer (von der Klasse Circle)
     * @throws Exception Handling wird an nächsthöhere Instanz weitergegeben
     */
    public String testCircle(String jarFilePath) throws Exception{
        String textAnUser = "\nBeginn der Tests für die Klasse Circle";
        CircleTester circleTester = new CircleTester(jarFilePath);

        // Aufruf des Tests der Methode getArea() inkl. Rückmeldung an den Benutzer
        TestResult outputGetArea = circleTester.testGetArea();
        if (outputGetArea.isSuccess()){
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode getArea() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji() +" Die Methode getArea() hat noch Fehler. Es soll \"pi * r hoch 2\" im System.out.println() ausgegeben werden. Aktuell wird \""+outputGetArea.getReturnValue()+"\" ausgegeben." ;
        }

        // Aufruf des Tests der Methode getCircumference() inkl. Rückmeldung an den Benutzer
        TestResult outputGetCircumference = circleTester.testGetCircumference();
        if (outputGetCircumference.isSuccess()){
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode getCircumference() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji() +" Die Methode getCircumference() hat noch Fehler. Es soll \"2*pi*rs\" in System.out.println() geschrieben werden. Aktuell wird \""+outputGetCircumference.getReturnValue()+"\" ausgegeben. ";
        }
        textAnUser += "\nEnde der Tests für die Klasse Circle \n";
        return textAnUser;
    }

    /***
     * Tests für die Klasse Quadrat
     * @param jarFilePath wird bei der Instanziierung der Klasse CircleTester mitgegeben
     * @return Ausgabe an den Benutzer (von der Klasse Quadrat)
     * @throws Exception Handling wird an nächsthöhere Instanz weitergegeben
     */
    public String testQuadrat(String jarFilePath) throws Exception{
        String textAnUser = "\nBeginn der Tests für die Klasse Quadrat";
        QuadratTester quadratTester = new QuadratTester(jarFilePath);

        // Aufruf des Tests der Methode getArea() inkl. Rückmeldung an den Benutzer
        TestResult outputGetArea = quadratTester.testGetArea();
        if (outputGetArea.isSuccess()){
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode getArea() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji() +" Die Methode getArea() hat noch Fehler. Es soll \"a hoch 2\" im System.out.println() ausgegeben werden. Aktuell wird \""+outputGetArea.getReturnValue()+"\" ausgegeben." ;
        }

        // Aufruf des Tests der Methode getCircumference() inkl. Rückmeldung an den Benutzer
        TestResult outputGetCircumference = quadratTester.testGetCircumference();
        if (outputGetCircumference.isSuccess()){
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode getCircumference() wurde erfolgreich getestet.";

        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji() +" Die Methode getCircumference() hat noch Fehler. Es soll \"4a\" in System.out.println() geschrieben werden. Aktuell wird \""+outputGetCircumference.getReturnValue()+"\" ausgegeben.";
        }
        textAnUser += "\nEnde der Tests für die Klasse Quadrat \n";
        return textAnUser;
    }
}

