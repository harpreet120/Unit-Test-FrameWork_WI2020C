package com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü06;


import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class PersonenzugTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Personenzug";
    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;

    // Konstruktor
    public PersonenzugTester(String jarFilePath) { this.jarFilePath = jarFilePath; }

    // Test der Methode essen()
    public TestResult<String> testEssen() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"essen");
        System.setOut(standardOut);

        //Rückgabewert (null) und Benutzerausgabe prüfen
        if (result == null && outputStreamCaptor.toString().contains("Mpf Mpf")) {
            return new TestResult<>(true,outputStreamCaptor.toString());
        }
        return new TestResult<>(false,outputStreamCaptor.toString().trim());
    }

    // Test der Methode essen()
    public TestResult<Integer> testGetWagons() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"getWagons");
        System.setOut(standardOut);

        //Rückgabewert (null) und Benutzerausgabe prüfen
        Number number = (Number) result;
        Integer intnumber = number.intValue();
        if (intnumber == 10) {
            return new TestResult<>(true, intnumber);
        }
        return new TestResult<>(false, intnumber);
    }
}
