//package com.codebuster.enums.test;
//
//import com.codebuster.enums.Prize;
//import org.junit.Test;
//import static org.junit.Assert.assertTrue;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class PrizeTest {
//        @Test
//        public void randomPrizeGeneratorTest_ShouldHaveAHashMapRelativeEven(){
//            Map<Prize, Integer> prizeMap = new HashMap<>();
//            Prize prize = Prize.GEO_METRO_1990;
//            Prize currentPrize;
//            for(int i = 0; i < 1000; i++){
//                currentPrize = prize.randomPrize();
//                int count = prizeMap.getOrDefault(currentPrize, 0);
//                prizeMap.put(currentPrize, count+1);
//            }
//            System.out.println(prizeMap);
//            boolean trueCondition = true;
//            for(int i=0 ; i < Prize.values().length; i++){
//                int count = prizeMap.get(prize.values()[i]);
//                if(count < 200 && count > 300 ){
//                    trueCondition = false;
//                    break;
//                }
//            }
//            assertTrue(trueCondition);
//        }
//}
