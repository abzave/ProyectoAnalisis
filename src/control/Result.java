package control;

public class Result {

    private int totalAnts;
    private double beginTime;
    private Three three;

    public Result(Three pThree, int pTotalAnts, double pBeginTime){
        three = pThree;
        totalAnts = pTotalAnts;
        beginTime = pBeginTime;
    }

    public int getTotalAnts() {
        return totalAnts;
    }

    public Three getThree() {
        return three;
    }

    public double getBeginTime() {
        return beginTime;
    }
}
