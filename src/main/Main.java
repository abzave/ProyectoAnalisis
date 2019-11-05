package main;

import control.Ant;
import control.Controller;
import control.Three;
import ui.MainFrame;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.addThree(new Three(270, 600, 20, 20, 9));
        controller.addThree(new Three(700, 600, 20, 20, 7));
        controller.addThree(new Three(1000, 600, 20, 20, 6));
        controller.addAnt(new Ant(1200,580,40,20));
        new MainFrame(controller);
    }
}
