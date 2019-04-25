package Strategy;

import Crossers.ICrosser;
import Strategy.ICrossingStrategy;

import java.util.List;

public class LevelTwo implements ICrossingStrategy {
    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {
        return false;
    }

    @Override
    public List<ICrosser> getInitialCrossers() {
        return null;
    }

    @Override
    public String[] getInstructions() {
        return new String[0];
    }
}
