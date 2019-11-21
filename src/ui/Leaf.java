package ui;

import lib.IConstants;

import java.awt.*;

public class Leaf extends ThreePiece{

    private boolean recollected = false;

    public Leaf(int x1, int x2, int y1, int y2, BasicStroke stroke) {
        super(x1, x2, y1, y2, stroke);
    }

    public boolean isRecollected(){
        return recollected;
    }

    public void recollect(){
        recollected = true;
    }

}
