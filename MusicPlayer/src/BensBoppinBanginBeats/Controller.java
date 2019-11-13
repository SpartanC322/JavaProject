package BensBoppinBanginBeats;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.*;
import javax.swing.*;
import java.io.File;
import java.net.URL;

public class Controller
{
    @FXML
    private Button buttonPlay;

    public void onClick()
    {
        URL resource = getClass().getResource("Test Music/Whole Lotta Love.mp3");
        Media media = new Media(resource.toString());
        MediaPlayer player = new MediaPlayer(media);
        player.play();
    }

}
