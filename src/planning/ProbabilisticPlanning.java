package planning;

import java.util.ArrayList;
import java.util.Random;

public class ProbabilisticPlanning {

    private ArrayList<Double> probabilities = new ArrayList<>();
    private ArrayList<Integer> leavesAmount;
    private Random random = new Random();
    private double recollectionPercentage;

    public ProbabilisticPlanning(ArrayList<Integer> pLeavesAmount, ArrayList<Integer> pDistances,
                                 double pRecollectionPercentage){
        leavesAmount = pLeavesAmount;
        recollectionPercentage = pRecollectionPercentage;
        calculateProbabilities(pDistances);
    }

    private void calculateProbabilities(ArrayList<Integer> pDistances){
        int total = 0;
        for(int tree = 0; tree < pDistances.size(); tree++){
            double ratio = (double)leavesAmount.get(tree) / pDistances.get(tree);
            probabilities.add(ratio);
            total += ratio;
        }
        for(int tree = 0; tree < pDistances.size(); tree++){
            double probability = probabilities.get(tree) / total;
            probabilities.set(tree, probability);
            System.out.println(probability);
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
        return (int)(leavesAmount.get(tree) * recollectionPercentage);
    }

}
