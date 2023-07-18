package com.example.testframeworkwi2020c.testSammlung.t06_Strings.Ü02;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class DiceTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Dice";
    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;



    public DiceTester(String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }

    /***
     * Testet, ob das Programm alle angestrebten Integer bildet und die Korrektheit des Strings
     * @return TestResult, ob der Test erfolgreich war oder nicht
     * @throws Exception wenn eine Methode nicht funktioniert
     */
    public TestResult<String> testRoll() throws Exception {

        //Test auf richtigkeit der Zahlen
        objectList = CodeRunnerBackend.jarTest(jarFilePath,"Dice", new Class[]{int.class},new Object[]{10});
        boolean[] numbers = new boolean[10];
        for (int i = 0; i < 200; i++) {
            outputStreamCaptor = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStreamCaptor));
            CodeRunnerBackend.invokeMethodByName(objectList,className,"roll");
            int temp = Integer.parseInt(outputStreamCaptor.toString().replaceAll("\\D", ""));
            System.setOut(standardOut);
            if (temp < 1 || temp > 10) {
                return new TestResult<>(false,""+temp);
            }
            numbers[temp -1] = true;
        }

        //Test auf Korrektheit des Strings
        objectList = CodeRunnerBackend.jarTest(jarFilePath,"Dice", new Class[]{int.class},new Object[]{1});
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        CodeRunnerBackend.invokeMethodByName(objectList,className,"roll");
        System.setOut(standardOut);
        if (!outputStreamCaptor.toString().contains("Sie haben 1 Augen gewürfelt")) {
            return new TestResult<>(false,outputStreamCaptor.toString().trim());
        }

        // Überprüfe, ob 8 Zahlen von 1 bis 10 mindestens einmal vorgekommen sind
        for (int i = 0; i < numbers.length; i++) {
            if (!numbers[i]) {
                return new TestResult<>(false,""+(i+1));
            }
        }

        return new TestResult<>(true,null);
    }
}
