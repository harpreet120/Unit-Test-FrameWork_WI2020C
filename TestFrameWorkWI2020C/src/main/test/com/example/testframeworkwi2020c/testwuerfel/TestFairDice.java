package com.example.testframeworkwi2020c.testwuerfel;

import com.example.testframeworkwi2020c.wuerfel.FairDice;
import static org.junit.Assert.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;


import java.util.ArrayList;

public class TestFairDice {

    private FairDice fairDice;
    private final ArrayList<Integer> validRolls = new ArrayList<>();

    @BeforeEach
    public void initFairDice(){
        fairDice = new FairDice();
        validRolls.add(1);
        validRolls.add(2);
        validRolls.add(3);
        validRolls.add(4);
        validRolls.add(5);
        validRolls.add(6);
    }

    @AfterEach
    public void tearDown() {
        fairDice = null; // Setze fairDice auf null, um die Referenz freizugeben
    }

    @RepeatedTest(100)
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
