package greedyPlaning;

import control.Three;

import java.util.ArrayList;

import static lib.IConstants.ANT_MAX_SPEED;
import static lib.IConstants.ANT_SIZE;

public class OptimalThreeSet {

    public ArrayList<ThreesAtSameX> set;

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


    public double scoreAsig(){
        if(distLastFirst()==0){
            return (double)countTotalLeaves()/1;
        }else{
            return (double)countTotalLeaves()/(double)distLastFirst();
        }
    }

    public double timeToRecolect(){
        double time = 0;
        ArrayList<Three> threesAtSameX = set.get(set.size()-1).getThrees();
        double lastThreeHeight = threesAtSameX.get(threesAtSameX.size()-1).getHeight();
        double lastThreeX = (double)threesAtSameX.get(0).getX();
        double totalAntLenght = (double)ANT_SIZE * (double)countTotalLeaves();
        time = (lastThreeHeight + lastThreeX + totalAntLenght)/(double)ANT_MAX_SPEED;
        return time;
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
