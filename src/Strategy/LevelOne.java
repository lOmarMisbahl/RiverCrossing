package Strategy;
import Crossers.*;
import sun.security.smartcardio.SunPCSC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LevelOne implements ICrossingStrategy {
    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers,
                           List<ICrosser> leftBankCrossers, List<ICrosser>
                                   boatRiders) {
        System.out.println("Level One");
        System.out.println("Left Side : " + leftBankCrossers.size());
        System.out.println("Boat : " + boatRiders.size());
        System.out.println("Right Side : " + rightBankCrossers.size());
        boolean boatCanSail = false;
        for(int i=0;i<boatRiders.size();i++) {
            ICrosser x = boatRiders.get(i);
            if ( x instanceof Farmer)
            {
                boatCanSail = true;
            }
        }

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
        }

        if(boatCanSail && !leftBankError &&  !rightBankError)
            return true;
        else  return false;

    }

    @Override
    public List<ICrosser> getInitialCrossers() {
        List<ICrosser> levelSceneRightBank = new ArrayList<ICrosser>();
        Factory x= new Factory();
        Crosser wolf =x.getCrosser("Wolf");
        levelSceneRightBank.add(wolf);
        Crosser sheep = x.getCrosser("Sheep");
        levelSceneRightBank.add(sheep);
        Crosser farmer =x.getCrosser("Farmer");
       // Farmer farmer = new Farmer();
        levelSceneRightBank.add(farmer);
        Crosser plant = x.getCrosser("plant");
        levelSceneRightBank.add(plant);
        return levelSceneRightBank;
    }

    @Override
    public String[] getInstructions() {
        String[] instructionOne = new String[]{"A farmer want to cross the river with a plant, a sheep and a wolf."," The wolf and the sheep cant stay together on the right bank "," the plant and the sheep cant stay together on the left bank. how to solve it? "};
        return instructionOne;
    }
    @Override
    public boolean isEnd(List<ICrosser> rightBankCrossers)
    { boolean end=false;
      int occurrences = rightBankCrossers.size();
        System.out.println("occurrences"+occurrences);
        if (occurrences==4)
          end=true;
        System.out.println(end);
        return end;
    }

}