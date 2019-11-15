package greedyPlaning;

import control.Three;
import util.DescendantSort;
import util.SortByDepth;

import java.util.ArrayList;
import java.util.HashMap;

public class Planner {

    private HashMap<Integer, ArrayList<Three>> threeOrder = new HashMap<>();
    private ArrayList<Integer> positions;
    private ArrayList<Three> threeArray;

    public Planner(ArrayList<Three> pThreeList){
        threeArray = pThreeList;
        positions = new ArrayList<>();
        generateOrder();
        sortThrees();
    }

    private void generateOrder(){
        for (Three three : threeArray) {
            if(!threeOrder.containsKey(three.getX())){
                threeOrder.put(three.getX(),new ArrayList<>());
                positions.add(three.getX());
            }
            threeOrder.get(three.getX()).add(three);
        }
    }

    private void sortThrees(){
        positions.sort(new DescendantSort());
        SortByDepth sortByDepth = new SortByDepth();
        for(Integer position: positions){
            threeOrder.get(position).sort(sortByDepth);
        }
    }

}
