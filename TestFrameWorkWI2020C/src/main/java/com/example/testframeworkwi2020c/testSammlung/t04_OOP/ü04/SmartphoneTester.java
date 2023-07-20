package com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü04;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.CoreSystem.TestController;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class SmartphoneTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Smartphone";
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    public SmartphoneTester(String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }

    /**
     * Führt den Test für die Methode click() der Klasse Smartphone aus.
     *
     * @return Ein TestResult-Objekt, das den Testergebnisstatus und ggf. Fehlerausgaben enthält.
     * @throws Exception Falls eine Ausnahme auftritt, wird sie an die aufrufende Methode weitergeleitet.
     */
    public TestResult<String> testClick() throws Exception {
        // Testen der Klasse Smartphone durch Ausführen der übergebenen JAR-Datei
        objectList = CodeRunnerBackend.jarTest(jarFilePath);

        // Redirect System.out zum outputStreamCaptor, um die Ausgabe zu erfassen
        System.setOut(new PrintStream(outputStreamCaptor));

        // Aufruf der Methode "dial" der Klasse Smartphone
        CodeRunnerBackend.invokeMethodByName(objectList, className, "dial");

        // Setze System.out zurück auf den ursprünglichen Zustand
        System.setOut(standardOut);

        // Überprüfen, ob die erwartete Ausgabe "Klick" in der erfassten Ausgabe vorhanden ist
        if (outputStreamCaptor.toString().contains("Klick")) {
            return new TestResult<>(true, null); // Test erfolgreich
        } else {
            // Test fehlgeschlagen, gib die erfasste Ausgabe als Fehlermeldung zurück
            return new TestResult<>(false, outputStreamCaptor.toString().trim());
        }
    }

}
