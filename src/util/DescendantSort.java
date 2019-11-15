package util;

import java.util.Comparator;

public class DescendantSort implements Comparator<Integer> {
    @Override
    public int compare(Integer pPosition1, Integer pPosition2) {
        return pPosition2-pPosition1;
    }
}
