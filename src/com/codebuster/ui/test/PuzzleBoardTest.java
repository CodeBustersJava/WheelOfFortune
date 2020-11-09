package com.codebuster.ui.test;

import com.codebuster.enums.Category;
import com.codebuster.ui.PuzzleBoard;
import org.junit.Test;

public class PuzzleBoardTest {
    @Test
    public void createPuzzleBoardTest(){
//        PuzzleBoard puzzle = new PuzzleBoard("Author", "This is my puzzle");
//        String[][] puzzleArray = puzzle.getPuzzleBoard();
//        for(int j = 0; j < puzzleArray[1].length; j++) {
//            System.out.println();
//            for (String[] lines : puzzleArray) {
//                System.out.print(lines[j]);
//            }
//        }
//        PuzzleBoard puzzle2 = new PuzzleBoard("Author", "____ M_ __ __ZZ__");
//        String[][] puzzleArray2 = puzzle2.getPuzzleBoard();
//        for(int j = 0; j < puzzleArray2[3].length; j++) {
//            System.out.println();
//            for (String[] lines : puzzleArray2) {
//                System.out.print(lines[j]);
//            }
//        }
        PuzzleBoard puzzle3 = new PuzzleBoard("Author", "__nnie");
        String[][] puzzleArray3 = puzzle3.getPuzzleBoard();
        for(int j = 0; j < puzzleArray3[3].length; j++) {
            System.out.println();
            for (String[] lines : puzzleArray3) {
                System.out.print(lines[j]);
            }
        }
        puzzle3.updatePuzzle("Bonnie");
        String[][] puzzleArray4 = puzzle3.getPuzzleBoard();
        for(int j = 0; j < puzzleArray4[3].length; j++) {
            System.out.println();
            for (String[] lines : puzzleArray4) {
                System.out.print(lines[j]);
            }
        }
    }

//    @Test
//    public void storeLetterTest(){
//        PuzzleBoard puzzle = new PuzzleBoard(Category.AROUND_THE_HOUSE,"Test_This");
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
