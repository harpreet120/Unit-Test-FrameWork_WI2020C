package com.example.testframeworkwi2020c.testSammlung.t04_OOP;

import com.example.testframeworkwi2020c.testSammlung.Emojis;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü05.CircleTester;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü05.QuadratTester;

public class T04_OOP_Ü05_Controller {
    // Tests für die Klasse Circle
    public String testCircle(String jarFilePath) throws Exception{
        String textAnUser = "\nBeginn der Tests für die Klasse Circle";
        CircleTester circleTester = new CircleTester(jarFilePath);
        String outputGetArea = circleTester.testGetArea();
        String outputGetCircumference = circleTester.testGetCircumference();

        // Aufruf des Tests der Methode getArea() inkl. Rückmeldung an den Benutzer
        if (outputGetArea.equals("true")){
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode getArea() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji() +" Die Methode getArea() hat noch Fehler. Es soll \"pi *r hoch 2\" im System.out.println() ausgegeben werden. Aktuell wird \""+outputGetArea+"\" ausgegeben." ;
        }

        // Aufruf des Tests der Methode getCircumference() inkl. Rückmeldung an den Benutzer
        if (outputGetCircumference.equals("true")){
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode getCircumference() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji() +" Die Methode getCircumference() hat noch Fehler. Es soll \"2*pi*rs\" in System.out.println() geschrieben werden. Aktuell wird \""+outputGetCircumference+"\" ausgegeben. ";
        }
        textAnUser += "\nEnde der Tests für die Klasse Circle \n";
        return textAnUser;
    }

    // Tests für die Klasse Quadrat
    public String testQuadrat(String jarFilePath) throws Exception{
        String textAnUser = "\nBeginn der Tests für die Klasse Quadrat";
        QuadratTester quadratTester = new QuadratTester(jarFilePath);
        String outputGetArea = quadratTester.testGetArea();
        String outputGetCircumference = quadratTester.testGetCircumference();

        // Aufruf des Tests der Methode getArea() inkl. Rückmeldung an den Benutzer
        if (outputGetArea.equals("true")){
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode getArea() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji() +" Die Methode getArea() hat noch Fehler. Es soll \"a hoch 2\" im System.out.println() ausgegeben werden. Aktuell wird \""+outputGetArea+"\" ausgegeben." ;
        }

        // Aufruf des Tests der Methode getCircumference() inkl. Rückmeldung an den Benutzer
        if (outputGetCircumference.equals("true")){
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode getCircumference() wurde erfolgreich getestet.";

        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji() +" Die Methode getCircumference() hat noch Fehler. Es soll \"4a\" in System.out.println() geschrieben werden. Aktuell wird \""+outputGetCircumference+"\" ausgegeben.";
        }
        textAnUser += "\nEnde der Tests für die Klasse Quadrat \n";
        return textAnUser;
    }
}

