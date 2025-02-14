package Crossers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public interface ICrosser {
    /**
     * @return whether the crosser can sail the boat or not
     */
    public boolean getCanSail();
    /**
     * @return get the weight of the crosser
     */
    public double getWeight();
    /**
     * @return get the eating rank of the crosser
     * this rank can be used to detect if one
     * crosser can eat/harm another crosser
     */
    public int getEatingRank();
    /**
     *
     * @return images of the crosser
     * each crosser must have at least two images, each one
     * is used on one bank of the river
     */
    public ArrayList<BufferedImage> getImages() throws Exception;
    /**
     * @return exact copy of the crosser
     */
    public ICrosser makeCopy();
/**
 * this field is used by the game strategy to set the label which
 * will be shown beside the crosser in the game view
 * to inform the user about the criteria of the current level
 * e.g. crosser eating rank
 */
public void setLabelToBeShown(String label);
    /**
     * @return gets label of the crosser depending on the current game
     */
    public String getLabelToBeShown();

    public void setWeight(double weight);

    public void setEatingRank(int eatingRank);

    public void setCanSail(boolean canSail);

    public boolean isOnBoat();

    public void setOnBoat(boolean onBoat);
}
