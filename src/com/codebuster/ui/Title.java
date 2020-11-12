package com.codebuster.ui;

import com.codebuster.enums.Colors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Title {
    private int letterHeight = 9;
    private String[] titleBoard;

    public Title() {
        titleBoard = storeTitle();
    }

    public void printTitle() {
            for (String line : titleBoard) {
                System.out.println(line);
            }
    }

    private String[] storeTitle() {
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
                + "Letters" + File.separator + "title.txt");
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
