package main;

import ui.Ant;
import control.Controller;
import ui.DrawableThree;
import ui.MainFrame;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.addThree(new DrawableThree(270, 20, 20, 1));
        controller.addAnt(new Ant(1200,40,20));
        new MainFrame(controller);
    }
}
