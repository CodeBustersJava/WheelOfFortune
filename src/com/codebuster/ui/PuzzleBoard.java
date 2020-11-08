package com.codebuster.ui;

import com.codebuster.enums.Category;

import java.util.HashMap;

public class PuzzleBoard {
    private String[][][] puzzleBoard;
    private char[] puzzleBoardModel;
    private String category;
    private String puzzle;
    private final int letterHeight = 5;
    private final int letterWidth = 10;

    PuzzleBoard(Category category, String puzzle){
        setCategory(category);
        setPuzzle(puzzle);
        puzzleBoard = new String[puzzle.length()][letterHeight][letterWidth];
        puzzleBoardModel = new char[puzzle.length()];
    }

    private void buildDisplay(){
        String[][] tempLetter = null;
        for(int letter = 0; letter < puzzle.length(); letter++){
            if(puzzle.charAt(letter) != '_'){
                if(puzzleBoardModel[letter] == '\000'){
                    if(tempLetter == null){
                        tempLetter = storeTempLetter(puzzle.charAt(letter));
                        puzzleBoardModel[letter] = puzzle.charAt(letter);
                    }
                    puzzleBoard[letter] = tempLetter;
                }
            }else if(puzzle.charAt(letter) == ' '){
                for(int row = 0; row < letterHeight; row++){
                    for(int col = 0; col < letterWidth; col++){
                        puzzleBoard[letter][row][col] = " ";
                    }
                }
            }
        }
        // loop through each letter in the array
        // if the letter is not an "_" underscore then look for it in the puzzleBoard
        // if it isn't already in the puzzleBoard
        //  then look for a temp variable
        //  if not load it from a file into a temp variable
        // add temp variable to the corresponding place in the puzzleBoard
    }

    private String[][] storeTempLetter(char letter){
        return new String[letterHeight][letterWidth];
    }

    public void setCategory(Category category) {
        this.category = category.toString();
    }

    public void setPuzzle(String puzzle) {
        this.puzzle = puzzle;
        buildDisplay();
    }

    public String[][][] getPuzzleBoard() {
        return puzzleBoard;
    }
}
