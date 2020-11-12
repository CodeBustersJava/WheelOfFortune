package com.codebuster.puzzle;

import com.codebuster.game.Game;
import com.codebuster.player.Player;
import com.codebuster.wheel.Wheel;
import org.junit.Before;
import org.junit.Test;
import com.codebuster.puzzle.StopGameThread;
import static org.junit.Assert.*;

public class PlayerTest {
    Game game;
    Player player1;
    Player player2;
    Player player3;

    @Before
    public void init(){
        game = new Game();
        player1 = new Player("TestPlayer1", game);
        player2 = new Player( "TestPlayer2", game);
        player3 = new Player( "TestPlayer3", game);
        game.start();
    }
    @Test
    public void playerSpinsWheelTest(){
        StopGameThread thread = new StopGameThread();
        thread.run();
        Wheel wheel = Wheel.getInstance();
        Player current = game.getCurrentPlayer();
        current.playerSpinsWheel();
        if(wheel.isWheelOnPrize()){
            assertTrue(current.getPotentialMoney() >= 1000 && current.getPotentialMoney() <= 4000);
            assertTrue(current.getPotentialPrize().equals(wheel.getWheelPrize()));
        }else if(wheel.isWheelOnNegative()){
            assertTrue(game.getCurrentPlayer() != current);
        }else{
            assertTrue(current.getPotentialMoney() == wheel.getMoney());
        }
    }
}
