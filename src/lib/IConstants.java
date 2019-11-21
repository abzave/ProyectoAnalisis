package lib;

import java.awt.*;

public interface IConstants {
    //UI Constants
        //Window constants
        String WINDOW_TITLE = "Reina de la noche";
        int WINDOW_WIDTH = 1280;
        int WINDOW_HEIGHT = 720;

        //Buttons constants
        Color BUTTON_BACKGROUND = new Color(0x795548);

        //Grass constants
        int GRASS_Y_POS = 600;
    //Threes constants
        //draw control
        double THREE_ROTATION = -90;
        int THREE_BRANCH_ANGLE = 20;
        float THREE_STROKE_WIDTH_FACTOR = 1f;
        float THREE_GROWING_FACTOR = 10f;


        //Colors
        Color THREE_COLOR = new Color(0x795548);
        Color LEAVES_COLOR = new Color(0x388e3c);
        Color TRANSPARENT = new Color(0f, 0f, 0f, 0f);

    //Ants constants
        //control
        float ANT_MAX_SPEED = 10f;
        long ANTS_LEFT = 1000000L;
        float ANT_SIZE = 0.5f;
        int ANT_WIDTH = 10;
        int ANTTHILL = 1000;

        //Colors
        Color ANT_COLOR = new Color(0xe53935);

        double NANOSECONDS_TO_SECONDS_FACTOR = 1e+9;
        double PLANNING_TIME = 0.2;
        double TREE_PERCENTAGE = 0.05;

    //Total
        int TOTAL_TIME = 60;

    //Control
        int RESULT_PERCENTAGE_EXTRACTION = 20;

        double PERCENTAGE_OF_LEAVES = 0.1;

}
