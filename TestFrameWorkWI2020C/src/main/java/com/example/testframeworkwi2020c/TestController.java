package com.example.testframeworkwi2020c;

import javafx.util.Pair;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;


public class TestController implements ITester{
    @Override
    public String startComparison(String aufgabenname, String filepath) {
        switch (aufgabenname) {
            case "X-I_unfair_dice":
                return testWuerfel(filepath);
        }
        return "";
    }

    public String testWuerfel(String jarFilePath) {
        String textAnUser = "";
        TestWuerfel testWuerfel = new TestWuerfel();
        try {
            textAnUser += testWuerfel.testFairDice(jarFilePath);
            textAnUser += testWuerfel.testUnfairDice(jarFilePath);
//            textAnUser += testWuerfel.testDealer(jarFilePath);
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