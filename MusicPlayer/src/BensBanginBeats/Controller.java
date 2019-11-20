package BensBanginBeats;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class Controller implements GenericController
{

    int loadCounter = 0;
    private String filePath;
    MediaPlayer player;

    @FXML
    private Button buttonPlay;

    @FXML
    private Button buttonLoader;

    public void onClickLoader()
    {
        FileChooser newFileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select mp3..","*.mp3");
        newFileChooser.getExtensionFilters().add(filter);
        File file = newFileChooser.showOpenDialog(null);
        filePath = file.toURI().toString();

        Song newSong = new Song(filePath);
        loadCounter++;

        Playlist.createPlaylist(filePath,loadCounter);



    }

    public void onClickPlay()
    {

        ArrayList<String> listOfSongs = Playlist.getPlaylist();

        for(int i = 0; i < listOfSongs.size(); i++)
        {

            System.out.println(listOfSongs.size());

            Media media = new Media(listOfSongs.get(i));
            player = new MediaPlayer(media);
            player.stop();
            player.play();
        }


    }
    //This method plays music files when the play button is clicked



}
