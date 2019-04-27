import Crossers.Crosser;
import Crossers.Farmer;
import Crossers.ICrosser;
import Strategy.ICrossingStrategy;
import Strategy.LevelOne;

import java.util.ArrayList;
import java.util.List;

public class GameEngine implements IGameController{
    private static GameEngine ourInstance = new GameEngine();
    private ICrossingStrategy gameStrategy ;
    List<ICrosser> rightBank = new ArrayList<ICrosser>();
    List<ICrosser> leftBank = new ArrayList<ICrosser>();
    List<ICrosser> boatRiders = new ArrayList<ICrosser>();
    String boatPosition = "L";
    int sails = 0;
    public static GameEngine getInstance() {
        return ourInstance;
    }
    private GameEngine() {

    }

    @Override
    public void newGame(ICrossingStrategy gameStrategy) {
       this.gameStrategy = gameStrategy;
       leftBank.addAll(gameStrategy.getInitialCrossers());
        boatPosition = "L";

    }

    @Override
    public void resetGame() {

        leftBank.addAll(gameStrategy.getInitialCrossers());
        rightBank.clear();
        boatRiders.clear();
        boatPosition = "L";
        sails = 0;
    }

    @Override
    public String[] getInstructions() {
        return gameStrategy.getInstructions();
    }

    @Override
    public List<ICrosser> getCrossersOnRightBank() {
        return rightBank;
    }

    @Override
    public List<ICrosser> getCrossersOnLeftBank() {
        return leftBank;
    }

    @Override
    public boolean isBoatOnTheLeftBank() {
        if (boatPosition == "L")
            return true;
        else
            return false;
    }

    @Override
    public int getNumberOfSails() {
        return sails;
    }

    @Override
    public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
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
        for (int i=0;(i<rightBank.size()-1);i++) {
            for (int j=1;j<rightBank.size();j++) {
                ICrosser y = rightBank.get(i);
                ICrosser z = rightBank.get(j);
                if(Math.abs(y.getEatingRank()-z.getEatingRank())==1) {
                    rightBankError = true;
                } else {
                    rightBankError = false;
                    break;
                }
            }
            if (!rightBankError){
                break;
            }
        }

        for (int i=0;(i<leftBank.size()-1);i++) {
            for (int j=1;j<leftBank.size();j++) {
                ICrosser y = leftBank.get(i);
                ICrosser z = leftBank.get(j);
                if(Math.abs(y.getEatingRank()-z.getEatingRank())!=1) {
                    leftBankError = true;
                    System.out.println("it's true");
                    break;
                }else{
                    leftBankError = false;

                }
            }
            if (leftBankError){
                System.out.println("its still true");
                break;
            }
        }
        System.out.println("Farmer is " + boatCanSail + "LeftBank" + leftBankError);
        if(boatCanSail && leftBankError &&  rightBankError)
            return true;
        else
            return false;

        //return this.gameStrategy.isValid(rightBank,leftBank,crossers);
    }

    @Override
    public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {

    }

    public List<ICrosser> getBoatRiders() {
        return boatRiders;
    }

    @Override
    public boolean canUndo() {
        return false;
    }

    @Override
    public boolean canRedo() {
        return false;
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
    /******Save/Load ***************/
    @Override
    public void saveGame() {

    }

    @Override
    public void loadGame() {

    }
    //Not Implemented Yet
    @Override
    public List<List<ICrosser>> solveGame() {
        return null;
    }

    public void getOffBoat(ICrosser A, boolean fromLeftToRightBank){

        boatRiders.remove(A);
        if (fromLeftToRightBank){
            leftBank.add(A);
        }else {
            rightBank.add(A);
        }
        A.setOnBoat(false);
    }
    public boolean moveToBoat(ICrosser A){
        if (boatRiders.size()<2){
            if (isBoatOnTheLeftBank()){
                leftBank.remove(A);

            }else {
                rightBank.remove(A);
            }
            boatRiders.add(A);
            A.setOnBoat(true);
            return true;
        }else {
            System.out.println("No more room on boat");
            return false;
        }
    }
}
