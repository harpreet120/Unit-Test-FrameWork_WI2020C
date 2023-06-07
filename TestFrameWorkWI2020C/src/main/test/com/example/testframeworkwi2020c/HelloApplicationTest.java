package com.example.testframeworkwi2020c;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static com.example.testframeworkwi2020c.DynamicMethodInvocationExample.createInstanceFromZipJavaFile;
import static com.example.testframeworkwi2020c.DynamicMethodInvocationExample.invokeMethod;

public class HelloApplicationTest {
    @Test
    public void test(){

    }

    public Object instance;
    String zipFilePath = "C:\\Users\\alisi\\Documents\\Paul\\Uebungen_Java\\X-II_black_jack\\Loesungen\\blackjack2.zip";
    String javaFilePath = "C:\\Users\\alisi\\Documents\\Paul\\Uebungen_Java\\X-II_black_jack\\Loesungen\\blackjack2.zip\\RiskyPlayer.java";
    String className = "RiskyPlayer";
    String methodName = "getChoice";
    @Test
    public void test1() throws Exception {
        Object instance = createInstanceFromZipJavaFile(zipFilePath, javaFilePath, className);
        Object result = invokeMethod(instance, methodName, 21);
        Assertions.assertEquals(true, result);
    }

}
