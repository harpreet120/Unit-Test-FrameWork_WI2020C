package com.example.testframeworkwi2020c.testSammlung.t04_OOP;

import com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü05.CircleTester;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü05.QuadratTester;

public class T04_OOP_Ü05_Controller {
    // Tests für die Klasse Circle
    public String testCircle(String jarFilePath) throws Exception{
        String textAnUser = "\nBeginn der Circle Tests";
        CircleTester circleTester = new CircleTester(jarFilePath);

        // Aufruf des Tests der Methode getArea() inkl. Rückmeldung an den Benutzer
        if (circleTester.testGetArea()){
            textAnUser += "\ngetArea() erfolgreich getestet :)";
        } else {
            textAnUser += "\ngetArea() hat noch Fehler. Bitte achte darauf, dass \"pi *r hoch 2\" in System.out.println() geschrieben wird ";
        }

        // Aufruf des Tests der Methode getCircumference() inkl. Rückmeldung an den Benutzer
        if (circleTester.testGetCircumference()){
            textAnUser += "\ngetCircumference() erfolgreich getestet :)";
        } else {
            textAnUser += "\ngetCircumference() hat noch Fehler. Bitte achte darauf, dass \"2*pi*r\" in System.out.println() geschrieben wird ";
        }
        textAnUser += "\nEnde der Circle Tests";
        return textAnUser;
    }

    // Tests für die Klasse Quadrat
    public String testQuadrat(String jarFilePath) throws Exception{
        String textAnUser = "\nBeginn der Quadrat Tests";
        QuadratTester quadratTester = new QuadratTester(jarFilePath);

        // Aufruf des Tests der Methode getArea() inkl. Rückmeldung an den Benutzer
        if (quadratTester.testGetArea()){
            textAnUser += "\ngetArea() erfolgreich getestet :)";
        } else {
            textAnUser += "\ngetArea() hat noch Fehler. Bitte achte darauf, dass \"a hoch 2\" in System.out.println() geschrieben wird ";
        }

        // Aufruf des Tests der Methode getCircumference() inkl. Rückmeldung an den Benutzer
        if (quadratTester.testGetCircumference()){
            textAnUser += "\ngetCircumference() erfolgreich getestet :)";
        } else {
            textAnUser += "\ngetCircumference() hat noch Fehler. Bitte achte darauf, dass \"4a\" in System.out.println() geschrieben wird ";
        }
        textAnUser += "\nEnde der Quadrat Tests";
        return textAnUser;
    }
}

