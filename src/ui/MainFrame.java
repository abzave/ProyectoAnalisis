package ui;

import control.Controller;
import lib.IConstants;

import javax.swing.*;

public class MainFrame extends JFrame implements IConstants {

    private MainPanel mainPanel;
    private Controller controller;

    public MainFrame(Controller pController){
        super(WINDOW_TITLE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        controller = pController;
        mainPanel = new MainPanel(controller.getThrees(), controller.getAnts());
        setContentPane(mainPanel);
        setVisible(true);
    }

}
