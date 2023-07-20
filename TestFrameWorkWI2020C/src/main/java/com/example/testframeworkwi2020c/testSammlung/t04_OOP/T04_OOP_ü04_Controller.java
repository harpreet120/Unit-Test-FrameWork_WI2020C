package com.example.testframeworkwi2020c.testSammlung.t04_OOP;

import com.example.testframeworkwi2020c.testSammlung.Emojis;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü04.MobileTester;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü04.SmartphoneTester;

public class T04_OOP_ü04_Controller {
    public String testSmartphone(String jarFilePath) throws Exception{
        String textAnUser = "\nBeginn der Tests für die Klasse Smartphone";
        SmartphoneTester smartphoneTester = new SmartphoneTester(jarFilePath);
        TestResult<String> testResult = smartphoneTester.testClick();
        if (testResult.isSuccess()){
            textAnUser += "\n" + Emojis.RICHTIG.getEmoji() + " Die Methode click() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n" + Emojis.FALSCH.getEmoji() +" Die Methode click() hat noch Fehler. Es soll \"Klick\" im System.out.println() ausgegeben werden. Aktuell wird \""+testResult.getReturnValue()+"\" ausgegeben.";
        }
        textAnUser += "\nEnde der Tests für die Klasse Smartphone\n";
        return textAnUser;
    }

    public String testMobile(String jarFilePath) throws Exception {
        String textAnUser = "\n\nBeginn der Tests für die Klasse Mobile";
        MobileTester mobileTester = new MobileTester(jarFilePath);
        TestResult<String> testResult = mobileTester.testDial();
        if (testResult.isSuccess()) {
            textAnUser += "\n" + Emojis.RICHTIG.getEmoji() + " Die Methode dial() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n" + Emojis.FALSCH.getEmoji() +" Die Methode click() hat noch Fehler. Es soll \"Piep\" im System.out.println() ausgegeben werden. Aktuell wird \""+testResult.getReturnValue()+"\" ausgegeben.";
        }
        testResult = mobileTester.testRing();
        if (testResult.isSuccess()) {
            textAnUser += "\n" + Emojis.RICHTIG.getEmoji() + " Die Methode ring() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n" + Emojis.FALSCH.getEmoji() +" Die Methode click() hat noch Fehler. Es soll \"Ding Dong\" im System.out.println() ausgegeben werden. Aktuell wird \""+testResult.getReturnValue()+"\" ausgegeben.";
        }
        textAnUser += "\nEnde der Tests für die Klasse Mobile\n";
        return textAnUser;
    }
}
