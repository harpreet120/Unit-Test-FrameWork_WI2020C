package com.example.testframeworkwi2020c.testSammlung.t08_User_Interaction;

import com.example.testframeworkwi2020c.testSammlung.Emojis;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import com.example.testframeworkwi2020c.testSammlung.t08_User_Interaction.Ü01.MainTester;


public class T08_User_Interaction_Ü01_Controller {

    /***
     *  Stellt die Rückgabeoptionen dar
     * @param jarFilePath wird benötigt zur korrekten Anwendung
     * @return der fertigen textAnUser
     * @throws Exception wird weitergegeben
     */
    public String testMain(String jarFilePath) throws Exception{
        String textAnUser = "\nBeginn der Tets für die Klasse Main";
        MainTester mainTester = new MainTester(jarFilePath);
        TestResult<String> testResult = mainTester.testMain();
        if (testResult.isSuccess()){
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji()+" Die Methode main() wurde erfolgreich getestet.";
        } else {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji()+" Die Methode main() hat noch Fehler. Es soll  \"The sum is: 10\" im System.out.println() ausgegeben werden. Aktuell wird \""+ testResult.getReturnValue()+ "\" ausgegeben.";
        }
        textAnUser += "\n"+"Ende der Tests für die Klasse Main";
        return textAnUser;
    }
}
