package com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle.Ü14;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class GiroKontoTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "GiroKonto";

    /***
     * Konstruktor
     * @param jarFilePath Festlegung der Variable jarFilePath
     */
    public GiroKontoTester(String jarFilePath) { this.jarFilePath = jarFilePath; }

    /***
     * Test der Methode einzahlen()
     * @return TestResult<String>: Rückgabe an User
     * @throws Exception Handling für Methode jarTest
     */
    public TestResult<String> testEinzahlen() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        Object priorValue = CodeRunnerBackend.getVariableValue(objectList,className,"kontostand");
        CodeRunnerBackend.invokeMethodByName(objectList,className,"einzahlen", new Object[]{500}, new Class[]{int.class});
        Object newValue = CodeRunnerBackend.getVariableValue(objectList,className,"kontostand");
        double expectedValue = (double) priorValue + 500;

        if (expectedValue == (double) newValue) {
            return new TestResult<>(true, null);
        }
        return new TestResult<>(false, newValue.toString().trim()+" anstelle von "+expectedValue);
    }

    /***
     * Test der Methode auszahlen()
     * @return TestResult<String>: Rückgabe an User
     * @throws Exception Handling für Methode jarTest
     */
    public TestResult<String> testAuszahlen() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        Object priorValue = CodeRunnerBackend.getVariableValue(objectList,className,"kontostand");
        CodeRunnerBackend.invokeMethodByName(objectList,className,"auszahlen", new Object[]{200}, new Class[]{int.class});
        Object newValue = CodeRunnerBackend.getVariableValue(objectList,className,"kontostand");
        double expectedValue = (double) priorValue - 200;

        if (expectedValue == (double) newValue) {
            return new TestResult<>(true, null);
        }
        return new TestResult<>(false, newValue.toString().trim()+" anstelle von "+expectedValue);
    }

    /***
     * Test der Methode auskunft()
     * @return TestResult<String>: Rückgabe an User
     * @throws Exception Handling für Methode jarTest
     */
    public TestResult<String> testAuskunft() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        Object expectedValue = CodeRunnerBackend.getVariableValue(objectList,className,"kontostand");
        Object valueKonto = CodeRunnerBackend.invokeMethodByName(objectList,className,"auskunft");
        if ((double) expectedValue == (double) valueKonto) {
            return new TestResult<>(true, null);
        }
        return new TestResult<>(false, valueKonto.toString().trim()+" anstelle von "+expectedValue.toString().trim());
    }
}
