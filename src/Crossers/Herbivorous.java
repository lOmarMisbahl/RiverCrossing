<<<<<<< HEAD
public abstract class Herbivorous extends Crosser {
=======
package Crossers;

import Crossers.Animal;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Herbivorous extends Animal {

    @Override
    public ArrayList<BufferedImage> getImages() throws Exception{
        ArrayList<BufferedImage> images = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            images.add(ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\GUI\\Sprites\\herbivorous"+i+".png")));
        }
        return images;
    }

>>>>>>> 7bbae6c4f68a3cc83a19edb4e5d7176e9dacaf85
}
