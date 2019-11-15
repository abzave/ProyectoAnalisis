package control;

import ui.DrawableAnt;
import ui.DrawableThree;

import java.util.ArrayList;

public class Controller {

    private ArrayList<DrawableThree> drawableThrees;
    private ArrayList<DrawableAnt> drawableAnts;

    public Controller(){
        drawableThrees = new ArrayList<>();
        drawableAnts = new ArrayList<>();
    }

    public ArrayList<DrawableThree> getDrawableThrees() {
        return drawableThrees;
    }

    public ArrayList<DrawableAnt> getDrawableAnts() {
        return drawableAnts;
    }


}
