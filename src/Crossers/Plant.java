package Crossers;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Plant extends Crosser {
    public Plant(){
        this.setEatingRank(1);
        setLabelToBeShown(this.getClass().getName().substring(this.getClass().getName().lastIndexOf('.') + 1));

    }
    @Override
    public ArrayList<BufferedImage> getImages() throws Exception{
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(ImageIO.read(new File(System.getProperty("user.dir")+"/src/GUI/Sprites/Cabbage.png")));
        /*for (int i = 0; i < 3; i++) {
            images.add(ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\GUI\\Sprites\\plant"+i+".png")));
        }*/
        return images;
    }

}
