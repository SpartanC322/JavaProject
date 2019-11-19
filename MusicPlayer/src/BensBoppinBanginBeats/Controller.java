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

    MediaPlayer player;
    public void onClickPlay()
    {
        URL resource = getClass().getResource("Test Music/Monkeys Spinning Monkeys.mp3");
        Media media = new Media(resource.toString());
        player = new MediaPlayer(media);
        player.stop();
        player.play();
    }
    //This method plays music files when the play button is clicked


    @FXML
    private Button buttonLoader;

    public void onClickLoader()
    {
        File[] songPlaylist = Playlist.getPlaylist();

        for(int i = 0; i < songPlaylist.length; i++)
        {
            File currentSong = new File(songPlaylist.toString());

            //player = new MediaPlayer();
        }

    }
}
