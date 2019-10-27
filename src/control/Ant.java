package control;

import ui.Drawable;

import java.awt.*;

public class Ant extends Drawable {


    public Ant(int pX, int pY, int pWidth, int pHeight) {
        super(pX, pY, pWidth, pHeight);
    }

    @Override
    public void paint(Graphics g) {
        g.fillOval(x, y, width, height);
    }
}
