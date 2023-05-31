package com.example.testframeworkwi2020c;

import org.junit.Test;

public class HelloApplicationTest {
    @Test
    public void test(){

        Object result = invokeMethod(instance, methodName, 4,4);

        Assertions.assertEquals(8, result);
    }
}
