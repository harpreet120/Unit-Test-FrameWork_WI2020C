package com.example.testframeworkwi2020c.testSammlung.x_II_black_jack;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ManuelPlayerTester {

    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "ManualPlayer";
    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;
    private final InputStream standardIn = System.in;
    public ManuelPlayerTester(String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }

    /**
     * Führt den Test für die Methode getOffer() aus.
     *
     * @return Ein TestResult-Objekt, das den Testergebnisstatus und ggf. die erfasste Ausgabe enthält.
     * @throws Exception Falls eine Ausnahme auftritt, wird sie an die aufrufende Methode weitergeleitet.
     */
    public TestResult<Integer[]> testGetOffer() throws Exception {
        // Testen der Methode getOffer durch Ausführen der übergebenen JAR-Datei mit einer maximalen Zeit von 70 Millisekunden
        objectList = CodeRunnerBackend.jarTest(jarFilePath, 70);

        // Definiere den Benutzereingabe-Testfall für die Methode getOffer()
        String userInput = "16";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());

        // Redirect System.in zum inputStream, um den vordefinierten Benutzereingabetestfall zu verwenden
        System.setIn(inputStream);

        // Ermittle den aktuellen Wert der Variable totalBudget
        int totalBudget = (int) CodeRunnerBackend.getVariableValue(objectList, className, "totalBudget");

        // Rufe die Methode getOffer auf
        int result = (int) CodeRunnerBackend.invokeMethodByName(objectList, className, "getOffer");

        // Setze System.in zurück auf den ursprünglichen Zustand
        System.setIn(standardIn);

        // Überprüfen, ob das Ergebnis mit der Benutzereingabe übereinstimmt
        if (result == Integer.parseInt(userInput)) {
            return new TestResult<>(true, null); // Test erfolgreich
        } else {
            return new TestResult<>(false, new Integer[]{Integer.parseInt(userInput), result}); // Test fehlgeschlagen, gib die erwartete und die erhaltene Ausgabe zurück
        }
    }

    /**
     * Führt den Test für die Methode getChoice() aus.
     *
     * @return Ein TestResult-Objekt, das den Testergebnisstatus und ggf. die erfasste Ausgabe enthält.
     * @throws Exception Falls eine Ausnahme auftritt, wird sie an die aufrufende Methode weitergeleitet.
     */
    public TestResult<Boolean> testGetChoice() throws Exception {
        // Testen der Methode getChoice durch Ausführen der übergebenen JAR-Datei mit einer maximalen Zeit von 70 Millisekunden
        objectList = CodeRunnerBackend.jarTest(jarFilePath, 70);

        // Erstelle einen ByteArrayOutputStream zum Erfassen der System.out-Ausgabe
        outputStreamCaptor = new ByteArrayOutputStream();

        // Redirect System.out zum outputStreamCaptor, um die Ausgabe zu erfassen
        System.setOut(new PrintStream(outputStreamCaptor));

        // Definiere den Benutzereingabe-Testfall für die Methode getChoice()
        String userInput = "true";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());

        // Redirect System.in zum inputStream, um den vordefinierten Benutzereingabetestfall zu verwenden
        System.setIn(inputStream);

        // Rufe die Methode getChoice() auf und erhalte das Ergebnis
        Boolean result = (Boolean) CodeRunnerBackend.invokeMethodByName(objectList, className, "getChoice", new Object[]{10}, new Class[]{int.class});

        // Setze System.out und System.in zurück auf die ursprünglichen Zustände
        System.setOut(standardOut);
        System.setIn(standardIn);

        return new TestResult<>(result, null); // Testergebnis zurückgeben (True oder False)
    }

    /**
     * Führt den Test für die Methode informWinning() aus.
     *
     * @return Ein TestResult-Objekt, das den Testergebnisstatus und ggf. die erfasste Ausgabe enthält.
     * @throws Exception Falls eine Ausnahme auftritt, wird sie an die aufrufende Methode weitergeleitet.
     */
    public TestResult<Integer> testInformWinning() throws Exception {
        // Testen der Methode informWinning durch Ausführen der übergebenen JAR-Datei mit einer maximalen Zeit von 70 Millisekunden
        objectList = CodeRunnerBackend.jarTest(jarFilePath, 70);

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
