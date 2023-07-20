package com.example.testframeworkwi2020c.testSammlung;

import com.example.testframeworkwi2020c.testSammlung.x_III_StringController.StringControllerTester;

public class X_III_StringController_Controller {

    public String testStringController(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der Tests für die Klasse StringController";
        StringControllerTester tester = new StringControllerTester(jarFilePath);
        TestResult<String> testResult= tester.testAddString();
        //TestAddString
        if (testResult.isSuccess()) {
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+"Die Methode addString() wurde erfolgreich getestet. ";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji()+"Die Methode addString() hat noch Fehler. Bei einem Input von \"Hello\" und einem addieren von \" World\" soll \"Hello World\" gespeichert werden. Aktuell wird \"" + testResult.getReturnValue() + "\" gespeichert";
        }
        testResult= tester.testReplaceStringWithIndices();
        //TestReplaceStringWithIndices
        if (testResult.isSuccess()) {
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+"Die Methode replaceStringWithIndices() wurde erfolgreich getestet. ";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji()+"Die Methode replaceStringWithIndices() hat noch Fehler. Der String \"Hello World!\" soll bei einem Input von 6,11,\"Universe\" lokal als \"Hello Universe!\" gespeichert werden. Aktuell wird \"" + testResult.getReturnValue() + "\" gespeichert";
        }
        testResult= tester.testReplaceStringWithStartIndex();
        //TestReplaceStringWithStartIndex
        if (testResult.isSuccess()) {
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+"Die Methode replaceStringWithStartIndex() wurde erfolgreich getestet. ";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji()+"Die Methode replaceStringWithStartIndex() hat noch Fehler. Der String \"Hello World!\" soll bei einem Input von 6,\"Universe\" lokal als \"Hello Universe!\" gespeichert werden. Aktuell wird \"" + testResult.getReturnValue() + "\" gespeichert";
        }
        testResult= tester.testGetString();
        //TestGetString
        if (testResult.isSuccess()) {
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+"Die Methode getString() wurde erfolgreich getestet. ";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji()+"Die Methode getString() hat noch Fehler. Es soll \"Hello\" zurückgegeben werden. Aktuell wird \""+testResult.getReturnValue()+"\" zurückgegeben.";
        }
        testResult= tester.testSetString();
        //TestSetString
        if (testResult.isSuccess()) {
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+"Die Methode setString() wurde erfolgreich getestet. ";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji()+"Die Methode setString() hat noch Fehler Es soll \"Goodbye\" gespeichert werden. Aktuell wird \""+testResult.getReturnValue()+"\" gespeichert.";
        }
        TestResult<Integer> testResultInt= tester.testGetLength();
        //TestGetLength
        if (testResultInt.isSuccess()) {
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+"Die Methode getLength() wurde erfolgreich getestet. ";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji()+"Die Methode getLength() hat noch Fehler. Es soll bei einem Input von \"Hello\", 5 zurückgegeben werden. Aktuell wird \""+testResultInt.getReturnValue()+"\" zurückgegeben.";
        }
        testResultInt= tester.testGetCapacity();
        //TestGetCapacity
        if (testResultInt.isSuccess()) {
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+"Die Methode getCapacity() wurde erfolgreich getestet. ";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji()+"Die Methode getCapacity() hat noch Fehler. Es soll bei einem Input von \"Hello\", 16 zurückgegeben werden. Aktuell wird \""+testResultInt.getReturnValue()+"\" zurückgegeben.";
        }
        return textAnUser;
    }
}
