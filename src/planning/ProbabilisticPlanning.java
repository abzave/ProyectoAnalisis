package planning;

import control.Ant;
import javafx.collections.transformation.SortedList;
import lib.IConstants;

import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeSet;

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
