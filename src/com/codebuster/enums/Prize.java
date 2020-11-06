package com.codebuster.enums;

import java.util.Random;

public enum Prize implements Possibilities {
    TRIP_TO_NORTH_KOREA,
    SCUBA_DIVING_VACATION,
    PANDEMIC_CRUISE,
    GEO_METRO_1990
    ;
    private Prize prize;

    public static Prize randomPrize(){
        int max = Prize.values().length;
        Random random = new Random();
        int index = random.nextInt(max);
        return Prize.values()[index];
    }

    public static int prizeValue(){
        Random random = new Random();
        return random.nextInt(3000)+1000;
    }

}

