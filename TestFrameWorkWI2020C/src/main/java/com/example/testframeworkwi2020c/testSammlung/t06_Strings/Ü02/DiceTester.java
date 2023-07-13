package com.example.testframeworkwi2020c.testSammlung.t06_Strings.Ü02;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class DiceTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Dice";
    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;



    public DiceTester(String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }

    public TestResult<String> testRoll() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath, new Class <?>[]{int.class},new Object[]{10});
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        CodeRunnerBackend.invokeMethodByName(objectList,className,"roll");
        //System.out.println(CodeRunnerBackend.getVariableValue(objectList,className,"temp"));
        System.setOut(standardOut);
        //if (outputStreamCaptor.toString().contains("playing the blueray")) {
        //    return new TestResult<>(true,null);
        //}
        return new TestResult<>(false,outputStreamCaptor.toString().trim());
    }
}
