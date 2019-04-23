import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Plant extends Crosser {

    @Override
    public ArrayList<BufferedImage> getImages() throws Exception{
        ArrayList<BufferedImage> images = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            images.add(ImageIO.read(new File("C:\\Users\\Omar\\Desktop\\RiverCrossing\\src\\plant" + i + ".png")));
        }
        return images;
    }

}
