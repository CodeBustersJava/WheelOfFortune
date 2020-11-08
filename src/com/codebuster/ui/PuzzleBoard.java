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

    public PuzzleBoard(Category category, String puzzle) {
        puzzleBoard = new String[puzzle.length()][letterHeight];
        puzzleBoardModel = new boolean[puzzle.length()];
        setCategory(category);
        setPuzzle(puzzle);
    }

    private void buildDisplay() {
        for (int letter = 0; letter < puzzle.length(); letter++) {
            if (puzzle.charAt(letter) != ' ') {
                if (puzzleBoardModel[letter] == false) {
                        puzzleBoard[letter] = storeLetter(puzzle.charAt(letter));
                        puzzleBoardModel[letter] = true;
                }
            } else {
                for (int row = 0; row < letterHeight; row++) {
                        puzzleBoard[letter][row] = "     ";
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

    public void setCategory(Category category) {
        this.category = category.toString();
    }

    public String getCategory() {
        return category;
    }

    public void setPuzzle(String puzzle) {
        this.puzzle = puzzle;
        buildDisplay();
    }

    public String[][] getPuzzleBoard() {
        return puzzleBoard;
    }
}
