import Crossers.ICrosser;
import Strategy.ICrossingStrategy;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class GameEngineData {
    private ICrossingStrategy gameStrategy ;
    private List<ICrosser> rightBank = new ArrayList<ICrosser>();
    private List<ICrosser> leftBank = new ArrayList<ICrosser>();
    private List<ICrosser> boatRiders = new ArrayList<ICrosser>();
    private String boatPosition = "L";
    private int sails;
    public GameEngineData(GameEngine gameEngine){
        gameStrategy = gameEngine.getGameStrategy();
        rightBank.addAll(gameEngine.getCrossersOnRightBank());
        leftBank.addAll(gameEngine.getCrossersOnLeftBank());
        boatRiders.addAll(gameEngine.getBoatRiders());
        boatPosition = gameEngine.isBoatOnTheLeftBank() ? "L" : "R";
        sails = gameEngine.getNumberOfSails();
    }

    public ICrossingStrategy getGameStrategy() {
        return gameStrategy;
    }

    public List<ICrosser> getBoatRiders() {
        return boatRiders;
    }

    public List<ICrosser> getRightBank() {
        return rightBank;
    }

    public int getSails() {
        return sails;
    }

    public List<ICrosser> getLeftBank() {
        return leftBank;
    }

    public String getBoatPosition() {
        return boatPosition;
    }

}
