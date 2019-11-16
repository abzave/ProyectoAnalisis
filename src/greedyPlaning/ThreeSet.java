package greedyPlaning;

import control.Three;

import javax.xml.crypto.dsig.Reference;
import java.util.ArrayList;
import java.util.HashMap;

public class ThreeSet {

    public ArrayList<ArrayList<Three>> sets;

    public ThreeSet(HashMap<Integer, ArrayList<Three>> pHashMap, ArrayList<Integer> pPositions){
        sets = defineSets(pHashMap, pPositions);
    }

    private ArrayList<ArrayList<Three>> defineSets(HashMap<Integer, ArrayList<Three>> pTotalThrees, ArrayList<Integer> pPositions){

        ArrayList<ArrayList<Three>> resultSet = new ArrayList<>();
        for(int referenceA = 0; referenceA < pPositions.size(); referenceA++){

            resultSet.add(pTotalThrees.get(pPositions.get(referenceA)));//ADD FIRST TO SET
            int toComp = 0;
            for(int referenceB = referenceA+1; referenceB < pPositions.size(); referenceB++){
                double calculating1 = pTotalThrees.get(pPositions.get(toComp)).get(0).getheigh();
                double calculating2 = 2 * (pTotalThrees.get(pPositions.get(referenceB)).get(0).getheigh() // next.heigh
                                                + (pTotalThrees.get(pPositions.get(referenceB)).get(0).getX()  // nex.x - act.x
                                                    - pTotalThrees.get(pPositions.get(toComp)).get(0).getX()));
                if (calculating1 < calculating2) {
                    System.out.println("Calculating1: "+calculating1+ " vs  Calculating2: "+calculating2);
                    for (int actualThree = 0; actualThree < pTotalThrees.get(pPositions.get(referenceB)).size(); actualThree++) {
                        resultSet.get(referenceA).add(pTotalThrees.get(pPositions.get(referenceB)).get(actualThree));
                    }
                    toComp += (pTotalThrees.get(pPositions.get(toComp)).size())-1;
                }
            }
        }
        return resultSet;
    }


}
