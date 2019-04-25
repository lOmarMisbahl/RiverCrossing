
import Strategy.LevelOne;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.image.BufferedImage;
import java.awt.print.Book;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.ResourceBundle;
import Crossers.*;

import javax.imageio.ImageIO;

public class Controller implements Initializable {

    GameEngine gameEngine;
    @FXML
    private ImageView Crosser1;

    @FXML
    private ImageView Crosser3;

    @FXML
    private ImageView Crosser4;

    @FXML
    private ImageView Crosser2;
    @FXML
    private ImageView Boat;
    @FXML
    private ImageView Leftside;
    @FXML
    private ImageView Rightside;
    Map<ImageView, ICrosser> myCrossers = new HashMap<>();

    ArrayList<ImageView> IV = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gameEngine = GameEngine.getInstance();

        if (url.toString().contains("Game")) {

            gameEngine.newGame(new LevelOne());
            IV.add(Crosser1);
            IV.add(Crosser2);
            IV.add(Crosser3);
            IV.add(Crosser4);
            int i = 0;
            for (ICrosser I:
                    gameEngine.getCrossersOnLeftBank() ) {
                try {

                    Image image = SwingFXUtils.toFXImage(I.getImages().get(0), null);
                    IV.get(i).setImage(image);
                    myCrossers.put(IV.get(i),I);
                    moveToSide(IV.get(i),fromLeftToRightBank);
                    boatOffset= 0;
                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Couldn't Load Image");
                }
            }

        }
    }


    @FXML
    void goToMenu(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI/Menu.fxml"));
            Scene scene = new Scene(loader.load());
            ((Stage)((Node)event.getSource()).getScene().getWindow()).setScene(scene);
        }catch (Exception e){
            System.out.println("Error Loading Menu");
        }

    }


    @FXML
    void resume(ActionEvent event) {

    }

    @FXML
    void start(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI/Game.fxml"));
            Scene scene = new Scene(loader.load());
            ((Stage)((Node)event.getSource()).getScene().getWindow()).setScene(scene);
        }catch (Exception e){
            System.out.println("Error Loading Game");
        }
        int i = 0;
        /*
        for (ICrosser I:
            gameEngine.getCrossersOnLeftBank() ) {
            try {
                Image image = SwingFXUtils.toFXImage(I.getImages().get(0), null);
                System.out.println("Couldn't Load Image");
                IV.get(i).setImage(image);
            }catch (Exception e){
                System.out.println("Couldn't Load Image");
            }

        }*/

    }
    private int leftOffset = 0;
    private int rightOffset = 0;
    private int boatOffset = 0;
    int offset = 35;
    private boolean fromLeftToRightBank = true;
    @FXML
    void moveCrosser(MouseEvent event){
        System.out.println("hereee");
        ImageView myImageView = ((ImageView)event.getSource());
        ICrosser myCrosser = myCrossers.get(myImageView);

        if (myCrosser.isOnBoat()){
                moveToSide(myImageView,fromLeftToRightBank);
                gameEngine.getOffBoat(myCrosser,fromLeftToRightBank);

        }else {
            if (gameEngine.moveToBoat(myCrosser)){
                moveToBoat(myImageView,fromLeftToRightBank);

            }
        }

    }
    void moveToSide(ImageView A,Boolean fromLeftToRightBank){
        if (fromLeftToRightBank){
            A.setLayoutX(Leftside.getLayoutX()+leftOffset);
            A.setLayoutY(Leftside.getLayoutY());
            leftOffset += offset;
        }else {
            A.setLayoutX(Rightside.getLayoutX()+rightOffset);
            A.setLayoutY(Rightside.getLayoutY());
            rightOffset += offset;
        }
        boatOffset -= offset;
    }
    void moveToBoat(ImageView A,Boolean fromLeftToRightBank){

        A.setLayoutX(Boat.getLayoutX()+boatOffset);
        A.setLayoutY(Boat.getLayoutY()-Boat.getFitHeight()+10);
        boatOffset += offset;
        if (fromLeftToRightBank){
            leftOffset -= offset;
        }else {
            rightOffset -= offset;
        }
    }

}
