package ui;

import lib.IConstants;
import ui.Drawable;

import java.awt.*;

public class Ant extends Drawable {


    public Ant(int pX, int pWidth, int pHeight) {
        super(pX, pWidth, pHeight);
        y = IConstants.GRASS_Y_POS - pHeight;
    }

    @Override
    public void paint(Graphics2D g) {
        g.fillOval(x, y, width, height);
    }
}
