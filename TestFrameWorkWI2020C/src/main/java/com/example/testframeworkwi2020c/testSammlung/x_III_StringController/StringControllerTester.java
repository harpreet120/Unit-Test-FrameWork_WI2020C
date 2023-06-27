package com.example.testframeworkwi2020c.testSammlung.x_III_StringController;

import com.example.testframeworkwi2020c.CodeRunnerBackend;
import com.example.testframeworkwi2020c.TestController;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class StringControllerTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "StringController";

    public StringControllerTester(String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }

    public Boolean testAddString() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        TestController.invokeMethodByName(objectList,className,"setString","Hello");
        TestController.invokeMethodByName(objectList,className,"addString"," World!");
        Object result = TestController.invokeMethodByName(objectList,className,"getString");
        if(result instanceof String) {
            String str = (String) result;
            if (str.equals("Hello World!"));
            return true;
        }
        return false;
    }

    public Boolean testReplaceStringWithIndices() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        TestController.invokeMethodByName(objectList,className,"setString","Hello World!");
        TestController.invokeMethodByName(objectList,className,"replaceString",6,11, "Universe");
        Object result = TestController.invokeMethodByName(objectList,className,"getString");
        if(result instanceof String) {
            String str = (String) result;
            if (str.equals("Hello Universe!"));
            return true;
        }
        return false;
    }

    public Boolean testReplaceStringWithStartIndex() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        TestController.invokeMethodByName(objectList,className,"setString","Hello World!");
        TestController.invokeMethodByName(objectList,className,"replaceString",6,"Universe");
        Object result = TestController.invokeMethodByName(objectList,className,"getString");
        if(result instanceof String) {
            String str = (String) result;
            if (str.equals("Hello Universe!"));
            return true;
        }
        return false;
    }

    public Boolean testGetString() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        TestController.invokeMethodByName(objectList,className,"setString","Hello");
        Object result = TestController.invokeMethodByName(objectList,className,"getString");
        if(result instanceof String) {
            String str = (String) result;
            if (str.equals("Hello"));
            return true;
        }
        return false;
    }

    public Boolean testSetString() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        TestController.invokeMethodByName(objectList,className,"setString","Hello");
        TestController.invokeMethodByName(objectList,className,"setString","Goodbye");
        Object result = TestController.invokeMethodByName(objectList,className,"getString");
        if(result instanceof String) {
            String str = (String) result;
            if (str.equals("Goodbye"));
            return true;
        }
        return false;
    }

    public Boolean testGetLength() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        TestController.invokeMethodByName(objectList,className,"setString","Hello");
        Object result = TestController.invokeMethodByName(objectList,className,"getLength");
        if(result instanceof Number) {
            Number num = (Number) result;
            Integer value = num.intValue();
            if (value == 5);
            return true;
        }
        return false;
    }

    public Boolean testGetCapacity() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        TestController.invokeMethodByName(objectList,className,"setString","Hello");
        Object result = TestController.invokeMethodByName(objectList,className,"getCapacity");
        if(result instanceof Number) {
            Number num = (Number) result;
            Integer value = num.intValue();
            if (value == 16);
            return true;
        }
        return false;
    }
}
