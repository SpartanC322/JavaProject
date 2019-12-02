package BensBanginBeats;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MusicPlayer extends Application{




    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("MusicPlayer.fxml"));
        primaryStage.setTitle("BEN'S BANGIN' BEATZ");
        primaryStage.setScene(new Scene(root, 580, 240));
        primaryStage.show();
       // theSacredText.setText(WriteMusicFiles.fillTextArea());
    }


    public static void main(String[] args) { launch(args); }
}
