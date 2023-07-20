package com.example.testframeworkwi2020c.testSammlung.t09_ArrayList_Hashtable;

import com.example.testframeworkwi2020c.testSammlung.Emojis;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import com.example.testframeworkwi2020c.testSammlung.t09_ArrayList_Hashtable.Ü01.MainTester;
import com.example.testframeworkwi2020c.testSammlung.t09_ArrayList_Hashtable.Ü01.PersonTester;

public class T09_ArrayList_Hashtable_Ü01_Controller {

    public String testPerson(String jarFilePath) throws Exception{
        String textAnUser = "Beginn der Tests für die Klasse Person";
        PersonTester personTester = new PersonTester(jarFilePath);
        TestResult<String> testResult = personTester.testSetName();
        if (testResult.isSuccess()) {
            textAnUser += "\n" + Emojis.RICHTIG.getEmoji() + " Die Methode setName() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n" + Emojis.FALSCH.getEmoji() + " Die Methode setName() hat noch Fehler. Es soll \"Loh\" als Variablenwert für \"Name\" gespeichert werden. Aktuell wird \""+testResult.getReturnValue()+"\" als Variab-lenwert für \"Name\" gespeichert.";
        }
        testResult = personTester.testSetVorname();
        if (testResult.isSuccess()) {
            textAnUser += "\n" + Emojis.RICHTIG.getEmoji() + " Die Methode setVorname() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n" + Emojis.FALSCH.getEmoji() + " Die Methode setVorname() hat noch Fehler. Es soll \"Meike\" als Variablenwert für \"Vorname\" gespeichert werden. Aktuell wird \""+testResult.getReturnValue()+"\" als Variab-lenwert für \"Vorname\" gespeichert.";
        }
        TestResult<Integer> testResult1 = personTester.testSetAlter();
        if (testResult1.isSuccess()) {
            textAnUser += "\n" + Emojis.RICHTIG.getEmoji() + " Die Methode setAlter() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n" + Emojis.FALSCH.getEmoji() + " Die Methode setAlter() hat noch Fehler. Es soll '20' als Variablenwert für \"Alter\" gespeichert werden. Aktuell wird '"+testResult1.getReturnValue()+"' als Variab-lenwert für \"Alter\" gespeichert.";
        }
        testResult = personTester.testToString();
        if (testResult.isSuccess()) {
            textAnUser += "\n" + Emojis.RICHTIG.getEmoji() + " Die Methode toString() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n" + Emojis.FALSCH.getEmoji() + " Die Methode toString() hat noch Fehler. Es soll \"Mein Name ist Meike Loh und ich bin 20 Jahre alt\" im System.out.println() ausgegeben werden. Aktuell wird \""+testResult.getReturnValue()+"\" ausgegeben";
        }
        textAnUser += "\nEnde der Tests für die Klasse Person\n";
        return textAnUser;
    }
    public String testMain(String jarFilePath) throws Exception{
        String textAnUser = "\n\nBeginn der Tests für die Klasse Main";
        MainTester mainTester = new MainTester(jarFilePath);
        TestResult<String> testResult = mainTester.testMain();
        if (testResult.isSuccess()) {
            textAnUser += "\n" + Emojis.RICHTIG.getEmoji() + " Die Methode main() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n" + Emojis.FALSCH.getEmoji() + " Die Methode main() hat noch Fehler. Es soll die toString() Methode in das System.out.println() geschrieben werden. Aktuell wird \n"+testResult.getReturnValue()+"\" in die Konsole geschrieben.";
        }
        textAnUser += "\nEnde der Tests für die Klasse Main\n";
        return textAnUser;
    }
}
