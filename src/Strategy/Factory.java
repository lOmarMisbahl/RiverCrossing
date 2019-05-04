package Strategy;

import Crossers.*;

public class Factory {

    public Crosser getCrosser(String CrosserType){

        if (CrosserType == null) {
            return null;
        }
        if (CrosserType.equalsIgnoreCase("FARMER")){
            return new Farmer();
        }
        if (CrosserType.equalsIgnoreCase("PLANT")) {
            return new Plant();
        }
        if (CrosserType.equalsIgnoreCase("SHEEP")) {
                return new Sheep();
            }
        if (CrosserType.equalsIgnoreCase("WOLF")) {
            return new Wolf();
        }

        return null;

    }

}

