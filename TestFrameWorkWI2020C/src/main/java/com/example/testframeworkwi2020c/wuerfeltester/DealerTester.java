package com.example.testframeworkwi2020c.wuerfeltester;

import com.example.testframeworkwi2020c.CodeRunnerBackend;
import com.example.testframeworkwi2020c.TestController;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class DealerTester {
    List<Pair<String, Object>> objectList = new ArrayList<>();
    String jarFilePath;
    String className = "Dealer";
    FakeDice fakeDice = new FakeDice();

    private class FakeDice implements IDice {

        private int number;

        @Override
        public int getNumber() {
            return number;
        }

        @Override
        public void roll() {
        }

        public void roll(int augen) {
            number = augen;
        }
    }

    public DealerTester (String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }

    public Boolean testRollDice() throws Exception {
        Boolean ergebnis;
        fakeDice.roll(1);
        objectList = CodeRunnerBackend.jarTest(jarFilePath);
      //  Object oFakeDice = TestController.invokeMethodByName(objectList,"FakeDice","getClassInstance");

        return ergebnis = listToInt(objectList, className, "getScore", 1) == 1 &&
                listToInt(objectList, className, "getScore", 2) == 2 &&
                listToInt(objectList, className, "getScore", 3) == 6 &&
                listToInt(objectList, className, "getScore", 4) == 8 &&
                listToInt(objectList, className, "getScore", 5) == 15 &&
                listToInt(objectList, className, "getScore", 6) == 36;
    }

    private int listToInt (List<Pair<String, Object>> list, String className, String methodName, int augen) {
        Object object = TestController.invokeMethodByName(list,className,methodName, augen);
        Number number = (Number) object;
        Integer intNum = number.intValue();
        return intNum;
    }

}
