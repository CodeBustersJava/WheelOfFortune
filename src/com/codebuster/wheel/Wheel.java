package com.codebuster.wheel;

import com.codebuster.enums.Money;
import com.codebuster.enums.NegativeConsequence;
import com.codebuster.enums.Possibilities;
import com.codebuster.enums.Prize;

import java.util.Random;

public class Wheel {
    private static Wheel instance = null;
    private Prize wheelPrize;
    private int prizeValue;
    private Possibilities currentWheelSelection;
    private static int negativesLength = NegativeConsequence.values().length;
    private static int moneyLength = Money.values().length;


    private Wheel(){
        wheelPrize = Prize.randomPrize();
        prizeValue = Prize.prizeValue();
    }

    public Possibilities spinWheel(){
        int upperBound = 1 + negativesLength + moneyLength;
        Random random = new Random();
        int wheelSelection = random.nextInt(upperBound);
        if(wheelSelection == 1){
            return wheelPrize;
        }else if(wheelSelection > 1 && wheelSelection < moneyLength){
            return Money.values()[wheelSelection - 1];
        }else if(wheelSelection >= 1+moneyLength){

        }
    }

    public static Wheel getInstance(){
        return instance != null ? instance : new Wheel();
    }

}