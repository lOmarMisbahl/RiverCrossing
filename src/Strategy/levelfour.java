package Strategy;
import Crossers.*;

import java.util.ArrayList;
import java.util.List;



public class levelfour implements ICrossingStrategy  {


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

        Farmer person1 = new Farmer();
        person1.setWeight(100);
        levelSceneRightBank.add(person1);
        Farmer person2 = new Farmer();
        person2.setWeight(100);
        levelSceneRightBank.add(person2);
        Farmer child1= new Farmer();
        child1.setWeight(50);
        levelSceneRightBank.add(child1);
        Farmer child2 = new Farmer();
        child2.setWeight(50);
        levelSceneRightBank.add(child2);

        return levelSceneRightBank;
    }

    @Override
    public String[] getInstructions() {
        String[] instructionfour = new String[]{"two workers and two children want to cross a river,rules:1)the craft can hold maximum one worker or two children,,everyone can row"};
        return instructionfour;
    }
}
