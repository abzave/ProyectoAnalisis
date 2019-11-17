package planning;

import control.Ant;
import javafx.collections.transformation.SortedList;
import lib.IConstants;

import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeSet;

/**
 * Class to create de planification for the work that will be done by the ants.
 */
public class ProbabilisticPlanning {

    private ArrayList<Double> probabilities;
    private ArrayList<Integer> leafsAmount;
    private ArrayList<Integer> distances;
    private Random random = new Random();
    private double recollectionPercentage;

    /**
     * Constructor of the class.
     *
     * @param pLeafsAmount leaf quantity of the trees.
     * @param pDistances   distance of trees from the anthill (hormiguero).
     * @param pRecollectionPercentage  leaf collection percentage.
     */
    public ProbabilisticPlanning(ArrayList<Integer> pLeafsAmount, ArrayList<Integer> pDistances,
                                 double pRecollectionPercentage){
        leafsAmount = pLeafsAmount;
        recollectionPercentage = pRecollectionPercentage;
        distances = pDistances;
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
        return (int)(leafsAmount.get(tree) * recollectionPercentage);
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
     * @param time timing of the planification.
     * @return an ArrayList of ants packages.
     */
    public ArrayList<AntPack> plan(double time){
        ArrayList<AntPack> antPacks = new ArrayList<>();
        TreeSet<AntPack> reuseQueue = new TreeSet<>();
        double planningTime = time * IConstants.PLANNING_TIME;
        double totalTime = 0;
        int currentTimeUnit = 0;
        int ants;
        AntPack pack;
        while (time > 0 && planningTime > totalTime){
            long startMoment = System.nanoTime();
            int tree = selectTree();
            if (reuseQueue.size() > 0 && reuseQueue.first().getLastArriveTime() <= currentTimeUnit){
                pack = reuseQueue.first();
                ants = reusePack(pack, tree, currentTimeUnit, time);
                reuseQueue.remove(pack);
            }else {
                ants = 0;
                pack = createPack(tree, time, currentTimeUnit);
                if (pack != null){
                    antPacks.add(pack);
                    ants = pack.getAmount();
                }
            }
            reuseQueue.add(pack);
            currentTimeUnit += ants;
            time -= ants * (double)IConstants.ANT_MAX_SPEED;
            reduceLeafs(tree, ants);
            calculateProbabilities();
            double elapsedTime = (System.nanoTime() - startMoment) / IConstants.NANOSECONDS_TO_SECONDS_FACTOR;
            time -= elapsedTime;
            totalTime += elapsedTime;
        }
        return antPacks;
    }

    /**
     * Function for the reusing of a pack of ants.
     *
     * @param pack an object of ant package.
     * @param tree index of a tree.
     * @param currentTimeUnit ??.
     * @param time timing of the planification.
     * @return index of an ant package.
     */
    private int reusePack(AntPack pack, int tree, int currentTimeUnit, double time){
        int ants;
        if(pack.calculateRoadTime(distances.get(tree)) * (double)IConstants.ANT_MAX_SPEED < time){
            ants = pack.getAmount();
            pack.reuse(currentTimeUnit, tree, distances.get(tree));
        }else{
            ants = 0;
        }
        return ants;
    }

    /**
     * Function to create an ant package.
     *
     * @param tree index position of a tree.
     * @param time correspondent time for the ant pack.
     * @param currentTimeUnit ??.
     * @return an object AntPack.
     */
    private AntPack createPack(int tree, double time, int currentTimeUnit){
        int ants = getAntsToSend(tree);
        if (ants * IConstants.ANT_MAX_SPEED > time) {
            ants = (int) (time * 1000);
            time = 0;
        }
        AntPack pack = new AntPack(ants, currentTimeUnit, tree, distances.get(tree));
        if(pack.calculateRoadTime(distances.get(tree)) * (double)IConstants.ANT_MAX_SPEED > time){
            return null;
        }
        return pack;
    }

}
