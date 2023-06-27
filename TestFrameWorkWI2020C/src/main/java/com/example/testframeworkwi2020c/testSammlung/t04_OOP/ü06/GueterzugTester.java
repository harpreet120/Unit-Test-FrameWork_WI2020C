package com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü06;

import com.example.testframeworkwi2020c.CodeRunnerBackend;
import com.example.testframeworkwi2020c.TestController;
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
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    // Konstruktor
    public GueterzugTester(String jarFilePath) { this.jarFilePath = jarFilePath; }

    // Test der Methode beladen()
    public boolean testBeladen() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        System.setOut(new PrintStream(outputStreamCaptor));
        Object result = TestController.invokeMethodByName(objectList,className,"beladen");
        System.setOut(standardOut);

        //Rückgabewert (null) und Benutzerausgabe prüfen
        if (result == null && outputStreamCaptor.toString().contains("tue rein...")) {
            return true;
        }
        return false;
    }

    //Test der Methode entladen()
    public boolean testEntladen() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        System.setOut(new PrintStream(outputStreamCaptor));
        Object result = TestController.invokeMethodByName(objectList,className,"entladen");
        System.setOut(standardOut);

        //Rückgabewert (null) und Benutzerausgabe prüfen
        if (result == null && outputStreamCaptor.toString().contains("raus damit...")) {
            return true;
        }
        return false;
    }

}
