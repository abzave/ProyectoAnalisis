package planning;

import control.Result;
import control.Three;
import lib.IConstants;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

/**
 * Class to create de planification for the work that will be done by the ants.
 */
public class ProbabilisticPlanning {

    private ArrayList<Double> probabilities;
    private ArrayList<Integer> leafsAmount = new ArrayList<>();
    private ArrayList<Integer> distances = new ArrayList<>();
    private ArrayList<Three> threes;
    private Random random = new Random();

    public ProbabilisticPlanning(ArrayList<Three> pThrees){
        threes = pThrees;
        for(Three three : threes){
            leafsAmount.add(three.getLeavesCount());
            distances.add(2 * ((int)three.getHeight() + three.getX()));
        }
        calculateProbabilities();
    }

    /**
     * Function for the calculation of the probabilities for the trees.
     */
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

    /**
     * Function to select a tree in the ArrayList of trees.
     *
     * @return the index position of the tree selected.
     */
    private int selectTree(){
        for(int tree = 0; tree < probabilities.size(); tree++){
            if(random.nextDouble() < probabilities.get(tree)){
                return tree;
            }
        }
        return 0;
    }

    /**
     *Funtion to get the ants that will be selected to get the leafs of a tree.
     *
     * @param tree  index position of a tree.
     * @return an amount of ants.
     */
    private int getAntsToSend(int tree){
        return (int)Math.ceil(leafsAmount.get(tree) * Math.max(probabilities.get(tree), IConstants.PERCENTAGE_OF_LEAVES));
    }

    /**
     * Function to reduce the leafs of a tree.
     *
     * @param pTree index position of a tree.
     * @param pAmount amount of leafs to be reduced.
     */
    private void reduceLeafs(int pTree, int pAmount){
        int currentLeafs = leafsAmount.get(pTree);
        leafsAmount.set(pTree, currentLeafs - pAmount);
    }

    /**
     * Function to create the planification.
     *
     * @return an ArrayList of ants packages.
     */
    public ArrayList<AntPack> plan(){
        ArrayList<AntPack> antPacks = new ArrayList<>();
        TreeSet<AntPack> reuseQueue = new TreeSet<>();
        double time = IConstants.TOTAL_TIME;
        int ants;
        long antsLeft = IConstants.ANTS_LEFT;
        AntPack pack;
        while (time > 0 && antsLeft > 0){
            int tree = selectTree();
            pack = createPack(tree, time);
            if (canReuse(reuseQueue, time) && leafsAmount.get(tree) >= reuseQueue.first().getAmount() && pack != null){
                ants = pack.getAmount();
                reuseQueue.remove(pack);
            }else {
                ants = 0;
                if (pack != null){
                    ants = pack.getAmount();
                    antsLeft -= ants;
                }
            }
            if(pack != null) {
                antPacks.add(pack);
                reuseQueue.add(pack);
            }
            time -= ants / IConstants.ANT_MAX_SPEED;
            reduceLeafs(tree, ants);
            calculateProbabilities();
        }
        return antPacks;
    }

    private boolean canReuse(TreeSet<AntPack> reuseQueue, double time){
        int currentTimeUnit = (int)(IConstants.TOTAL_TIME - time);
        return reuseQueue.size() > 0 && reuseQueue.first().getLastArriveTime() <= currentTimeUnit;
    }

    public ArrayList<Result> getResultsFromAntPacks(ArrayList<AntPack> packs){
        ArrayList<Result> results = new ArrayList<>();
        for(AntPack pack : packs){
            results.add(pack.translateToResult(threes));
        }
        return results;
    }

    /**
     * Function to create an ant package.
     *
     * @param tree index position of a tree.
     * @param time correspondent time for the ant pack.
     * @return an object AntPack.
     */
    private AntPack createPack(int tree, double time){
        int ants = getAntsToSend(tree);
        if(ants == 0){
            return null;
        }
        int currentTime = (int)(IConstants.TOTAL_TIME - time);
        return new AntPack(ants, currentTime, tree, distances.get(tree));
    }

}
