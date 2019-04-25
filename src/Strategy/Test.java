package Strategy;
import Crossers.*;

import java.util.ArrayList;
import java.util.List;

public class Test implements ICrossingStrategy {
    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {
       return true;
    }

    @Override
    public List<ICrosser> getInitialCrossers() {
        List<ICrosser> levelSceneRightBank = new ArrayList<ICrosser>();
        levelSceneRightBank.add(new Farmer());
        levelSceneRightBank.add(new Farmer());
        levelSceneRightBank.add(new Farmer());
        levelSceneRightBank.add(new Farmer());
        return levelSceneRightBank;
    }

    @Override
    public String[] getInstructions() {
        String[] instructionOne = new String[]{"A farmer want to cross the river with a plant, a sheep and a wolf. The wolf and the sheep cant stay together on the right bank , the plant and the sheep cant stay together on the left bank. how to solve it? "};
        return instructionOne;
    }
}