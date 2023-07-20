package com.example.testframeworkwi2020c.testSammlung.x_II_black_jack;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ManuelPlayerTester {

    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "ManualPlayer";
    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;
    private final InputStream standardIn = System.in;
    public ManuelPlayerTester(String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }

    public TestResult<Integer[]> testGetOffer() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath,70);
        String userInput = "16";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        int totalBudget = (int) CodeRunnerBackend.getVariableValue(objectList,className,"totalBudget");
        int result = (int) CodeRunnerBackend.invokeMethodByName(objectList,className,"getOffer");
        System.setIn(standardIn);
        if (result == Integer.parseInt(userInput)) {
            return new TestResult<>(true,null);
        }
        return new TestResult<>(false,new Integer[]{Integer.parseInt(userInput),result});
    }

    public TestResult<Boolean> testGetChoice() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath,70);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        String userInput = "true";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        Boolean result = (Boolean) CodeRunnerBackend.invokeMethodByName(objectList,className,"getChoice",new Object[]{10},new Class[]{int.class});
        System.setOut(standardOut);
        System.setIn(standardIn);
        return new TestResult<>(result,null);
    }

    public TestResult<Integer> testInformWinning() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath,70);
        int totalBudget = (int) CodeRunnerBackend.getVariableValue(objectList,className,"totalBudget");
        CodeRunnerBackend.invokeMethodByName(objectList,className,"informWinning",new Object[]{17},new Class[]{int.class});
        int result = (int) CodeRunnerBackend.getVariableValue(objectList,className,"totalBudget");
        if (result == totalBudget+17) {
            return new TestResult<>(true,null);
        }
        return new TestResult<>(false,result);
    }
}
