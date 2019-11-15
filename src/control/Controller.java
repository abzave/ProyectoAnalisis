package control;

import ui.Ant;
import ui.DrawableThree;

import java.util.ArrayList;

public class Controller {

    private ArrayList<DrawableThree> threes;
    private ArrayList<Ant> ants;

    public Controller(){
        threes = new ArrayList<>();
        ants = new ArrayList<>();
    }

    public ArrayList<DrawableThree> getThrees() {
        return threes;
    }

    public ArrayList<Ant> getAnts() {
        return ants;
    }

    public void addThree(DrawableThree pThree){
        threes.add(pThree);
    }

    public void addAnt(Ant pAnt){
        ants.add(pAnt);
    }
}
