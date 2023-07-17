package com.example.testframeworkwi2020c.testSammlung.t07_Arrays.Ü02;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class MainTesterArr2 {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Main";
    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;

    /***
     * Konstruktor
     * @param jarFilePath an jarTest weitergeben
     */
    public MainTesterArr2(String jarFilePath) { this.jarFilePath = jarFilePath; }

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

        //Prüfung, ob die 10 Zahlen in aufsteigender Reihenfolge sind
        int number = 0;
        int temp = -10000;
        int counter = 0;
        String output = outputStreamCaptor.toString();
        output = output.replaceAll("\r\n", ", ");
        output = output.replaceAll(", $", "");

        String[] words = output.split(", "); // Aufteilen des Textes
        for (String word : words) {
            number = Integer.parseInt(word);
            if(number < temp || counter > 9){
                return new TestResult<>(false, output.trim());
            }
            temp = number;
            counter++;
        }
        return new TestResult<>(true, null);
    }
}
