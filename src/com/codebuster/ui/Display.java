package com.codebuster.ui;

import com.codebuster.enums.Colors;
import com.codebuster.player.Player;
import com.codebuster.wheel.Wheel;

public class Display {
    private static Display instance;
    private Display(){}
    public void showPlayers(Player player1, Player player2, Player player3, Player currentPlayer) {
        if (currentPlayer == player1) {
            System.out.print(Colors.ANSI_YELLOW);
        }
        System.out.print(player1.getName());
        System.out.print(Colors.ANSI_RESET);
        System.out.print("           ");
        if (currentPlayer == player2) {
            System.out.print(Colors.ANSI_YELLOW);
        }
        System.out.print(player2.getName());
        System.out.print(Colors.ANSI_RESET);
        System.out.print("           ");
        if (currentPlayer == player3) {
            System.out.print(Colors.ANSI_YELLOW);
        }
        System.out.print(player3.getName());
        System.out.print(Colors.ANSI_RESET);
        System.out.println();
        System.out.println("-------------------------------------");

    }
    public void showScore(Player player1, Player player2, Player player3){
        System.out.print(Colors.ANSI_CYAN);
        System.out.print("$" + player1.getRoundEarningsMoney());
        System.out.print("           ");
        printSpaces(player1);
        System.out.print("$" + player2.getRoundEarningsMoney());
        System.out.print("           ");
        printSpaces(player2);
        System.out.print("$" + player3.getRoundEarningsMoney());
        System.out.print("           ");
        System.out.print(Colors.ANSI_RESET);
        System.out.println();
    }

    public void showTotalScore(Player player1, Player player2, Player player3){
        System.out.print(Colors.ANSI_PURPLE);
        System.out.print("$" + player1.getTotalPrizeMoney());
        System.out.print("           ");
        printSpaces(player1);
        System.out.print("$" + player2.getTotalPrizeMoney());
        System.out.print("           ");
        printSpaces(player2);
        System.out.print("$" + player3.getTotalPrizeMoney());
        System.out.print("           ");
        System.out.print(Colors.ANSI_RESET);
        System.out.println();
    }

    public void printSpaces(Player player){
        for(int i = 0; i < player.getName().length()-2; i++){
            System.out.print(" ");
        }
    }

    public void showCategory(PuzzleBoard puzzleBoard){
        System.out.print(Colors.ANSI_WHITE_BG);
        System.out.print(Colors.ANSI_BLACK);
        System.out.println("Category: " + puzzleBoard.getCategory());
        System.out.println(Colors.ANSI_RESET);
    }

    public void showWheel(Wheel wheel){
        System.out.print(Colors.ANSI_BLUE);
        System.out.println();
        System.out.print("Wheel value: $");
        if(!wheel.isWheelOnPrize() && !wheel.isWheelOnNegative()) {
            System.out.println(wheel.getMoney());
        }else if(wheel.isWheelOnPrize()){
            System.out.println(wheel.getWheelPrize());
        }else{
            System.out.println(wheel.getNegative());
        }
        System.out.println();
        System.out.print(Colors.ANSI_RESET);
    }

    public void showWheel(Wheel wheel, WheelBoard moneyDisplay){
        String[][] money;
        if(!wheel.isWheelOnPrize() && !wheel.isWheelOnNegative()) {
            moneyDisplay.setMoney(wheel.getMoney());
            money = moneyDisplay.getMoneyBoard();
        }else if(wheel.isWheelOnPrize()){
            money = moneyDisplay.getPrizeBoard();
        }else{
            moneyDisplay.setNegative(wheel.getNegative());
            money = moneyDisplay.getNegative();
        }
        printMoney(money);
        System.out.println();
    }

    private void printMoney(String[][] money) {
        System.out.print(Colors.ANSI_GREEN);
        for (int j = 0; j < money[1].length; j++) {
            System.out.println();
            for (String[] lines : money) {
                if(lines.length > j) {
                    System.out.print(lines[j]);
                }else{
                    System.out.print("     ");
                }
            }
        }
        System.out.print(Colors.ANSI_RESET);
    }

    public void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                ProcessBuilder p = new ProcessBuilder("cls");
                p.inheritIO().start().waitFor();
            } else {
                ProcessBuilder p = new ProcessBuilder("clear");
                p.inheritIO().start().waitFor();
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }
    }

    public void showPuzzle(PuzzleBoard puzzleBoard){
        String[][] puzzleArray = puzzleBoard.getPuzzleBoard();
        for(int j = 0; j < puzzleArray[3].length; j++) {
            System.out.println();
            for (String[] lines : puzzleArray) {
                System.out.print(lines[j]);
            }
        }
        System.out.println();
    }

    public static Display getInstance(){
        return instance != null ? instance : new Display();
    }
}
