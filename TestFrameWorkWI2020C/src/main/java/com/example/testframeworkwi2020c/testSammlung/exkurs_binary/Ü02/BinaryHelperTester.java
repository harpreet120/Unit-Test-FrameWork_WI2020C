package com.example.testframeworkwi2020c.testSammlung.exkurs_binary.Ü02;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BinaryHelperTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "BinaryHelper";
    private PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;
    private String solution;

    /***
     * Konstruktor
     * @param jarFilePath Variablenwert setzen
     */
    public BinaryHelperTester(String jarFilePath) { this.jarFilePath = jarFilePath; }

    /***
     * Test der Methode and(): Überprüfung, ob der Output aus dem Syso die entsprechende Wahrheitstabelle ist
     * @return Test erfolgreich J/N und ggf. output der Methode and()
     * @throws Exception Handling wird an nächsthöhere Instanz weitergereicht
     */
    public TestResult<String> testAnd() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"and");
        System.setOut(standardOut);

        //Rückgabewert (null) und prüfen ob die Zahl korrekt binär dargestellt wird
        solution =  "A & B = C\n" +
                    "0 & 0 = 0\n" +
                    "0 & 1 = 0\n" +
                    "1 & 0 = 0\n" +
                    "1 & 1 = 1";
        String output = outputStreamCaptor.toString().replaceAll("\r", "");

        if (result == null && output.contains(solution)) {
            return new TestResult<>(true, null);
        }
        return new TestResult<>(false, output);
    }

    /***
     * Test der Methode or(): Überprüfung, ob der Output aus dem Syso die entsprechende Wahrheitstabelle ist
     * @return Test erfolgreich J/N und ggf. output der Methode or()
     * @throws Exception Handling wird an nächsthöhere Instanz weitergereicht
     */
    public TestResult<String> testOr() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"or");
        System.setOut(standardOut);

        //Rückgabewert (null) und prüfen ob die Zahl korrekt binär dargestellt wird
        solution =  "A | B = C\n" +
                    "0 | 0 = 0\n" +
                    "0 | 1 = 1\n" +
                    "1 | 0 = 1\n" +
                    "1 | 1 = 1";
        String output = outputStreamCaptor.toString().replaceAll("\r", "");

        if (result == null && output.contains(solution)) {
            return new TestResult<>(true, null);
        }
        return new TestResult<>(false, output);
    }

    /***
     * Test der Methode xor(): Überprüfung, ob der Output aus dem Syso die entsprechende Wahrheitstabelle ist
     * @return Test erfolgreich J/N und ggf. output der Methode xor()
     * @throws Exception Handling wird an nächsthöhere Instanz weitergereicht
     */
    public TestResult<String> testXor() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"xor");
        System.setOut(standardOut);

        //Rückgabewert (null) und prüfen ob die Zahl korrekt binär dargestellt wird
        solution =  "A ^ B = C\n" +
                    "0 ^ 0 = 0\n" +
                    "0 ^ 1 = 1\n" +
                    "1 ^ 0 = 1\n" +
                    "1 ^ 1 = 0";
        String output = outputStreamCaptor.toString().replaceAll("\r", "");

        if (result == null && output.contains(solution)) {
            return new TestResult<>(true, null);
        }
        return new TestResult<>(false, output);
    }
}
