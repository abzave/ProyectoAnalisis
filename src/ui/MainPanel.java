package ui;

import lib.IConstants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainPanel extends JPanel implements IConstants {

    private ArrayList<DrawableThree> threes;
    private ArrayList<Ant> ants;
    private BufferedImage grassImage;
    private BufferedImage groundImage;

    public MainPanel(ArrayList<DrawableThree> pThrees, ArrayList<Ant> pAnts){
        threes = pThrees;
        ants = pAnts;
        try {
            grassImage = ImageIO.read(new File("assets/grass.png"));
            groundImage = ImageIO.read(new File("assets/ground.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Color oldColor = g.getColor();
        Graphics2D g2d = (Graphics2D) g;
        int grassWidth = grassImage.getWidth();
        for(int grassPos = 0; grassPos < WINDOW_WIDTH; grassPos+= grassWidth){
            g.drawImage(grassImage, grassPos, GRASS_Y_POS, this);
        }
        int groundYPos = GRASS_Y_POS+grassWidth;
        for(; groundYPos < WINDOW_HEIGHT; groundYPos+=grassWidth) {
            int groundXPos = 0;
            for (; groundXPos < WINDOW_WIDTH; groundXPos += grassWidth) {
                g.drawImage(groundImage, groundXPos, groundYPos, this);
            }
        }
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (DrawableThree three : threes){
            three.paint(g2d);
        }
        g.setColor(ANT_COLOR);
        for (Ant ant: ants){
            ant.paint(g2d);
        }
        g.setColor(oldColor);
    }
}
