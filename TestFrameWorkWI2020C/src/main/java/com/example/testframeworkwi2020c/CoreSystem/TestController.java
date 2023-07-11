package com.example.testframeworkwi2020c.CoreSystem;

import com.example.testframeworkwi2020c.testSammlung.X_III_StringController_Controller;
import com.example.testframeworkwi2020c.testSammlung.X_I_unfair_Dice_Controller;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.T04_OOP_Ü05_Controller;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.T04_OOP_Ü06_Controller;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.T04_OOP_Ü08_Controller;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.T04_OOP_ü04_Controller;
import com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle.T05_DAK_Ü02_Controller;


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
            case "04_OOP_Ü08":
                return testCar(jarFilePath);
            case "05_Datentypen_Ü02":
                return testMainÜ02(jarFilePath);
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

    // Tests für die Übungsaufgabe OOP_Übung08
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
}