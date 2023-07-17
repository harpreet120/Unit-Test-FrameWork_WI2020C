package com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü06;


import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class ZugTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Zug";

    /***
     * Konstruktor
     * @param jarFilePath Variablenwert wird gesetzt
     */
    public ZugTester(String jarFilePath) { this.jarFilePath = jarFilePath; }

    /***
     * Test der Methode getWagons()
     * @return Testergebnis erfolgreich J/N und ggf. output der Methode
     * @throws Exception handling wird weitergegeben
     */
    public TestResult<Integer> testGetWagons() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"getWagons");
        //Rückgabewert prüfen
        Number number = (Number) result;
        Integer intnumber = number.intValue();
        if (intnumber == 3) {
            return new TestResult<>(true,intnumber);
        }
        return new TestResult<>(false,intnumber);
    }
}
