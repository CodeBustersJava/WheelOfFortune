package com.codebuster.wheel;

import com.codebuster.enums.Money;
import com.codebuster.enums.NegativeConsequence;
import com.codebuster.enums.Prize;

import java.util.Random;

public class Wheel {
    private static Wheel instance = null;
    private Prize wheelPrize;
    private int negativesLength = NegativeConsequence.values().length;
    private int moneyLength = Money.values().length;
    private int money;
    private String negative;
    private boolean wheelOnPrize;
    private boolean wheelOnNegative;

    private Wheel(){
        wheelPrize = Prize.randomPrize();
        spinWheel();
    }

    public String spinWheel(){
        int upperBound = 1 + negativesLength + moneyLength;
        Random random = new Random();
        int wheelSelection = random.nextInt(upperBound);
        if(wheelSelection == 0){
            wheelOnPrize = true;
            wheelOnNegative = false;
            return wheelPrize.toString();
        }else if(wheelSelection <= moneyLength){
            wheelOnPrize = false;
            wheelOnNegative = false;
            this.money = Integer.parseInt(Money.values()[wheelSelection - 1].toString());
            return Money.values()[wheelSelection - 1].toString();
        }else {
            wheelOnPrize = false;
            wheelOnNegative = true;
            this.negative = NegativeConsequence.values()[wheelSelection - 1 - moneyLength].toString();
            return this.negative;
        }
    }

    public String getWheelPrize() {
        return wheelPrize.toString();
    }

    public int getMoney() {
        return money;
    }

    public boolean isWheelOnPrize() {
        return wheelOnPrize;
    }

    public boolean isWheelOnNegative() {
        return wheelOnNegative;
    }

    public String getNegative() {
        return negative;
    }

    public static Wheel getInstance(){
        instance = instance == null ? new Wheel() : instance;
        return instance;
    }

}
