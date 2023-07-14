package com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü07;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BlurayTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Bluray";
    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;


    public BlurayTester(String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }

    public TestResult<String> testPlay() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        CodeRunnerBackend.invokeMethodByName(objectList,className,"play");
        System.setOut(standardOut);
        if (outputStreamCaptor.toString().contains("playing the blueray")) {
            return new TestResult<>(true,null);
        }
        return new TestResult<>(false,outputStreamCaptor.toString().trim());
    }

    public TestResult<String> testSearch() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        CodeRunnerBackend.invokeMethodByName(objectList,className,"search");
        System.setOut(standardOut);
        if (outputStreamCaptor.toString().contains("fast searching...")) {
            return new TestResult<>(true,null);
        }
        return new TestResult<>(false,outputStreamCaptor.toString().trim());
    }
}
