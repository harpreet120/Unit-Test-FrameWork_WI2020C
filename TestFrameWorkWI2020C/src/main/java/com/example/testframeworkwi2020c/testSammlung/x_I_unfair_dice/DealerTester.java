package com.example.testframeworkwi2020c.testSammlung.x_I_unfair_dice;

import com.example.testframeworkwi2020c.CodeRunnerBackend;
import com.example.testframeworkwi2020c.TestController;
import javafx.util.Pair;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DealerTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Dealer";


    public DealerTester (String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }

    public Boolean testRollDice() throws Exception {
        Boolean ergebnis;
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
        Object fakeDice = TestController.getObjectByClassName(objectList,"FakeDice");
//        IDice testice = new IDice() {
//            @Override
//            public int getNumber() {
//                return ((IDice) fakeDice).getNumber();
//            }
//
//            @Override
//            public void roll() {
//                ((IDice) fakeDice).roll();
//            }
//        };

     //   Class<?> oFakeDice = (Class<?>) TestController.invokeMethodByName(objectList,"FakeDice","getClassInstance");
     //   IDice fakeDice = (IDice) fakeDiceO;
        TestController.invokeMethodByName(objectList,className,"setDice",new Object[]{fakeDice},new Class[]{TestController.castObjectToInterface(fakeDice,"IDice")});

        TestController.invokeMethodByName(objectList,"FakeDice","roll",1);
        if (listToInt(objectList, className, "getScore", 1) == 1) {
            ergebnis = true;
        } else {
            return false;
        }
        TestController.invokeMethodByName(objectList,"FakeDice","roll",2);
        if (listToInt(objectList, className, "getScore", 2) == 2) {
            ergebnis = true;
        } else {
            return false;
        }
        TestController.invokeMethodByName(objectList,"FakeDice","roll",3);
        if (listToInt(objectList, className, "getScore", 3) == 6) {
            ergebnis = true;
        } else {
            return false;
        }
        TestController.invokeMethodByName(objectList,"FakeDice","roll",4);
        if (listToInt(objectList, className, "getScore", 4) == 8) {
            ergebnis = true;
        } else {
            return false;
        }
        TestController.invokeMethodByName(objectList,"FakeDice","roll",5);
        if (listToInt(objectList, className, "getScore", 5) == 15) {
            ergebnis = true;
        } else {
            return false;
        }
        TestController.invokeMethodByName(objectList,"FakeDice","roll",6);
        if (listToInt(objectList, className, "getScore", 6) == 36) {
            ergebnis = true;
        } else {
            return false;
        }
        return ergebnis;
    }

    private int listToInt (List<Pair<String, Object>> list, String className, String methodName, int augen) {
        Object object = TestController.invokeMethodByName(list,className,methodName, augen);
        Number number = (Number) object;
        Integer intNum = number.intValue();
        return intNum;
    }

}
