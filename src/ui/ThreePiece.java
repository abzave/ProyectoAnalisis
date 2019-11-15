package ui;

import java.awt.*;

public abstract class ThreePiece {

    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private BasicStroke stroke;

    public ThreePiece(int x1, int x2, int y1, int y2, BasicStroke stroke) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.stroke = stroke;
    }

    public void paint(Graphics2D g){
        g.setStroke(stroke);
        g.drawLine(x1, y1, x2, y2);
    }
}
