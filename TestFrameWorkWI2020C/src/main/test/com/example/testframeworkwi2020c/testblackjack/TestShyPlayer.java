package com.example.testframeworkwi2020c.testblackjack;

import com.example.testframeworkwi2020c.blackjack.ShyPlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestShyPlayer {
    private ShyPlayer shyPlayer;

    @Before
    public void setUp() {
        shyPlayer = new ShyPlayer();
    }

    @Test
    public void testGetOffer() {
        int initialBudget = shyPlayer.getTotalBudget();
        int offer = shyPlayer.getOffer();

        Assert.assertTrue(offer >= 0);
        Assert.assertTrue(offer <= initialBudget / 12);
        Assert.assertEquals(initialBudget - offer, shyPlayer.getTotalBudget());
    }

    @Test
    public void testGetChoice() {
        boolean choice;

        // Test for score greater than 17
        choice = shyPlayer.getChoice(18);
        Assert.assertFalse(choice);

        // Test for score less than or equal to 17
        choice = shyPlayer.getChoice(10);
        Assert.assertTrue(choice);
    }

    @Test
    public void testInformWinning() {
        int initialBudget = shyPlayer.getTotalBudget();
        int profit = 50;

        shyPlayer.informWinning(profit);
        Assert.assertEquals(initialBudget + profit, shyPlayer.getTotalBudget());
    }

}
