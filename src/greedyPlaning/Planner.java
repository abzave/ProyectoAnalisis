package greedyPlaning;

import control.Three;
import util.AscendantSort;
import util.SortByDepth;

import java.util.ArrayList;
import java.util.HashMap;

public class Planner {

    private HashMap<Integer, ThreesAtSameX> threesAtSameX = new HashMap<>();
    private ArrayList<Integer> positions;
    private ArrayList<Three> threeArray;
    private ArrayList<OptimalThreeSet> optimalSets;

    public Planner(ArrayList<Three> pThreeList){
        threeArray = pThreeList;
        positions = new ArrayList<>();
        optimalSets = new ArrayList<>();
        joinThreesAtSameXPos();
        sortThrees();
        defineOptimalSets();

    }

    private void joinThreesAtSameXPos(){
        for (Three three : threeArray) {
            if(!threesAtSameX.containsKey(three.getX())){
                threesAtSameX.put(three.getX(),new ThreesAtSameX());
                positions.add(three.getX());
            }
            threesAtSameX.get(three.getX()).getThrees().add(three);
        }
    }

    private void sortThrees(){
        positions.sort(new AscendantSort());
        SortByDepth sortByDepth = new SortByDepth();
        for(Integer position: positions){
            threesAtSameX.get(position).getThrees().sort(sortByDepth);
        }
    }

    private double getThreesMaxHeightAt(int index){
        return (getThreesAt(index).getThrees().get(0).getHeight());
    }

    private double getThreesMinHeightAt(int index){
        ArrayList<Three> threes = getThreesAt(index).getThrees();
        return threes.get(threes.size()-1).getHeight();
    }

    private int getDistanceBetweenThrees(int index1, int index2){
        return positions.get(index2) - positions.get(index1);
    }

    private ThreesAtSameX getThreesAt(int index){
        return threesAtSameX.get(positions.get(index));
    }

    private void defineOptimalSets(){
        int positionsLenght = positions.size();
        for(int subThrees = 0; subThrees < positionsLenght; subThrees++){
            OptimalThreeSet actualSet = new OptimalThreeSet(getThreesAt(subThrees));
            optimalSets.add(actualSet);
            int previousOptimalSubThrees = subThrees;
            double previousOptimalHeight = getThreesMaxHeightAt(previousOptimalSubThrees);
            for(int nextSubThrees = subThrees+1; nextSubThrees < positionsLenght; nextSubThrees++){
                int distanceBetweenThrees = getDistanceBetweenThrees(previousOptimalSubThrees, nextSubThrees);
                double nextSubThreesHeight = getThreesMinHeightAt(nextSubThrees);
                if( previousOptimalHeight < (distanceBetweenThrees+nextSubThreesHeight)){
                    actualSet.add(getThreesAt(nextSubThrees));
                    previousOptimalSubThrees = nextSubThrees;
                    previousOptimalHeight = getThreesMaxHeightAt(nextSubThrees);
                }
            }
        }
    }

    private OptimalThreeSet getBestOptimal(){
        int bestIndex = 0;
        double actualBest = optimalSets.get(0).scoreAsig();
        for (int actual = 1; actual < optimalSets.size(); actual ++){
            double actualCompared = optimalSets.get(actual).scoreAsig();
            if (actualBest < actualCompared){
                actualBest = actualCompared;
                bestIndex = actual;
            }
        }
        return optimalSets.get(bestIndex);
    }

    public void printOptimalSets(){
        for (OptimalThreeSet threeSet : optimalSets){
            System.out.println(threeSet);
        }
    }

}