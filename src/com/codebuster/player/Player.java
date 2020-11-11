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
    private int potentialMoney;
    private String potentialPrize = "";
    private int roundEarningsMoney = 0;
    private int totalPrizeMoney = 0;
    private final Set<String> roundEarningsPrize = new HashSet<>();
    private final Wheel wheel = Wheel.getInstance();
    private final Scanner scanner = new Scanner(System.in);
    private Game game;

    //CONSTRUCTOR
    public Player(String name, Game game) {
        this.name = name;
        this.game = game;
    }

    //METHODS
    public void playerSpinsWheel() {
        potentialMoney = 0;
        potentialPrize = "";
        //gets Dustin's Wheel method which spins the wheel of choices:
        // empty, lose turn, bankruptcy, money, and prizes.
        String result = wheel.spinWheel();

        //if empty "" print empty.
        if (result.equals("")) {
            System.out.println("You did not get a reward");
        }
        //if LOSE_TURN get the next player to play and print out the player's name whose turn it is.
        else if (result.equals("LOSE_TURN")) {
            System.out.println("You lose a turn");
            game.getTheNextPlayer();
            System.out.println("Currently playing: " + game.getCurrentPlayer().name);
        }
        //if BANKRUPTCY money = 0 and print
        else if (result.equals("BANKRUPTCY")) {
            setTotalPrizeMoney(0);
            game.getTheNextPlayer();
        }
        //check if the award is money or prize
        else if (result.matches("[0-9]+")) {
            //store result in a temporary variable 'potentialMoney'.
            potentialMoney = Integer.parseInt(result);
        } else {
            //else potentialPrize
            potentialPrize = result;
            //potentialMoney = wheel.getPrizeValue();
        }
    }

    public void requestConsonant(Puzzle puzzle) {
        //player requests consonant through input. check if the input is right.
        //checking is happening in Puzzle class from consonants list.
        System.out.println("Please enter only one consonant: ");
        String input = scanner.nextLine().toUpperCase();
        if (puzzle.consonants.contains(input)) {
            checkIfRight(input, puzzle);
        } else {
            //when player chooses not a consonant they lose a turn as penalty.
            System.out.println(input + " is not a consonant!");
            System.out.println("Penalty for freeloading: You lose a turn!");
            game.getTheNextPlayer();
        }
    }

    public void checkIfRight(String consonant, Puzzle puzzle) {
        //player guesses again if the consonant chosen is already revealed on the board.
        if (puzzle.getGuessedRightLetters().contains(consonant)) {
            System.out.println("This letter is already on the board");
            game.guess();
        } else {
            if (puzzle.getCurrentPhrase().contains(consonant)) {
                System.out.println("Guessed right, reveal the consonant: " + consonant);
                //after player guesses right:
                // potential earnings turn into actual earnings money/prize (print both).
                totalPrizeMoney = potentialMoney + totalPrizeMoney;
                if (!potentialPrize.equals("")){
                    roundEarningsPrize.add(potentialPrize);
                }
                //update the board with the guessed right consonant
                //System.out.println("Money Earned: $" + getRoundEarningsMoney());
               // roundEarningsPrize.add(potentialPrize);
                //System.out.println("Prizes Earned: ");
                //getRoundEarningsPrize();
                puzzle.setGuessedRightLetters(consonant.charAt(0));
                puzzle.showPuzzle();
            } else {
                //player guesses wrong:
                //potential money earnings = 0.
                //guessed wrong letters are added to the guessedWrongLetters set.
                //player loses turn.
                System.out.println("Guessed wrong!");
                potentialMoney = 0;
                puzzle.getGuessedWrongLetters().add(consonant.charAt(0));
                System.out.println(puzzle.getGuessedWrongLetters());
                game.getTheNextPlayer();
            }
        }
    }

    public void buyVowel(Puzzle puzzle) {
        //check if player has enough money to buy a vowel worth $250.
        //player buys a vowel their total money is decreased by $250.
        if (getRoundEarningsMoney() >= 250) {
            System.out.print("Enter a vowel: ");
            String input = scanner.nextLine().toUpperCase();
            setRoundEarningsMoney(-250);
            //check if player entered a vowel.
            if (puzzle.vowels.contains(input)) {
                checkIfRight(input, puzzle);
            } else {
                System.out.println(input + " is not a vowel!");
                System.out.println("Penalty for freeloading: LOSE A TURN!");
                game.getTheNextPlayer();
            }
        }//player does not have enough money to buy a vowel
        //player needs to choose a consonant instead.
        else {
            System.out.println("You do not have enough money to buy a vowel.");
            game.getCurrentPlayer().requestConsonant(puzzle);
        }
    }


    //ACCESSORS

    public Player getPlayer() {
        return this;
    }

    public int getRoundEarningsMoney() {
        return roundEarningsMoney;
    }

    public void setRoundEarningsMoney(int roundEarningsMoney) {
        this.roundEarningsMoney = this.roundEarningsMoney + roundEarningsMoney;
    }
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
//        this.totalPrizeMoney = this.totalPrizeMoney + getRoundEarningsMoney() + 5000;
//        setRoundEarningsMoney(-1*getRoundEarningsMoney());
        this.totalPrizeMoney = totalPrizeMoney;
    }

    public int getPotentialMoney() {
        return potentialMoney;
    }
}
