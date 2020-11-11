package com.codebuster.puzzle;

import com.codebuster.game.Game;

import java.util.*;

/*
Aliona's work starts...
 */
public class Puzzle {
    public static String currentPhrase;
    public static String currentCategory;
    public static boolean solvedPuzzle = false;
    public static List<Character> guessedRightLetters = new ArrayList<>();
    public static Set<Character> guessedWrongLetters = new HashSet<>();
    public static List<String> consonants = Arrays.asList("B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "V", "W", "X", "Z", "Y");
    public static List<String> vowels = Arrays.asList("A", "E", "I", "O", "U");
    private final List<String> Occupation = Arrays.asList("DOCTOR", "TEACHER", "DOG WALKER", "SOFTWARE DEVELOPER", "MUSICIAN", "FILM PRODUCER");
    private final List<String> Quotations = Arrays.asList("IT IS RAINING CATS AND DOGS", "HASTA LA VISTA BABY", "A PARTY WITHOUT CAKE IS JUST A MEETING", "TALK IS CHEAP SHOW ME THE CODE");
    private final List<String> Amazon_Leadership_Principles = Arrays.asList("DIVE DEEP", "CUSTOMER OBSESSION", "ARE RIGHT A LOT", "OWNERSHIP", "LEARN AND BE CURIUOS", "THINK BIG", "INSIST ON HIGHEST STANDARDS",
            "INVENT AND SIMPLIFY", "HIRE AND DEVELOP THE BEST", "BIAS FOR ACTION", "EARN TRUST", "FRUGALITY", "HAVE BACKBONE DISAGREE AND COMMIT", "DELIVER RESULTS");
    List<String> Categories = Arrays.asList("Occupation", "Quotations", "Amazon Leadership Principles");

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

    public static String showPuzzle() {
        char[] puzzle = currentPhrase.toCharArray();
        int thePhrase = 0;
        StringBuilder currentPuzzle = new StringBuilder();
        //iterate through each letter in the puzzle.
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
        System.out.println(currentPuzzle);
        return currentPuzzle.toString();
    }

    public static void solvePuzzle(String input) {
        //entire puzzle solved by player inputting the correct phrase.
        //player who solved the puzzle gets additional $5000 plus initial earnings money/prize.
        if (input.equals(currentPhrase)) {
            System.out.println("Congratulations " + Game.currentPlayer.getName() + ", you won!!! Collect your additional $5000 reward");
            Game.currentPlayer.setTotalPrizeMoney(Game.currentPlayer.getTotalPrizeMoney() + Game.currentPlayer.potentialMoney + 5000);
            System.out.println("Winner's total prizes: ");
            Game.currentPlayer.getRoundEarningsPrize();
            //total money of all players.
            System.out.println(Game.player1.getName() + " earned: $" + Game.player1.getTotalPrizeMoney());
            System.out.println(Game.player2.getName() + " earned: $" + Game.player2.getTotalPrizeMoney());
            System.out.println(Game.player3.getName() + " earned: $" + Game.player3.getTotalPrizeMoney());

            solvedPuzzle = true;
        } else {
            //player loses turn when guesses the wrong phrase.
            System.out.println("You guessed wrong, better luck next time!");
            Game.getTheNextPlayer();
        }
    }
}

/*
Aliona's work ends.
 */