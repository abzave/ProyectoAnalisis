package greedyPlaning;


import control.Three;

import java.util.ArrayList;

public class OptimalThreeSet {

    public ArrayList<ThreesAtSameX> set;
    public double score;

    public OptimalThreeSet(ThreesAtSameX threesAtSameX){
        set = new ArrayList<>();
        set.add(threesAtSameX);
    }

    public ArrayList<ThreesAtSameX> getSet() {
        return set;
    }

    public void add(ThreesAtSameX threesAtSameX){
        set.add(threesAtSameX);
    }

    public double getScore(){ return score; }

    private int countLeavesPerSameX(int pIndex){
        int total = 0;
        for (Three ActualThree: set.get(pIndex).getThrees()){
            total += ActualThree.getLeavesCount();
        }
        return total;
    }

    private int countTotalLeaves(){
        int leaves = 0;
        for(int setOfThrees = 0; setOfThrees < set.size(); setOfThrees++){
            leaves += countLeavesPerSameX(setOfThrees);
        }
        return leaves;
    }

    private int distLastFirst(){
        int lastDistance = set.get(set.size()-1).getThrees().get(0).getX();
        int firstDistance = set.get(0).getThrees().get(0).getX();
        return lastDistance-firstDistance;
    }


    public void scoreAsig(){
        if(distLastFirst()!=0){
            score = (double)countTotalLeaves()/(double)distLastFirst();
        }else{
            score = 0;
        }

    }

    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder("OptimalSet:{\n");
        for(ThreesAtSameX threesAtSameX : set){
            ret.append("\t").append(threesAtSameX).append("\n");
        }
        return ret.append('}').toString();
    }
}
