package com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü04;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.CoreSystem.TestController;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class MobileTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Mobile";
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    public MobileTester(String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }

    public TestResult<String> testDial() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        System.setOut(new PrintStream(outputStreamCaptor));
        CodeRunnerBackend.invokeMethodByName(objectList,className,"dial");
        System.setOut(standardOut);
        if (outputStreamCaptor.toString().contains("Piep")) {
            return new TestResult<>(true,outputStreamCaptor.toString().trim());
        }
        return new TestResult<>(false,null);
    }

    public TestResult<String> testRing() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        System.setOut(new PrintStream(outputStreamCaptor));
        CodeRunnerBackend.invokeMethodByName(objectList,className,"ring");
        System.setOut(standardOut);
        if (outputStreamCaptor.toString().contains("Ding Dong")) {
            return new TestResult<>(true,outputStreamCaptor.toString().trim());
        }
        return new TestResult<>(false,null);
    }
}
