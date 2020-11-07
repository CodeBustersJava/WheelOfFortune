package com.codebuster.wheel.test;

import com.codebuster.enums.Money;
import com.codebuster.enums.NegativeConsequence;
import com.codebuster.wheel.Wheel;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class WheelTest {
    private Wheel wheel;

    @Before
    public void createWheel(){
        wheel = Wheel.getInstance();
    }
    @Test
    public void spinWheelTest(){
        HashMap<String, Integer> map = new HashMap<>();
        int negativesLength = NegativeConsequence.values().length;
        int moneyLength = Money.values().length;
        int totalLength = 1 + negativesLength + moneyLength;
        int average = 100;
        for(int i = 0; i < totalLength*average; i++){
            String key = wheel.spinWheel();
            int value = map.getOrDefault(key, 0);
            map.put(key, value + 1);
        }
        System.out.println(map);
        assertEquals(totalLength, map.size());
        AtomicBoolean averageCheck = new AtomicBoolean(true);
        map.forEach((key, value)->{
            if(value < average * .75 && value > average * 1.25 ){
                averageCheck.set(false);
            }
        });
        assertTrue(averageCheck.get());
    }

    @Test
    public void getPrizeValueTest(){
        boolean condition = (wheel.getPrizeValue() >= 1000) && (wheel.getPrizeValue() <= 4000);
        assertTrue(condition);
    }
}

