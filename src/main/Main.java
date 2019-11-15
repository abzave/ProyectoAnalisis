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
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        a.add(34561);
        a.add(59795);
        a.add(93475);
        a.add(61824);
        a.add(86870);
        a.add(63411);
        a.add(37903);
        a.add(89295);
        a.add(87220);
        a.add(78145);
        b.add(2865);
        b.add(2639);
        b.add(1202);
        b.add(2872);
        b.add(812);
        b.add(2791);
        b.add(337);
        b.add(487);
        b.add(2281);
        b.add(423);
        new ProbabilisticPlanning(a, b, 0.0001).plan(60);
    }
}
