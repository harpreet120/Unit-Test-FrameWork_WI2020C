package com.example.testframeworkwi2020c;

import com.example.testframeworkwi2020c.testSammlung.X_III_StringController_Controller;
import com.example.testframeworkwi2020c.testSammlung.X_I_unfair_Dice_Controller;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.T04_OOP_Ü05_Controller;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.T04_OOP_Ü06_Controller;
import com.example.testframeworkwi2020c.testSammlung.t04_OOP.T04_OOP_ü04_Controller;
import javafx.util.Pair;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;


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

    public static Object invokeMethodByName(List<Pair<String, Object>> classObjects, String className, String methodName, Object... methodArgs) {
        Optional<Object> optionalObject = classObjects.stream()
                .filter(pair -> pair.getKey().equals(className))
                .map(Pair::getValue)
                .findFirst();
        if (optionalObject.isPresent()) {
            Object object = optionalObject.get();
            try {
                // Erzeuge ein Array der Parameter-Typen basierend auf den übergebenen Argumenten
                Class<?>[] parameterTypes = new Class<?>[methodArgs.length];
                for (int i = 0; i < methodArgs.length; i++) {
                    parameterTypes[i] = methodArgs[i].getClass();
                }

                // Hole die entsprechende Methode basierend auf dem Methodennamen und den Parameter-Typen
                Method method = object.getClass().getMethod(methodName, parameterTypes);

                // Rufe die Methode auf dem Objekt mit den übergebenen Argumenten auf
                return method.invoke(object, methodArgs);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException("Error invoking method " + methodName + " on object of class " + className, e);
            }
        } else {
            System.out.println("Object not found for class name: " + className);
        }
        return null;
    }

    public static Object getObjectByClassName(List<Pair<String, Object>> objectList, String className) {
        for (Pair<String, Object> pair : objectList) {
            if (pair.getKey().equals(className)) {
                return pair.getValue();
            }
        }
        return null; // Objekt mit dem angegebenen Klassennamen wurde nicht gefunden
    }


}