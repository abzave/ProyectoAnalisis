package main;

import control.Ant;
import control.Controller;
import control.Three;
import planning.ProbabilisticPlanning;
import ui.MainFrame;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.addThree(new Three(270, 20, 20, 9));
        controller.addThree(new Three(700, 20, 20, 7));
        controller.addThree(new Three(1000, 20, 20, 6));
        controller.addAnt(new Ant(1200,40,20));
        new MainFrame(controller);
    }
}
