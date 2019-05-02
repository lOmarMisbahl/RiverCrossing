package Crossers;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public  class Crosser implements ICrosser {
    private double Weight;
    private String Label;
    private int EatingRank;
    private boolean canSail;
    private boolean onBoat = false;
    private ArrayList<BufferedImage> Images;


    public boolean isOnBoat(){
        return onBoat;
    }

    public void setOnBoat(boolean onBoat) {
        this.onBoat = onBoat;
    }


    @Override
    public void setCanSail(boolean canSail) {
        this.canSail = canSail;
    }

    @Override
    public void setWeight(double weight) {
        this.Weight = weight;
        setLabelToBeShown(this.getClass().getName()+(int)Weight);
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
        Label = label;
    }

    @Override
    public String getLabelToBeShown() {
        return this.Label;
    }



    public ArrayList<WritableImage> ToNormalImages() throws Exception{
        ArrayList<WritableImage> Images = new ArrayList<>();
        for (int i =0 ; i < getImages().size(); i++) {
            Images.add(SwingFXUtils.toFXImage(getImages().get(i), null));
        }
        return Images;
    }
}
