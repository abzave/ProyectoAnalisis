package greedyPlaning;

import lib.IConstants;

import java.util.HashMap;

public class Calculator {

    private static HashMap<Integer, Double> threeDepthLength = new HashMap<>();

    public static double getThreeLenght(int pDepth){
        if(!threeDepthLength.containsKey(pDepth)){
            calculateThreeLenght(pDepth);
        }
        return threeDepthLength.get(pDepth);
    }

    private static void calculateThreeLenght(int pDepth){
        double baseHeight = IConstants.THREE_GROWING_FACTOR*pDepth;
        double depth = 3;
        double size = 10;
        for(; depth > 1; depth--){
            baseHeight /= 2;
            size += baseHeight;
        }
        threeDepthLength.put(pDepth, size);
    }



}
