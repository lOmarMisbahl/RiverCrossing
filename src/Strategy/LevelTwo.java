package Strategy;
import Crossers.*;
import Strategy.ICrossingStrategy;

import java.util.ArrayList;
import java.util.List;

public class LevelTwo implements ICrossingStrategy {
    @Override
    public boolean isValid(List<ICrosser> rightBankICrossers, List<ICrosser> leftBankICrossers, List<ICrosser> boatRiders) {
        System.out.println("Level Two");
        boolean verifieWeight= false;
        boolean verifieFarmer= false;
        float BoatWeight=0;
        for(int i=0;i<boatRiders.size();i++)
        {  ICrosser x = boatRiders.get(i);
            BoatWeight  +=  x.getWeight();}
        if (BoatWeight <= 100)
        {  verifieWeight=true; }
        for(int i=0;i<boatRiders.size();i++)
        {  ICrosser x = boatRiders.get(i);
            if ( x instanceof Farmer)
            {verifieFarmer = true; }
        }
        if(verifieFarmer && verifieWeight)
        {return  true;}
        else {return false;}
    }




    @Override
    public List<ICrosser> getInitialCrossers(){
        List<ICrosser> levelSceneRightBank = new ArrayList<ICrosser>();
     /*   Carnivorous wolf =new Wolf();
        levelSceneRightBank.add(wolf);
        Herbivorous sheep = new Sheep();
        levelSceneRightBank.add(sheep);
        Farmer farmer = new Farmer();
        levelSceneRightBank.add(farmer);
        Plant plant = new Plant();
        levelSceneRightBank.add(plant);
        return levelSceneRightBank;*/
        Farmer farmer1 = new Farmer();
        farmer1.setWeight(90);
        levelSceneRightBank.add(farmer1);
        Farmer farmer2 = new Farmer();
        farmer2.setWeight(80);
        levelSceneRightBank.add(farmer2);
        Farmer farmer3= new Farmer();
        farmer3.setWeight(60);
        levelSceneRightBank.add(farmer3);
        Farmer farmer4 = new Farmer();
        farmer4.setWeight(40);
        levelSceneRightBank.add(farmer4);
        Sheep sheeplvltwo =new Sheep();
        sheeplvltwo.setWeight(20);
        levelSceneRightBank.add(sheeplvltwo);
        return levelSceneRightBank;
    }

    @Override
    public String[] getInstructions() {
        String[] instructionTwo = new String[]{" Four  farmers with their sheeps  want to cross the river their weights are 90,80,60 and 40kg and the max weight on boat is 100kg, how can they cross?"};
        return instructionTwo;}
}