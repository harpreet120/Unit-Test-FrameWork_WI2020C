package com.example.testframeworkwi2020c;

import com.example.testframeworkwi2020c.testwuerfel.TestUnfairDice;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestMain {
    public static void main(String[] args) {
        //Test einer kompletten Klasse
        Result result = JUnitCore.runClasses(TestUnfairDice.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("Tests erfolgreich: " + result.wasSuccessful());

        //Test einzelner Methoden in einer Klasse
        Request request = Request.method(TestUnfairDice.class,"testZahl");
        Result singleTestResult = new JUnitCore().run(request);
        if (singleTestResult.wasSuccessful()) {
            System.out.println("Einzelner Test erfolgreich");
        } else {
            for (Failure failure : singleTestResult.getFailures()) {
                System.out.println(failure.toString());
            }
        }
    }
}
