package ui;

import common.TestTree;
import lib.IConstants;

import java.util.ArrayList;
import java.util.Collections;

public class TreeScale {

    ArrayList<TestTree> scaledTrees = new ArrayList<>();

    public TreeScale(ArrayList<TestTree> trees){
        Collections.shuffle(trees);
        int newTreeAmount = (int)Math.ceil(trees.size() * IConstants.TREE_PERCENTAGE);
        for(int tree = 0; tree < newTreeAmount; tree++){
            scaledTrees.add(trees.get(tree));
        }
    }

    public ArrayList<TestTree> getScaledTrees() {
        return scaledTrees;
    }
}
