package planning;

import java.util.ArrayList;

public class ProbabilisticPlanning {

    private ArrayList<Double> probabilities = new ArrayList<>();
    private ArrayList<Integer> leavesAmount;

    public ProbabilisticPlanning(ArrayList<Integer> pLeavesAmount, ArrayList<Integer> pDistances,
                                 int pRecollectionPercentage){
        leavesAmount = pLeavesAmount;
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

}
