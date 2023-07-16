package com.example.testframeworkwi2020c.testSammlung.t08_User_Interaction.Ü01;

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
     * Testet, ob das Programm mitgegebenen Werte im String[] args erfolgreich zu 10 addiert
     * @return TestResult, ob der Test erfolgreich war oder nicht
     * @throws Exception wenn eine Methode nicht funktioniert
     */
    public TestResult<String> testMain() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        CodeRunnerBackend.invokeMethodByName(objectList,className,"main",new Object[]{new String[]{"1","2","3","4"}},new Class[]{String[].class});
        System.setOut(standardOut);
        if (outputStreamCaptor.toString().contains("The sum is: 10")) {
            return new TestResult<>(true,null);
        }
        return new TestResult<>(false,outputStreamCaptor.toString().trim());
    }
}
