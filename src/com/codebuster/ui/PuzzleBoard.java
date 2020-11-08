package com.codebuster.ui;

import com.codebuster.enums.Category;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PuzzleBoard {
    private String[][] puzzleBoard;
    private boolean[] puzzleBoardModel;
    private String category;
    private String puzzle;
    private final int letterHeight = 5;
    private final int letterWidth = 10;

    public PuzzleBoard(Category category, String puzzle) {
        puzzleBoard = new String[puzzle.length()][letterHeight];
        puzzleBoardModel = new boolean[puzzle.length()];
        setCategory(category);
        setPuzzle(puzzle);
    }

    private void buildDisplay() {
        String[] tempLetter = null;
        for (int letter = 0; letter < puzzle.length(); letter++) {
            if (puzzle.charAt(letter) != ' ') {
                if (puzzleBoardModel[letter] == false) {
                    if (tempLetter == null) {
                        tempLetter = storeTempLetter(puzzle.charAt(letter));
                        puzzleBoardModel[letter] = true;
                    }
                    puzzleBoard[letter] = tempLetter;
                }
            } else {
                for (int row = 0; row < letterHeight; row++) {
                        puzzleBoard[letter][row] = "       ";
                }
            }
        }
    }

    public String[] storeTempLetter(char letter) {
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

    public void setCategory(Category category) {
        this.category = category.toString();
    }

    public void setPuzzle(String puzzle) {
        this.puzzle = puzzle;
        buildDisplay();
    }

    public String[][] getPuzzleBoard() {
        return puzzleBoard;
    }
}
