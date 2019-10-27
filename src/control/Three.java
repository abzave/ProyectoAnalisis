package control;

import lib.IConstants;
import ui.Drawable;

import java.awt.*;

public class Three extends Drawable {

    private int depth;

    public Three(int pX, int pY, int pWidth, int pHeight, int pDepth) {
        super(pX, pY, pWidth, pHeight);
        depth = pDepth;
    }

    private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
        if (depth == 0) return;
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 10.0);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * 10.0);
        g.drawLine(x1, y1, x2, y2);
        drawTree(g, x2, y2, angle - 20, depth - 1);
        drawTree(g, x2, y2, angle + 20, depth - 1);
    }

    @Override
    public void paint(Graphics g) {
        drawTree(g, x, y, IConstants.THREE_ANGLE, depth);
    }
}
