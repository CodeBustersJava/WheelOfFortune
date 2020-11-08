package com.codebuster.game;

import com.codebuster.enums.Category;
import com.codebuster.ui.PuzzleBoard;

public class Game {
    private PuzzleBoard puzzleBoard;
    // puzzle stuff
    // player stuff
    Game(PuzzleBoard puzzleBoard){

    }

    public void showSplashScreen(){}

    public void showPuzzle(){
        String[][] puzzleArray = puzzleBoard.getPuzzleBoard();
        for(int j = 0; j < puzzleArray[3].length; j++) {
            System.out.println();
            for (String[] lines : puzzleArray) {
                System.out.print(lines[j]);
            }
        }
    }

    public void showCategory(){
        System.out.println();
        System.out.println(puzzleBoard.getCategory());
    }

    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                ProcessBuilder p = new ProcessBuilder("cls");
                p.inheritIO().start();
            } else {
                ProcessBuilder p = new ProcessBuilder("clear");
                p.inheritIO().start();
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }
    }
}
