package com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle;

import com.example.testframeworkwi2020c.testSammlung.Emojis;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü05.CircleTester;
import com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle.Ü14.GeldmarktKontoTester;
import com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle.Ü14.GiroKontoTester;
import com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle.Ü14.TagesgeldKontoTester;

public class T05_DAK_Ü14_Controller {

    /***
     *
     * @param jarFilePath wird an GirokontoTester übergeben
     * @return der Ausgabe an den Benutzer
     * @throws Exception Handling weitergeben
     */
    public String testGiroKonto(String jarFilePath) throws Exception{
        String textAnUser = "\nBeginn der Tests für die Klasse GiroKonto";
        GiroKontoTester giroKontoTester = new GiroKontoTester(jarFilePath);

        // Aufruf des Tests der Methode einzahlen() inkl. Rückmeldung an den Benutzer
        TestResult outputEinzahlen = giroKontoTester.testEinzahlen();
        if (outputEinzahlen.isSuccess()){
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode einzahlen() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji() +" Die Methode einzahlen() hat noch Fehler. Es soll für die Variable 'kontostand' der Wert um 500 erhöht werden. Aktuell wird '"+outputEinzahlen.getReturnValue()+"' als Variablenwert festgelegt." ;
        }

        // Aufruf des Tests der Methode auszahlen() inkl. Rückmeldung an den Benutzer
        TestResult outputAuszahlen= giroKontoTester.testAuszahlen();
        if (outputAuszahlen.isSuccess()){
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode auszahlen() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji() +" Die Methode auszahlen() hat noch Fehler. Es soll für die Variable 'kontostand' der Wert um 200 reduziert werden. Aktuell wird '"+outputAuszahlen.getReturnValue()+"' als Variablenwert festgelegt." ;
        }

        // Aufruf des Tests der Methode auskunft() inkl. Rückmeldung an den Benutzer
        TestResult outputAuskunft= giroKontoTester.testAuskunft();
        if (outputAuskunft.isSuccess()){
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode auskunft() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji() +" Die Methode auskunft() hat noch Fehler. Es soll der Wert der Variable 'kontostand' zurückgegeben werden. Aktuell wird '"+outputAuskunft.getReturnValue()+"' zurückgegeben." ;
        }

        textAnUser += "\nEnde der Tests für die Klasse GiroKonto \n";
        return textAnUser;
    }

    /***
     *
     * @param jarFilePath wird an GeldmarktKontoTester übergeben
     * @return der Ausgabe an den Benutzer
     * @throws Exception Handling weitergeben
     */
    public String testGeldMarktKonto(String jarFilePath) throws Exception{
        String textAnUser = "\nBeginn der Tests für die Klasse GeldmarktKonto";
        GeldmarktKontoTester geldmarktKontoTester = new GeldmarktKontoTester(jarFilePath);

        // Aufruf des Tests der Methode einzahlen() inkl. Rückmeldung an den Benutzer
        TestResult outputEinzahlen = geldmarktKontoTester.testEinzahlen();
        if (outputEinzahlen.isSuccess()){
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode einzahlen() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji() +" Die Methode einzahlen() hat noch Fehler. Es soll für die Variable 'kontostand' der Wert um 500*Faktor erhöht werden. Aktuell wird '"+outputEinzahlen.getReturnValue()+"' verändert." ;
        }

        // Aufruf des Tests der Methode auszahlen() inkl. Rückmeldung an den Benutzer
        TestResult outputAuszahlen= geldmarktKontoTester.testAuszahlen();
        if (outputAuszahlen.isSuccess()){
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode auszahlen() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji() +" Die Methode auszahlen() hat noch Fehler. Es soll für die Variable 'kontostand' der Wert um 200 reduziert werden. Aktuell wird '"+outputAuszahlen.getReturnValue()+"' als Variablenwert festgelegt." ;
        }

        // Aufruf des Tests der Methode auskunft() inkl. Rückmeldung an den Benutzer
        TestResult outputAuskunft= geldmarktKontoTester.testAuskunft();
        if (outputAuskunft.isSuccess()){
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode auskunft() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji() +" Die Methode auskunft() hat noch Fehler. Es soll der Wert der Variable 'kontostand' zurückgegeben werden. Aktuell wird '"+outputAuskunft.getReturnValue()+"' zurückgegeben." ;
        }

        textAnUser += "\nEnde der Tests für die Klasse GeldmarktKonto \n";
        return textAnUser;
    }

    /***
     *
     * @param jarFilePath wird an TagesgeldKonto übergeben
     * @return der Ausgabe an den Benutzer
     * @throws Exception Handling weitergeben
     */
    public String testTagesGeldKonto(String jarFilePath) throws Exception{
        String textAnUser = "\nBeginn der Tests für die Klasse TagesgeldKonto";
        TagesgeldKontoTester tagesgeldKontoTester = new TagesgeldKontoTester(jarFilePath);

        // Aufruf des Tests der Methode einzahlen() inkl. Rückmeldung an den Benutzer
        TestResult outputEinzahlen = tagesgeldKontoTester.testEinzahlen();
        if (outputEinzahlen.isSuccess()){
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode einzahlen() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji() +" Die Methode einzahlen() hat noch Fehler. Es soll für die Variable 'kontostand' der Wert um 500 und die Verzinsung erhöht werden. Aktuell wird '"+outputEinzahlen.getReturnValue()+"' als Variablenwert festgelegt." ;
        }

        // Aufruf des Tests der Methode auszahlen() inkl. Rückmeldung an den Benutzer
        TestResult outputAuszahlen= tagesgeldKontoTester.testAuszahlen();
        if (outputAuszahlen.isSuccess()){
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode auszahlen() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji() +" Die Methode auszahlen() hat noch Fehler. Es soll für die Variable 'kontostand' der Wert um 200 reduziert werden. Aktuell wird '"+outputAuszahlen.getReturnValue()+"' als Variablenwert festgelegt." ;
        }

        // Aufruf des Tests der Methode auskunft() inkl. Rückmeldung an den Benutzer
        TestResult outputAuskunft= tagesgeldKontoTester.testAuskunft();
        if (outputAuskunft.isSuccess()){
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode auskunft() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji() +" Die Methode auskunft() hat noch Fehler. Es soll der Wert der Variable 'kontostand' zurückgegeben werden. Aktuell wird '"+outputAuskunft.getReturnValue()+"' zurückgegeben." ;
        }

        textAnUser += "\nEnde der Tests für die Klasse TagesgeldKonto \n";
        return textAnUser;
    }
}
