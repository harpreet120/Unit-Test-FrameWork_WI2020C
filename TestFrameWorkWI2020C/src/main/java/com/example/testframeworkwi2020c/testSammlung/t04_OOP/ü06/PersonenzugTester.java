package com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü06;

import com.example.testframeworkwi2020c.CodeRunnerBackend;
import com.example.testframeworkwi2020c.TestController;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class PersonenzugTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Personenzug";
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    // Konstruktor
    public PersonenzugTester(String jarFilePath) { this.jarFilePath = jarFilePath; }

    // Test der Methode essen()
    public boolean testEssen() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        System.setOut(new PrintStream(outputStreamCaptor));
        Object result = TestController.invokeMethodByName(objectList,className,"essen");
        System.setOut(standardOut);

        //Rückgabewert (null) und Benutzerausgabe prüfen
        if (result == null && outputStreamCaptor.toString().contains("Mpf Mpf")) {
            return true;
        }
        return false;
    }

    // Test der Methode essen()
    public boolean testGetWagons() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        System.setOut(new PrintStream(outputStreamCaptor));
        Object result = TestController.invokeMethodByName(objectList,className,"getWagons");
        System.setOut(standardOut);

        //Rückgabewert (null) und Benutzerausgabe prüfen
        Number number = (Number) result;
        Integer intnumber = number.intValue();
        if (intnumber == 10) {
            return true;
        }
        return false;
    }
}
