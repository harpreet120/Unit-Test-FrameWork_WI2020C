package com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü07;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class DVDTester {

    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "DVD";
    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;


    public DVDTester(String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }

    /***
     * Es werden die Methode Play getestet, indem der Print Stream abgeglichen wird
     * @return der Standard Test Result wird ausgegeben
     * @throws Exception die nach oben weitergegeben wird
     */
    public TestResult<String> testPlay() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        CodeRunnerBackend.invokeMethodByName(objectList,className,"play");
        System.setOut(standardOut);
        if (outputStreamCaptor.toString().contains("playing the dvd")) {
            return new TestResult<>(true,null);
        }
        return new TestResult<>(false,outputStreamCaptor.toString().trim());
    }

    /***
     * Es werden die Methode Search getestet, indem der Print Stream abgeglichen wird
     * @return der Standard Test Result wird ausgegeben
     * @throws Exception die nach oben weitergegeben wird
     */
    public TestResult<String> testSearch() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        CodeRunnerBackend.invokeMethodByName(objectList,className,"search");
        System.setOut(standardOut);
        if (outputStreamCaptor.toString().contains("searching...")) {
            return new TestResult<>(true,null);
        }
        return new TestResult<>(false,outputStreamCaptor.toString().trim());
    }
}
