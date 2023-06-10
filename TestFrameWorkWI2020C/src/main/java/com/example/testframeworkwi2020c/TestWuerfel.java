package com.example.testframeworkwi2020c;

import com.example.testframeworkwi2020c.wuerfeltester.FairDiceTester;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class TestWuerfel {
//    public String testUnfairDice() {
//        String textAnUser = "";
//        //Test einer kompletten Klasse
//        Result result = JUnitCore.runClasses(TestUnfairDice.class);
//        for (Failure failure : result.getFailures()) {
//            //Custom fehlermeldung
//            textAnUser += failure.toString();
//        }
//        textAnUser += ("\nUnfair Dice tests erfolgreich: " + result.wasSuccessful());
//
//        //Test einzelner Methoden in einer Klasse
////        Request request = Request.method(TestUnfairDice.class,"testZahl");
////        Result singleTestResult = new JUnitCore().run(request);
////        if (singleTestResult.wasSuccessful()) {
////            textAnUser +=("Einzelner Test erfolgreich");
////        } else {
////            for (Failure failure : singleTestResult.getFailures()) {
////                textAnUser +=(failure.toString());
////            }
////        }
//        return textAnUser;
//    }

    public String testFairDice(String jarFilePath) throws Exception {
        String textAnUser = "";
        FairDiceTester fairDiceTester = new FairDiceTester(jarFilePath);
        //TestGetNumber
        if (fairDiceTester.testGetNumber()) {
            textAnUser += "\ngetNumber() erfolgreich getestet :)";
        } else {
            textAnUser += "\ngetNumber() hat noch Fehler :(";
        }
        //TestRoll
        if (fairDiceTester.testRoll()){
            textAnUser += "\nroll() erfolgreich getestet :)";
        } else {
            textAnUser += "\nroll() hat noch Fehler :(";
        }
        textAnUser += ("\nFair Dice tests abgeschlossen");
        return textAnUser;
    }

//    public String testDealer(){
//        String textAnUser = "";
//        //Test einer kompletten Klasse
//        Result result = JUnitCore.runClasses(TestDealer.class);
//        for (Failure failure : result.getFailures()) {
//            //Custom fehlermeldung
//            textAnUser += failure.toString();
//        }
//        textAnUser += ("\nDealer tests erfolgreich: " + result.wasSuccessful());
//        return textAnUser;
//    }
}
