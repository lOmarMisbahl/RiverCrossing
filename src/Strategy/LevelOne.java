package Strategy;

import Crossers.Farmer;
import Crossers.ICrosser;

import java.util.ArrayList;
import java.util.List;

public class LevelOne implements  ICrossingStrategy {
    String instructions[] = {"te"};
    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {
        return false;
    }

    @Override
    public List<ICrosser> getInitialCrossers() {
        ArrayList<ICrosser> x = new ArrayList<>();
        x.add(new Farmer());
        x.add(new Farmer());
        x.add(new Farmer());
        x.add(new Farmer());
        return x;
    }

    @Override
    public String[] getInstructions() {
        return instructions;
    }
}
