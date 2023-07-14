package com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle.Ü09;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class U9_MainTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Main";
    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;

    public U9_MainTester(String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }

    public TestResult<String> testMain() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Methode main aufrufen
        Object result = CodeRunnerBackend.invokeMethodByName(objectList, className, "main", new Object[]{new String[]{}}, new Class[]{String[].class});

        System.setOut(standardOut);

        // Rückgabewert (null) überprüfen
        if (result != null) {
            return new TestResult<>(false, null);
        }

        // Ausgabe des Würfelergebnisses abrufen
        String output = outputStreamCaptor.toString().trim();
        String[] lines = output.split(System.lineSeparator());

        if (lines.length != 2) {
            return new TestResult<>(false, null);
        }

        int number = Integer.parseInt(lines[0]);
        String message = lines[1];

        // Prüfen, ob die Ausgabe und die Aktion basierend auf dem Würfelergebnis korrekt sind
        switch (number) {
            case 1:
            case 2:
            case 3:
                if (!message.equals("lower half")) {
                    return new TestResult<>(false, null);
                }
                break;
            case 4:
            case 5:
            case 6:
                if (!message.equals("higher half")) {
                    return new TestResult<>(false, null);
                }
                break;
            default:
                return new TestResult<>(false, null);
        }

        return new TestResult<>(true, message);
    }


}
