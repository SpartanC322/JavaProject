package BensBoppinBanginBeats;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MusicPlayer extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MusicPlayer.fxml"));
        primaryStage.setTitle("BEN'S BOPPIN' BANGIN' BEATZ");
        primaryStage.setScene(new Scene(root, 650, 450));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

        //load songs



        //read each one

        //show on UI

        //try to play them

    }
}
