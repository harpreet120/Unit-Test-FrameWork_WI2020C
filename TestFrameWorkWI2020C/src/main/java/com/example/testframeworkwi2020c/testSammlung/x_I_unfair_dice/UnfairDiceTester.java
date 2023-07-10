package com.example.testframeworkwi2020c.testSammlung.x_I_unfair_dice;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.CoreSystem.TestController;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
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

    public TestResult<Integer> testGetNumber() throws Exception { //Test ob getNumber() ein Integer zurück gibt
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        CodeRunnerBackend.invokeMethodByName(objectList,className,"roll");
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"getNumber");

        if (result instanceof Integer) {
            return new TestResult<>(true,(Integer) result);
        }
        return new TestResult<>(false,null);
    }

    public TestResult<Integer> testZahl() throws Exception { //Test muss eine 6 zurückgeben
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        TestController.invokeMethodByName(objectList,className,"roll");
        Object result = TestController.invokeMethodByName(objectList,className,"getNumber");
        CodeRunnerBackend.invokeMethodByName(objectList,className,"roll");
        Object reslut = CodeRunnerBackend.invokeMethodByName(objectList,className,"getNumber");

        Number number = (Number) result;
        Integer intnumber = number.intValue();
        if (intnumber == 6) {
            return new TestResult<>(true,intnumber);
        }
        return new TestResult<>(false,intnumber);
    }
}
