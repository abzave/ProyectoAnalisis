package ui;

import control.Three;
import lib.IConstants;
import ui.Drawable;

import java.awt.*;

public class DrawableAnt extends Drawable {

    private DrawableThree target;
    private boolean going = true;
    private boolean reduced = false;

    public DrawableAnt(int pX, int pWidth, int pHeight, DrawableThree pTarget) {
        super(pX, pWidth, pHeight);
        y = IConstants.GRASS_Y_POS - pHeight;
        target = pTarget;
    }

    @Override
    public void paint(Graphics2D g) {
        g.fillOval(x, y, width, height);
    }

    public void move(){
        if(going) {
            x -= IConstants.ANT_MAX_SPEED;
            if(x < target.getX()){
                going = false;
            }
        }else if (x < IConstants.WINDOW_WIDTH){
            x += IConstants.ANT_MAX_SPEED;
        }
    }

    public boolean getGoing(){
        return going;
    }

    public void setReduced(boolean pReduced){
        reduced = pReduced;
    }

    public boolean isReduced() {
        return reduced;
    }
}
