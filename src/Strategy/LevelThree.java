package Strategy;
import Crossers.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LevelThree implements ICrossingStrategy {
    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers,
                           List<ICrosser> leftBankCrossers, List<ICrosser>
                                   boatRiders) {

        System.out.println("Level One");
        System.out.println("Left Side : " + leftBankCrossers.size());
        System.out.println("Boat : " + boatRiders.size());
        System.out.println("Right Side : " + rightBankCrossers.size());
        boolean boatCanSail = false;
        boolean rightBankError = false;
        boolean leftBankError = false;
       /* for(int i=0;i<rightBankCrossers.size();i++) {
            ICrosser x = rightBankCrossers.get(i);
            ICrosser y = rightBankCrossers.get(i);
            if(Math.abs(x.getEatingRank()-y.getEatingRank())==1)
                rightBankError=false;
            else
                rightBankError= true;
        }*/
        for(int i=0;i<leftBankCrossers.size();i++) {
            ICrosser x = leftBankCrossers.get(i);
            ICrosser y = leftBankCrossers.get(i);
            if(Math.abs(x.getEatingRank()-y.getEatingRank())==1)
                leftBankError=false;
            else
                leftBankError= true;
        }
        for(int j=0;j<boatRiders.size();j++) {
            ICrosser x = boatRiders.get(j);
            ICrosser y = boatRiders.get(j);
            if(Math.abs(x.getEatingRank()-y.getEatingRank())==1)
                boatCanSail=false;
            else
                boatCanSail=true;
        }

/*
        boolean rightBankError=false;
        boolean leftBankError=false;
        for (int i=0;(i<rightBankCrossers.size()-1);i++) {
            for (int j=1;j<rightBankCrossers.size();j++) {
                ICrosser y = rightBankCrossers.get(i);
                ICrosser z = rightBankCrossers.get(j);
                if(Math.abs(y.getEatingRank()-z.getEatingRank())==1)
                    rightBankError=true;
                else
                    rightBankError= false;
            }
        }

        for (int i=0;(i<leftBankCrossers.size()-1);i++) {
            for (int j=1;j<leftBankCrossers.size();j++) {
                ICrosser y = leftBankCrossers.get(i);
                ICrosser z = leftBankCrossers.get(j);
                if(Math.abs(y.getEatingRank()-z.getEatingRank())==1)
                    leftBankError=true;
                else
                    leftBankError= false;
            }
        }*/

        if(boatCanSail && !rightBankError && !leftBankError )
            return true;
        else  return false;

    }

    @Override
    public List<ICrosser> getInitialCrossers() {
        List<ICrosser> levelSceneRightBank = new ArrayList<ICrosser>();
        Factory x = new Factory();
        Crosser farmer1 = x.getCrosser("Farmer");
        farmer1.setEatingRank(1);
        farmer1.setLabelToBeShown("1");
        levelSceneRightBank.add(farmer1);
        Crosser farmer2 = x.getCrosser("Farmer");
        farmer2.setEatingRank(2);
        farmer2.setLabelToBeShown("2");
        levelSceneRightBank.add(farmer2);
        Crosser farmer3 = x.getCrosser("Farmer");
        farmer3.setEatingRank(3);
        farmer3.setLabelToBeShown("3");
        levelSceneRightBank.add(farmer3);
        Crosser farmer4 = x.getCrosser("Farmer");
        farmer4.setEatingRank(4);
        farmer4.setLabelToBeShown("4");
        levelSceneRightBank.add(farmer4);
        Crosser farmer5 = x.getCrosser("Farmer");
        farmer5.setEatingRank(5);
        farmer5.setLabelToBeShown("5");
        levelSceneRightBank.add(farmer5);
        return levelSceneRightBank;
    }

    @Override
    public String[] getInstructions() {
        String[] instructionThree = new String[]{" Five farmers want to cross the river but each one dislike his neighbor, the can only hold two people, how can they cross the river? "};
        return instructionThree;
    }
    @Override
    public boolean isEnd(List<ICrosser> rightBankCrossers)
    { boolean end=false;
        int occurrences =  rightBankCrossers.size();
        System.out.println(occurrences);
        if (occurrences==5)
            end=true;
        System.out.println(end);
        return end;
    }

}