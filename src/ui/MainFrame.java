package ui;

import control.Controller;
import lib.IConstants;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements IConstants {

    private MainPanel mainPanel;
    private Controller controller;
    private JLabel timeLabel;

    public MainFrame(Controller pController){
        super(WINDOW_TITLE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        controller = pController;
        mainPanel = new MainPanel(controller.getDrawableThrees(), controller.getDrawableAnts());
        controller.setUI(this, mainPanel);
        setContentPane(mainPanel);
        setLayout(null);
        setVisible(true);
        initComponents();
        controller.start();
    }

    public void setTime(int time){
        timeLabel.setText(String.valueOf(time));
    }

    private void initComponents(){
        JButton reignButton = new JButton("Reign");
        Insets insets = getInsets();
        reignButton.setBounds(getWidth()-200-insets.right*2,getHeight()-100-insets.top-insets.bottom, 200, 100);
        reignButton.setBackground(BUTTON_BACKGROUND);
        reignButton.setSelected(false);
        reignButton.setFocusPainted(false);
        add(reignButton);
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        timeLabel.setBounds(getWidth()-80-insets.right*2,0, 100, 50);
        add(timeLabel);
        setVisible(true);
    }

}
