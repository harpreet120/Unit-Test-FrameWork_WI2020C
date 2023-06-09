package com.example.testframeworkwi2020c.testwuerfel;

import com.example.testframeworkwi2020c.wuerfel.Dealer;
import com.example.testframeworkwi2020c.wuerfel.IDice;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class TestDealer {

    private static class FakeDice implements IDice {
        int roll;
        @Override
        public int getNumber() {
            return roll;
        }

        @Override
        public void roll() {}

        public void roll(int number){
            roll = number;
        }
    }

    private Dealer dealer;
    private FakeDice fakeDice;

    @BeforeEach
    public void initDealer(){
        fakeDice = new FakeDice();
        dealer = new Dealer();
        dealer.setDice(fakeDice);
    }

    @Test
    public void testRollDice1(){
        fakeDice.roll(1);
        dealer.rollDice();
        assertEquals(1,dealer.getScore());
    }

    @Test
    public void testRollDice2(){
        fakeDice.roll(2);
        dealer.rollDice();
        assertEquals(2,dealer.getScore());
    }

    @Test
    public void testRollDice3(){
        fakeDice.roll(3);
        dealer.rollDice();
        assertEquals(6,dealer.getScore());
    }

    @Test
    public void testRollDice4(){
        fakeDice.roll(4);
        dealer.rollDice();
        assertEquals(8,dealer.getScore());
    }

    @Test
    public void testRollDice5(){
        fakeDice.roll(5);
        dealer.rollDice();
        assertEquals(15,dealer.getScore());
    }

    @Test
    public void testRollDice6(){
        fakeDice.roll(6);
        dealer.rollDice();
        assertEquals(36,dealer.getScore());
    }
}
