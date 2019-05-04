package Strategy;
import Crossers.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class LevelFour implements ICrossingStrategy  {


    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {

        System.out.println("Level four");
        boolean verifieWeight= false;
        boolean verifieFarmer= false;
        float BoatWeight=0;
        for(int i=0;i<boatRiders.size();i++)
        {  ICrosser n = boatRiders.get(i);
            BoatWeight  +=  n.getWeight();}
        if (BoatWeight <= 100)
        {  verifieWeight=true; }
        for(int i=0;i<boatRiders.size();i++)
        {  ICrosser n = boatRiders.get(i);
            if ( n instanceof Farmer)
            {verifieFarmer = true; }
        }
        if(verifieFarmer && verifieWeight)
        {return  true;}
        else {return false;}







    }

    @Override
    public List<ICrosser> getInitialCrossers() {
        List<ICrosser> levelSceneRightBank = new ArrayList<ICrosser>();
        Factory z = new Factory();
        Crosser person1 = z.getCrosser("Farmer");
        person1.setWeight(100);
        person1.setLabelToBeShown("Farmer");
        levelSceneRightBank.add(person1);
        Crosser person2 =z.getCrosser("Farmer");
        person2.setWeight(100);
        person2.setLabelToBeShown("Farmer");
        levelSceneRightBank.add(person2);
        Crosser child1= z.getCrosser("Farmer");
        child1.setWeight(50);
        child1.setLabelToBeShown("child");
        levelSceneRightBank.add(child1);
        Crosser child2 =z.getCrosser("Farmer");
        child2.setWeight(50);
        child2.setLabelToBeShown("child");
        levelSceneRightBank.add(child2);

        return levelSceneRightBank;
    }

    @Override
    public String[] getInstructions() {
        String[] instructionfour = new String[]{"two workers and two children want to cross a river,rules:1)the craft can hold maximum one worker or two children,,everyone can row"};
        return instructionfour;
    }
    @Override
    public boolean isEnd(List<ICrosser> rightBankCrossers)
    { boolean end=false;
        int occurrences = Collections.frequency(rightBankCrossers, "Crosser");
        System.out.println(occurrences);
        if (occurrences==4)
            end=true;
        System.out.println(end);
        return end;
    }

}
