package com.example.testframeworkwi2020c.testSammlung.x_II_black_jack;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class RiskyPlayerTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "RiskyPlayer";

    public RiskyPlayerTester(String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }

    public TestResult<Integer[]> testGetOffer() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        int totalBudget = (int) CodeRunnerBackend.getVariableValue(objectList,className,"totalBudget");
        int temp = (int) Math.round(totalBudget / 4);
        totalBudget -= temp;
        int result = (int) CodeRunnerBackend.invokeMethodByName(objectList,className,"getOffer");
        if (result == temp) {
            return new TestResult<>(true,null);
        }
        return new TestResult<>(false,new Integer[]{temp,result});
    }

    public TestResult<String> testGetChoice() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        Boolean result = (Boolean) CodeRunnerBackend.invokeMethodByName(objectList,className,"getChoice",new Object[]{19},new Class[]{int.class});
        return new TestResult<>(result,null);
    }

    public TestResult<Integer> testInformWinning() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        int totalBudget = (int) CodeRunnerBackend.getVariableValue(objectList,className,"totalBudget");
        CodeRunnerBackend.invokeMethodByName(objectList,className,"informWinning",new Object[]{17},new Class[]{int.class});
        int result = (int) CodeRunnerBackend.getVariableValue(objectList,className,"totalBudget");
        if (result == totalBudget+17) {
            return new TestResult<>(true,null);
        }
        return new TestResult<>(false,result);
    }
}
