package com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü06;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.CoreSystem.TestController;
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class ZugTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Zug";


    // Konstruktor
    public ZugTester(String jarFilePath) { this.jarFilePath = jarFilePath; }

    // Test der Methode getWagons()
    public boolean testGetWagons() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"getWagons");
        //Rückgabewert prüfen
        Number number = (Number) result;
        Integer intnumber = number.intValue();
        if (intnumber == 3) {
            return true;
        }
        return false;
    }
}
