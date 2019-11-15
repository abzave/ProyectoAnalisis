package main;


import control.Three;
import greedyPlaning.Planner;
import lib.IConstants;
import util.Randoms;

import java.util.ArrayList;

public class Main {

    private static ArrayList<Three> generateRandomThrees(int pAmountThree){
        ArrayList<Three> threes = new ArrayList<>();
        for(int three = 0; three < pAmountThree; three++){
            threes.add(new Three(Randoms.randInt(0, IConstants.ANTHILL_X_POS), Randoms.randInt(2, 10)));
        }
        return threes;
    }

    public static void main(String[] args) {
        Three three = new Three(1300, 3);
        Planner planner = new Planner(generateRandomThrees(20));
    }
}
