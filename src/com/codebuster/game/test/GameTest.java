package com.codebuster.game.test;

import com.codebuster.enums.Category;
import com.codebuster.game.Game;
import org.junit.Before;
import org.junit.Test;

public class GameTest {
    Game game;
    @Before
    public void init(){
        game = new Game(Category.AROUND_THE_HOUSE, "Lightbulb and Lampshade");
    }

    @Test
    public void gameTest(){
        game.start();
    }

}
