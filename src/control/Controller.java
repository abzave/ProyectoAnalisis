package control;

import java.util.ArrayList;

public class Controller {

    private ArrayList<Three> threes;
    private ArrayList<Ant> ants;

    public Controller(){
        threes = new ArrayList<>();
        ants = new ArrayList<>();
    }

    public ArrayList<Three> getThrees() {
        return threes;
    }

    public ArrayList<Ant> getAnts() {
        return ants;
    }

    public void addThree(Three pThree){
        threes.add(pThree);
    }

    public void addAnt(Ant pAnt){
        ants.add(pAnt);
    }
}
