package com.example.testframeworkwi2020c.testSammlung.x_I_unfair_dice;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.CoreSystem.TestController;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class FairDiceTester {


    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "FairDice";

    public FairDiceTester(String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }

    //Test ob getNumber() ein Integer zurückgibt
    public TestResult<Integer> testGetNumber() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        CodeRunnerBackend.invokeMethodByName(objectList,className,"roll");
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"getNumber");

        if (result instanceof Integer) {
            return new TestResult<>(true, (Integer) result);
        }

        return new TestResult<>(false, null);
    }

    public TestResult<Integer> testRoll() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);

        //System.out.println(objectList);

        //System.out.println("Rolling the dice 100 times:");
        boolean[] numbers = new boolean[6]; // Array zum Speichern der vorkommenden Zahlen
        for (int i = 0; i < 100; i++) {
            CodeRunnerBackend.invokeMethodByName(objectList, className, "roll");
            Object result = CodeRunnerBackend.invokeMethodByName(objectList, className, "getNumber");
            Number number = (Number) result;
            int intValue = number.intValue();
            if (intValue < 1 || intValue > 6) {
                return new TestResult<>(false,intValue);
            }
            numbers[intValue - 1] = true; // Markiere die vorgekommene Zahl im Array
        }

        // Überprüfe, ob alle Zahlen von 1 bis 6 mindestens einmal vorgekommen sind
        for (int i = 0; i < numbers.length; i++) {
            if (!numbers[i]) {
                return new TestResult<>(false,i+1);
            }
        }

        return new TestResult<>(true,null);
    }
}
