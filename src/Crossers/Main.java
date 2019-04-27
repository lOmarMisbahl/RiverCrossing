package Crossers;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Farmer farmer = new Farmer();
        GridPane pane = new GridPane();
        ImageView IV1 = new ImageView(farmer.ToNormalImages().get(0));
        ImageView IV2 = new ImageView(farmer.ToNormalImages().get(1));
        pane.add(IV1,0,0);
        pane.add(IV2,1,0);
        Scene scene = new Scene(pane,600,600);
        primaryStage.setTitle("Hello");
        primaryStage.setScene(scene);
        primaryStage.show();



    }
}
