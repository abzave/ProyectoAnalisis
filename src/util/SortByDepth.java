package util;

import control.Three;

import java.util.Comparator;

public class SortByDepth implements Comparator<Three> {
    @Override
    public int compare(Three pThree1, Three pThree2) {//sorts ascendent
        return pThree1.getDepth()-pThree2.getDepth();
    }
}
