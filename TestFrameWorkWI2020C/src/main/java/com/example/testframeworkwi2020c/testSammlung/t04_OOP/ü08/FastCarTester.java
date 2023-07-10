package com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü08;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class FastCarTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "FastCar";
    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;

    // Konstruktor
    public FastCarTester(String jarFilePath) { this.jarFilePath = jarFilePath; }

    // Test der Methode open() von der abstrakten Elternklasse
    public TestResult<String> testOpen() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"open");
        System.setOut(standardOut);

        //Rückgabewert (null) und Benutzerausgabe prüfen
        if (result == null && outputStreamCaptor.toString().contains("it is opened")) {
            return new TestResult<>(true, null);
        }
        return new TestResult<>(false,outputStreamCaptor.toString().trim());
    }

    // Test der Methode drive()
    public TestResult<String> testDrive() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"drive");
        System.setOut(standardOut);

        //Rückgabewert (null) und Benutzerausgabe prüfen
        if (result == null && outputStreamCaptor.toString().contains("wrooooooom")) {
            return new TestResult<>(true, null);
        }
        return new TestResult<>(false,outputStreamCaptor.toString().trim());
    }
}
