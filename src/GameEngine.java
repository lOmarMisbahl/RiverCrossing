import Crossers.ICrosser;
import Strategy.ICrossingStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameEngine implements IGameController{
    private static GameEngine ourInstance = new GameEngine();
    private ICrossingStrategy gameStrategy;
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
        return gameStrategy.isValid(rightBank,leftBank,boatRiders);
    }

    @Override
    public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {

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
}
