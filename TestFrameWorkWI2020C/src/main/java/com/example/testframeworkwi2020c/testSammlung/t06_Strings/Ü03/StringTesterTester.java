package com.example.testframeworkwi2020c.testSammlung.t06_Strings.Ü03;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class StringTesterTester {

    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "StringTester";
    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;


    public StringTesterTester(String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }

    /***
     * Testet, ob das Programm die überladene Methode countOccurance richtig ausführt, indem sie befüllt und auf das korrekte Ergebnis geprüft werden
     * @return TestResult, ob der Test erfolgreich war oder nicht
     * @throws Exception wenn eine Methode nicht funktioniert
     */
    public TestResult<String> testCountOccurance() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        CodeRunnerBackend.invokeMethodByName(objectList,className,"setString",new Object[]{"Apfel"},new Class[]{String.class});
        //CodeRunnerBackend.setVariableValue(objectList,className,"myString", "Apfel");
        Object counter = CodeRunnerBackend.invokeMethodByName(objectList,className,"countOccurance",new Object[]{'A'},new Class[]{char.class});
        System.setOut(standardOut);
        if (Integer.parseInt(counter.toString()) == 1) {
            return new TestResult<>(true,null);
        }
        return new TestResult<>(false,counter.toString().trim());
    }

    /***
     * Testet, ob das Programm die überladene Methode countOccurance richtig ausführt, indem sie befüllt und auf das korrekte Ergebnis geprüft werden
     * @return TestResult, ob der Test erfolgreich war oder nicht
     * @throws Exception wenn eine Methode nicht funktioniert
     */
    public TestResult<String> testCountOccurance2() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        CodeRunnerBackend.invokeMethodByName(objectList,className,"setString",new Object[]{"Apfel"},new Class[]{String.class});
        //CodeRunnerBackend.setVariableValue(objectList,className,"myString", "Apfel");
        Object counter = CodeRunnerBackend.invokeMethodByName(objectList,className,"countOccurance",new Object[]{"Ap"},new Class[]{String.class});
        System.setOut(standardOut);
        if (Integer.parseInt(counter.toString()) == 1) {
            return new TestResult<>(true,null);
        }
        return new TestResult<>(false,counter.toString().trim());
    }
}
