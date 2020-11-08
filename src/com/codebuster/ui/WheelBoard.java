package com.codebuster.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WheelBoard {
    private final int numberHeight = 5;
    private final int letterHeight = 5;
    private int money = 0;
    private String prize;
    private String moneyString = String.valueOf(money);
    private String[][] moneyBoard = new String[moneyString.length() + 1][numberHeight];
    private String[][] prizeBoard = new String[prize.length()][letterHeight];

    WheelBoard(){}

    private void buildMoneyDisplay() {
        moneyBoard[0] = storeNumber('$');
        for (int number = 1; number < moneyString.length(); number++) {
            moneyBoard[number] = storeNumber(moneyString.charAt(number));
        }
    }

    private String[] storeNumber(char number) {
        String[] displayNumber = new String[numberHeight];
        String directory;
        try{
            directory = System.getProperty("user.dir");
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new String[0];
        }
        File file = new File(directory + File.separator
                + "Numbers" + File.separator + number + ".txt");
        Scanner sc;
        try {
            sc = new Scanner(file);
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            return new String[0];
        }
        for(int i = 0; i < numberHeight; i++){
            displayNumber[i] = sc.nextLine();
        }
        return displayNumber;
    }

    private void buildPrizeDisplay() {
        for (int letter = 0; letter < prize.length(); letter++) {
            if (prize.charAt(letter) != ' ') {
                    prizeBoard[letter] = storeLetter(prize.charAt(letter));
            } else {
                for (int row = 0; row < letterHeight; row++) {
                    prizeBoard[letter][row] = "     ";
                }
            }
        }
    }

    private String[] storeLetter(char letter) {
        String[] displayLetter = new String[letterHeight];
        String letterString;
        if(letter == '_'){
            letterString = "BLANK";
        }else{
            letterString = String.valueOf(letter).toUpperCase();
        }
        String directory;
        try{
            directory = System.getProperty("user.dir");
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new String[0];
        }
        File file = new File(directory + File.separator
                + "Letters" + File.separator + letterString + ".txt");
        Scanner sc;
        try {
            sc = new Scanner(file);
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            return new String[0];
        }
        for(int i = 0; i < letterHeight; i++){
            displayLetter[i] = sc.nextLine();
        }
        return displayLetter;
    }

    public String[][] getMoneyBoard() {
        return moneyBoard;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public String[][] getPrizeBoard() {
        return prizeBoard;
    }
}
