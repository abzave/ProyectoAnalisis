package main;

import control.Ant;
import control.Controller;
import control.Three;
import ui.MainFrame;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.addThree(new Three(400, 600, 20, 20, 10));
        controller.addAnt(new Ant(600,600,40,20));
        new MainFrame(controller);
    }
}
