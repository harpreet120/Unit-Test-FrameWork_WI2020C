package com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle.Ü13;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainTester_Ü13 {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Main";
    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;
    String solution = "";

    /***
     * Konstruktor
     * @param jarFilePath Variablenwert gesetzt
     */
    public MainTester_Ü13(String jarFilePath) { this.jarFilePath = jarFilePath; }

    /***
     * Test der Methode main()
     * @return Test erfolgreich J/N und ggf. output der Methode main()
     * @throws Exception Handling wird an nächsthöhere Ebene weitergereicht
     */
    public TestResult<String> testMain() throws Exception {
        for(int i = 40; i <= 90; i++) {
            if(i%3 == 0) {
                solution += i+" is dividable by 3\n";
            } else {
                solution += i + " is not dividable by 3\n";
            }
        }
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        CodeRunnerBackend.invokeMethodByName(objectList,className,"main", new Object[]{new String[]{}}, new Class[]{String[].class});
        System.setOut(standardOut);

        //Rückgabewert (null) und prüfen wie oft 'gerade'ausgegeben wird
        String output[] = outputStreamCaptor.toString().split("\r\n");
        for(String outputValue: output){
            if (!solution.contains(outputValue)) {
                return new TestResult<>(false, "\n"+outputStreamCaptor.toString().trim()+"\n");
            }
        }
        return new TestResult<>(true, null);
    }
}
