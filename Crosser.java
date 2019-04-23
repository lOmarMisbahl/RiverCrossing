import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Crosser implements ICrosser{
    private double Weight;
    private int EatingRank;
    private String Label;
    private boolean canSail;
    private ArrayList<BufferedImage> Images;

    @Override
    public void setCanSail(boolean canSail) {
        this.canSail = canSail;
    }

    @Override
    public void setWeight(double weight) {
        this.Weight = weight;
    }
    @Override
    public void setEatingRank(int eatingRank) {
        this.EatingRank = eatingRank;
    }

    @Override
    public boolean getCanSail() {
        return this.canSail;
    }

    @Override
    public double getWeight() {
        return this.Weight;
    }

    @Override
    public int getEatingRank() {
        return this.EatingRank;
    }

    @Override
    public ArrayList<BufferedImage> getImages() throws Exception {
        return this.Images;
    }

    @Override
    public ICrosser makeCopy() {
        return null;
    }

    @Override
    public void setLabelToBeShown(String label) {
        this.Label=label;

    }

    @Override
    public String getLabelToBeShown() {
        return this.Label;
    }
}
