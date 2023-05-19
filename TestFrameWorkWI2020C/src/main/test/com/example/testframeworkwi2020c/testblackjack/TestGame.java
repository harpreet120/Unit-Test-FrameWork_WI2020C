package com.example.testframeworkwi2020c.testblackjack;

import com.example.testframeworkwi2020c.blackjack.Game;
import com.example.testframeworkwi2020c.blackjack.IPlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TestGame {
    private Game game;
    private IPlayer player;

    @Before
    public void setUp() {
        player = Mockito.mock(IPlayer.class);
        game = new Game(player);
    }

    @Test
    public void testPlay_PlayerWins() {
        // Mocking player.getChoice() to return true
        Mockito.when(player.getChoice(Mockito.anyInt())).thenReturn(true);

        int result = game.play();

        // Verify that player.getChoice() was called
        Mockito.verify(player, Mockito.atLeastOnce()).getChoice(Mockito.anyInt());

        // Verify that player won
        Assert.assertEquals(1, result);
    }

    @Test
    public void testPlay_BankWins() {
        // Mocking player.getChoice() to return false after the first invocation
        Mockito.when(player.getChoice(Mockito.anyInt()))
                .thenReturn(true)
                .thenReturn(false);

        int result = game.play();

        // Verify that player.getChoice() was called at least twice
        Mockito.verify(player, Mockito.atLeast(2)).getChoice(Mockito.anyInt());

        // Verify that bank won
        Assert.assertEquals(0, result);
    }
}


