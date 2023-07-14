package com.example.testframeworkwi2020c.testSammlung.t05_Datentypen_Arithmetik_Kontrolle.Ü11;

import com.example.testframeworkwi2020c.CoreSystem.CodeRunnerBackend;
import com.example.testframeworkwi2020c.testSammlung.TestResult;
import javafx.util.Pair;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class MainTester_DAK_U11 {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Main";
    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;
    String solution = "";

    // Konstruktor
    public MainTester_DAK_U11(String jarFilePath) { this.jarFilePath = jarFilePath; }

    // Test der Methode main()
    public TestResult<String> testMain() throws Exception {
        for(int i = 0; i <= 100; i++) {
            solution += i+" => ";
            for(int j = 2; j <= 9; j++) {
                if(i%j == 0) {
                    solution += j+" ";
                }
                if(j == 9){
                    solution += "\n";
                }
            }
        }

        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Object result = CodeRunnerBackend.invokeMethodByName(objectList,className,"main", new Object[]{new String[]{}}, new Class[]{String[].class});
        System.setOut(standardOut);

        //Rückgabewert (null) und prüfen wie oft 'gerade'ausgegeben wird
        String output = outputStreamCaptor.toString().replaceAll("\r", "");
        if (result == null && output.contains(solution)) {
            return new TestResult<>(true, null);
        }
        return new TestResult<>(false, "\n"+output.trim()+"\n");
    }
}
