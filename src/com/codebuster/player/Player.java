package com.codebuster.player;

import com.codebuster.game.Game;
import com.codebuster.puzzle.Puzzle;
import com.codebuster.wheel.Wheel;

import java.util.*;

/*
Aliona's Work
 */
public class Player {
    Player player;
    public String name;
    public int potentialMoney;
    public String potentialPrize;
    public int roundEarningsMoney = 0;
    //int totalPrizeMoney = 0;
    private List<String> roundEarningsPrize = new ArrayList<>();
    Wheel wheel = Wheel.getInstance();
    //boolean loseTurn = false;
    Scanner scanner = new Scanner(System.in);

    //CONSTRUCTOR
    public Player(String name) {
        this.name = name;
    }

    //METHODS
    public void playerSpinsWheel() {
        //gets Dustin's Wheel method which spins the wheel of choices:
        // empty, lose turn, bankruptcy, money, and prizes.
        String result = wheel.spinWheel();
        System.out.println("Potential Earnings: " + result);

        //if empty "" print empty.
        if (result.equals("")) {
            System.out.println("You did not get a reward");
        }
        //if LOSE_TURN get the next player to play and print out the player's name whose turn it is.
        else if (result.equals("LOSE_TURN")) {
            System.out.println("You lose a turn");
            Game.getTheNextPlayer();
            System.out.println("Currently playing: " + Game.currentPlayer.name);
        }
        //if BANKRUPTCY money = 0 and print
        else if (result.equals("BANKRUPTCY")) {
            this.roundEarningsMoney = 0;
            System.out.println("$" + roundEarningsMoney);
        }
        //check if the award is money or prize
        else if (result.matches("[0-9]+")) {
            //store result in a temporary variable 'potentialMoney'.
            potentialMoney = Integer.parseInt(result);
        } else {
            //else potentialPrize
            potentialPrize = result;
            potentialMoney = wheel.getPrizeValue();
        }
    }
//    //true or false for player being able to play or loses turn.
//    public boolean ableToGo() {
//        if (!loseTurn) {
//            return true;
//        }
//        return false;
//    }

    public void requestConsonant() {
        //player requests consonant through input. check if the input is right.
        //checking is happening in Puzzle class from consonants list.
        System.out.println("Please enter only one consonant: ");
        String input = scanner.nextLine().toUpperCase();
        if (Puzzle.consonants.contains(input)) {
            checkIfRight(input);
        } else {
            //when player chooses not a consonant they lose a turn as penalty.
            System.out.println(input + " is not a consonant!");
            System.out.println("Penalty for freeloading: You lose a turn!");
            Game.getTheNextPlayer();
        }
    }

    public void checkIfRight(String consonant) {
        if (Puzzle.currentPhrase.contains(consonant)) {
            System.out.println("Guessed right, reveal the consonant: " + consonant);
            //after player guesses right:
            // potential earnings turn into actual earnings money/prize (print both).
            roundEarningsMoney = potentialMoney + roundEarningsMoney;
            System.out.println("Money Earned: $" + roundEarningsMoney);
            roundEarningsPrize.add(potentialPrize);
            System.out.println("Prizes Earned: ");
            getRoundEarningsPrize();
            Puzzle.guessedRightLetters.add(consonant.charAt(0));
            Puzzle.showPuzzle();
        } else {
            System.out.println("Guessed wrong!");
            potentialMoney = 0;
            //potentialPrize.isEmpty();
            Game.getTheNextPlayer();
        }
    }

    public void buyVowel() {
        if (roundEarningsMoney >= 250) {
            System.out.println("Enter a vowel: ");
            String input = scanner.nextLine().toUpperCase();
            if (Puzzle.vowels.contains(input)) {
                checkIfRight(input);
            } else {
                System.out.println(input + " is not a vowel!");
                System.out.println("Penalty for freeloading: LOSE A TURN!");
                Game.getTheNextPlayer();
            }
        } else {
            System.out.println("You do not have enough money to buy a vowel.");
        }
    }

    //ACCESSORS

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getRoundEarningsMoney() {
        return roundEarningsMoney;
    }

    public void setRoundEarningsMoney(int roundEarningsMoney) {
        this.roundEarningsMoney = roundEarningsMoney;
    }

    public void getRoundEarningsPrize() {
        for (String prize : this.roundEarningsPrize) {
            if (prize != null) {
                System.out.println(prize);
            }
        }

    }


}