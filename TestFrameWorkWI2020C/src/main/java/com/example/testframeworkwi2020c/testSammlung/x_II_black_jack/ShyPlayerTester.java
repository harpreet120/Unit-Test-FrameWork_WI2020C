package com.example.testframeworkwi2020c.testSammlung.x_II_black_jack;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class ShyPlayerTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "ShyPlayer";

    public ShyPlayerTester(String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }

    /**
     * Führt den Test für die Methode getOffer() aus.
     *
     * @return Ein TestResult-Objekt, das den Testergebnisstatus und ggf. die erfasste Ausgabe enthält.
     * @throws Exception Falls eine Ausnahme auftritt, wird sie an die aufrufende Methode weitergeleitet.
     */
    public TestResult<Integer[]> testGetOffer() throws Exception {
        // Testen der Klasse durch Ausführen der übergebenen JAR-Datei
        objectList = CodeRunnerBackend.jarTest(jarFilePath);

        // Ermittle den aktuellen Wert der Variable totalBudget
        int totalBudget = (int) CodeRunnerBackend.getVariableValue(objectList, className, "totalBudget");

        // Berechne einen temporären Wert als totalBudget / 12 und ziehe ihn von totalBudget ab
        int temp = (int) Math.round(totalBudget / 12);
        totalBudget -= temp;

        // Rufe die Methode getOffer der Klasse auf
        int result = (int) CodeRunnerBackend.invokeMethodByName(objectList, className, "getOffer");

        // Überprüfen, ob das Ergebnis mit dem temporären Wert übereinstimmt
        if (result == temp) {
            return new TestResult<>(true, null); // Test erfolgreich
        } else {
            return new TestResult<>(false, new Integer[]{totalBudget, result}); // Test fehlgeschlagen, gib den aktualisierten totalBudget-Wert und das Ergebnis zurück
        }
    }

    /**
     * Führt den Test für die Methode getChoice() aus.
     *
     * @return Ein TestResult-Objekt, das den Testergebnisstatus und ggf. die erfasste Ausgabe enthält.
     * @throws Exception Falls eine Ausnahme auftritt, wird sie an die aufrufende Methode weitergeleitet.
     */
    public TestResult<String> testGetChoice() throws Exception {
        // Testen der Klasse durch Ausführen der übergebenen JAR-Datei
        objectList = CodeRunnerBackend.jarTest(jarFilePath);

        // Rufe die Methode getChoice der Klasse mit einem Argument von 17 auf
        Boolean result = (Boolean) CodeRunnerBackend.invokeMethodByName(objectList, className, "getChoice", new Object[]{17}, new Class[]{int.class});

        return new TestResult<>(result, null); // Testergebnis zurückgeben (True oder False)
    }

    /**
     * Führt den Test für die Methode informWinning() aus.
     *
     * @return Ein TestResult-Objekt, das den Testergebnisstatus und ggf. die erfasste Ausgabe enthält.
     * @throws Exception Falls eine Ausnahme auftritt, wird sie an die aufrufende Methode weitergeleitet.
     */
    public TestResult<Integer> testInformWinning() throws Exception {
        // Testen der Klasse durch Ausführen der übergebenen JAR-Datei
        objectList = CodeRunnerBackend.jarTest(jarFilePath);

        // Ermittle den aktuellen Wert der Variable totalBudget
        int totalBudget = (int) CodeRunnerBackend.getVariableValue(objectList, className, "totalBudget");

        // Rufe die Methode informWinning() mit einem Argument von 17 auf
        CodeRunnerBackend.invokeMethodByName(objectList, className, "informWinning", new Object[]{17}, new Class[]{int.class});

        // Ermittle den neuen Wert der Variable totalBudget nach Aufruf der Methode informWinning()
        int result = (int) CodeRunnerBackend.getVariableValue(objectList, className, "totalBudget");

        // Überprüfen, ob der neue Wert des totalBudgets korrekt berechnet wurde
        if (result == totalBudget + 17) {
            return new TestResult<>(true, null); // Test erfolgreich
        } else {
            return new TestResult<>(false, result); // Test fehlgeschlagen, gib den neuen Wert des totalBudgets zurück
        }
    }


}
