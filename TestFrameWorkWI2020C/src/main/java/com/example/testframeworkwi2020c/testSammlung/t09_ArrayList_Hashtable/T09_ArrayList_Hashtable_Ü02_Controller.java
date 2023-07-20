package com.example.testframeworkwi2020c.testSammlung.t09_ArrayList_Hashtable;

import com.example.testframeworkwi2020c.testSammlung.Emojis;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import com.example.testframeworkwi2020c.testSammlung.t09_ArrayList_Hashtable.Ü02.MainTester;

public class T09_ArrayList_Hashtable_Ü02_Controller {
    public String testMain(String jarFilePath) throws Exception {
        String textAnUser = "Beginn der Tests für die Klasse Main";
        MainTester mainTester = new MainTester(jarFilePath);
        TestResult<String> testResult = mainTester.testMain();
        if (testResult.isSuccess()) {
            textAnUser += "\n" + Emojis.RICHTIG.getEmoji() + " Die Methode main() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n" + Emojis.FALSCH.getEmoji() + " Die Methode main() hat noch Fehler. Es sollen alle gegebenen Zahlen bis zur -1 rückwärts ausgegeben werden. Aktuell wird \""+testResult.getReturnValue()+"\" ausgegeben.";
        }
        textAnUser += "\nEnde der Tests für die Klasse Main\n";
        return textAnUser;
    }
}
