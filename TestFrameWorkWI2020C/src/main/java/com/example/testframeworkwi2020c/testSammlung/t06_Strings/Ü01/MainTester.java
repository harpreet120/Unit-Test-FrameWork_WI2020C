package com.example.testframeworkwi2020c.testSammlung.t06_Strings.Ü01;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Main";
    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;

    // Konstruktor
    public MainTester(String jarFilePath) { this.jarFilePath = jarFilePath; }

    String[] correctAnswers = {
            "Zahl 1 ist nicht durch 5 teilbar",
            "Zahl 2 ist nicht durch 5 teilbar",
            "Zahl 3 ist nicht durch 5 teilbar",
            "Zahl 4 ist nicht durch 5 teilbar",
            "Zahl 5 ist durch 5 teilbar",
            "Zahl 6 ist nicht durch 5 teilbar",
            "Zahl 7 ist nicht durch 5 teilbar",
            "Zahl 8 ist nicht durch 5 teilbar",
            "Zahl 9 ist nicht durch 5 teilbar",
            "Zahl 10 ist durch 5 teilbar",
            "Zahl 11 ist nicht durch 5 teilbar",
            "Zahl 12 ist nicht durch 5 teilbar",
            "Zahl 13 ist nicht durch 5 teilbar",
            "Zahl 14 ist nicht durch 5 teilbar",
            "Zahl 15 ist durch 5 teilbar",
            "Zahl 16 ist nicht durch 5 teilbar",
            "Zahl 17 ist nicht durch 5 teilbar",
            "Zahl 18 ist nicht durch 5 teilbar",
            "Zahl 19 ist nicht durch 5 teilbar",
            "Zahl 20 ist durch 5 teilbar",
            "Zahl 21 ist nicht durch 5 teilbar",
            "Zahl 22 ist nicht durch 5 teilbar",
            "Zahl 23 ist nicht durch 5 teilbar",
            "Zahl 24 ist nicht durch 5 teilbar",
            "Zahl 25 ist durch 5 teilbar",
            "Zahl 26 ist nicht durch 5 teilbar",
            "Zahl 27 ist nicht durch 5 teilbar",
            "Zahl 28 ist nicht durch 5 teilbar",
            "Zahl 29 ist nicht durch 5 teilbar",
            "Zahl 30 ist durch 5 teilbar",
    };

    /***
     * Testet, ob das Ergebnis des Programms mit den möglichen Korrekten Antworten übereinstimmt, in dem der String zerlegt wird und die Elemente einzeln geprüft werden
     * @return TestResult, ob der Test erfolgreich war oder nicht
     * @throws Exception wenn eine Methode nicht funktioniert
     */
    // Test der Methode main()
    public TestResult<String> testMain() throws Exception {

        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        CodeRunnerBackend.invokeMethodByName(objectList, className, "main", new Object[]{new String[]{}}, new Class[]{String[].class});
        System.setOut(standardOut);
        String[] answers = outputStreamCaptor.toString().split("\n");
        int counter = 0;
        for (String answer: answers) {
            for (int i = 0; i < 30; i++) {
                if (answer.contains(correctAnswers[i])) {
                counter ++;
                }
            }

        }
        if(counter == 10){
            return new TestResult<>(true,outputStreamCaptor.toString());
        }
        return new TestResult<>(false, outputStreamCaptor.toString().trim());

    }

}
