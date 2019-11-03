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

    private void drawTree(Graphics2D g, int x1, int y1, double angle, int depth) {
        if (depth == 0) return;
        g.setColor(IConstants.THREE_COLOR);
        if (depth == 1){
            g.setColor(IConstants.LEAVES_COLOR);
        }
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * IConstants.THREE_GROWING_FACTOR);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * IConstants.THREE_GROWING_FACTOR);
        g.setStroke(new BasicStroke(IConstants.THREE_STROKE_WIDTH_FACTOR * depth));
        g.drawLine(x1, y1, x2, y2);
        drawTree(g, x2, y2, angle - IConstants.THREE_BRANCH_ANGLE, depth - 1);
        drawTree(g, x2, y2, angle + IConstants.THREE_BRANCH_ANGLE, depth - 1);
    }

    @Override
    public void paint(Graphics2D g) {
        drawTree(g, x, y, IConstants.THREE_ROTATION, depth);
    }
}
