package util;

import java.util.Comparator;

public class AscendantSort implements Comparator<Integer> {
    @Override
    public int compare(Integer pPosition1, Integer pPosition2) {
        return pPosition1-pPosition2;
    }
}
