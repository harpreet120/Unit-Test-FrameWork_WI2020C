package com.example.testframeworkwi2020c.testSammlung.t08_User_Interaction;

import com.example.testframeworkwi2020c.testSammlung.Emojis;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import com.example.testframeworkwi2020c.testSammlung.t08_User_Interaction.Ü02.MainTester;

public class T08_User_Interaction_Ü02_Controller {
    /***
     *  Stellt die Rückgabeoptionen dar
     * @param jarFilePath wird benötigt zur korrekten Anwendung
     * @return der fertigen textAnUser
     * @throws Exception wird weitergegeben
     */
    public String testMain(String jarFilePath) throws Exception{
        String textAnUser = "\nBeginn der Tests für die Klasse Main";
        MainTester mainTester = new MainTester(jarFilePath);
        TestResult<String> testResult = mainTester.testMain();
        if (testResult.isSuccess()){
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji()+" Die Methode main() wurde erfolgreich getestet.";
        } else if (testResult.getReturnValue().contains("3")) {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji()+" Die Methode main() hat noch Fehler. Es soll  \"3\" im System.out.println() bei der Operation Dividieren ausgegeben werden. Aktuell wird \""+ testResult.getReturnValue()+ "\" ausgegeben.";
        } else if (testResult.getReturnValue().contains("44")) {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji()+" Die Methode main() hat noch Fehler. Es soll  \"44\" im System.out.println() bei der Operation Multiplizieren ausgegeben werden. Aktuell wird \""+ testResult.getReturnValue()+ "\" ausgegeben.";
        } else if (testResult.getReturnValue().contains("1")) {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji()+" Die Methode main() hat noch Fehler. Es soll  \"1\" im System.out.println() bei der Operation Subtrahieren ausgegeben werden. Aktuell wird \""+ testResult.getReturnValue()+ "\" ausgegeben.";
        } else if (testResult.getReturnValue().contains("7")) {
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji()+" Die Methode main() hat noch Fehler. Es soll  \"7\" im System.out.println() bei der Operation Addition ausgegeben werden. Aktuell wird \""+ testResult.getReturnValue()+ "\" ausgegeben.";
        } else{
            textAnUser += "\n"+ Emojis.FALSCH.getEmoji()+" Die Methode main() hat noch Fehler. Es soll das Ergebnis einer Operation im System.out.println() ausgegeben werden. Aktuell wird mindestens ein Operator nicht erkannt und \""+ testResult.getReturnValue()+ "\" ausgegeben.";

        }

        textAnUser += "\n"+"Ende der Tests für die Klasse Main";
        return textAnUser;
    }
}
