package com.codebuster.wheel;

import com.codebuster.enums.Money;
import com.codebuster.enums.NegativeConsequence;
import com.codebuster.enums.Prize;

import java.util.Random;

public class Wheel {
    private static Wheel instance = null;
    private Prize wheelPrize;
    private int prizeValue;
    private static int negativesLength = NegativeConsequence.values().length;
    private static int moneyLength = Money.values().length;


    private Wheel(){
        wheelPrize = Prize.randomPrize();
        prizeValue = Prize.prizeValue();
    }

    public String spinWheel(){
        int upperBound = 1 + negativesLength + moneyLength;
        Random random = new Random();
        int wheelSelection = random.nextInt(upperBound);
        if(wheelSelection == 0){
            return wheelPrize.toString();
        }else if(wheelSelection <= moneyLength){
            return Money.values()[wheelSelection - 1].toString();
        }else {
            return NegativeConsequence.values()[wheelSelection - 1 - moneyLength].toString();
        }
    }

    public int getPrizeValue() {
        return prizeValue;
    }

    public static Wheel getInstance(){
        return instance != null ? instance : new Wheel();
    }

}
