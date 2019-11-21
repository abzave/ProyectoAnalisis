package greedyPlaning;

import control.Three;

import java.util.ArrayList;

public class ThreesAtSameX {

    private ArrayList<Three> threes;

    public ThreesAtSameX(){ threes = new ArrayList<>(); }

    public ArrayList<Three> getThrees() {
        return threes;
    }



    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder("ThreesAtSameX:{\n");
        for(Three three : threes){
            ret.append("\t\t").append(three).append("\n");
        }
        return ret.append("\t}").toString();
    }
}
