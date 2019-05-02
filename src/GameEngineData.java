import Crossers.ICrosser;
import Strategy.ICrossingStrategy;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class GameEngineData {
    private ICrossingStrategy gameStrategy ;
    List<ICrosser> rightBank = new ArrayList<ICrosser>();
    List<ICrosser> leftBank = new ArrayList<ICrosser>();
    List<ICrosser> boatRiders = new ArrayList<ICrosser>();
    String boatPosition = "L";
    int sails;
    public GameEngineData(GameEngine gameEngine){
        
    }


}
