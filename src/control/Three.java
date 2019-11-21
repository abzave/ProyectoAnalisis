package control;

import greedyPlaning.Calculator;

public class Three extends Positionable {

    private int depth;
    private int leavesCount;
    private double height;

    public Three(int pX, int pDepth) {
        super(pX);
        depth = pDepth;
        leavesCount = (int)Math.pow(2,pDepth-1);
        height = Calculator.getThreeLenght(pDepth);
    }

    public double getHeight() {
        return height;
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

    @Override
    public String toString(){
        return "Three:{x: "+x+", depth: "+depth+"}";
    }
}
