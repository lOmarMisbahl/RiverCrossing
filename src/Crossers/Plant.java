import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Plant extends Crosser {

    @Override
    public ArrayList<BufferedImage> getImages() throws Exception{
        ArrayList<BufferedImage> images = new ArrayList<>();
<<<<<<< HEAD
        images.add(ImageIO.read(new File("C:\\Users\\Omar\\Desktop\\RiverCrossing\\src\\GUI\\Sprites\\Cabbage.png")));
=======
        for (int i = 0; i < 3; i++) {
            images.add(ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\GUI\\Sprites\\plant"+i+".png")));
        }
>>>>>>> 7bbae6c4f68a3cc83a19edb4e5d7176e9dacaf85
        return images;
    }

}
