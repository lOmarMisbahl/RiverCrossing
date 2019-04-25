import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Wolf extends Carnivorous {
    @Override
    public ArrayList<BufferedImage> getImages() throws Exception{
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(ImageIO.read(new File("C:\\Users\\Omar\\Desktop\\RiverCrossing\\src\\GUI\\Sprites\\WolfRight.png")));
        images.add(ImageIO.read(new File("C:\\Users\\Omar\\Desktop\\RiverCrossing\\src\\GUI\\Sprites\\WolfLeft.png")));
        return images;
    }

}
