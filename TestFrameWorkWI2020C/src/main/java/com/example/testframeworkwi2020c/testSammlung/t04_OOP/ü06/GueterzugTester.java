package com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü06;


import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class GueterzugTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Gueterzug";
    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;

    /***
     * Konstruktor
     * @param jarFilePath Variablenwert festgelegt
     */
    public GueterzugTester(String jarFilePath) { this.jarFilePath = jarFilePath; }

    /***
     * Test der Methode beladen()
     * @return Test erfolgreich J/N und ggf. output der Methode
     * @throws Exception Handling wird weitergereicht
     */
    public TestResult<String> testBeladen() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"beladen");
        System.setOut(standardOut);

        //Rückgabewert (null) und Benutzerausgabe prüfen
        if (result == null && outputStreamCaptor.toString().contains("tue rein...")) {
           return new TestResult<>(true, null);
        }
        return new TestResult<>(false,outputStreamCaptor.toString().trim());
    }

    /***
     * Test der Methode entladen()
     * @return Test erfolgreich J/N und ggf. output der Methode
     * @throws Exception Handling wird weitergereicht
     */
    public TestResult<String> testEntladen() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"entladen");
        System.setOut(standardOut);

        //Rückgabewert (null) und Benutzerausgabe prüfen
        if (result == null && outputStreamCaptor.toString().contains("raus damit...")) {
            return new TestResult<>(true,outputStreamCaptor.toString());
        }
        return new TestResult<>(false,outputStreamCaptor.toString().trim());
    }

}
