package ui;

import control.Three;
import lib.IConstants;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class DrawableThree extends Drawable {

    private int depth;
    private ArrayList<Branch> branches;
    private ArrayList<Leaf> leaves;

    public DrawableThree(Three pThree) {
        super(pThree.getX(), 0, 0);
        depth = pThree.getDepth();
        branches = new ArrayList<>();
        leaves = new ArrayList<>();
        buildThree(x, IConstants.GRASS_Y_POS, IConstants.THREE_ROTATION, depth);
    }

    private void buildThree(int x1, int y1, double angle, int depth) {
        if (depth == 0) return;
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * IConstants.THREE_GROWING_FACTOR);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * IConstants.THREE_GROWING_FACTOR);
        if(depth == 1){
            leaves.add(new Leaf(x1, x2, y1, y2, new BasicStroke(IConstants.THREE_STROKE_WIDTH_FACTOR * depth*2)));
        }else {
            branches.add(new Branch(x1, x2, y1, y2, new BasicStroke(IConstants.THREE_STROKE_WIDTH_FACTOR * depth)));
        }
        buildThree(x2, y2, angle - IConstants.THREE_BRANCH_ANGLE, depth - 1);
        buildThree(x2, y2, angle + IConstants.THREE_BRANCH_ANGLE, depth - 1);
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(IConstants.THREE_COLOR);
        for (Branch branch : branches){
            branch.paint(g);
        }
        for (Leaf leaf : leaves){
            if (!leaf.isRecollected()) {
                g.setColor(IConstants.LEAVES_COLOR);
            }else{
                g.setColor(IConstants.TRANSPARENT);
            }
            leaf.paint(g);
        }
    }

    public int getX(){
        return x;
    }

    public void reduceLeafs(int leafs){
        Collections.shuffle(leaves);
        int leaf = 0;
        while (leafs > 0){
            Leaf drawLeaf = leaves.get(leaf);
            if (!drawLeaf.isRecollected()) {
                drawLeaf.recollect();
                leafs--;
                leaf++;
            }
        }
    }
}
