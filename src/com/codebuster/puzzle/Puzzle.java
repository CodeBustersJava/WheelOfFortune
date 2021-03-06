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
    private final List<String> Endangered_Animals = Arrays.asList("SAVANNA ELEPHANT", "SUMATRAN RHINO", "SNOW LEOPARD", "GREAT WHITE SHARK", "GIANT PANDA", "RED PANDA", "MOUNTAIN GORILLA");
    private final List<String> Quotations = Arrays.asList("IT IS RAINING CATS AND DOGS", "HASTA LA VISTA BABY", "TALK IS CHEAP SHOW ME THE CODE");
    private final List<String> Amazon_Leadership_Principles = Arrays.asList("DIVE DEEP", "CUSTOMER OBSESSION", "ARE RIGHT A LOT", "OWNERSHIP", "LEARN AND BE CURIUOS", "THINK BIG", "INSIST ON HIGHEST STANDARDS",
            "INVENT AND SIMPLIFY", "HIRE AND DEVELOP THE BEST", "BIAS FOR ACTION", "EARN TRUST", "FRUGALITY", "HAVE BACKBONE DISAGREE AND COMMIT", "DELIVER RESULTS");
    private List<String> Categories = Arrays.asList("Occupation", "Quotations", "Amazon Leadership Principles", "Endangered Animals");

    private Game game;

    public Puzzle(Game game) {
        this.game = game;
    }

    public String randomPhrase() {
        //shuffle and get the first category.
        Collections.shuffle(Categories);
        currentCategory = Categories.get(0);
        //shuffle the phrases and get the first phrase.
        if (currentCategory.equalsIgnoreCase("Occupation")) {
            Collections.shuffle(Occupation);
            currentPhrase = Occupation.get(0);
        } else if (currentCategory.equalsIgnoreCase("Quotations")) {
            Collections.shuffle(Quotations);
            currentPhrase = Quotations.get(0);
        } else if (currentCategory.equalsIgnoreCase("Amazon Leadership Principles")) {
            Collections.shuffle(Amazon_Leadership_Principles);
            currentPhrase = Amazon_Leadership_Principles.get(0);
        } else if (currentCategory.equalsIgnoreCase("Endangered Animals")) {
            Collections.shuffle(Endangered_Animals);
            currentPhrase = Endangered_Animals.get(0);
        }
        return currentPhrase;
    }


    public String showPuzzle() {
        char[] puzzle = currentPhrase.toCharArray();
        int thePhrase = 0;
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
            System.out.println();
            System.out.println("Congratulations " + game.getCurrentPlayer().getName() + ", you won!!! Collect your additional $5000 reward");
            game.getCurrentPlayer().setTotalPrizeMoney(game.getCurrentPlayer().getTotalPrizeMoney() + game.getCurrentPlayer().getPotentialMoney() + 5000);
            System.out.print("Winner's total prizes: ");
            game.getCurrentPlayer().getRoundEarningsPrize();
            //total money of all players.
            System.out.print(game.getPlayer1().getName() + " earned: $" + game.getPlayer1().getTotalPrizeMoney() + ", prizes earned: ");
            game.getPlayer1().getRoundEarningsPrize();
            System.out.print(game.getPlayer2().getName() + " earned: $" + game.getPlayer2().getTotalPrizeMoney() + ", prizes earned: ");
            game.getPlayer2().getRoundEarningsPrize();
            System.out.print(game.getPlayer3().getName() + " earned: $" + game.getPlayer3().getTotalPrizeMoney() + ", prizes earned: ");
            game.getPlayer3().getRoundEarningsPrize();
            System.out.println();
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

    public List<Character> getGuessedRightLetters() {
        return guessedRightLetters;
    }

    public void setGuessedRightLetters(char character) {
        this.guessedRightLetters.add(character);
    }

    public void clearGuessedWrongLetters() {
        this.guessedWrongLetters.clear();
    }

    public void clearGuessedRightLetters() {
        this.guessedRightLetters.clear();
    }
}

/*
Aliona's work ends.
 */