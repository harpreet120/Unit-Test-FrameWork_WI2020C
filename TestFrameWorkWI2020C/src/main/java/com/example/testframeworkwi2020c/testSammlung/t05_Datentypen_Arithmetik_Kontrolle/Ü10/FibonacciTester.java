package com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle.Ü10;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class FibonacciTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Fibonacci";
    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;

    // Konstruktor
    public FibonacciTester(String jarFilePath) { this.jarFilePath = jarFilePath; }

    // Test der Methode folge()
    public TestResult<String> testFolge() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        CodeRunnerBackend.invokeMethodByName(objectList,className,"folge", new Object[]{0, 1, 0}, new Class[]{int.class, int.class, int.class});
        System.setOut(standardOut);

        String fibonacci = "1, 1, 2, 3, 5, 8, 13, 21, 34, 55";
        String output = outputStreamCaptor.toString().replaceAll("\r\n", ", ");
        output = output.replaceAll(", $", ""); // Entfernt das letzte Komma, falls vorhanden

        if (output.contains(fibonacci)) {
            return new TestResult<>(true, null);
        }
        return new TestResult<>(false, output.trim());
    }

    // Test der Methode folge2()
    public TestResult<String> testFolge2() throws Exception {
        String fibonacci = "1, 1, 2, 3, 5, 8, 13, 21, 34, 55";
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        CodeRunnerBackend.invokeMethodByName(objectList,className,"folge2");
        System.setOut(standardOut);
        String output = outputStreamCaptor.toString().replaceAll("\r\n", ", ");
        output = output.replaceAll(", $", ""); // Entfernt das letzte Komma, falls vorhanden
        if (output.contains(fibonacci)) {
            return new TestResult<>(true, null);
        }
        return new TestResult<>(false, output.trim());
    }

}
