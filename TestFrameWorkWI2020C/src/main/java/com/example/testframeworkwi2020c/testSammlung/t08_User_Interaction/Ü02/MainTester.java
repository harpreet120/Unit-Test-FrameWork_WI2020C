package com.example.testframeworkwi2020c.testSammlung.t08_User_Interaction.Ü02;

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


    public MainTester(String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }

    /***
     * Testet, ob das Programm mitgegebenen Werte im String[] args erfolgreich anhand ihrer Operatoren zusammenrechnet
     * @return TestResult, ob der Test erfolgreich war oder nicht
     * @throws Exception wenn eine Methode nicht funktioniert
     */
    public TestResult<String> testMain() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        CodeRunnerBackend.invokeMethodByName(objectList,className,"main",new Object[]{new String[]{"Add","4","3"}},new Class[]{String[].class});

        if (!outputStreamCaptor.toString().contains("7")) {
            return new TestResult<>(false,outputStreamCaptor.toString().trim());
        }

        System.setOut(standardOut);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        CodeRunnerBackend.invokeMethodByName(objectList,className,"main",new Object[]{new String[]{"Sub","4","3"}},new Class[]{String[].class});
        if (!outputStreamCaptor.toString().contains("1")) {
            return new TestResult<>(false,outputStreamCaptor.toString().trim());
        }

        System.setOut(standardOut);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        CodeRunnerBackend.invokeMethodByName(objectList,className,"main",new Object[]{new String[]{"Mul","4","11"}},new Class[]{String[].class});
        if (!outputStreamCaptor.toString().contains("44")) {
            return new TestResult<>(false,outputStreamCaptor.toString().trim());
        }

        System.setOut(standardOut);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        CodeRunnerBackend.invokeMethodByName(objectList,className,"main",new Object[]{new String[]{"Div","6","2"}},new Class[]{String[].class});
        if (!outputStreamCaptor.toString().contains("3")) {
            return new TestResult<>(false,outputStreamCaptor.toString().trim());
        }

        System.setOut(standardOut);
        return new TestResult<>(true,null);
    }
}
