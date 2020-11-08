package com.codebuster.ui.test;

import com.codebuster.enums.Category;
import com.codebuster.ui.PuzzleBoard;
import org.junit.Test;

public class PuzzleBoardTest {
    @Test
    public void storeTempLetterTest(){
        PuzzleBoard puzzle = new PuzzleBoard(Category.AROUND_THE_HOUSE,"Test_This");
        String[] letter = puzzle.storeTempLetter('A');
        for(String line : letter){
            System.out.println(line);
        }
        letter = puzzle.storeTempLetter('_');
        for(String line : letter){
            System.out.println(line);
        }
    }
}
