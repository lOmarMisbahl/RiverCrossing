import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Sheep extends Herbivorous {

    @Override
    public ArrayList<BufferedImage> getImages() throws Exception{
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(ImageIO.read(new File("C:\\Users\\Omar\\Desktop\\RiverCrossing\\src\\GUI\\Sprites\\SheepRight.png")));
        images.add(ImageIO.read(new File("C:\\Users\\Omar\\Desktop\\RiverCrossing\\src\\GUI\\Sprites\\SheepLeft.png")));
        return images;
    }

}
