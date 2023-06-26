package com.example.testframeworkwi2020c.testSammlung.t04_OOP.ü04;

import com.example.testframeworkwi2020c.CodeRunnerBackend;
import com.example.testframeworkwi2020c.TestController;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class SmartphoneTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Smartphone";
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    public SmartphoneTester(String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }

    public Boolean testClick() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        System.setOut(new PrintStream(outputStreamCaptor));
        TestController.invokeMethodByName(objectList,className,"dial");
        System.setOut(standardOut);
        if (outputStreamCaptor.toString().contains("Klick")) {
            return true;
        }
        return false;
    }

}
