package com.example.testframeworkwi2020c.testblackjack;

import com.example.testframeworkwi2020c.blackjack.ManualPlayer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class TestManualPlayer {
    private ManualPlayer manualPlayer;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
        String input = "70";
        provideInput(input);
        manualPlayer = new ManualPlayer();
    }

    @After
    public void tearDown() {
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    public void testGetOffer() {
        String input = "25";
        provideInput(input);

        int initialBudget = manualPlayer.getTotalBudget();
        int offer = manualPlayer.getOffer();

        Assert.assertTrue(outputStream.toString().contains("You have " + initialBudget + " - how many do you want to place:"));
        Assert.assertEquals(initialBudget - offer, manualPlayer.getTotalBudget());
    }

    @Test
    public void testGetChoice() {
        String input = "true";
        provideInput(input);

        boolean choice = manualPlayer.getChoice(10);

        Assert.assertTrue(outputStream.toString().contains("Whats your choice (true/false)?"));
        Assert.assertTrue(choice);
    }

    @Test
    public void testInformWinning() {
        int initialBudget = manualPlayer.getTotalBudget();
        int profit = 50;

        manualPlayer.informWinning(profit);

        String expectedOutput = "Your new total Budget is " + (initialBudget + profit);
        Assert.assertTrue(outputStream.toString().contains(expectedOutput));
    }

    private void provideInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}


