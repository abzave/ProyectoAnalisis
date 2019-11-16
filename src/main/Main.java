package main;


import control.Three;
import greedyPlaning.Planner;
import util.Randoms;

import java.util.ArrayList;

public class Main {

    private static ArrayList<Three> generateRandomThrees(int pAmountThree){
        ArrayList<Three> threes = new ArrayList<>();
        for(int three = 0; three < pAmountThree; three++){
            threes.add(new Three(Randoms.randInt(0, 20), Randoms.randInt(2, 20)));
        }
        return threes;
    }

    public static void main(String[] args) {
        Planner planner = new Planner(generateRandomThrees(20));
        planner.printOptimalSets();
    }
}
