package com.codebuster.ui.test;

import com.codebuster.ui.WheelBoard;
import org.junit.Test;

public class WheelBoardTest {
    @Test
    public void prizeDisplayTest(){
        WheelBoard prizeDisplay = new WheelBoard("Trip to Nevada!,'\"");
        String[][] prize = prizeDisplay.getPrizeBoard();
        printMoney(prize);
    }

    @Test
    public void moneyDisplayTest(){
        WheelBoard moneyDisplay = new WheelBoard("Trip to Nevada");
        String[][] money = moneyDisplay.getMoneyBoard();
        printMoney(money);
        System.out.println();
        moneyDisplay.setMoney(100);
        money = moneyDisplay.getMoneyBoard();
        printMoney(money);

    }

    private void printMoney(String[][] money) {
        for (int j = 0; j < money[1].length; j++) {
            System.out.println();
            for (String[] lines : money) {
                System.out.print(lines[j]);
            }
        }
    }
}
