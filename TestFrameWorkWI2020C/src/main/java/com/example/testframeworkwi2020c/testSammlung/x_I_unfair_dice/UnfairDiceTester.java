package com.example.testframeworkwi2020c.testSammlung.x_I_unfair_dice;

import com.example.testframeworkwi2020c.CodeRunnerBackend;
import com.example.testframeworkwi2020c.TestController;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class UnfairDiceTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "UnfairDice";

    public UnfairDiceTester(String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }

    public boolean testGetNumber() throws Exception { //Test ob getNumber() ein Integer zurück gibt
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        TestController.invokeMethodByName(objectList,className,"roll");
        Object result = TestController.invokeMethodByName(objectList,className,"getNumber");

        if (result instanceof Integer) {
            return true;
        }
        return false;
    }

    public Boolean testZahl() throws Exception { //Test muss eine 6 zurückgeben
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        TestController.invokeMethodByName(objectList,className,"roll");
        Object reslut = TestController.invokeMethodByName(objectList,className,"getNumber");

        Number number = (Number) reslut;
        Integer intnumber = number.intValue();
        if (intnumber == 6) {
            return true;
        }
        return false;
    }
}
