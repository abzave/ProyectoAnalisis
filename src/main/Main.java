package main;

import common.TestGenerator;
import common.TestTree;
import control.Controller;
import control.Result;
import greedyPlaning.Planner;
import lib.IConstants;
import planning.*;
import ui.DrawableThree;
import ui.MainFrame;
import ui.TreeScale;

import java.io.*;
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

    private static ArrayList<Result> greedyPlanning(ArrayList<Three> pThreeList){
        return new Planner(pThreeList).getPlanningResult();
    }

    private static ArrayList<Result> probabilisticPlanningR(ArrayList<Three> pThreeList){
        ProbabilisticPlanning probabilisticPlan = new ProbabilisticPlanning(pThreeList);
        ArrayList<AntPack> packs = probabilisticPlan.plan((double)IConstants.TOTAL_TIME);
        ArrayList<Result> results = probabilisticPlan.getResultsFromAntPacks(packs);
        return results;
    }


    private static void printResults(ArrayList<Result> pGreedyResults, ArrayList<Result> pProbabilisticResults){
        try (PrintWriter writer = new PrintWriter(new File("results.csv"))) {

            StringBuilder sb = new StringBuilder();
            sb.append("type,");
            sb.append("time,");
            sb.append("count");
            sb.append('\n');

            //adding the greedyresults
            for(Result thisResult: pGreedyResults) {
                sb.append("greedy");
                sb.append(',');
                sb.append(String.valueOf((int)thisResult.getBeginTime()));
                sb.append(',');
                sb.append(String.valueOf(thisResult.getTotalAnts()));
                sb.append('\n');
            }

            //adding the probabilisticResults
            for(Result thisResult: pProbabilisticResults) {
                sb.append("probabilistic");
                sb.append(',');
                sb.append(String.valueOf((int)thisResult.getBeginTime()));
                sb.append(',');
                sb.append(String.valueOf(thisResult.getTotalAnts()));
                sb.append('\n');
            }

            writer.write(sb.toString());

            System.out.println("done!");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
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
        ArrayList<Three> threesToPlan = generateRandomThrees(500);
        ArrayList<Result> greedyResults = greedyPlanning(threesToPlan);
        ArrayList<Result> probabilisticResults = probabilisticPlanningR(threesToPlan);
        printResults(greedyResults, probabilisticResults);



        //Hace falta implementar un metodo que compare los dos resultados por cada pack y solo muestre el mejor



        //new MainFrame(new Controller(greedyResults));
    }
}
