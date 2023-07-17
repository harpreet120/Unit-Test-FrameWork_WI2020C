package com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü06;


import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class SpezialZugTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Spezialzug";
    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    /***
     * Konstruktor
     * @param jarFilePath wird als Variablenwert festgelegt
     */
    public SpezialZugTester(String jarFilePath) { this.jarFilePath = jarFilePath; }

    /***
     * Test der Methode sichern()
     * @return Test erfolgreich J/N und ggf. output des Benutzers
     * @throws Exception handling weiterreichen
     */
    public TestResult<String> testSichern() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        System.setOut(new PrintStream(outputStreamCaptor));
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"sichern");
        System.setOut(standardOut);

        //Rückgabewert (null) und Benutzerausgabe prüfen
        if (result == null && outputStreamCaptor.toString().contains("Ich checke...")) {
            return new TestResult<>(true,outputStreamCaptor.toString());
        }
        return new TestResult<>(false,outputStreamCaptor.toString().trim());
    }
}
