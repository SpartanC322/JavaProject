//General knowledge of JavaFX gained from this website:https://www.javatpoint.com/javafx-tutorial
//This is the main class, it runs the application

package BensBanginBeats;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The type Music player.
 */
public class MusicPlayer extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("MusicPlayer.fxml"));
        primaryStage.setTitle("BEN'S BANGIN' BEATZ");
        primaryStage.setScene(new Scene(root, 580, 240));
        primaryStage.show();

    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) { launch(args); }
}
