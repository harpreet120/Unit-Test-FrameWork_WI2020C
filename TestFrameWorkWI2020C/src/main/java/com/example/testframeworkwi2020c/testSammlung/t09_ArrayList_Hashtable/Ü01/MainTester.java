package com.example.testframeworkwi2020c.testSammlung.t09_ArrayList_Hashtable.Ü01;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class MainTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Main";
    private ByteArrayOutputStream outputStreamCaptor;
    private final PrintStream standardOut = System.out;

    public MainTester(String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }

    public TestResult<String> testMain() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        CodeRunnerBackend.invokeMethodByName(objectList,className,"main",new Object[]{new String[]{}}, new Class[]{String[].class});
        System.setOut(standardOut);
        if (outputStreamCaptor.toString().contains("Mein Name ist ")) {
            return new TestResult<>(true,null);
        }
        return new TestResult<>(false,outputStreamCaptor.toString().trim());
    }
}
