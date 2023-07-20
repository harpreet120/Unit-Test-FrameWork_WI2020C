package com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü04;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.CoreSystem.TestController;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class MobileTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Mobile";
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    public MobileTester(String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }

    /**
     * Führt den Test für die Methode dial() der Klasse Mobile aus.
     *
     * @return Ein TestResult-Objekt, das den Testergebnisstatus und ggf. die erfasste Ausgabe enthält.
     * @throws Exception Falls eine Ausnahme auftritt, wird sie an die aufrufende Methode weitergeleitet.
     */
    public TestResult<String> testDial() throws Exception {
        // Testen der Klasse Smartphone durch Ausführen der übergebenen JAR-Datei
        objectList = CodeRunnerBackend.jarTest(jarFilePath);

        // Redirect System.out zum outputStreamCaptor, um die Ausgabe zu erfassen
        System.setOut(new PrintStream(outputStreamCaptor));

        // Aufruf der Methode "dial" der Klasse Smartphone
        CodeRunnerBackend.invokeMethodByName(objectList, className, "dial");

        // Setze System.out zurück auf den ursprünglichen Zustand
        System.setOut(standardOut);

        // Überprüfen, ob die erwartete Ausgabe "Piep" in der erfassten Ausgabe vorhanden ist
        if (outputStreamCaptor.toString().contains("Piep")) {
            return new TestResult<>(true, outputStreamCaptor.toString().trim()); // Test erfolgreich, gib die erfasste Ausgabe zurück
        } else {
            return new TestResult<>(false, null); // Test fehlgeschlagen
        }
    }

    /**
     * Führt den Test für die Methode ring() der Klasse Smartphone aus.
     *
     * @return Ein TestResult-Objekt, das den Testergebnisstatus und ggf. die erfasste Ausgabe enthält.
     * @throws Exception Falls eine Ausnahme auftritt, wird sie an die aufrufende Methode weitergeleitet.
     */
    public TestResult<String> testRing() throws Exception {
        // Testen der Klasse Smartphone durch Ausführen der übergebenen JAR-Datei
        objectList = CodeRunnerBackend.jarTest(jarFilePath);

        // Redirect System.out zum outputStreamCaptor, um die Ausgabe zu erfassen
        System.setOut(new PrintStream(outputStreamCaptor));

        // Aufruf der Methode "ring" der Klasse Smartphone
        CodeRunnerBackend.invokeMethodByName(objectList, className, "ring");

        // Setze System.out zurück auf den ursprünglichen Zustand
        System.setOut(standardOut);

        // Überprüfen, ob die erwartete Ausgabe "Ding Dong" in der erfassten Ausgabe vorhanden ist
        if (outputStreamCaptor.toString().contains("Ding Dong")) {
            return new TestResult<>(true, outputStreamCaptor.toString().trim()); // Test erfolgreich, gib die erfasste Ausgabe zurück
        } else {
            return new TestResult<>(false, null); // Test fehlgeschlagen
        }
    }
}
