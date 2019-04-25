package Crossers;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Carnivorous extends Animal{
    @Override
    public ArrayList<BufferedImage> getImages() throws Exception{
        ArrayList<BufferedImage> images = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            images.add(ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\GUI\\Sprites\\carnivorous"+i+".png")));
        }
        return images;
    }
}
