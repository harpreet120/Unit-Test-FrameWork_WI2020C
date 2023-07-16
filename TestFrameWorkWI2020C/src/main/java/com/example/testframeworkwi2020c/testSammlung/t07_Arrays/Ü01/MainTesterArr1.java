package com.example.testframeworkwi2020c.testSammlung.t07_Arrays.Ü01;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class MainTesterArr1 {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Main";
    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;

    /***
     * Konstruktor
     * @param jarFilePath an jarTest weitergeben
     */
    public MainTesterArr1(String jarFilePath) { this.jarFilePath = jarFilePath; }

    /***
     *  Test der Methode main()
     * @return TestResult<String>: Rückgabe an User
     * @throws Exception Handling wird an nächsthöhere Ebene weitergeleitet
     */
    public TestResult<String> testMain() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        CodeRunnerBackend.invokeMethodByName(objectList,className,"main", new Object[]{new String[]{}}, new Class[]{String[].class});
        System.setOut(standardOut);

        //Prüfen wie viele Zahlen und in welchem Bereich diese liegen
        int number = 0;
        int counter = 0;
        String output = outputStreamCaptor.toString();
        output = output.replaceAll("\r\n", ", ");
        output = output.replaceAll(", $", "");

        String[] words = output.split(", "); // Aufteilen des Textes
        for (String word : words) {
            number = Integer.parseInt(word);
            if(number > 10 || number < 0 || counter > 9){
                return new TestResult<>(false, output.trim());
            }
            counter++;
        }
        return new TestResult<>(true, null);
    }
}
