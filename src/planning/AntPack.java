package planning;

import control.Result;
import control.Three;
import lib.IConstants;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Class to represent an ant package.
 */
public class AntPack implements Comparable{

    private int amount;
    private ArrayList<Integer> startTimes = new ArrayList<>();
    private ArrayList<Integer> arriveUnits = new ArrayList<>();
    private ArrayList<Integer> trees = new ArrayList<>();
    private ArrayList<Integer> distances = new ArrayList<>();

    /**
     * Constructor of the class.
     *
     * @param pAmount amount of ants.
     * @param pStartTime start time of the package work.
     * @param pTree index position of a tree.
     * @param pDistance distance of the travel.
     */
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

    /**
     * Funtion to reuse an ant package.
     *
     * @param pStartTime  start time of the package work.
     * @param pTree index position of a tree.
     * @param pDistance distance of the travel.
     */
    public void reuse(int pStartTime, int pTree, int pDistance){
        startTimes.add(pStartTime);
        trees.add(pTree);
        distances.add(pDistance);
        arriveUnits.add(pStartTime + calculateRoadTime(pDistance));
    }

    /**
     * Funtion to calculate the time of the travel, based in the distance and  the max speed of the ants.
     *
     * @param pDistance distance of the travel.
     * @return the time for the travel.
     */
    public int calculateRoadTime(int pDistance){
        return (int)(pDistance / IConstants.ANT_MAX_SPEED) * amount;
    }

    @Override
    public int compareTo(Object o) {
        return getLastArriveTime() - ((AntPack)o).getLastArriveTime();
    }

    public Result translateToResult(ArrayList<Three> threes){
        return new Result(threes.get(trees.get(0)), amount, startTimes.get(0));
    }
}
