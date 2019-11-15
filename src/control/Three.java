package control;

import greedyPlaning.Calculator;
import lib.IConstants;

public class Three extends Positionable {

    private int leavesCount;
    private double distance;

    public Three(int pX, int pY, int pDepth) {
        super(pX, pY);
        leavesCount = (int)Math.pow(2,pDepth-1);
        distance = IConstants.ANTHILL_X_POS-x + Calculator.getThreeLenght(pDepth);
    }

    public double getDistance() {
        return distance;
    }

    public int getLeavesCount() {
        return leavesCount;
    }

    public int getX(){
        return x;
    }
}
