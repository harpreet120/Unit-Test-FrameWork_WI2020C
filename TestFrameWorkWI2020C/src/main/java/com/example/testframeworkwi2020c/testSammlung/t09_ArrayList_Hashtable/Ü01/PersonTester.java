package com.example.testframeworkwi2020c.testSammlung.t09_ArrayList_Hashtable.Ü01;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class PersonTester {

    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Person";

    public PersonTester(String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }

    public TestResult<String> testSetName () throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        CodeRunnerBackend.invokeMethodByName(objectList,className,"setName","Loh");
        Object result = CodeRunnerBackend.getVariableValue(objectList,className,"Name");
        String str = (String) result;
        if (str.equals("Loh")) {
            return new TestResult<>(true,null);
        }
        return new TestResult<>(false,(String) result);
    }

    public TestResult<String> testSetVorname () throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        CodeRunnerBackend.invokeMethodByName(objectList,className,"setVorname","Meike");
        Object result = CodeRunnerBackend.getVariableValue(objectList,className,"Vorname");
        String str = (String) result;
        if (str.equals("Meike")) {
            return new TestResult<>(true,null);
        }
        return new TestResult<>(false,(String) result);
    }

    public TestResult<Integer> testSetAlter () throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        CodeRunnerBackend.invokeMethodByName(objectList,className,"setAlter",new Object[]{20},new Class[]{int.class});
        Object result = CodeRunnerBackend.getVariableValue(objectList,className,"Alter");
        if(result instanceof Number) {
            Number num = (Number) result;
            Integer value = num.intValue();
            if (value == 20);
            return new TestResult<>(true,null);
        }
        Number num = (Number) result;
        Integer value = num.intValue();
        return new TestResult<>(false,value);
    }

    public TestResult<String> testToString() throws Exception {
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        CodeRunnerBackend.invokeMethodByName(objectList,className,"setName","Loh");
        CodeRunnerBackend.invokeMethodByName(objectList,className,"setVorname","Meike");
        CodeRunnerBackend.invokeMethodByName(objectList,className,"setAlter",new Object[]{20},new Class[]{int.class});
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"toString");
        String str = (String) result;
        if (str.contains("Meike") && str.contains("Loh") && str.contains("20")) {
            return new TestResult<>(true, null);
        }
        return new TestResult<>(false,str);
    }
}
