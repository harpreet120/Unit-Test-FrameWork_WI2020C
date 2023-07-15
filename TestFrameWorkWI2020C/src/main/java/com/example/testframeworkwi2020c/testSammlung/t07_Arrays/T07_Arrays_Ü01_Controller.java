package com.example.testframeworkwi2020c.testSammlung.t07_Arrays;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.Emojis;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import com.example.testframeworkwi2020c.testSammlung.t07_Arrays.Ü01.MainTesterArr1;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class T07_Arrays_Ü01_Controller {

    // Tests für die Klasse Main
    public String testMain(String jarFilePath) throws Exception {
        String textAnUser = "\nBeginn der Tests für die Klasse Main";
        MainTesterArr1 mainTester= new MainTesterArr1(jarFilePath);

        // Aufruf des Tests der Methode main() inkl. Rückmeldung an den Benutzer
        TestResult outputMain = mainTester.testMain();
        if (outputMain.isSuccess()) {
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji() +" Die Methode main() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+Emojis.FALSCH.getEmoji()+" Die Methode main() hat noch Fehler.  Es sollen 10 Zahlen eines Arrays in umgekehrter Reihenfolge im System.out.println() ausgegeben werden. Aktuell werden die Zahlen "+outputMain.getReturnValue() +" ausgegeben.";
        }
        textAnUser += "\nEnde der Tests für die Klasse Main";
        return textAnUser;
    }
}
