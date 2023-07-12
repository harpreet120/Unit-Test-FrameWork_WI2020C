package com.example.testframeworkwi2020c.testSammlung.t06_Strings;
import com.example.testframeworkwi2020c.testSammlung.Emojis;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import com.example.testframeworkwi2020c.testSammlung.t06_Strings.Ü01.MainTester;

public class T06_Strings_Ü01_Controller {

    public String testMain(String jarFilePath) throws Exception{
        String textAnUser = "\nBeginn der Tets für die Klasse Main";
        MainTester mainTester = new MainTester(jarFilePath);
        TestResult<String> testResult = mainTester.testMain();
        if (testResult.isSuccess()){
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji()+" Die Methode main() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji()+" Die Methode main() hat noch Fehler. Es soll  \"Zahl XY ist durch 5 teilbar\" oder \"Zahl XY ist nicht durch 5 teilbar\" im System.out.println() ausgegeben werden. Aktuell wird \n\""+ testResult.getReturnValue()+ "\" ausgegeben.";
        }
        textAnUser += "\n"+"Ende der Tests für die Klasse Main";
        return textAnUser;
    }
}
