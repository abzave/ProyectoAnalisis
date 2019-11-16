package control;

import greedyPlaning.Calculator;
import lib.IConstants;

public class Three extends Positionable {

    private int depth;
    private int leavesCount;
    private double heigh;

    public Three(int pX, int pDepth) {
        super(pX);
        depth = pDepth;
        leavesCount = (int)Math.pow(2,pDepth-1);
        heigh = Calculator.getThreeLenght(pDepth);
    }

    public double getheigh() {
        return heigh;
    }

    public int getLeavesCount() {
        return leavesCount;
    }

    public int getX(){
        return x;
    }

    public int getDepth() {
        return depth;
    }
}
