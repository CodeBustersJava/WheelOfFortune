package com.codebuster.player;

import com.codebuster.game.Game;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    private Game game;
    @Test
    public void testPlayerSpinsWheel() {
        Player player = new Player("Aliona", game);
        assertEquals("Aliona", player.getName()); //check valid name
        assertFalse("Diva".equals(player.getName())); //check invalid name
    }
}
