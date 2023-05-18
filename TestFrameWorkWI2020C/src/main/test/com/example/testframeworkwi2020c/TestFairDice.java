package com.example.testframeworkwi2020c;

import com.example.testframeworkwi2020c.wuefel.FairDice;
import static org.junit.Assert.*;
import org.junit.*;


import java.util.ArrayList;

public class TestFairDice {

    private FairDice fairDice;
    private final ArrayList<Integer> validRolls = new ArrayList<>();

    @Before
    public void initFairDice(){
        fairDice = new FairDice();
        validRolls.add(1);
        validRolls.add(2);
        validRolls.add(3);
        validRolls.add(4);
        validRolls.add(5);
        validRolls.add(6);
    }

    @Test
    public void testZahl(){
        fairDice.roll();
        int roll = fairDice.getNumber();
        System.out.println(roll);
        assertTrue(isInRange(roll));
    }

    public Boolean isInRange(int roll){
        return validRolls.contains(roll);
    }
}
