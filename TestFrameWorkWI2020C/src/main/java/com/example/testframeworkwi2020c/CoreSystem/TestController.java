package com.example.testframeworkwi2020c.CoreSystem;

import com.example.testframeworkwi2020c.testSammlung.X_III_StringController_Controller;
import com.example.testframeworkwi2020c.testSammlung.X_I_unfair_Dice_Controller;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.*;
import com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle.*;
import com.example.testframeworkwi2020c.testSammlung.t06_Strings.T06_Strings_Ü01_Controller;
import com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle.T05_DAK_Ü04_Controller;
import com.example.testframeworkwi2020c.testSammlung.t06_Strings.T06_Strings_Ü02_Controller;


public class TestController implements ITester{
    @Override
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
            case "06_Strings_Ü01":
                return testMainÜ01String(jarFilePath);
            case "06_Strings_Ü02":
                return testMainÜ02String(jarFilePath);
            case "X-I_unfair_dice":
                return testWuerfel(jarFilePath);
            case "X-III_StringController":
                return testStringController(jarFilePath);
        }
        return "";
    }

    public String testWuerfel(String jarFilePath) {
        String textAnUser = "";
        X_I_unfair_Dice_Controller testWuerfel = new X_I_unfair_Dice_Controller();
        try {
            textAnUser += testWuerfel.testFairDice(jarFilePath);
            textAnUser += testWuerfel.testUnfairDice(jarFilePath);
//            textAnUser += testWuerfel.testDealer(jarFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return textAnUser;
    }

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

    // Tests für die Übungsaufgabe OOP_Übung05
    // Weitergabe des "Text an User"
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

    // Tests für die Übungsaufgabe OOP_Übung06
    // Weitergabe des "Text an User"
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


    // Tests für die Übungsaufgabe OOP_Übung07
    // Weitergabe des "Text an User"
    public String testDiscs(String jarFilePath) {
        String textAnUser = "";
        T04_OOP_Ü07_Controller controller = new T04_OOP_Ü07_Controller();
        try {
            textAnUser += controller.testDVD(jarFilePath);
            textAnUser += "\n";
            textAnUser += controller.testBluray(jarFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        textAnUser += "\n";
        textAnUser += "\nDas Interface \"IDisc\" kann aufgrund von Limitierungen des Testframeworks nicht getestet werden.";
        textAnUser += "\nDie Klasse Player und ihre Methoden können aufgrund von Limitierungen des Testframeworks nicht getestet werden.";
        return textAnUser;
    }

    // Tests für die Übungsaufgabe OOP_Übung08
    // Weitergabe des "Text an User"
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

    // Tests für die Übungsaufgabe 02 aus Kapitel Datentypen, Arithmetik und Kontrolle
    // Weitergabe des "Text an User"
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

    // Tests für die Übungsaufgabe 03 aus Kapitel Datentypen, Arithmetik und Kontrolle
    // Weitergabe des "Text an User"
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

    // Tests für die Übungsaufgabe 04 aus Kapitel Datentypen, Arithmetik und Kontrolle
    // Weitergabe des "Text an User"
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

    // Tests für die Übungsaufgabe 06 aus Kapitel Datentypen, Arithmetik und Kontrolle
    // Weitergabe des "Text an User"
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

    // Tests für die Übungsaufgabe 10 aus Kapitel Datentypen, Arithmetik und Kontrolle
    // Weitergabe des "Text an User"
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

    // Tests für die Übungsaufgabe 06 aus Kapitel Datentypen, Arithmetik und Kontrolle
    // Weitergabe des "Text an User"
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

    // Tests für die Übungsaufgabe 06 aus Kapitel Datentypen, Arithmetik und Kontrolle
    // Weitergabe des "Text an User"
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

    // Tests für die Übungsaufgabe 01 aus Strings
    // Weitergabe des "Text an User"
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

    // Tests für die Übungsaufgabe 02 aus Strings
    // Weitergabe des "Text an User"
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
}