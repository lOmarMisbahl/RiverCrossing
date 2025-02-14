package Crossers;
import Crossers.Herbivorous;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Sheep extends Herbivorous {
    public Sheep(){
        this.setEatingRank(2);
        setLabelToBeShown(this.getClass().getName().substring(this.getClass().getName().lastIndexOf('.') + 1));


    }
    @Override
    public ArrayList<BufferedImage> getImages() throws Exception{
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(ImageIO.read(new File(System.getProperty("user.dir")+ "/src/GUI/Sprites/SheepRight.png")));
        images.add(ImageIO.read(new File(System.getProperty("user.dir") + "/src/GUI/Sprites/SheepLeft.png")));
        return images;
    }

}
