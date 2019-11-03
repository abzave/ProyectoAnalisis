package ui;

import control.Ant;
import control.Three;
import lib.IConstants;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainPanel extends JPanel implements IConstants {

    private ArrayList<Three> threes;
    private ArrayList<Ant> ants;

    public MainPanel(ArrayList<Three> pThrees, ArrayList<Ant> pAnts){
        threes = pThrees;
        ants = pAnts;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Color oldColor = g.getColor();
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (Three three : threes){
            three.paint(g2d);
        }
        g.setColor(ANT_COLOR);
        for (Ant ant: ants){
            ant.paint(g2d);
        }
        g.setColor(oldColor);
    }
}
