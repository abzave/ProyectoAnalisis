package lib;

import java.awt.*;

public interface IConstants {
    //UI Constants
        //Window constants
        String WINDOW_TITLE = "Reina de la noche";
        int WINDOW_WIDTH = 1600;
        int WINDOW_HEIGHT = 1000;

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

    //Ants constants
        //control
        float ANT_MAX_SPEED = 10f;

        //Colors
        Color ANT_COLOR = new Color(0xe53935);
}
