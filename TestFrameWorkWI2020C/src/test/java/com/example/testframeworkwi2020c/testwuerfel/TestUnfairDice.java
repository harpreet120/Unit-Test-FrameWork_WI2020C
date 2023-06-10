package com.example.testframeworkwi2020c.testwuerfel;

import com.example.testframeworkwi2020c.wuerfel.UnfairDice;
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
