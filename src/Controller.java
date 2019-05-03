import Crossers.ICrosser;
import Strategy.LevelThree;
import Strategy.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
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
    @FXML
    private ImageView Crosser5;

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

        loadItems();

        }
    }

    void loadItems(){
        IV.clear();
        myCrossers.clear();
        IV.add(Crosser1);
        IV.add(Crosser2);
        IV.add(Crosser3);
        IV.add(Crosser4);
        IV.add(Crosser5);
        RightSide.getChildren().clear();
        LeftSide.getChildren().clear();
        Boat.getChildren().clear();


        fromLeftToRightBank = gameEngine.isBoatOnTheLeftBank();
            if(gameEngine.isNotification()) {
                String y = new String();
                notetext.setEditable(false);
                noteOk.setVisible(true);
                notetext.setVisible(true);
                note.setVisible(true);
                for (String x : gameEngine.getInstructions()) {
                    y += ('\n' + x);
                }
                notetext.setText(y);
                gameEngine.notificationShown();
            }
        int i = 0;

        for (ICrosser I:
                gameEngine.getCrossersOnLeftBank() ) {
            try {

                Image image = SwingFXUtils.toFXImage(I.getImages().get(0), null);
                IV.get(i).setImage(image);
                myCrossers.put(IV.get(i),I);
                moveToSide(IV.get(i),true);
                i++;
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println("Couldn't Load Image on left bank"+ i);
            }
        }

        for (ICrosser I:
                gameEngine.getCrossersOnRightBank() ) {
            try {

                Image image = SwingFXUtils.toFXImage(I.getImages().get(0), null);
                IV.get(i).setImage(image);
                myCrossers.put(IV.get(i),I);
                moveToSide(IV.get(i),false);
                i++;
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println("Couldn't Load Image on right bank"+ i);
            }
        }
        for (ICrosser I:
                gameEngine.getBoatRiders() ) {
            try {

                Image image = SwingFXUtils.toFXImage(I.getImages().get(0), null);
                IV.get(i).setImage(image);
                myCrossers.put(IV.get(i),I);
                forcemoveToBoat(IV.get(i));
                i++;
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println("Couldn't Load Image in boat"+ i);
            }
        }
        forceMoveBoat(fromLeftToRightBank);
        checkUndoRedo();

    }


    @FXML
    void undo(MouseEvent event) {
        gameEngine.undo();
        loadItems();
    }
    @FXML
    void redo(MouseEvent event) {
        gameEngine.redo();
        loadItems();
    }
    @FXML
    private TextArea notetext;

    @FXML
    private Button noteOk;
    @FXML
    private ImageView note;

    @FXML
    void noteHide(ActionEvent event) {
        noteOk.setVisible(false);
        notetext.setVisible(false);
        note.setVisible(false);
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
    void goToMainMenu(ActionEvent event) {


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI/Menu.fxml"));
            Scene scene = new Scene(loader.load());
            ((Stage)((Node)event.getSource()).getScene().getWindow()).setScene(scene);
        }catch (Exception e){
            System.out.println("Error Loading Menu");
        }

    }

    @FXML
    void resetGame(ActionEvent event) {
        gameEngine.resetGame();
        loadItems();

    }
    @FXML
    void resume(ActionEvent event) {
        //load game
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
    @FXML
    private ImageView rightboatpos;

    @FXML
    private ImageView lefttboatpos;
    private boolean fromLeftToRightBank = true;
    @FXML
    void moveCrosser(MouseEvent event){
        ImageView myImageView = ((ImageView)event.getSource());
        ICrosser myCrosser = myCrossers.get(myImageView);
        addToMomento();

        if (myCrosser.isOnBoat()){
                moveToSide(myImageView,fromLeftToRightBank);
                gameEngine.getOffBoat(myCrosser,fromLeftToRightBank);

        }else {
            if (gameEngine.leftBank.contains(myCrosser)&&fromLeftToRightBank){
                if (gameEngine.moveToBoat(myCrosser,fromLeftToRightBank)) {
                    moveToBoat(myImageView, fromLeftToRightBank);
                }
            }else if( gameEngine.rightBank.contains(myCrosser)&&!fromLeftToRightBank ) {
                if (gameEngine.moveToBoat(myCrosser,fromLeftToRightBank)) {
                    moveToBoat(myImageView, fromLeftToRightBank);
                }
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
    void forcemoveToBoat(ImageView A){
        Boat.getChildren().add(A);
    }
    void moveToBoat(ImageView A,Boolean fromLeftToRightBank){

        if (fromLeftToRightBank){
            LeftSide.getChildren().remove(A);
        }else {
            RightSide.getChildren().remove(A);
        }
        Boat.getChildren().add(A);
    }
    @FXML
    void moveBoat(MouseEvent event) {

        if(gameEngine.canMove(gameEngine.getBoatRiders(),fromLeftToRightBank)) {
            addToMomento();
            if (fromLeftToRightBank) {
                BoatGroup.setLayoutX(RightSide.getLayoutX() + 10);
                BoatGroup.setLayoutY(RightSide.getLayoutY() + BoatGroup.getHeight());
                fromLeftToRightBank = false;
                gameEngine.setBoatPosition("R");
            } else {
                BoatGroup.setLayoutX(LeftSide.getLayoutX() + 10);
                BoatGroup.setLayoutY(LeftSide.getLayoutY() + BoatGroup.getHeight() - 20);
                fromLeftToRightBank = true;
                gameEngine.setBoatPosition("L");

            }

        }

        gameEngine.Command(save);
    }
    private void forceMoveBoat(boolean fromLeftToRightBank){
        if (!fromLeftToRightBank) {
            BoatGroup.setLayoutX(rightboatpos.getLayoutX());
            BoatGroup.setLayoutY(rightboatpos.getLayoutY());
        } else {
            BoatGroup.setLayoutX(lefttboatpos.getLayoutX());
            BoatGroup.setLayoutY(lefttboatpos.getLayoutY());
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
            e.printStackTrace();
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

    @FXML
    private ImageView undo;

    @FXML
    private ImageView redo;
    void checkUndoRedo(){
        if(gameEngine.canUndo()){
            undo.setVisible(true);
        }else {
            undo.setVisible(false);
        }
        if(gameEngine.canRedo()){
            redo.setVisible(true);
        }else {
            redo.setVisible(false);
        }

    }
    void addToMomento(){
        Originator originator = new Originator();
        CareTacker careTaker = new CareTacker();
        //  while (game is on) data = game engine data
        originator.setState(gameEngine.getGameEngineData());
        careTaker.addundo(originator.saveStateToMemento());
        System.out.printf("saved");
        checkUndoRedo();
    }
}
