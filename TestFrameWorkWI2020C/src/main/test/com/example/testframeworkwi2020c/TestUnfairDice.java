package com.example.testframeworkwi2020c;

import com.example.testframeworkwi2020c.wuefel.UnfairDice;
import static org.junit.Assert.*;
import org.junit.*;

public class TestUnfairDice {

    private UnfairDice unfairDice;

    @Before
    public void initUnfairDice(){
        unfairDice = new UnfairDice();
    }

    @Test
    public void testZahl(){
        unfairDice.roll();
        assertEquals(6,unfairDice.getNumber());
    }
}
