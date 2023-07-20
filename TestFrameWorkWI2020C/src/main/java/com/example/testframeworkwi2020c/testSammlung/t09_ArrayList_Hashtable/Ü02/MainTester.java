package com.example.testframeworkwi2020c.testSammlung.t09_ArrayList_Hashtable.Ü02;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class MainTester {

    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Main";
    private final PrintStream standardOut = System.out;
    private final InputStream standardIn = System.in;
    private ByteArrayOutputStream outputStreamCaptor;

    public MainTester(String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }

    public TestResult<String> testMain() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        String userInput = "1\n2\n3\n4\n5\n6\n-1";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        CodeRunnerBackend.invokeMethodByName(objectList,className,"main",new Object[]{new String[]{}}, new Class[]{String[].class});
        System.setOut(standardOut);
        System.setIn(standardIn);
        if (outputStreamCaptor.toString().contains("6\r\n5\r\n4\r\n3\r\n2\r\n1")) {
            return new TestResult<>(true,null);
        }
        return new TestResult<>(false,outputStreamCaptor.toString().trim());
    }
}
