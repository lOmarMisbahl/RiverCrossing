package Crossers;

import Crossers.Carnivorous;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Wolf extends Carnivorous {
    public Wolf(){
        setLabelToBeShown(this.getClass().getName().substring(this.getClass().getName().lastIndexOf('.') + 1));
        this.setEatingRank(3);

    }
    @Override
    public ArrayList<BufferedImage> getImages() throws Exception{
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(ImageIO.read(new File(System.getProperty("user.dir")+ "/src/GUI/Sprites/WolfRight.png")));
        images.add(ImageIO.read(new File(System.getProperty("user.dir")+ "/src/GUI/Sprites/WolfLeft.png")));
        return images;
    }

}
