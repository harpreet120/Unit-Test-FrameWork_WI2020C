package com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle.Ü02;

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
     * Test der Methode main()
     * @return Test erfolgreich J/N und ggf. output der Methode main()
     * @throws Exception Handling wird an nächsthöhere Instanz weitergereicht
     */
    public TestResult<Integer> testMain() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"main", new Object[]{new String[]{}}, new Class[]{String[].class});
        System.setOut(standardOut);

        //Rückgabewert (null) und prüfen wie oft 'gerade'ausgegeben wird
        int counter = 0;
        String output = outputStreamCaptor.toString();

        String[] words = output.split("\\s+"); // Aufteilen des Texts in Wörter
        for (String word : words) {
            if (word.equals("gerade")) {
                counter++;
            }
        }
        if (result == null && counter == 51) {
            return new TestResult<>(true, counter);
        }
        return new TestResult<>(false, counter);
    }
}
