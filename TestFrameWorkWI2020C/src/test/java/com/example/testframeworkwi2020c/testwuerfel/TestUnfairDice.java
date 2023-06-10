package com.example.testframeworkwi2020c.testwuerfel;

import com.example.testframeworkwi2020c.CodeRunnerBackend_old;
import com.example.testframeworkwi2020c.wuerfel.UnfairDice;

import static com.example.testframeworkwi2020c.TestController.invokeMethodByName;
//import static org.junit.jupiter.

import org.junit.jupiter.api.*;

import javafx.util.Pair;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class TestUnfairDice {

    private UnfairDice unfairDice;
    private CodeRunnerBackend_old codeRunner = new CodeRunnerBackend_old();
    private List<Pair<String, Object>> objectList;
    String jarFilePath;

//    public TestUnfairDice (String jarFilePath){
//        this.jarFilePath = jarFilePath;
//    }


    @BeforeAll
    public void initUnfairDice(){
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(System.getProperty("java.io.tmpdir") + File.separator + "config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(jarFilePath);
        try {
            objectList = codeRunner.jarTest(jarFilePath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testZahl(){
        invokeMethodByName(objectList, "UnfairDice", "roll");
        Assertions.assertEquals(6,invokeMethodByName(objectList, "UnfairDice", "getNumber"));
    }
}
