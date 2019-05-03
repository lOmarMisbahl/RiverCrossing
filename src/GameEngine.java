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
    private boolean notification ;
    int sails = 0;
    public static GameEngine getInstance() {
        return ourInstance;
    }
    private GameEngine() {

    }
    Originator originator = new Originator();
    CareTacker careTaker = new CareTacker();
    @Override
    public void newGame(ICrossingStrategy gameStrategy) {
       this.gameStrategy = gameStrategy;
        notification = true;
       leftBank.addAll(gameStrategy.getInitialCrossers());
        System.out.println("size of left"+leftBank.size());
        boatPosition = "L";
        sails = 0;

    }

    @Override
    public void resetGame() {
        notification = true;
        leftBank.clear();
        leftBank.addAll(gameStrategy.getInitialCrossers());
        rightBank.clear();
        boatRiders.clear();
        boatPosition = "L";
        sails = 0;
        //rightBank.addAll(gameStrategy.getInitialCrossers());
    }
    public ICrossingStrategy getGameStrategy() {
        return gameStrategy;
    }
    public void notificationShown(){
        notification = false;
    }

    public boolean isNotification() {
        return notification;
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

        return  !careTaker.isUndoEmpty();

    }

    @Override
    public boolean canRedo() {
        return !careTaker.isRedoEmpty();

    }

    @Override
    public void undo() {

        System.out.println("Current State: " + originator.getState());
        Memento x = careTaker.saveundo();
        originator.getStateFromMemento(careTaker.getundo());
        System.out.println("Current State: " + originator.getState());
        setThis(originator.getState());
        careTaker.addredo(x);
    }

    @Override
    public void redo() {
        
        originator.getStateFromMemento(careTaker.getredo());
        System.out.println("Current State: " + originator.getState());
        setThis(originator.getState());

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
    public void setThis(GameEngineData myGameEngineData){
        this.boatRiders = myGameEngineData.getBoatRiders();
        this.leftBank = myGameEngineData.getLeftBank();
        this.rightBank = myGameEngineData.getRightBank();
        this.sails = myGameEngineData.getSails();
        this.boatPosition = myGameEngineData.getBoatPosition();
        this.gameStrategy = myGameEngineData.getGameStrategy();
        System.out.printf("Size of left" + leftBank.size());
        System.out.printf("Size of boat" + boatRiders.size());
        System.out.printf("Size of right" + rightBank.size());

    }
    public GameEngineData getGameEngineData(){
        return new GameEngineData(this);
    }
}
