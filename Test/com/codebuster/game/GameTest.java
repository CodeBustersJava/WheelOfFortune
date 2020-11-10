package com.codebuster.game;

import com.codebuster.enums.Category;
import com.codebuster.game.Game;
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
