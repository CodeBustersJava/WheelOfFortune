package com.codebuster.game;

import com.codebuster.player.Player;
import com.codebuster.puzzle.Puzzle;

import java.util.*;
//.....starts Aliona's work.
public class Game {
    Scanner scanner = new Scanner(System.in);
    Player currentPlayer;
    String thePhrase;

   public static List <Player> players = new ArrayList<>();
    Player player1 = new Player("Aliona");
    Player player2 = new Player("Debbie");
    Player player3 = new Player("Dustin");

    public void startTheGame() {
        Puzzle puzzle = new Puzzle();
        puzzle.randomPhrase();
        System.out.println(Puzzle.currentPhrase);
        players.add(player1);
        players.add(player2);
        players.add(player3);
        Collections.shuffle(players);
        currentPlayer = players.get(0);
        currentPlayer.playerSpinsWheel();
        guess();
    }
    public void guess(){
        if(currentPlayer.ableToGo()){
            System.out.println("Would you like to request a consonant for free, or buy a vowel for $250?");
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("consonant")){
                currentPlayer.requestConsonant();
            }else if(input.equalsIgnoreCase("vowel")){
                currentPlayer.buyVowel();
            }else{
                System.out.println("Please choose a valid input either consonant or vowel");
            }
        }
    }
    //..........ends Aliona's Work.
    public void buyVowel(){

    }

}


