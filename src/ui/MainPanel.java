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
        g.setColor(THREE_COLOR);
        for (Three three : threes){
            three.paint(g);
        }
        g.setColor(ANT_COLOR);
        for (Ant ant: ants){
            ant.paint(g);
        }
        g.setColor(oldColor);
    }
}
