package greedyPlaning;

import control.Three;

import java.util.ArrayList;
import java.util.HashMap;

public class Planner {

    private HashMap<Integer, ArrayList<Three>> threeOrder = new HashMap<>();
    private ArrayList<Three> threeArray;

    public Planner(ArrayList<Three> pThreeList){
        threeArray = pThreeList;
        generateOrder();
    }

    private void generateOrder(){
        for (Three three : threeArray) {
            if(!threeOrder.containsKey(three.getX())){
                threeOrder.put(three.getX(),new ArrayList<Three>());
            }
            threeOrder.get(three.getX()).add(three);
        }
    }

}
