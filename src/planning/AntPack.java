package planning;

import lib.IConstants;

import javax.swing.*;
import java.util.ArrayList;

public class AntPack implements Comparable{

    private int amount;
    private ArrayList<Integer> startTimes = new ArrayList<>();
    private ArrayList<Integer> arriveUnits = new ArrayList<>();
    private ArrayList<Integer> trees = new ArrayList<>();
    private ArrayList<Integer> distances = new ArrayList<>();

    public AntPack(int pAmount, int pStartTime, int pTree, int pDistance){
        amount = pAmount;
        reuse(pStartTime, pTree, pDistance);
    }

    public int getAmount(){
        return amount;
    }

    public int getStartTime(int index){
        return startTimes.get(index);
    }

    public int getTree(int index){
        return trees.get(index);
    }

    public int getLastArriveTime(){
        return arriveUnits.get(arriveUnits.size() - 1);
    }

    public void reuse(int pStartTime, int pTree, int pDistance){
        startTimes.add(pStartTime);
        trees.add(pTree);
        distances.add(pDistance);
        arriveUnits.add(pStartTime + (int)(pDistance / IConstants.ANT_MAX_SPEED) * amount);
    }

    @Override
    public int compareTo(Object o) {
        return getLastArriveTime() - ((AntPack)o).getLastArriveTime();
    }
}
