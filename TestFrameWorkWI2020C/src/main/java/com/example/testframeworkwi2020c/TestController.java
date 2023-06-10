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
//        String tempDir = System.getProperty("java.io.tmpdir");
//        String configFilePath = tempDir + File.separator + "config.properties";
//
//        try (FileWriter writer = new FileWriter(configFilePath)) {
//            writer.write("jarFilePath=" + filepath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        System.out.println("Config file created: " + configFilePath);
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
        } catch (Exception e) {
            e.printStackTrace();
        }


//        CodeRunnerBackend_old codeRunner = new CodeRunnerBackend_old();
////        String jarFilePath = "C:\\Users\\alisi\\IdeaProjects\\Ich bin Student\\out\\artifacts\\Ich_bin_Student_jar\\Ich bin Student.jar";
//        List<Pair<String, Object>> test = null;
//        try {
//            test = codeRunner.jarTest(jarFilePath);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(test.toString());
//        invokeMethodByName(test, "FairDice", "roll");
//        Object result = invokeMethodByName(test, "FairDice", "getNumber");
//        System.out.println(result);
//        if(test.isEmpty()){
//            System.out.println("Hat nicht funktioniert");
//        } else {
//            TestWuerfel testMain = new TestWuerfel();
//            textAnUser += testMain.testUnfairDice();
//            textAnUser += testMain.testFairDice();
//            textAnUser += testMain.testDealer();
 //       }
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


//    public static void main(String[] args) {
//        TestWuerfel testMain = new TestWuerfel();
//        System.out.println(testMain.testDealer());
//        System.out.println(testMain.testUnfairDice());
//    }
}