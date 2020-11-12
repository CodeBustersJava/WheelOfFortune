package com.codebuster.ui;

import com.codebuster.enums.Colors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SplashScreen {
    private int letterHeight = 6;
    private String[] splashBoard;

    public SplashScreen() {
        splashBoard = storeScreen();
    }

    public void printScreen() {
        int count = 10;
        while (count > 0) {
            System.out.print(Colors.randomColor());
            for (String line : splashBoard) {
                System.out.println(line);
            }
            try {
                Thread.sleep(750);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            count--;
        }
        System.out.print(Colors.ANSI_RESET);
    }

    private String[] storeScreen() {
        String[] displayLetter = new String[letterHeight];
        String directory;
        try {
            directory = System.getProperty("user.dir");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new String[0];
        }
        File file = new File(directory + File.separator
                + "Letters" + File.separator + "splashscreen.txt");
        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new String[0];
        }
        for (int i = 0; i < letterHeight; i++) {
            displayLetter[i] = sc.nextLine();
        }
        return displayLetter;
    }
}
