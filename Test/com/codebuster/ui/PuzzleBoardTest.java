package com.codebuster.ui;

import org.junit.Test;

public class PuzzleBoardTest {
    @Test
    public void createPuzzleBoardTest(){
        PuzzleBoard puzzle = new PuzzleBoard("Author", "This is my puzzle");
        String[][] puzzleArray = puzzle.getPuzzleBoard();
        for(int j = 0; j < puzzleArray[1].length; j++) {
            System.out.println();
            for (String[] lines : puzzleArray) {
                System.out.print(lines[j]);
            }
            System.out.println();
        }
        PuzzleBoard puzzle2 = new PuzzleBoard("Author", "____ M_ __ __ZZ__");
        String[][] puzzleArray2 = puzzle2.getPuzzleBoard();
        for(int j = 0; j < puzzleArray2[3].length; j++) {
            System.out.println();
            for (String[] lines : puzzleArray2) {
                System.out.print(lines[j]);
            }
        }
        System.out.println();
        PuzzleBoard puzzle3 = new PuzzleBoard("Author", "_____EE_");
        String[][] puzzleArray3 = puzzle3.getPuzzleBoard();
        for(int j = 0; j < 3; j++) {
            System.out.println();
            for (String[] lines : puzzleArray3) {
                System.out.print(lines[j]);
            }
        }
        System.out.println();
        puzzle3.updatePuzzle("Bonnie");
        String[][] puzzleArray4 = puzzle3.getPuzzleBoard();
        for(int j = 0; j < puzzleArray4[3].length; j++) {
            System.out.println();
            for (String[] lines : puzzleArray4) {
                System.out.print(lines[j]);
            }
        }
        System.out.println();
    }

//    @Test
//    public void storeLetterTest(){
//        PuzzleBoard puzzle = new PuzzleBoard("AROUND_THE_HOUSE","Test_This");
//        String[] letter = puzzle.storeLetter('A');
//        for(String line : letter){
//            System.out.println(line);
//        }
//        letter = puzzle.storeLetter('_');
//        for(String line : letter){
//            System.out.println(line);
//        }
//    }
}
