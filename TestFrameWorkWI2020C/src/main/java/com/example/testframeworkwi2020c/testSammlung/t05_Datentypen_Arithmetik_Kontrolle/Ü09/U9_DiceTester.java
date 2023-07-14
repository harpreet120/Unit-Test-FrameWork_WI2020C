package com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle.Ü09;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import com.example.testframeworkwi2020c.testSammlung.t06_Strings.Ü02.DiceTester;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class U9_DiceTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Dice";

    public U9_DiceTester(String jarFilePath){
        this.jarFilePath = jarFilePath;
    }

    public TestResult<Integer> testGetNumber() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        CodeRunnerBackend.setVariableValue(objectList,className,"eyes", 23);
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"getNumber");
        Number number = (Number) result;
        Integer intnumber = number.intValue();
        if (intnumber == 23) {
            return new TestResult<>(true,null);
        }
        return new TestResult<>(false,intnumber);
    }

    public TestResult<Integer> testRoll() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);

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
