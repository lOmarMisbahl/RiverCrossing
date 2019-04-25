package Strategy;
import Crossers.*;
import Strategy.ICrossingStrategy;

import java.util.ArrayList;
import java.util.List;

public class LevelTwo implements ICrossingStrategy {
    @Override
    public boolean isValid(List<ICrosser> rightBankICrossers, List<ICrosser> leftBankICrossers, List<ICrosser> boatRiders) {
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
        Carnivorous wolf =new Carnivorous();
        levelSceneRightBank.add(wolf);
        Herbivorous sheep = new Herbivorous();
        levelSceneRightBank.add(sheep);
        Farmer farmer = new Farmer();
        levelSceneRightBank.add(farmer);
        Plant plant = new Plant();
        levelSceneRightBank.add(plant);
        return levelSceneRightBank;

    }

    @Override
    public String[] getInstructions() {
        return new String[0];
    }
}