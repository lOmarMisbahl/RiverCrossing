import Crossers.ICrosser;
import Strategy.LevelOne;
import Strategy.LevelThree;
import Strategy.LevelTwo;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Controller implements Initializable {

     private Save save = new Save();
     private Load load = new Load();

    GameEngine gameEngine;
    @FXML
    private ImageView Crosser1;

    @FXML
    private ImageView Crosser3;

    @FXML
    private ImageView Crosser4;

    @FXML
    private ImageView Crosser2;
    Map<ImageView, ICrosser> myCrossers = new HashMap<>();

    ArrayList<ImageView> IV = new ArrayList<>();
    static boolean init = false;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gameEngine = GameEngine.getInstance();
        if (!init){
            //gameEngine.newGame( new LevelThree());
            System.out.println(gameEngine.getLevelNumber());
            init = true;
        }
        if (url.toString().contains("Game")) {

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
                    i++;
                } catch (Exception e) {
                    //e.printStackTrace();
                    System.out.println("Couldn't Load Image"+ i);
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
    void loadLevels(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI/levels.fxml"));
            Scene scene = new Scene(loader.load());
            ((Stage)((Node)event.getSource()).getScene().getWindow()).setScene(scene);
        }catch (Exception e){
            System.out.println("Error Loading Level");
            e.printStackTrace();
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

    @FXML
    private HBox RightSide;

    @FXML
    private HBox LeftSide;

    @FXML
    private VBox BoatGroup;

    @FXML
    private HBox Boat;
    private boolean fromLeftToRightBank = true;
    @FXML
    void moveCrosser(MouseEvent event){
        ImageView myImageView = ((ImageView)event.getSource());
        ICrosser myCrosser = myCrossers.get(myImageView);

        if (myCrosser.isOnBoat()){
                moveToSide(myImageView,fromLeftToRightBank);
                gameEngine.getOffBoat(myCrosser,fromLeftToRightBank);

        }else {
            if (gameEngine.moveToBoat(myCrosser,fromLeftToRightBank)){
                moveToBoat(myImageView,fromLeftToRightBank);

            }
        }

    }
    void moveToSide(ImageView A,Boolean fromLeftToRightBank){
        if (fromLeftToRightBank){
            LeftSide.getChildren().add(A);
        }else {
            RightSide.getChildren().add(A);
        }
    }
    void moveToBoat(ImageView A,Boolean fromLeftToRightBank){

        if (fromLeftToRightBank){
            gameEngine.Command(save);
            LeftSide.getChildren().remove(A);
        }else {
            RightSide.getChildren().remove(A);
        }
        Boat.getChildren().add(A);
    }
    @FXML
    void moveBoat(MouseEvent event) {

        //System.out.println(gameEngine.canMove(gameEngine.getBoatRiders(),fromLeftToRightBank));
        if(gameEngine.canMove(gameEngine.getBoatRiders(),fromLeftToRightBank)) {
            if (fromLeftToRightBank) {
                BoatGroup.setLayoutX(RightSide.getLayoutX() + 10);
                BoatGroup.setLayoutY(RightSide.getLayoutY() + BoatGroup.getHeight());
                fromLeftToRightBank = false;
            } else {
                BoatGroup.setLayoutX(LeftSide.getLayoutX() + 10);
                BoatGroup.setLayoutY(LeftSide.getLayoutY() + BoatGroup.getHeight() - 20);
                fromLeftToRightBank = true;

            }
        }
    }
    @FXML
    void loadLevelOne(MouseEvent event) {
        gameEngine.newGame(new LevelOne());
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI/Game.fxml"));
            Scene scene = new Scene(loader.load());
            ((Stage)((Node)event.getSource()).getScene().getWindow()).setScene(scene);
        }catch (Exception e){
            System.out.println("Error Loading Game");
        }
    }

    @FXML
    void loadLevelTwo(MouseEvent event) {

        gameEngine.newGame(new LevelTwo());
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI/Game.fxml"));
            Scene scene = new Scene(loader.load());
            ((Stage)((Node)event.getSource()).getScene().getWindow()).setScene(scene);
        }catch (Exception e){
            System.out.println("Error Loading Game");
        }

    }


}
