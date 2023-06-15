package com.example.testframeworkwi2020c.wuerfeltester;

import com.example.testframeworkwi2020c.CodeRunnerBackend;
import com.example.testframeworkwi2020c.TestController;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class FairDiceTester {


    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "FairDice";

    public FairDiceTester(String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }

    //Test ob getNumber() ein Integer zurückgibt
    public boolean testGetNumber() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        TestController.invokeMethodByName(objectList,className,"roll");
        Object result = TestController.invokeMethodByName(objectList,className,"getNumber");

        if (result instanceof Integer) {
            return true;
        }
        return false;
    }

    public Boolean testRoll() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);

        System.out.println("Rolling the dice 100 times:");
        for (int i = 0; i < 100; i++) {
            TestController.invokeMethodByName(objectList,className,"roll");
            Object result = TestController.invokeMethodByName(objectList,className,"getNumber");
            Number number = (Number) result;
            int intValue = number.intValue();
            if (intValue < 1 || intValue > 6){
                return false;
            }
        }
        return true;
    }
}
