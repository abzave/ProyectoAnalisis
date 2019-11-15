package planning;

import lib.IConstants;

import java.util.ArrayList;
import java.util.Random;

public class ProbabilisticPlanning {

    private ArrayList<Double> probabilities;
    private ArrayList<Integer> leafsAmount;
    private ArrayList<Integer> distances;
    private Random random = new Random();
    private double recollectionPercentage;

    public ProbabilisticPlanning(ArrayList<Integer> pLeafsAmount, ArrayList<Integer> pDistances,
                                 double pRecollectionPercentage){
        leafsAmount = pLeafsAmount;
        recollectionPercentage = pRecollectionPercentage;
        distances = pDistances;
        calculateProbabilities();
    }

    private void calculateProbabilities(){
        probabilities = new ArrayList<>();
        double total = 0;
        for(int tree = 0; tree < distances.size(); tree++){
            double ratio = (double)leafsAmount.get(tree) / distances.get(tree);
            probabilities.add(ratio);
            total += ratio;
        }
        for(int tree = 0; tree < distances.size(); tree++){
            double probability = probabilities.get(tree) / total;
            probabilities.set(tree, probability);
        }
    }

    private int selectTree(){
        for(int tree = 0; tree < probabilities.size(); tree++){
            if(random.nextDouble() < probabilities.get(tree)){
                return tree;
            }
        }
        return 0;
    }

    private int getAntsToSend(int tree){
        return (int)(leafsAmount.get(tree) * recollectionPercentage);
    }

    private void reduceLeafs(int pTree, int pAmount){
        int currentLeafs = leafsAmount.get(pTree);
        leafsAmount.set(pTree, currentLeafs - pAmount);
    }

    public void plan(double time){
        double planningTime = time * IConstants.PLANNING_TIME;
        double totalTime = 0;
        while (time > 0 && planningTime > totalTime){
            long startMoment = System.nanoTime();
            int tree = selectTree();
            int ants = getAntsToSend(tree);
            if (ants * 0.001 > time){
                ants = (int)(time * 1000);
                time = 0;
            }
            reduceLeafs(tree, ants);
            calculateProbabilities();
            time -= (ants * 0.001);
            double elapsedTime = (System.nanoTime() - startMoment) / IConstants.NANOSECONDS_TO_SECONDS_FACTOR;
            time -= elapsedTime;
            totalTime += elapsedTime;
        }
    }

}
