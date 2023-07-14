package com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle.Ü12;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ExponentiatorTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Exponentiator";
    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;

    // Konstruktor
    public ExponentiatorTester(String jarFilePath) { this.jarFilePath = jarFilePath; }

    // Test der Methode exponentiate()
    public TestResult<String> testExponentiate() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        CodeRunnerBackend.invokeMethodByName(objectList,className,"exponentiate", new Object[]{6, 0}, new Class[]{int.class, int.class});
        System.setOut(standardOut);

        String sechserPotenz = "1, 6, 36, 216, 1296, 7776, 46656";
        String output = outputStreamCaptor.toString().replaceAll("\r\n", ", ");
        output = output.replaceAll(", $", ""); // Entfernt das letzte Komma, falls vorhanden

        if (output.contains(sechserPotenz)) {
            return new TestResult<>(true, null);
        }
        return new TestResult<>(false, output.trim());
    }
}
