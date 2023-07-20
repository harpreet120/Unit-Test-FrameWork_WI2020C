package com.example.testframeworkwi2020c.testSammlung.t06_Strings;

import com.example.testframeworkwi2020c.testSammlung.Emojis;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import com.example.testframeworkwi2020c.testSammlung.t06_Strings.Ü03.StringTesterTester;

public class T06_Strings_Ü03_Controller {
    /***
     *  Stellt die Rückgabeoptionen für die einzelnen Methoden dar
     * @param jarFilePath wird benötigt zur korrekten Anwendung
     * @return der fertigen textAnUser
     * @throws Exception wird weitergegeben
     */
    public String testStringTester(String jarFilePath) throws Exception{
        String textAnUser = "\nBeginn der Tets für die Klasse StringTester";
        StringTesterTester stringTester = new StringTesterTester(jarFilePath);
        TestResult<String> testResult = stringTester.testCountOccurance();
        if (testResult.isSuccess()){
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji()+" Die Methode countOccurance() für char wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji()+" Die Methode countOccurance() für char hat noch Fehler. Es soll  1 im System.out.println() ausgegeben werden. Aktuell wird "+ testResult.getReturnValue()+ " ausgegeben.";
        }

        TestResult<String> testResult2 = stringTester.testCountOccurance2();
        if (testResult2.isSuccess()){
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji()+" Die Methode countOccurance() für String wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji()+" Die Methode countOccurance() für String hat noch Fehler. Es soll  1 im System.out.println() ausgegeben werden. Aktuell wird "+ testResult.getReturnValue()+ " ausgegeben.";
        }
        textAnUser += "\n"+"Ende der Tests für die Klasse StringTester";
        return textAnUser;
    }


}
