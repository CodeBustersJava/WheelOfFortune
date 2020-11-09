package com.codebuster.game;

<<<<<<< HEAD
import com.codebuster.enums.Category;
import com.codebuster.ui.PuzzleBoard;

public class Game {
    private PuzzleBoard puzzleBoard;
    // puzzle stuff
    // player stuff
    public Game(Category category, String puzzle){
        puzzleBoard = new PuzzleBoard(category, puzzle);
        start();
    }

    public void start(){
        clearConsole();
        showSplashScreen();
        clearConsole();
        showPuzzle();
        showCategory();
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
        System.out.println("Category: " + puzzleBoard.getCategory());
    }

    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                ProcessBuilder p = new ProcessBuilder("cls");
                p.inheritIO().start().waitFor();
            } else {
                ProcessBuilder p = new ProcessBuilder("clear");
                p.inheritIO().start().waitFor();
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }
    }
}
=======
import com.codebuster.player.Player;
import com.codebuster.puzzle.Puzzle;

import java.util.*;
//.....starts Aliona's work.
public class Game {
    Scanner scanner = new Scanner(System.in);
    public static Player currentPlayer;
    public static List<Player> players = new ArrayList<>();
    Player player1 = new Player("Aliona");
    Player player2 = new Player("Debbie");
    Player player3 = new Player("Dustin");
    public static int indexForCurrentPlayer = 0;

    //METHODS
    public void startTheGame() {
        //use randomPhrase() from Puzzle class to generate current puzzle.
        Puzzle puzzle = new Puzzle();
        puzzle.randomPhrase();
        System.out.println(Puzzle.currentPhrase);
        //add all players to the players list and shuffle them to have a random order.
        players.add(player1);
        players.add(player2);
        players.add(player3);
        Collections.shuffle(players);
        //from players list get the first player at indexForCurrentPlayer (default 0), and assign as currentPlayer.
        currentPlayer = players.get(indexForCurrentPlayer);

        //gameplay loop
        while (!Puzzle.solvedPuzzle) {
            System.out.println("Currently playing: " + currentPlayer.name);
            //current player spins the wheel of fortune.
            currentPlayer.playerSpinsWheel();
            System.out.println("Puzzle Category: " + Puzzle.currentCategory);
            System.out.print("Puzzle: ");
            Puzzle.showPuzzle();
            guess();
        }
    }
    //first player is 0 second 1 and third 2.
    public static void getTheNextPlayer() {
        if (indexForCurrentPlayer == 2) {
            indexForCurrentPlayer = 0;
        } else {
            indexForCurrentPlayer++;
        }
        currentPlayer = players.get(indexForCurrentPlayer);
        System.out.println();
    }

    public void guess() {
            System.out.println("Please choose your option:\n Enter [1] to request a free consonant, \n " +
                    "Enter [2] to buy a vowel for $250, \n Enter [3] to solve the puzzle.");
            System.out.print("Enter input: ");
            String input = scanner.nextLine();
            if (input.equals("1")) {
                currentPlayer.requestConsonant();
            } else if (input.equals("2")) {
                currentPlayer.buyVowel();
            } else if (input.equals("3")) {
                System.out.println("Please enter the phrase: ");
                String solveInput = scanner.nextLine().toUpperCase();
                Puzzle.solvePuzzle(solveInput);
            } else {
                System.out.println("Invalid input. Please choose option 1,2, or 3.");
            }
    }
}
//..........ends Aliona's Work.





>>>>>>> AlionaBranch
