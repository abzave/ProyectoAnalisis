package ui;

import java.awt.*;

public abstract class Drawable {

    protected int x;
    protected int y;
    protected int width;
    protected int height;

    public Drawable(int pX, int pY, int pWidth, int pHeight){
        x = pX;
        y = pY;
        width = pWidth;
        height = pHeight;
    }

    public void paint(Graphics g) {

    }
}
