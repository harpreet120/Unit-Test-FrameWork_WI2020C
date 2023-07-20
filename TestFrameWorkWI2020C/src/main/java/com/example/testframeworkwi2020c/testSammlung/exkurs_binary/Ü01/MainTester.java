package com.example.testframeworkwi2020c.testSammlung.exkurs_binary.Ü01;

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
    private PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;

    /***
     * Konstruktor
     * @param jarFilePath Variablenwert setzen
     */
    public MainTester(String jarFilePath) { this.jarFilePath = jarFilePath; }

    /***
     * Test der Methode main(): Überprüfung, ob der Output aus dem Syso die Binär-Darstellung der entsprechenden Zahl ist
     * @return Test erfolgreich J/N und ggf. output der Methode main()
     * @throws Exception Handling wird an nächsthöhere Instanz weitergereicht
     */
    public TestResult<String> testMain() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"main", new Object[]{new String[]{}}, new Class[]{String[].class});
        System.setOut(standardOut);

        //Rückgabewert (null) und prüfen ob die Zahl korrekt binär dargestellt wird
        String output = outputStreamCaptor.toString().replaceAll("\r\n", "");

        if (result == null && output.contains("011")) {
            return new TestResult<>(true, output);
        }
        return new TestResult<>(false, output);
    }
}
