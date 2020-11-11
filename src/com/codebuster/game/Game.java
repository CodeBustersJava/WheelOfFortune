package com.codebuster.game;

import com.codebuster.player.Player;
import com.codebuster.puzzle.Puzzle;
import java.util.*;

//Aliona's work starts...
public class Game {
    private static Scanner scanner = new Scanner(System.in);
    public static Player currentPlayer;
    public static List<Player> players = new ArrayList<>();
    public static Player player1 = new Player("Aliona");
    public static Player player2 = new Player("Debbie");
    public static Player player3 = new Player("Dustin");
    public static int indexForCurrentPlayer = 0;

    //METHODS
    public static void startTheGame() {
        Puzzle puzzle = new Puzzle();
        //use randomPhrase() from Puzzle class to generate current puzzle.
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
            System.out.println("Currently playing: " + currentPlayer.getName());
            System.out.println("Round Money Earned: $" + currentPlayer.getTotalPrizeMoney());
            System.out.println("Prizes Earned: ");
            currentPlayer.getRoundEarningsPrize();
            //current player spins the wheel of fortune.
            currentPlayer.playerSpinsWheel();
            System.out.println("Puzzle Category: " + Puzzle.currentCategory);
            System.out.println("Wrong letter collection: " + Puzzle.guessedWrongLetters);
            System.out.print("Puzzle: ");
            Puzzle.showPuzzle();
            guess();
        }
        playAgain();
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

    public static void guess() {
        System.out.println("Please choose your option:\n " +
                "Enter [1] to request a free consonant, \n " +
                "Enter [2] to buy a vowel for $250, \n " +
                "Enter [3] to solve the puzzle.");
        System.out.print("Enter option input: ");
        String input = scanner.nextLine();
        if (input.equals("1")) {
            currentPlayer.requestConsonant();
        } else if (input.equals("2")) {
            currentPlayer.buyVowel();
        } else if (input.equals("3")) {
            System.out.print("Please enter the phrase: ");
            String solveInput = scanner.nextLine().toUpperCase();
            Puzzle.solvePuzzle(solveInput);
        } else {
            System.out.println("Invalid input. Please choose option 1,2, or 3.");
        }
    }

    //repeat game as many times as the user chooses through promp input.
    public static void playAgain() {
        System.out.println("Would you like to play another round? Enter [1] for yes or [2] for no to quit: ");
        String playAnotherRound = scanner.nextLine();
        //clear puzzle and guessed wrong letters.
        if (playAnotherRound.equals("1")) {
            Puzzle.guessedWrongLetters.clear();
            Puzzle.guessedRightLetters.clear();
            //clear players list and start the game loop.
            Puzzle.solvedPuzzle = false;
            players.clear();
            startTheGame();
        } //show the winner and players' total money earned before quitting the game.
        else {
            //iterate through players and compare their money.
            //assign player as the winner who has the most money.
            System.out.println("The winner is...");
            Player winner = null;
            int highestEarnings = 0;
            for (Player player : players) {
                if (highestEarnings < player.getTotalPrizeMoney()) {
                    highestEarnings = player.getTotalPrizeMoney();
                    winner = player;
                }
            }
            //check if there is a tie, and add to the set of winners if there is more than one.
            Set<Player> winners = new HashSet<>();
            for (Player player : players) {
                if (player.getTotalPrizeMoney() == winner.getTotalPrizeMoney()) {
                    winners.add(player);
                }
            }
            //iterate through winners.
            //get winners' names and total money earned.
            for (Player player : winners) {
                System.out.println(player.getName());
            }
            System.out.println("With: $" + winner.getTotalPrizeMoney());
        }
    }

}

//..........ends Aliona's Work.





