import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
          FilesParser parser = new FilesParser();
          parser.ReadSaveGame();
//        GameEngine gameEngine = GameEngine.getInstance();
//        Parent root = FXMLLoader.load(getClass().getResource("GUI/Game.fxml"));
//        Scene scene = new Scene(root);//, 500, 500);
//        //primaryStage.setTitle("Hello");
//        primaryStage.setScene(scene);
//        primaryStage.show();
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
    }
}