package com.codebuster.game;

import com.codebuster.player.Player;
import com.codebuster.puzzle.Puzzle;
import com.codebuster.ui.Display;
import com.codebuster.ui.PuzzleBoard;
import com.codebuster.ui.WheelBoard;
import com.codebuster.wheel.Wheel;
import java.util.*;

//Aliona's work starts...
public class Game {
    private PuzzleBoard puzzleBoard;
    private Display display = Display.getInstance();
    Wheel wheel = Wheel.getInstance();
    private WheelBoard moneyDisplay = new WheelBoard(wheel.getWheelPrize());
    Scanner scanner = new Scanner(System.in);
    private Player currentPlayer;
    public List<Player> players = new ArrayList<>();
    Player player1;
    Player player2;
    Player player3;
    Puzzle puzzle;
    public static int indexForCurrentPlayer = 0;

    private boolean gameOn = true;

    public Game(){
        moneyDisplay.setMoney(wheel.getMoney());
        player1 = new Player("Aliona", this);
        player2 = new Player("Debbie", this);
        player3 = new Player("Dustin", this);
        puzzle = new Puzzle(this);
    }

    public void start(){
        display.clearConsole();
        startTheGame();
    }

    public void startTheGame() {
        puzzle.randomPhrase();
        puzzleBoard = new PuzzleBoard(puzzle.getCurrentCategory(), puzzle.showPuzzle());
        System.out.println(puzzle.getCurrentPhrase());
        puzzle.showPuzzle();
        //add all players to the players list and shuffle them to have a random order.
        players.add(player1);
        players.add(player2);
        players.add(player3);
        Collections.shuffle(players);
        //from players list get the first player at indexForCurrentPlayer (default 0), and assign as currentPlayer.
        currentPlayer = players.get(indexForCurrentPlayer);

        //gameplay loop
        while (!puzzle.isSolvedPuzzle() && gameOn) {
            puzzleBoard.updatePuzzle(puzzle.showPuzzle());
            currentPlayer.playerSpinsWheel();
            display.clearConsole();
            System.out.println("Prizes Earned: ");
            currentPlayer.getRoundEarningsPrize();
            //current player spins the wheel of fortune.
            display.showPuzzle(puzzleBoard);
            display.showCategory(puzzleBoard);
            display.showWheel(wheel);
            System.out.println();
            display.showPlayers(player1, player2, player3, currentPlayer);
            display.showScore(player1, player2, player3);
            display.showTotalScore(player1, player2, player3);
            System.out.println("Wrong letter collection: " + puzzle.getGuessedWrongLetters());
            System.out.print("Puzzle: ");
            puzzle.showPuzzle();
            guess();
        }
        playAgain();
    }

    //first player is 0 second 1 and third 2.
    public void getTheNextPlayer() {
        if (indexForCurrentPlayer == 2) {
            indexForCurrentPlayer = 0;
        } else {
            indexForCurrentPlayer++;

        }
        currentPlayer = players.get(indexForCurrentPlayer);
        currentPlayer.playerSpinsWheel();
        System.out.println();
    }

    public void guess() {
        System.out.println("Please choose your option:\n " +
                "Enter [1] to request a free consonant, \n " +
                "Enter [2] to buy a vowel for $250, \n " +
                "Enter [3] to solve the puzzle. \n" +
                "Quit [4]");
        System.out.print("Enter option input: ");
        String input = scanner.nextLine();
        if (input.equals("1")) {
            currentPlayer.requestConsonant(puzzle);
        } else if (input.equals("2")) {
            currentPlayer.buyVowel(puzzle);
        } else if (input.equals("3")) {
            System.out.print("Please enter the phrase: ");
            String solveInput = scanner.nextLine().toUpperCase();
            puzzle.solvePuzzle(solveInput);
        } else if(input.equals("4")){
            gameOn = false;
        } else {
            System.out.println("Invalid input. Please choose option 1,2, or 3.");
        }
    }

    //repeat game as many times as the user chooses through promp input.
    public void playAgain() {
        System.out.println("Would you like to play another round? Enter [1] for yes or [2] for no to quit: ");
        String playAnotherRound = scanner.nextLine();
        //clear puzzle and guessed wrong letters.
        if (playAnotherRound.equals("1")) {
            puzzle.clearGuessedWrongLetters();
            puzzle.clearGuessedRightLetters();
            //clear players list and start the game loop.
            puzzle.setSolvedPuzzle(false);
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

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getPlayer3() {
        return player3;
    }

    public void setGameOn(boolean gameOn) {
        this.gameOn= gameOn;
    }
}


