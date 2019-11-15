package control;

public class Three extends Positionable {

    private int depth;
    private int leavesCount;

    public Three(int pX, int pY, int pDepth) {
        super(pX, pY);
        depth = pDepth;
        leavesCount = (int)Math.pow(2,pDepth-1);
    }
}
