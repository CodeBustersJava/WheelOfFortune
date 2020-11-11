package com.codebuster.player;

import com.codebuster.game.Game;
import com.codebuster.puzzle.Puzzle;
import com.codebuster.wheel.Wheel;

import java.util.*;

/*
Aliona's work starts...
 */
public class Player {
    private String name;
    public int potentialMoney;
    public String potentialPrize = "";
    private int totalPrizeMoney = 0;
    private final Set<String> roundEarningsPrize = new HashSet<>();
    private final Wheel wheel = Wheel.getInstance();
    private final Scanner scanner = new Scanner(System.in);

    //CONSTRUCTOR
    public Player(String name) {
        this.name = name;
    }

    //METHODS
    public void playerSpinsWheel() {
        potentialMoney = 0;
        potentialPrize = "";
        //gets Dustin's Wheel method which spins the wheel of choices:
        // empty, lose turn, bankruptcy, money, and prizes.
        String result = wheel.spinWheel();
        System.out.println("Potential Earnings: $" + result);

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
            setTotalPrizeMoney(0);
        }
        //check if the award is money or prize
        else if (result.matches("[0-9]+")) {
            //store result in a temporary variable 'potentialMoney'.
            potentialMoney = Integer.parseInt(result);
        } else {
            //else potentialPrize
            potentialPrize = result;
        }
    }

    public void requestConsonant() {
        //player requests consonant through input. check if the input is right.
        //checking is happening in Puzzle class from consonants list.
        System.out.println("Please enter a consonant: ");
        String input = scanner.nextLine().toUpperCase();
        if (Puzzle.consonants.contains(input)) {
            checkIfRight(input);
        } else {
            //when player chooses not a consonant they lose a turn as penalty.
            System.out.println(input + " is not a consonant!");
            System.out.println("Penalty for freeloading: LOSE A TURN");
            Game.getTheNextPlayer();
        }
    }

    public void checkIfRight(String consonant) {
        //player guesses again if the consonant chosen is already revealed on the board.
        if (Puzzle.guessedRightLetters.contains(consonant)) {
            System.out.println("This letter is already on the board");
            Game.guess();
        } else {
            if (Puzzle.currentPhrase.contains(consonant)) {
                System.out.println("You guessed right, reveal the consonant: " + consonant);
                //player guesses right:
                //potential earnings turn into actual earnings money/prize (print both).
                totalPrizeMoney = potentialMoney + totalPrizeMoney;
                if (!potentialPrize.equals("")) {
                    roundEarningsPrize.add(potentialPrize);
                }
                //update the board with the guessed right consonant.
                Puzzle.guessedRightLetters.add(consonant.charAt(0));
                Puzzle.showPuzzle();
            } else {
                //player guesses wrong:
                //potential money earnings = 0.
                //guessed wrong letters are added to the guessedWrongLetters set.
                //player loses turn.
                System.out.println("Guessed wrong!");
                potentialMoney = 0;
                Puzzle.guessedWrongLetters.add(consonant.charAt(0));
                System.out.println(Puzzle.guessedWrongLetters);
                Game.getTheNextPlayer();
            }
        }
    }

    public void buyVowel() {
        //check if player has enough money to buy a vowel worth $250.
        //player buys a vowel their total money is decreased by $250.
        if (getTotalPrizeMoney() >= 250) {
            System.out.print("Enter a vowel: ");
            String input = scanner.nextLine().toUpperCase();
            totalPrizeMoney = totalPrizeMoney - 250;
            //check if player entered a vowel.
            if (Puzzle.vowels.contains(input)) {
                checkIfRight(input);
            } else {
                System.out.println(input + " is not a vowel!");
                System.out.println("Penalty for freeloading: LOSE A TURN!");
                Game.getTheNextPlayer();
            }
        }   //player does not have enough money to buy a vowel
        //player needs to choose a consonant instead.
        else {
            System.out.println("You do not have enough money to buy a vowel.");
            Game.currentPlayer.requestConsonant();
        }
    }

    //ACCESSORS
    public String getName() {
        return name;
    }

    public void getRoundEarningsPrize() {
        if (this.roundEarningsPrize.size() == 0) {
            System.out.println("No prizes won.");
        }
        for (String prize : this.roundEarningsPrize) {
            if (prize != null) {
                System.out.println(prize);
            }
        }
    }

    public int getTotalPrizeMoney() {
        return this.totalPrizeMoney;
    }

    public void setTotalPrizeMoney(int totalPrizeMoney) {
        this.totalPrizeMoney = totalPrizeMoney;
    }

}

/*
Aliona's work ends.
 */