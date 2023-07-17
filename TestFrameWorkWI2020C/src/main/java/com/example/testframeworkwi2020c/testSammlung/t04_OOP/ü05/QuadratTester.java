package com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü05;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
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
    private ByteArrayOutputStream outputStreamCaptor;

    /***
     * Konstruktor
     * @param jarFilePath wird als Variable gesetzt
     */
    public QuadratTester(String jarFilePath) { this.jarFilePath = jarFilePath; }

    /***
     * Test der Methode getArea()
     * @return Erfolgreiche Durchführung J/N + ggf. Output des Studierenden
     * @throws Exception Handling wird an nächsthöhere Ebene weitergegeben
     */
    public TestResult<String> testGetArea() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor= new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        CodeRunnerBackend.invokeMethodByName(objectList,className,"getArea");
        System.setOut(standardOut);
        if (outputStreamCaptor.toString().contains("a hoch 2")) {
            return new TestResult<>(true, null);
        }
        return new TestResult<>(false, outputStreamCaptor.toString().trim());
    }

    /***
     * Test der Methode getCircumference()
     * @return Erfolgreiche Durchführung J/N + ggf. Output des Studierenden
     * @throws Exception Handling wird an nächsthöhere Ebene weitergegeben
     */
    public TestResult<String> testGetCircumference() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor= new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        CodeRunnerBackend.invokeMethodByName(objectList,className,"getCircumference");
        System.setOut(standardOut);
        if (outputStreamCaptor.toString().contains("4a")) {
            return new TestResult<>(true, null);
        }
        return new TestResult<>(false, outputStreamCaptor.toString().trim());
    }
}
