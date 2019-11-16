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
    private ThreeSet optimalSets;

    public Planner(ArrayList<Three> pThreeList){
        threeArray = pThreeList;
        positions = new ArrayList<>();
        generateOrder();
        sortThrees();
        optimalSets = new ThreeSet(threeOrder, positions);
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

    public void printOptimalSets(){
        for(int set = 0; set < optimalSets.sets.size(); set++){
            System.out.println("Set number --> "+ set);
            for(int element = 0; element < optimalSets.sets.get(set).size(); element++){
                System.out.println("Three "+element+" is in "+ optimalSets.sets.get(set).get(element).getX() +
                        "Alto: " + optimalSets.sets.get(set).get(element).getheigh());
            }
        }
    }

}
