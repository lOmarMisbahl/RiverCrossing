import Crossers.Farmer;
import Crossers.ICrosser;
import Strategy.*;

import java.util.ArrayList;
import java.util.List;

public class GameEngine implements IGameController{
    private static GameEngine ourInstance = new GameEngine();
    private ICrossingStrategy gameStrategy ;
    private List<ICrosser> rightBank = new ArrayList<ICrosser>();
    private List<ICrosser> leftBank = new ArrayList<ICrosser>();
    private List<ICrosser> boatRiders = new ArrayList<ICrosser>();
    private String boatPosition = "L";
    private boolean notification ;
    private int sails = 0;
    private Originator originator = new Originator();
    private CareTacker careTaker = new CareTacker();
    FileManager fileManager = new FileManager();

    private Save save = new Save();
    private Load load = new Load();

    public static GameEngine getInstance() {
        return ourInstance;
    }
    private GameEngine() {

    }

    @Override
    public void newGame(ICrossingStrategy gameStrategy) {

       this.gameStrategy = gameStrategy;
        resetGame();
    }

    @Override
    public void resetGame() {
        originator = new Originator();
        careTaker = new CareTacker();
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

    public void setGameStrategy(ICrossingStrategy gameStrategy) {
        this.gameStrategy = gameStrategy;
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

    public String getBoatPosition() {
        return boatPosition;
    }

    public void sail(){
        sails++;
    }

    @Override
    public int getNumberOfSails() {
        return sails;
    }

    public void setSails(int sails) {
        this.sails = sails;
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
          try {
              LevelTwo x = (LevelTwo) gameStrategy;//
              return x.isValid(rightBank, leftBank, boatRiders);
          }catch (Exception ee){
              try {
                  LevelThree x = (LevelThree) gameStrategy;//
                  return x.isValid(rightBank, leftBank, boatRiders);
              }catch (Exception eee){
                  LevelFour x = (LevelFour) gameStrategy;//
                  return x.isValid(rightBank, leftBank, boatRiders);
              }
          }

        }
    }

    @Override
    public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
        ICrosser A = crossers.get(0);
        boatRiders.remove(A);
        if (fromLeftToRightBank){
            leftBank.add(A);
        }else {
            rightBank.add(A);
        }
        A.setOnBoat(false);

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
        fileManager.Command(save);

    }

    @Override
    public void loadGame() {
        originator = new Originator();
        careTaker = new CareTacker();
        leftBank.clear();
        rightBank.clear();
        boatRiders.clear();
        notification = false;
        fileManager.Command(load);

    }
    //Not Implemented Yet
    @Override
    public List<List<ICrosser>> solveGame() {
        return null;
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

    public Originator getOriginator() {
        return originator;
    }

    public CareTacker getCareTaker() {
        return careTaker;
    }

    public boolean isEnd() {
        try{
            LevelOne x = (LevelOne) gameStrategy;//
            return x.isEnd(rightBank);
        }catch (Exception e){
            try {
                LevelTwo x = (LevelTwo) gameStrategy;//
                return x.isEnd(rightBank);
            }catch (Exception ee){
                try {
                    LevelThree x = (LevelThree) gameStrategy;//
                    return x.isEnd(rightBank);
                }catch (Exception eee){
                    LevelFour x = (LevelFour) gameStrategy;//
                    return x.isEnd(rightBank);
                }
            }

        }

    }
}
