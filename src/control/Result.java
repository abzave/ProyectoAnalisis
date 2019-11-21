package control;

public class Result {

    private int totalAnts;
    private Three three;

    public Result(Three pThree, int pTotalAnts){
        three = pThree;
        totalAnts = pTotalAnts;
    }

    public int getTotalAnts() {
        return totalAnts;
    }

    public Three getThree() {
        return three;
    }
}
