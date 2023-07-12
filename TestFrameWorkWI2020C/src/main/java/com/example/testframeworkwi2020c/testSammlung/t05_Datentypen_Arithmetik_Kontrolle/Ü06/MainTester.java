package com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle.Ü06;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class MainTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Main";
    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;
    String breakNumbers = "35, 42, 49, 56, 63, 70, 77, 84, 91, 98";

    // Konstruktor
    public MainTester(String jarFilePath) { this.jarFilePath = jarFilePath; }

    // Test der Methode main()
    public TestResult<String> testMain() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"main", new Object[]{new String[]{}}, new Class[]{String[].class});
        System.setOut(standardOut);

        //Rückgabewert (null) und prüfen wie oft 'gerade'ausgegeben wird
        int number = 0;
        String output = outputStreamCaptor.toString();

        String[] words = output.split("\\s+"); // Aufteilen des Texts in Wörter
        for (String word : words) {
            number = Integer.parseInt(word);
            if(number < 30 || number > 100){
                return new TestResult<>(false, outputStreamCaptor.toString().replaceAll("\n", ", ").trim());
            }
        }
        if (result == null && breakNumbers.contains(""+number)) {
            return new TestResult<>(true, null);
        }
        return new TestResult<>(false, outputStreamCaptor.toString().replaceAll("\n", ", ").trim());
    }
}
