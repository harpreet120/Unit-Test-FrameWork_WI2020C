package com.example.testframeworkwi2020c.testSammlung.x_III_StringController;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.CoreSystem.TestController;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
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

    public TestResult<String> testReplaceStringWithIndices() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        CodeRunnerBackend.invokeMethodByName(objectList,className,"setString","Hello World!");
        CodeRunnerBackend.invokeMethodByName(objectList, className, "replaceString", new Object[]{6, 11, "Universe"}, new Class[]{int.class, int.class, String.class});
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"getString");
        if(result instanceof String) {
            String str = (String) result;
            if (str.equals("Hello Universe!"));
            return new TestResult<>(true,null);
        }
        return new TestResult<>(false,(String) result);
    }

    public TestResult<String> testAddString() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        CodeRunnerBackend.invokeMethodByName(objectList,className,"setString","Hello");
        CodeRunnerBackend.invokeMethodByName(objectList,className,"addString"," World!");
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"getString");
        if(result instanceof String) {
            String str = (String) result;
            if (str.equals("Hello World!"));
            return new TestResult<>(true,null);
        }
        return new TestResult<>(false,(String) result);
    }

    public TestResult<String> testReplaceStringWithStartIndex() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        CodeRunnerBackend.invokeMethodByName(objectList,className,"setString","Hello World!");
        CodeRunnerBackend.invokeMethodByName(objectList,className,"replaceString",new Object[]{6,"Universe"},new Class[]{int.class,String.class});
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"getString");
        if(result instanceof String) {
            String str = (String) result;
            if (str.equals("Hello Universe!"));
            return new TestResult<>(true,null);
        }
        return new TestResult<>(false,(String) result);
    }

    public TestResult<String> testGetString() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        CodeRunnerBackend.invokeMethodByName(objectList,className,"setString","Hello");
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"getString");
        if(result instanceof String) {
            String str = (String) result;
            if (str.equals("Hello"));
            return new TestResult<>(true,null);
        }
        return new TestResult<>(false,(String) result);
    }

    public TestResult<String> testSetString() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        CodeRunnerBackend.invokeMethodByName(objectList,className,"setString","Hello");
        CodeRunnerBackend.invokeMethodByName(objectList,className,"setString","Goodbye");
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"getString");
        if(result instanceof String) {
            String str = (String) result;
            if (str.equals("Goodbye"));
            return new TestResult<>(true,null);
        }
        return new TestResult<>(false,(String) result);
    }

    public TestResult<Integer> testGetLength() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        CodeRunnerBackend.invokeMethodByName(objectList,className,"setString","Hello");
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"getLength");
        if(result instanceof Number) {
            Number num = (Number) result;
            Integer value = num.intValue();
            if (value == 5);
            return new TestResult<>(true,null);
        }
        Number num = (Number) result;
        Integer value = num.intValue();
        return new TestResult<>(false,value);
    }

    public TestResult<Integer> testGetCapacity() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        CodeRunnerBackend.invokeMethodByName(objectList,className,"setString","Hello");
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"getCapacity");
        if(result instanceof Number) {
            Number num = (Number) result;
            Integer value = num.intValue();
            if (value == 16);
            return new TestResult<>(true,null);
        }
        Number num = (Number) result;
        Integer value = num.intValue();
        return new TestResult<>(false,value);
    }
}
