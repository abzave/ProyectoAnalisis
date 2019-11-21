package main;

import common.TestGenerator;
import common.TestTree;
import control.Controller;
import ui.DrawableThree;
import ui.MainFrame;
import ui.TreeScale;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TestGenerator generator = new TestGenerator();
        ArrayList<TestTree>[] tests = generator.getTests();
        Controller controller = new Controller();
        TreeScale scaledTrees = new TreeScale(tests[0]);
        for(TestTree tree : scaledTrees.getScaledTrees()){
            controller.getDrawableThrees().add(new DrawableThree(tree.getPosX(), 20, tree.getLength(), tree.getLevels()));
        }
        new MainFrame(controller);
    }
}
