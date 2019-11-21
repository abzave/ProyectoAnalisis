package main;

import common.TestGenerator;
import common.TestTree;
import control.Controller;
import control.Result;
import greedyPlaning.Planner;
import ui.DrawableThree;
import ui.MainFrame;
import ui.TreeScale;

import java.util.ArrayList;

import control.Three;
import util.Randoms;


public class Main {

    private static ArrayList<Three> generateRandomThrees(int pAmountThree){
        ArrayList<Three> threes = new ArrayList<>();
        for(int three = 0; three < pAmountThree; three++){
            threes.add(new Three(Randoms.randInt(0, 20), Randoms.randInt(2, 8)));
        }
        return threes;
    }

    private static void greedyPlanning(){
        Planner planner = new Planner(generateRandomThrees(200));
        ArrayList<Result> results = planner.getPlanningResult();
        for(Result result : results){
            System.out.println(result.getTotalAnts());
        }
    }

    public static void main(String[] args) {
//        TestGenerator generator = new TestGenerator();
//        ArrayList<TestTree>[] tests = generator.getTests();
//        Controller controller = new Controller();
//        TreeScale scaledTrees = new TreeScale(tests[0]);
//        for(TestTree tree : scaledTrees.getScaledTrees()){
//            controller.getDrawableThrees().add(new DrawableThree(tree.getPosX(), 20, tree.getLength(), tree.getLevels()));
//        }
//        new MainFrame(controller);
        greedyPlanning();
    }
}
