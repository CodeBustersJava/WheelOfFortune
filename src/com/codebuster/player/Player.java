package com.codebuster.player;

import com.codebuster.puzzle.Puzzle;
import com.codebuster.wheel.Wheel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Aliona's Work
 */
public class Player {
    Player player;
    String name;
    int potentialMoney;
    String potentialPrize;
    int roundEarningsMoney = 0;
    int totalPrizeMoney = 0;
    List<String> roundEarningsPrize = new ArrayList<>();
    List<String> totalPrizesEarned = new ArrayList<>();
    Wheel wheel = Wheel.getInstance();
    boolean loseTurn = false;
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
            System.out.println("empty");
        }
        //if LOSE_TURN change loseTurn to true and print.
        else if (result.equals("LOSE_TURN")) {
            loseTurn = true;
        }
        //if BANKRUPTCY money = 0 and print
        else if (result.equals("BANKRUPTCY")) {
            roundEarningsMoney = 0;
            loseTurn = true;
        }
        //if MONEY use regex to find matching numbers from the enum choices.
        else if (result.matches("[0-9]+")) {
            //stores in temporary variable potentialMoney
            potentialMoney = Integer.parseInt(result);
        } else
            //else potentialPrize
            potentialPrize = result;
    }

    public boolean ableToGo(){
        if(!loseTurn){
            return true;
        }
        return false;
    }

    public void requestConsonant() {
        //player requests consonant through input. check if the input is right.
        System.out.println("Please enter a consonant: ");
        String input = scanner.nextLine();
        checkIfRightConsonant(input);
    }

    public void checkIfRightConsonant(String consonant) {
        if (Puzzle.currentPhrase.contains(consonant)) {
            System.out.println("You guessed right, reveal the consonant: " + consonant);
            //after player guesses right:
            // potential earnings turn into actual earnings money/prize (print both).
            roundEarningsMoney = potentialMoney + roundEarningsMoney;
            System.out.println(roundEarningsMoney);
            roundEarningsPrize.add(potentialPrize);
            System.out.println(roundEarningsPrize);
        }
    }

    public void solvePuzzle() {
        //player guesses the entire puzzle
        System.out.println("Please guess the phrase to solve the puzzle: ");
        String inputPuzzle = scanner.nextLine();
        if (Puzzle.currentPhrase.equalsIgnoreCase(inputPuzzle)) {
            System.out.println("The phrase is correct. Congratulations you win!");
            totalPrizesEarned = roundEarningsPrize;
            totalPrizeMoney = roundEarningsMoney;
        } else {
            roundEarningsMoney = 0;
            roundEarningsPrize.isEmpty();
        }
    }

    //Game class should have this method initiated.
    public void buyVowel() {
        System.out.println("spend 250$ to buy vowel");
        if (roundEarningsMoney >= 250) {
            System.out.println("Player has enough money to buy a vowel");
        }else{
            System.out.println("I'm sorry player does not have enough money to buy a vowel");
        }
    }

    //ACCESSORS

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getPotentialMoney() {
        return potentialMoney;
    }

    public String getPotentialPrize() {
        return potentialPrize;
    }

    public int getRoundEarningsMoney() {
        return roundEarningsMoney;
    }

    public int getTotalPrizeMoney() {
        return totalPrizeMoney;
    }

    public List<String> getRoundEarningsPrize() {
        return roundEarningsPrize;
    }

    public List<String> getTotalPrizesEarned() {
        return totalPrizesEarned;
    }
}