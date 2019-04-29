package Crossers;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Farmer extends Crosser {
    public Farmer(){
        this.setEatingRank(4);


    }

    @Override
    public ArrayList<BufferedImage> getImages() throws Exception{
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(ImageIO.read(new File(System.getProperty("user.dir")+ "/src/GUI/Sprites/FarmerRight.png")));
        images.add(ImageIO.read(new File(System.getProperty("user.dir")+ "/src/GUI/Sprites/FarmerLeft.png")));
        return images;
    }


}
