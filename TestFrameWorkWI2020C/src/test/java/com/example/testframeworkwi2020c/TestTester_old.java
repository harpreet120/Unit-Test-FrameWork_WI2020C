package com.example.testframeworkwi2020c;

import javafx.util.Pair;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

public class TestTester_old implements ITester {
    @Override
    public boolean startComparison(String aufgabenname, String filepath) {
        return false;
    }

    public static void main(String jarFilePath) {
        CodeRunnerBackend_old codeRunner = new CodeRunnerBackend_old();
 //       String jarFilePath = "C:\\Users\\alisi\\IdeaProjects\\Ich bin Student\\out\\artifacts\\Ich_bin_Student_jar\\Ich bin Student.jar";
        List<Pair<String, Object>> test = null;
        try {
            test = codeRunner.jarTest(jarFilePath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(test.toString());
        invokeMethodByName(test, "FairDice", "roll");
        Object result = invokeMethodByName(test, "FairDice", "getNumber");
        System.out.println(result);
        if(test.isEmpty()){
            System.out.println("Hat nicht funktioniert");
        }
    }

    public static Object invokeMethodByName(List<Pair<String, Object>> classObjects, String className, String methodName) {
        Optional<Object> optionalObject = classObjects.stream()
                .filter(pair -> pair.getKey().equals(className))
                .map(Pair::getValue)
                .findFirst();

        if (optionalObject.isPresent()) {
            Object object = optionalObject.get();
            try {
                Method method = object.getClass().getMethod(methodName);
                return method.invoke(object);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException("Error invoking method " + methodName + " on object of class " + className, e);
            }
        } else {
            System.out.println("Object not found for class name: " + className);
        }
        return null;
    }



}
