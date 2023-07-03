package com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü05;

import com.example.testframeworkwi2020c.CodeRunnerBackend;
import com.example.testframeworkwi2020c.TestController;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class QuadratTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Quadrat";
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    // Konstruktor
    public QuadratTester(String jarFilePath) { this.jarFilePath = jarFilePath; }

    // Test der Methode getArea()
    public String testGetArea() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        System.setOut(new PrintStream(outputStreamCaptor));
        TestController.invokeMethodByName(objectList,className,"getArea");
        System.setOut(standardOut);
        if (outputStreamCaptor.toString().contains("a hoch 2")) {
            return "true";
        }
        return outputStreamCaptor.toString();
    }

    // Test der Methode getCircumference()
    public String testGetCircumference() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        System.setOut(new PrintStream(outputStreamCaptor));
        TestController.invokeMethodByName(objectList,className,"getCircumference");
        System.setOut(standardOut);
        if (outputStreamCaptor.toString().contains("4a")) {
            return "true";
        }
        return outputStreamCaptor.toString();
    }
}
