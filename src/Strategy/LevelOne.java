package Strategy;

import Crossers.ICrosser;

import java.util.List;

public class LevelOne implements  ICrossingStrategy {
    String instructions[] = {"te"};
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
        return instructions;
    }
}
