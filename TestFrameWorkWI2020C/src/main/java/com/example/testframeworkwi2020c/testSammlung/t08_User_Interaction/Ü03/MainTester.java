package com.example.testframeworkwi2020c.testSammlung.t08_User_Interaction.Ü03;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class MainTester {

    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Main";
    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;
    private final InputStream standardIn = System.in;


    public MainTester(String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }
    /**
     * Führt den Test für die Methode main() aus.
     *
     * @return Ein TestResult-Objekt, das den Testergebnisstatus und ggf. die erfasste Ausgabe enthält.
     * @throws Exception Falls eine Ausnahme auftritt, wird sie an die aufrufende Methode weitergeleitet.
     */
    public TestResult<String> testMain() throws Exception {
        // Testen der Klasse Smartphone durch Ausführen der übergebenen JAR-Datei
        objectList = CodeRunnerBackend.jarTest(jarFilePath);

        // Erstelle einen ByteArrayOutputStream zum Erfassen der System.out-Ausgabe
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        // Redirect System.out zum outputStreamCaptor, um die Ausgabe zu erfassen
        System.setOut(new PrintStream(outputStreamCaptor));

        // Definiere den Benutzereingabe-Testfall für die Methode main()
        String userInput = "a" + "\nhaaaallo";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());

        // Redirect System.in zum inputStream, um den vordefinierten Benutzereingabetestfall zu verwenden
        System.setIn(inputStream);

        // Aufruf der Methode "main" der Klasse Smartphone mit vordefinierter Benutzereingabe
        CodeRunnerBackend.invokeMethodByName(objectList, className, "main", new Object[]{new String[]{}}, new Class[]{String[].class});

        // Setze System.out und System.in zurück auf die ursprünglichen Zustände
        System.setOut(standardOut);
        System.setIn(standardIn);

        // Überprüfen, ob die erwartete Ausgabe "4" in der erfassten Ausgabe vorhanden ist
        if (outputStreamCaptor.toString().contains("4")) {
            return new TestResult<>(true, null); // Test erfolgreich
        } else {
            return new TestResult<>(false, outputStreamCaptor.toString().trim()); // Test fehlgeschlagen
        }
    }

}
