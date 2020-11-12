package com.codebuster.game;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
    Game game;
    @Before
    public void init(){
        game = new Game();
    }

    @Test
    public void gameTest(){
        game.start();
    }

}
