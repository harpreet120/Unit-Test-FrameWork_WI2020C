package com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle.Ü04;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class CalculatorTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Calculator";

    // Konstruktor
    public CalculatorTester(String jarFilePath) { this.jarFilePath = jarFilePath; }

    // Test der Methode add()
    public TestResult<Integer> testAdd() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"add", new Object[]{3, 5}, new Class[]{int.class, int.class});
        Number number = (Number) result;
        int intValue = number.intValue();
        if (intValue == 8) {
            return new TestResult<>(true, null);
        }
        return new TestResult<>(false, intValue);
    }

    // Test der Methode sub()
    public TestResult<Integer> testSub() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"sub", new Object[]{5, 3}, new Class[]{int.class, int.class});
        Number number = (Number) result;
        int intValue = number.intValue();
        if (intValue == 2) {
            return new TestResult<>(true, null);
        }
        return new TestResult<>(false, intValue);
    }

    // Test der Methode add()
    public TestResult<Integer> testMul() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"mul", new Object[]{3, 5}, new Class[]{int.class, int.class});
        Number number = (Number) result;
        int intValue = number.intValue();
        if (intValue == 15) {
            return new TestResult<>(true, null);
        }
        return new TestResult<>(false, intValue);
    }

    // Test der Methode sub()
    public TestResult<Integer> testDiv() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"div", new Object[]{12, 3}, new Class[]{int.class, int.class});
        Number number = (Number) result;
        int intValue = number.intValue();
        if (intValue == 4) {
            return new TestResult<>(true, null);
        }
        return new TestResult<>(false, intValue);
    }
}
