import Crossers.Farmer;
import Crossers.ICrosser;
import Strategy.ICrossingStrategy;
import Strategy.LevelOne;
import Strategy.LevelTwo;

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
        System.out.println("size of left"+leftBank.size());
        boatPosition = "L";
        sails = 0;

    }

    @Override
    public void resetGame() {
        leftBank.clear();
        //leftBank.addAll(gameStrategy.getInitialCrossers());
        rightBank.clear();
        boatRiders.clear();
        boatPosition = "L";
        sails = 0;
        rightBank.addAll(gameStrategy.getInitialCrossers());
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

    public void setBoatPosition(String boatPosition) {
        this.boatPosition = boatPosition;
    }


    @Override
    public int getNumberOfSails() {
        return sails;
    }

    @Override
    public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
        System.out.println("Game Engine");
        System.out.println("Left Side : " + leftBank.size());
        System.out.println("Boat : " + boatRiders.size());
        System.out.println("Right Side : " + rightBank.size());

        try{
            LevelOne x = (LevelOne) gameStrategy;//
            return x.isValid(rightBank,leftBank,boatRiders);


        }catch (Exception e){
            LevelTwo x = (LevelTwo) gameStrategy;//
            return x.isValid(rightBank,leftBank,boatRiders);


        }
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
        Originator originator = new Originator();
        CareTacker careTaker = new CareTacker();
        System.out.println("Current State: " + originator.getState());
        Memento x = careTaker.saveundo();
        originator.getStateFromMemento(careTaker.getundo());
        System.out.println("Current State: " + originator.getState());
        careTaker.addredo(x);
    }

    @Override
    public void redo() {
        Originator originator = new Originator();
        CareTacker careTaker = new CareTacker();
        originator.getStateFromMemento(careTaker.getredo());
        System.out.println("Current State: " + originator.getState());
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

    public boolean moveToBoat(ICrosser A,boolean fromLeftToRightBank ){
        if (boatRiders.size()<2){
            if (fromLeftToRightBank){
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
    public void Command(Command Order){
        Order.Execute();
    }
    public int getLevelNumber(){
        if (gameStrategy instanceof LevelOne ){
            return 1;
        }else{
            return 2;
        }
    }
}
