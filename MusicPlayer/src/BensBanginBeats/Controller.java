package BensBanginBeats;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Controller implements GenericController
{

    private int counter = 0;
    private int playlistIndex = 0;
    private MediaPlayer player;
    private ArrayList<String> listOfSongs;
    Media media;

    @FXML
    private Button buttonPlay;

    @FXML
    private Button buttonLoader;

    @FXML
    private Text numberInPlaylist;

    @FXML
    private Slider musicTime;

    public void onClickLoader()
    {

        Playlist.createPlaylist(counter);
        counter = counter + 1;

    }

    //This method plays music files when the play button is clicked
    public void onClickPlay() throws IOException {

        listOfSongs = Playlist.getPlaylist();

        try {
            media = new Media(listOfSongs.get(playlistIndex));
            player = new MediaPlayer(media);
            player.stop();
            player.play();
            numberInPlaylist.setText("Songs in playlist: " + listOfSongs.size());
        }
        catch(IndexOutOfBoundsException a)
        {
            JOptionPane.showMessageDialog(null,"No more songs");
        }

        //Get progress slider to work
        player.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observableValue, Duration oldTime, Duration newTime) {
                musicTime.setValue(newTime.toSeconds());
            }
        });

       WriteMusicFiles.writeToFile(listOfSongs);

    }

    //This method plays the next song
    public void onClickNext(ActionEvent actionEvent) {

        try {
            player.stop();
            playlistIndex++;
            media = new Media(listOfSongs.get(playlistIndex));
            player = new MediaPlayer(media);
            player.play();
        } catch (IndexOutOfBoundsException e) {
            player.stop();
            JOptionPane.showMessageDialog(null, "You have no songs");
        }

        //Get progress slider to work
        player.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observableValue, Duration oldTime, Duration newTime) {
                musicTime.setValue(newTime.toSeconds());
            }
        });
    }


    //This method plays the previous song
    public void onClickBack(ActionEvent actionEvent) {

        try {
            player.stop();
            playlistIndex--;
            media = new Media(listOfSongs.get(playlistIndex));
            player = new MediaPlayer(media);
            player.play();
        } catch (IndexOutOfBoundsException e) {
            player.stop();
            JOptionPane.showMessageDialog(null, "You have no songs");
        }

        //Get progress slider to work
        player.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observableValue, Duration oldTime, Duration newTime) {
                musicTime.setValue(newTime.toSeconds());
            }
        });

    }

    public void onMouse(MouseDragEvent mouseDragEvent) {

        //Get progress slider to be move-able to change time in song....not yet
        musicTime.setOnMouseClicked(mouseEvent -> player.seek(Duration.seconds(musicTime.getValue())));

    }
}
