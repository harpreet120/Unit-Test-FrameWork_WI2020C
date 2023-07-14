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

        //Test auf richtigkeit des Strings
        objectList = CodeRunnerBackend.jarTest(jarFilePath,"Dice", new Class[]{int.class},new Object[]{1});
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        CodeRunnerBackend.invokeMethodByName(objectList,className,"roll");
        System.setOut(standardOut);
        if (!outputStreamCaptor.toString().contains("Sie haben 1 Augen gewürfelt")) {
            return new TestResult<>(false,outputStreamCaptor.toString().trim());
        }

        return new TestResult<>(true,null);
    }
}
