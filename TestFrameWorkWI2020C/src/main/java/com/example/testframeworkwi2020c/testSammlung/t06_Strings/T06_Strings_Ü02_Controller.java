package com.example.testframeworkwi2020c.testSammlung.t06_Strings;

import com.example.testframeworkwi2020c.testSammlung.Emojis;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import com.example.testframeworkwi2020c.testSammlung.t06_Strings.Ü02.DiceTester;

public class T06_Strings_Ü02_Controller {

    /***
     *  Stellt die Rückgabeoptionen dar, je nachdem welche TestResults bei welchen Test erhalten werden
     * @param jarFilePath wird benötigt zur korrekten Anwendung
     * @return der fertigen textAnUser
     * @throws Exception wird weitergegeben
     */
    public String testDice(String jarFilePath) throws Exception{
        String textAnUser = "\nBeginn der Tets für die Klasse Dice";
        DiceTester diceTester = new DiceTester(jarFilePath);
        TestResult<String> testResult = diceTester.testRoll();
        if (testResult.isSuccess()){
            textAnUser += "\n"+ Emojis.RICHTIG.getEmoji()+" Die Methode roll() wurde erfolgreich getestet.";
        } else {
            if (testResult.getReturnValue().matches("\\d+")) {
                if (Integer.parseInt(testResult.getReturnValue())<1 || Integer.parseInt(testResult.getReturnValue()) > 10){
                    textAnUser += "\n"+ Emojis.FALSCH.getEmoji()+" Die Methode roll() hat noch Fehler. Es soll nur die Zahlen von 1 bis 'edges' im System.out.println() ausgegeben werden. Aktuell wird \""+ testResult.getReturnValue()+ "\" ausgegeben.";
                } else{
                    textAnUser += "\n"+ Emojis.FALSCH.getEmoji()+" Die Methode roll() hat noch Fehler. Es soll nur die Zahlen von 1 bis 'edges' im System.out.println() ausgegeben werden. Aktuell wird nicht \""+ testResult.getReturnValue()+ "\" ausgegeben, obwohl 10 als Input verwendet wurde.";
                }
            } else {
                textAnUser += "\n"+ Emojis.FALSCH.getEmoji()+" Die Methode roll() hat noch Fehler. Es soll \"Sie haben X Augen gewürfelt\" im System.out.println() ausgegeben werden. Aktuell wird \""+ testResult.getReturnValue()+ "\" ausgegeben.";
            }
        }
        textAnUser += "\n"+"Ende der Tests für die Klasse Main";
        return textAnUser;
    }
}
