package com.example.testframeworkwi2020c.CoreSystem;

import com.example.testframeworkwi2020c.testSammlung.Emojis;
import com.example.testframeworkwi2020c.testSammlung.X_III_StringController_Controller;
import com.example.testframeworkwi2020c.testSammlung.X_II_black_jack_Controller;
import com.example.testframeworkwi2020c.testSammlung.X_I_unfair_Dice_Controller;
import com.example.testframeworkwi2020c.testSammlung.exkurs_binary.*;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.*;
import com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle.*;
import com.example.testframeworkwi2020c.testSammlung.t06_Strings.*;
import com.example.testframeworkwi2020c.testSammlung.t07_Arrays.*;
import com.example.testframeworkwi2020c.testSammlung.t08_User_Interaction.*;
import com.example.testframeworkwi2020c.testSammlung.t09_ArrayList_Hashtable.*;


public class TestController{

    public String startComparison(String aufgabenname, String jarFilePath) {
        switch (aufgabenname) {
            case "04_OOP_Ü04":
                return testTelephone(jarFilePath);
            case "04_OOP_Ü05":
                return testFigure(jarFilePath);
            case "04_OOP_Ü06":
                return testTrain(jarFilePath);
            case "04_OOP_Ü07":
                return testDiscs(jarFilePath);
            case "04_OOP_Ü08":
                return testCar(jarFilePath);
            case "05_Datentypen_Ü02":
                return testMainÜ02(jarFilePath);
            case "05_Datentypen_Ü03":
                return testFigureExtended(jarFilePath);
            case "05_Datentypen_Ü04":
                return testCalculator(jarFilePath);
            case "05_Datentypen_Ü06":
                return testMainÜ06(jarFilePath);
            case "05_Datentypen_Ü10":
                return testFibonacci(jarFilePath);
            case "05_Datentypen_Ü11":
                return testMainDAKÜ11(jarFilePath);
            case "05_Datentypen_Ü12":
                return testExponentiator(jarFilePath);
            case "05_Datentypen_Ü13":
                return testMainDAKÜ13(jarFilePath);
            case "05_Datentypen_Ü14":
                return testKonto(jarFilePath);
            case "06_Strings_Ü01":
                return testMainÜ01String(jarFilePath);
            case "06_Strings_Ü02":
                return testMainÜ02String(jarFilePath);
            case "06_Strings_Ü03":
                return testStringTester(jarFilePath);
            case "07_Arrays_Ü01":
                return testMainArr01(jarFilePath);
            case "07_Arrays_Ü02":
                return testMainArr02(jarFilePath);
            case "08_User_Interaction_Ü01":
                return testMainÜ01UserInteraction(jarFilePath);
            case "08_User_Interaction_Ü02":
                return testMainÜ02UserInteraction(jarFilePath);
            case "08_User_Interaction_Ü03":
                return testMainÜ03UserInteraction(jarFilePath);
            case "Exkurs_Binary_Ü01":
                return testMainExkursBinary01(jarFilePath);
            case "Exkurs_Binary_Ü02":
                return testBinaryHelper(jarFilePath);
            case "09_ArrayList_Hashtable_Ü01":
                return testHashtable_Ü01(jarFilePath);
            case "09_ArrayList_Hashtable_Ü02":
                return testHashtable_Ü02(jarFilePath);
            case "X-I_unfair_dice":
                return testWuerfel(jarFilePath);
            case "X-II_black_jack":
                return testBlackjack(jarFilePath);
            case "X-III_StringController":
                return testStringController(jarFilePath);
        }
        return "";
    }

    /***
     * Tests für die Übungsaufgabe 04 aus OOP
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testTelephone(String jarFilePath){
        String textAnUser = "";
        T04_OOP_ü04_Controller controller = new T04_OOP_ü04_Controller();
        try {
            textAnUser += controller.testSmartphone(jarFilePath);
            textAnUser += controller.testMobile(jarFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textAnUser;
    }

    /***
     * Tests für die Übungsaufgabe 05 aus OOP
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testFigure(String jarFilePath){
        String textAnUser = "";
        T04_OOP_Ü05_Controller controller = new T04_OOP_Ü05_Controller();
        try {
            textAnUser += controller.testCircle(jarFilePath);
            textAnUser += controller.testQuadrat(jarFilePath);
            textAnUser += "\nDas Interface 'IFigure' kann aufgrund von Limitierungen des Testframeworks nicht getestet werden.";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textAnUser;
    }

    /***
     * Tests für die Übungsaufgabe 06 aus OOP
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testTrain(String jarFilePath){
        String textAnUser = "";
        T04_OOP_Ü06_Controller controller = new T04_OOP_Ü06_Controller();
        try {
            textAnUser += controller.testZug(jarFilePath);
            textAnUser += controller.testGueterzug(jarFilePath);
            textAnUser += controller.testSpezialzug(jarFilePath);
            textAnUser += controller.testPersonenzug(jarFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textAnUser;
    }

    /***
     * Tests für die Übungsaufgabe 07 aus OOP
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testDiscs(String jarFilePath) {
        String textAnUser = "";
        T04_OOP_Ü07_Controller controller = new T04_OOP_Ü07_Controller();
        try {
            textAnUser += controller.testDVD(jarFilePath)+"\n";
            textAnUser += controller.testBluray(jarFilePath);
            textAnUser += "\n";
            textAnUser += "\nDas Interface \"IDisc\" kann aufgrund von Limitierungen des Testframeworks nicht getestet werden.";
            textAnUser += "\nDie Klasse Player und ihre Methoden können aufgrund von Limitierungen des Testframeworks nicht getestet werden.";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textAnUser;
    }

    /***
     * Tests für die Übungsaufgabe 08 aus OOP
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testCar(String jarFilePath){
        String textAnUser = "";
        T04_OOP_Ü08_Controller controller = new T04_OOP_Ü08_Controller();
        try {
            textAnUser += controller.testFastCar(jarFilePath);
            textAnUser += controller.testFutureCar(jarFilePath);
            textAnUser += "\nDie abstrakte Klasse 'Car' und ihre Methoden können aufgrund von Limitierungen des Testframeworks nicht getestet werden.";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textAnUser;
    }

    /***
     * Tests für die Übungsaufgabe 02 aus Kapitel Datentypen, Arithmetik und Kontrolle
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testMainÜ02(String jarFilePath){
        String textAnUser = "";
        T05_DAK_Ü02_Controller controller = new T05_DAK_Ü02_Controller();
        try {
            textAnUser += controller.testMain(jarFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textAnUser;
    }

    /***
     * Tests für die Übungsaufgabe 03 aus Kapitel Datentypen, Arithmetik und Kontrolle
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testFigureExtended(String jarFilePath){
        String textAnUser = "";
        T05_DAK_Ü03_Controller controller = new T05_DAK_Ü03_Controller();
        try {
            textAnUser += controller.testKreis(jarFilePath);
            textAnUser += controller.testQuadrat(jarFilePath);
            textAnUser += "\nDas Interface 'IFigure' kann aufgrund von Limitierungen des Testframeworks nicht getestet werden.";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textAnUser;
    }

    /***
     * Tests für die Übungsaufgabe 04 aus Kapitel Datentypen, Arithmetik und Kontrolle
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testCalculator(String jarFilePath){
        String textAnUser = "";
        T05_DAK_Ü04_Controller controller = new T05_DAK_Ü04_Controller();
        try {
            textAnUser += controller.testCalculator(jarFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textAnUser;
    }

    /***
     * Tests für die Übungsaufgabe 06 aus Kapitel Datentypen, Arithmetik und Kontrolle
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testMainÜ06(String jarFilePath){
        String textAnUser = "";
        T05_DAK_Ü06_Controller controller = new T05_DAK_Ü06_Controller();
        try {
            textAnUser += controller.testMain(jarFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textAnUser;
    }

    /***
     * Tests für die Übungsaufgabe 10 aus Kapitel Datentypen, Arithmetik und Kontrolle
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testFibonacci(String jarFilePath){
        String textAnUser = "";
        T05_DAK_Ü10_Controller controller = new T05_DAK_Ü10_Controller();
        try {
            textAnUser += controller.testFibonacci(jarFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textAnUser;
    }

    /***
     * Tests für die Übungsaufgabe 11 aus Kapitel Datentypen, Arithmetik und Kontrolle
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testMainDAKÜ11(String jarFilePath){
        String textAnUser = "";
        T05_DAK_Ü11_Controller controller = new T05_DAK_Ü11_Controller();
        try {
            textAnUser += controller.testMain(jarFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textAnUser;
    }

    /***
     * Tests für die Übungsaufgabe 12 aus Kapitel Datentypen, Arithmetik und Kontrolle
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testExponentiator(String jarFilePath){
        String textAnUser = "";
        T05_DAK_Ü12_Controller controller = new T05_DAK_Ü12_Controller();
        try {
            textAnUser += controller.testExponentiator(jarFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textAnUser;
    }

    /***
     * Tests für die Übungsaufgabe 13 aus Kapitel Datentypen, Arithmetik und Kontrolle
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testMainDAKÜ13(String jarFilePath){
        String textAnUser = "";
        T05_DAK_Ü13_Controller controller = new T05_DAK_Ü13_Controller();
        try {
            textAnUser += controller.testMain(jarFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textAnUser;
    }

    /***
     * Tests für die Übungsaufgabe 14 aus Kapitel Datentypen, Arithmetik und Kontrolle
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testKonto(String jarFilePath){
        String textAnUser = "";
        T05_DAK_Ü14_Controller controller = new T05_DAK_Ü14_Controller();
        try {
            textAnUser += controller.testGiroKonto(jarFilePath);
            textAnUser += controller.testGeldMarktKonto(jarFilePath);
            textAnUser += controller.testTagesGeldKonto(jarFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textAnUser;
    }

    /***
     * Tests für die Übungsaufgabe 01 aus Strings
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testMainÜ01String(String jarFilePath){
        String textAnUser = "";
        T06_Strings_Ü01_Controller controller = new T06_Strings_Ü01_Controller();
        try {
            textAnUser += controller.testMain(jarFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textAnUser;
    }

    /***
     * Tests für die Übungsaufgabe 02 aus Strings
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testMainÜ02String(String jarFilePath){
        String textAnUser = "";
        T06_Strings_Ü02_Controller controller = new T06_Strings_Ü02_Controller();
        try {
            textAnUser += controller.testDice(jarFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textAnUser;
    }

    /***
     * Tests für die Übungsaufgabe 03 aus Strings
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testStringTester(String jarFilePath){
        String textAnUser = "";
        T06_Strings_Ü03_Controller controller = new T06_Strings_Ü03_Controller();
        try {
            textAnUser += controller.testStringTester(jarFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textAnUser;
    }

    /***
     * Tests für die Übungsaufgabe 01 aus Arrays
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testMainArr01(String jarFilePath){
        String textAnUser = "";
        T07_Arrays_Ü01_Controller controller = new T07_Arrays_Ü01_Controller();
        try {
            textAnUser += controller.testMain(jarFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textAnUser;
    }

    /***
     * Tests für die Übungsaufgabe 02 aus Arrays
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testMainArr02(String jarFilePath){
        String textAnUser = "";
        T07_Arrays_Ü02_Controller controller = new T07_Arrays_Ü02_Controller();
        try {
            textAnUser += controller.testMain(jarFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textAnUser;
    }

    /***
     * Tests für die Übungsaufgabe 01 aus User_Interaction
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testMainÜ01UserInteraction(String jarFilePath){
        String textAnUser = "";
        T08_User_Interaction_Ü01_Controller controller = new T08_User_Interaction_Ü01_Controller();
        try {
            textAnUser += controller.testMain(jarFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textAnUser;
    }

    /***
     * Tests für die Übungsaufgabe 02 aus User_Interaction
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testMainÜ02UserInteraction(String jarFilePath){
        String textAnUser = "";
        T08_User_Interaction_Ü02_Controller controller = new T08_User_Interaction_Ü02_Controller();
        try {
            textAnUser += controller.testMain(jarFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textAnUser;
    }
    /***
     * Tests für die Übungsaufgabe 03 aus User_Interaction
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testMainÜ03UserInteraction(String jarFilePath){
        String textAnUser = "";
        T08_User_Interaction_Ü03_Controller controller = new T08_User_Interaction_Ü03_Controller();
        try {
            textAnUser += controller.testMain(jarFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textAnUser;
    }

    /***
     * Tests für die Übungsaufgabe 01 aus Exkurs Binary
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testMainExkursBinary01(String jarFilePath){
        String textAnUser = "";
        Exkurs_Binary_Ü01_Controller controller = new Exkurs_Binary_Ü01_Controller();
        try {
            textAnUser += controller.testMain(jarFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textAnUser;
    }

    /***
     * Tests für die Übungsaufgabe 02 aus Exkurs Binary
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testBinaryHelper(String jarFilePath){
        String textAnUser = "";
        Exkurs_Binary_Ü02_Controller controller = new Exkurs_Binary_Ü02_Controller();
        try {
            textAnUser += controller.testBinaryHelper(jarFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textAnUser;
    }

    /***
     * Tests für die Übungsaufgabe 01 aus ArrayList_Hashtable
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testHashtable_Ü01(String jarFilePath){
        String textAnUser = "";
        T09_ArrayList_Hashtable_Ü01_Controller controller = new T09_ArrayList_Hashtable_Ü01_Controller();
        try {
            textAnUser += controller.testPerson(jarFilePath);
            textAnUser += controller.testMain(jarFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textAnUser;
    }

    /***
     * Tests für die Übungsaufgabe 02 aus ArrayList_Hashtable
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testHashtable_Ü02(String jarFilePath){
        String textAnUser = "";
        T09_ArrayList_Hashtable_Ü02_Controller controller = new T09_ArrayList_Hashtable_Ü02_Controller();
        try {
            textAnUser += controller.testMain(jarFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textAnUser;
    }

    /***
     * Tests für die Übungsaufgabe X-I_unfair_dice
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testWuerfel(String jarFilePath) {
        String textAnUser = "";
        X_I_unfair_Dice_Controller testWuerfel = new X_I_unfair_Dice_Controller();
        try {
            textAnUser += testWuerfel.testFairDice(jarFilePath);
            textAnUser += testWuerfel.testUnfairDice(jarFilePath);
            textAnUser += "\n\nDie Klasse Dealer kann aufgrund der Limitierungen des Frameworks nicht getestet werden.";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return textAnUser;
    }

    /***
     * Tests für die Übungsaufgabe X-II_black_jack
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testBlackjack(String jarFilePath) {
        String textAnUser = "";
        X_II_black_jack_Controller controller = new X_II_black_jack_Controller();
        try {
            textAnUser += controller.testRiskyPlayer(jarFilePath);
            textAnUser += controller.testShyPlayer(jarFilePath);
            textAnUser += controller.testManualPlayer(jarFilePath);
            textAnUser += "\n\nDie Klassen Game und Main können aufgrund der Limitierungen des Frameworks nicht getestet werden.";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return textAnUser;
    }

    /***
     * Tests für die Übungsaufgabe X-III_StringController
     * @param jarFilePath Wird in die jeweiligen zu testenden Klassen übergeben
     * @return Weitergabe des "Text an User"
     */
    public String testStringController (String jarFilePath) {
        String textAnUser = "";
        X_III_StringController_Controller controller = new X_III_StringController_Controller();
        try {
            textAnUser += controller.testStringController(jarFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textAnUser;
    }
}