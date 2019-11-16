package greedyPlaning;


import java.util.ArrayList;

public class ThreeSet {

    public ArrayList<ThreesAtSameX> set;

    public ThreeSet(ThreesAtSameX threesAtSameX){
        set = new ArrayList<>();
        set.add(threesAtSameX);
    }

    public ArrayList<ThreesAtSameX> getSet() {
        return set;
    }

    public void add(ThreesAtSameX threesAtSameX){
        set.add(threesAtSameX);
    }

    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder("OptimalSet:{\n");
        for(ThreesAtSameX threesAtSameX : set){
            ret.append("\t").append(threesAtSameX).append("\n");
        }
        return ret.append('}').toString();
    }
}
