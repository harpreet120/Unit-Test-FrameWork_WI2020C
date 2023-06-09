package com.example.testframeworkwi2020c.testblackjack;

import com.example.testframeworkwi2020c.blackjack.RiskyPlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestRiskyPlayer {
    private RiskyPlayer riskyPlayer;

    @Before
    public void setUp() {
        riskyPlayer = new RiskyPlayer();
    }

    @Test
    public void testGetOffer() {
        int initialBudget = riskyPlayer.getTotalBudget();
        int offer = riskyPlayer.getOffer();

        Assert.assertTrue(offer >= 0);
        Assert.assertTrue(offer <= initialBudget / 4);
        Assert.assertEquals(initialBudget - offer, riskyPlayer.getTotalBudget());
    }

    @Test
    public void testGetChoice() {
        boolean choice;

        // Test for score less than 20
        choice = riskyPlayer.getChoice(15);
        Assert.assertTrue(choice);

        // Test for score greater than or equal to 20
        choice = riskyPlayer.getChoice(22);
        Assert.assertFalse(choice);
    }

    @Test
    public void testInformWinning() {
        int initialBudget = riskyPlayer.getTotalBudget();
        int profit = 100;

        riskyPlayer.informWinning(profit);
        Assert.assertEquals(initialBudget + profit, riskyPlayer.getTotalBudget());
    }
}

