package com.codebuster.player;

import com.codebuster.enums.Prize;
import com.codebuster.wheel.Wheel;

import java.util.ArrayList;
import java.util.List;

public class Player {
    Player player;
    String name;
    int roundEarningsMoney = 0;
    int totalPrizeMoney= 0;
    List<String> roundEarningsPrize = new ArrayList<>();
    List<Prize> totalPrizesEarned = new ArrayList<>();
    Wheel wheel = Wheel.getInstance();

    //CONSTRUCTOR
    public Player(String name){
        this.name = name;
    }

    //METHODS
    public String playerSpinsWheel(){
        //gets Dustin's Wheel method. checking for if it is an string type or int to return corresponding earnings.
        String result = wheel.spinWheel(); //string prize or money
        if(result.contains("[a-zA-Z]")){
            roundEarningsPrize.add(result);
        } else{
            roundEarningsMoney = roundEarningsMoney + Integer.parseInt(result);
        }
        return result;
    }

    public void requestConsonant(){
        //player requests consonant. com.codebuster.puzzle.Puzzle class getLetters.


    }

    public void solvePuzzle(){
        //player solves the entire puzzle
    }

    public void buyVowel(){
       // getLetters contains("a, i, o, u, e");
    }

    //ACCESSORS
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getRoundPrizeMoney() {
        return roundEarningsMoney;
    }

    public void setRoundPrizeMoney(int roundPrizeMoney) {
        this.roundEarningsMoney = roundPrizeMoney;
    }

    public List<String> getRoundEarningsPrize() {
        return roundEarningsPrize;
    }

    public void setRoundEarningsPrize(List<String> roundEarningsPrize) {
        this.roundEarningsPrize = roundEarningsPrize;
    }

    public int getTotalPrizeMoney() {
        return totalPrizeMoney;
    }

    public void setTotalPrizeMoney(int totalPrizeMoney) {
        this.totalPrizeMoney = totalPrizeMoney;
    }
}
