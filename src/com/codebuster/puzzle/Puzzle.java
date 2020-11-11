package com.codebuster.puzzle;

import com.codebuster.game.Game;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import java.util.*;

/*
Aliona's work starts...
 */
public class Puzzle {
    private String currentPhrase;
    private String currentCategory;
    private boolean solvedPuzzle = false;
    private List<Character> guessedRightLetters = new ArrayList<>();
    private Set<Character> guessedWrongLetters = new HashSet<>();
    public final List<String> consonants = Arrays.asList("B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "V", "W", "X", "Z", "Y");
    public final List<String> vowels = Arrays.asList("A", "E", "I", "O", "U");
    private final List<String> Occupation = Arrays.asList("DOCTOR", "TEACHER", "DOG WALKER", "SOFTWARE DEVELOPER", "MUSICIAN", "FILM PRODUCER");
    private final List<String> Quotations = Arrays.asList("IT IS RAINING CATS AND DOGS", "HASTA LA VISTA BABY", "A PARTY WITHOUT CAKE IS JUST A MEETING", "TALK IS CHEAP SHOW ME THE CODE");
    private final List<String> Amazon_Leadership_Principles = Arrays.asList("DIVE DEEP", "CUSTOMER OBSESSION", "ARE RIGHT A LOT", "OWNERSHIP", "LEARN AND BE CURIUOS", "THINK BIG", "INSIST ON HIGHEST STANDARDS",
            "INVENT AND SIMPLIFY", "HIRE AND DEVELOP THE BEST", "BIAS FOR ACTION", "EARN TRUST", "FRUGALITY", "HAVE BACKBONE DISAGREE AND COMMIT", "DELIVER RESULTS");
    private List<String> Categories = Arrays.asList("Occupation", "Quotations", "Amazon Leadership Principles");
    private Game game;

    public Puzzle(Game game){
        this.game = game;
    }

    public String randomPhrase() {
        //shuffle and get the first category.
        Collections.shuffle(Categories);
        currentCategory = Categories.get(0);

        if (currentCategory.equalsIgnoreCase("Occupation")) {
            Collections.shuffle(Occupation);
            currentPhrase = Occupation.get(0);
        } else if (currentCategory.equalsIgnoreCase("Quotations")) {
            Collections.shuffle(Quotations);
            currentPhrase = Quotations.get(0);
        } else if (currentCategory.equalsIgnoreCase("Amazon Leadership Principles")) {
            Collections.shuffle(Amazon_Leadership_Principles);
            currentPhrase = Amazon_Leadership_Principles.get(0);
        }
        return currentPhrase;
    }

    public String showPuzzle() {
        char[] puzzle = currentPhrase.toCharArray();
        int thePhrase = 0;
        //iterate through each letter in the puzzle.
        StringBuilder currentPuzzle = new StringBuilder();
        //iterate through each letter in puzzle
        for (char letter : puzzle) {
            if (guessedRightLetters.contains(letter)) {
                currentPuzzle.append(letter);
                thePhrase++;
            } else if (letter == ' ') {
                currentPuzzle.append(" ");
                thePhrase++;
            } else {
                currentPuzzle.append("_");
            }
            //puzzle solved by each letter revealed.
            if (thePhrase == currentPhrase.length()) {
                solvePuzzle(currentPhrase);
            }
        }
        return currentPuzzle.toString();
    }

    public void solvePuzzle(String input) {
        //entire puzzle solved by player inputting the correct phrase.
        //player who solved the puzzle gets additional $5000 plus initial earnings money/prize.
        if (input.equals(currentPhrase)) {
            System.out.println("Congratulations, you won!!! Collect your $5000 reward");
            int totalWinnings = game.getCurrentPlayer().getRoundEarningsMoney();
            totalWinnings += 5000;
            System.out.println("Your prize money is $" + totalWinnings);
            System.out.println("Your prizes ");
            System.out.println("Congratulations " + game.getCurrentPlayer().getName() + ", you won!!! Collect your additional $5000 reward");
            game.getCurrentPlayer().setTotalPrizeMoney();
            System.out.println("Winner's total prizes: ");
            game.getCurrentPlayer().getRoundEarningsPrize();
            //total money of all players.
            System.out.println(game.getPlayer1().getName() + " earned: $" + game.getPlayer1().getTotalPrizeMoney());
            System.out.println(game.getPlayer2().getName() + " earned: $" + game.getPlayer2().getTotalPrizeMoney());
            System.out.println(game.getPlayer3().getName() + " earned: $" + game.getPlayer3().getTotalPrizeMoney());

            solvedPuzzle = true;
        } else {
            //player loses turn when guesses the wrong phrase.
            System.out.println("You guessed wrong, better luck next time!");
            game.getTheNextPlayer();
        }
    }
    public String getCurrentPhrase() {
        return currentPhrase;
    }

    public String getCurrentCategory() {
        return currentCategory;
    }

    public boolean isSolvedPuzzle() {
        return solvedPuzzle;
    }

    public void setSolvedPuzzle(boolean solved) {
        this.solvedPuzzle = solved;
    }

    public Set<Character> getGuessedWrongLetters() {
        return guessedWrongLetters;
    }

    public void setGuessedWrongLetters(char character) {
        this.guessedWrongLetters.add(character);
    }

    public List<Character> getGuessedRightLetters() {
        return guessedRightLetters;
    }

    public void setGuessedRightLetters(char character) {
        this.guessedRightLetters.add(character);
    }

    public void clearGuessedWrongLetters() {
        this.guessedRightLetters.clear();
    }

    public void clearGuessedRightLetters() {
        this.guessedRightLetters.clear();
    }
}

/*
Aliona's work ends.
 */