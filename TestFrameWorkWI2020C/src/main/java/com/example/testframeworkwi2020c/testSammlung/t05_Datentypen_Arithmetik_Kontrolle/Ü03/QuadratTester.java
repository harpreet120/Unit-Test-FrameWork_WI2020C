package com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle.Ü03;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class QuadratTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Quadrat";
    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;

    /***
     * Konstruktor
     * @param jarFilePath Variablenwert gesetzt
     */
    public QuadratTester(String jarFilePath) { this.jarFilePath = jarFilePath; }

    /***
     * Hilfsmethode für das Setzen der Variable a bei Bedarf
     * @return Wert von a
     */
    public int setA()  {
        Object variableValue = CodeRunnerBackend.getVariableValue(objectList,className,"a");
        if(variableValue == null || (int)variableValue == 0){
            CodeRunnerBackend.invokeMethodByName(objectList, className, "setA",  new Object[]{3}, new Class[]{int.class});;
            return 3;
        }else{
            return (int) variableValue;
        }

    }

    /***
     * Test der Methode getArea()
     * @return Test erfolgreich J/N und ggf. output der Methode getArea()
     * @throws Exception Handling wird an nächsthöhere Ebene weitergereicht
     */
    public TestResult<String> testGetArea() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        int variableValue = setA();
        double areaValue = variableValue*variableValue;
        outputStreamCaptor= new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        CodeRunnerBackend.invokeMethodByName(objectList,className,"getArea");
        System.setOut(standardOut);
        if (Double.parseDouble(outputStreamCaptor.toString()) == areaValue) {
            return new TestResult<>(true, null);
        }
        return new TestResult<>(false, outputStreamCaptor.toString().trim()+" anstelle von "+areaValue);
    }

    /***
     * Test der Methode getCircumference()
     * @return Test erfolgreich J/N und ggf. output der Methode getCircumference()
     * @throws Exception Handling wird an nächsthöhere Ebene weitergereicht
     */
    public TestResult<String> testGetCircumference() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor= new ByteArrayOutputStream();
        int variableValue = setA();
        double circumferenceValue = 4*variableValue;
        System.setOut(new PrintStream(outputStreamCaptor));
        CodeRunnerBackend.invokeMethodByName(objectList,className,"getCircumference");
        System.setOut(standardOut);
        if (Double.parseDouble(outputStreamCaptor.toString()) == circumferenceValue) {
            return new TestResult<>(true, null);
        }
        return new TestResult<>(false, outputStreamCaptor.toString().trim()+" anstelle von "+circumferenceValue);
    }
}
