package com.example.testframeworkwi2020c.testSammlung.t04_OOP;

import com.example.testframeworkwi2020c.testSammlung.Emojis;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü08.FastCarTester;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü08.FutureCarTester;

public class T04_OOP_Ü08_Controller {
    /***
     * Tests für die Klasse FastCar
     * @param jarFilePath wird an ein Object der Klasse FarCarTester weitergegeben
     * @return Ausgabe an den Benutzer
     * @throws Exception Handling wird weitergereicht an nächsthöhere Ebene
     */
    public String testFastCar(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der Tests für die Klasse FastCar";
        FastCarTester fastCarTester = new FastCarTester(jarFilePath);

        // Aufruf des Tests der Methode open() inkl. Rückmeldung an den Benutzer
        TestResult outputOpen = fastCarTester.testOpen();
        if (outputOpen.isSuccess()) {
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode open() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode open() hat noch Fehler.  Es soll 'it is opened' im System.out.println() ausgegeben werden. Aktuell wird '"+outputOpen.getReturnValue() +"' ausgegeben.";
        }
        // Aufruf des Tests der Methode drive() inkl. Rückmeldung an den Benutzer
        TestResult outputDrive = fastCarTester.testDrive();
        if (outputDrive.isSuccess()) {
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode drive() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode drive() hat noch Fehler. Es soll 'wrooooooom' im System.out.println() ausgegeben werden. Aktuell wird '"+outputDrive.getReturnValue() +"' ausgegeben.";
        }
        textAnUser += "\nEnde der Tests für die Klasse FastCar \n";
        return textAnUser;
    }

    /***
     * Tests für die Klasse FutureCar
     * @param jarFilePath wird an ein Object der Klasse FutureCarTester weitergegeben
     * @return Ausgabe an den Benutzer
     * @throws Exception Handling wird weitergereicht an nächsthöhere Ebene
     */
    public String testFutureCar(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der Tests für die Klasse FutureCar";
        FutureCarTester futureCarTester = new FutureCarTester(jarFilePath);

        // Aufruf des Tests der Methode open() inkl. Rückmeldung an den Benutzer
        TestResult outputOpen = futureCarTester.testOpen();
        if (outputOpen.isSuccess()) {
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode open() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode open() hat noch Fehler. Es soll 'it is opened' im System.out.println() ausgegeben werden. Aktuell wird '"+outputOpen.getReturnValue() +"' ausgegeben.";
        }
        // Aufruf des Tests der Methode drive() inkl. Rückmeldung an den Benutzer
        TestResult outputDrive = futureCarTester.testDrive();
        if (outputDrive.isSuccess()) {
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode drive() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode drive() hat noch Fehler. Es soll 'wusch' im System.out.println() ausgegeben werden. Aktuell wird '"+outputDrive.getReturnValue() +"' ausgegeben.";
        }
        textAnUser += "\nEnde der Tests für die Klasse FutureCar \n";
        return textAnUser;
    }
}
