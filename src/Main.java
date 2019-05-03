import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Stack;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.initStyle(StageStyle.UNDECORATED);
        GameEngine gameEngine = GameEngine.getInstance();
        Parent root = FXMLLoader.load(getClass().getResource("GUI/Intro.fxml"));
        Scene scene = new Scene(root);//, 500, 500);
        //primaryStage.setTitle("Hello");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
//          *To convert Buffered Image to Image then view it in GUI*
//        Image image = SwingFXUtils.toFXImage(bufferedimage, null);
//        GridPane pane = new GridPane();
//        ImageView imageView = new ImageView(image);
//        pane.add(imageView,0,0);
//        Scene scene = new Scene(pane,1000,1000);
//        primaryStage.setScene(scene);
//        primaryStage.show();


    public static void main(String[] args) {

        launch(args);
        Originator originator = new Originator();
        CareTacker careTaker = new CareTacker();
        GameEngineData data = new GameEngineData(GameEngine.getInstance());
      //  while (game is on) data = game engine data
        originator.setState(data);
        careTaker.addundo(originator.saveStateToMemento());

       /* System.out.println("First saved State: " + originator.getState());
        //System.out.println( originator.getStateFromMemento(careTaker.get(3)));
        originator.getStateFromMemento(careTaker.getundo());
        System.out.println("Second saved State: " + originator.getState());*/


    }
}