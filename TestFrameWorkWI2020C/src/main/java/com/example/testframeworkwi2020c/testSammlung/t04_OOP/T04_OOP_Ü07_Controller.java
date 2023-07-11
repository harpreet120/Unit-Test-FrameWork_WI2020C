package com.example.testframeworkwi2020c.testSammlung.t04_OOP;

import com.example.testframeworkwi2020c.testSammlung.Emojis;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü07.BlurayTester;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü07.DVDTester;

public class T04_OOP_Ü07_Controller {

    public String testDVD(String jarFilePath) throws Exception{
        String textAnUser = "\nBeginn der Tets für die Klasse DVD";
        DVDTester dvdTester = new DVDTester(jarFilePath);
        TestResult<String> testResult = dvdTester.testPlay();
        if (testResult.isSuccess()){
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+" Die Methode play() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji()+" Die Methode play() hat noch Fehler. Es soll  \"playing the dvd\" im System.out.println() ausgegeben werden. Aktuell wird \""+ testResult.getReturnValue()+ "\" ausgegeben.";
        }
        testResult = dvdTester.testSearch();
        if (testResult.isSuccess()){
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+" Die Methode search() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji()+" Die Methode search() hat noch Fehler. Es soll  \"searching...\" im System.out.println() ausgegeben werden. Aktuell wird \""+ testResult.getReturnValue()+ "\" ausgegeben.";
        }
        textAnUser += "\n"+"Ende der Tests für die Klasse DVD";
        return textAnUser;
    }

    public String testBluray(String jarFilePath) throws Exception{
        String textAnUser = "\nBeginn der Tets für die Klasse Bluray";
        BlurayTester blurayTester = new BlurayTester(jarFilePath);
        TestResult<String> testResult = blurayTester.testPlay();
        if (testResult.isSuccess()){
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+" Die Methode play() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji()+" Die Methode play() hat noch Fehler. Es soll  \"playing the bluray\" im System.out.println() ausgegeben werden. Aktuell wird \""+ testResult.getReturnValue()+ "\" ausgegeben.";
        }
        testResult = blurayTester.testSearch();
        if (testResult.isSuccess()){
            textAnUser += "\n"+Emojis.RICHTIG.getEmoji()+" Die Methode search() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji()+" Die Methode search() hat noch Fehler. Es soll  \"fast searching...\" im System.out.println() ausgegeben werden. Aktuell wird \""+ testResult.getReturnValue()+ "\" ausgegeben.";
        }
        textAnUser += "\n"+"Ende der Tests für die Klasse Bluray";
        return textAnUser;
    }
}
