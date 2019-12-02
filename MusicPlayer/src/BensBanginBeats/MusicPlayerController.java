//This class creates the events when buttons are clicked, example, Play, pause, previous, next buttons and load file button.

package BensBanginBeats;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.util.Duration;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The type Music player controller.
 */
public class MusicPlayerController
{

    private int counter = 0;
    private int playlistIndex = 0;
    private MediaPlayer player;
    private ArrayList<String> listOfSongs;
    private Media media;

    @FXML
    private TextArea theSacredText;

    @FXML
    private Button buttonPlay;

    @FXML
    private Button buttonLoader;

    @FXML
    private Button buttonStop;

    @FXML
    private Text numberInPlaylist;

    @FXML
    private Slider musicTime;

    /**
     * On click loader.
     *
     * @throws IOException the io exception
     */
//This method loads file into the playlist through the createPlaylist method
    public void onClickLoader() throws IOException {

        //This method keeps track of how many new songs are loaded into the playlist and
        // sends the current number to the setPlaylist array so the new file can be added to the next array index
        Playlist.setPlaylist(counter);
        counter = counter + 1;

        //the called method works the intended way but also doesn't.
        theSacredText.setText(WriteMusicFiles.fillTextArea());

    } //end of onClickLoader

    /**
     * On click play.
     *
     * @throws IOException the io exception
     */
//This method plays music files when the play button is clicked and writes them to the playlistHistory.txt
    public void onClickPlay() throws IOException
    {
       listOfSongs = Playlist.getPlaylist();

        //listOfSongs = PlaylistInterface.getPlaylist();

        try
        {

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

        //Get progress slider to follow the song when play is pressed
        player.currentTimeProperty().addListener(new ChangeListener<Duration>()
        {
            @Override
            public void changed(ObservableValue<? extends Duration> observableValue, Duration oldTime, Duration newTime) {
                musicTime.setValue(newTime.toSeconds());
            }
        });

       WriteMusicFiles.writeToFile(listOfSongs);

    } //end of onClickPlay

    /**
     * On click next.
     *
     * @param actionEvent the action event
     */
//This method plays the next song
    public void onClickNext(ActionEvent actionEvent)
    {
        try
        {
            player.stop();
            playlistIndex++;
            media = new Media(listOfSongs.get(playlistIndex));
            player = new MediaPlayer(media);
            player.play();
        } catch (IndexOutOfBoundsException e) {
            player.stop();
            JOptionPane.showMessageDialog(null, "You have no songs");
        }

        //Get progress slider to follow the song when next is pressed
        player.currentTimeProperty().addListener(new ChangeListener<Duration>()
        {
            @Override
            public void changed(ObservableValue<? extends Duration> observableValue, Duration oldTime, Duration newTime) {
                musicTime.setValue(newTime.toSeconds());
            }
        });
    }


    /**
     * On click back.
     *
     * @param actionEvent the action event
     */
//This method plays the previous song in the playlist
    public void onClickBack(ActionEvent actionEvent)
    {
        try
        {
            player.stop();
            playlistIndex--;
            media = new Media(listOfSongs.get(playlistIndex));
            player = new MediaPlayer(media);
            player.play();
        } catch (IndexOutOfBoundsException e) {
            player.stop();
            JOptionPane.showMessageDialog(null, "You have no songs");
        }

        //Get progress slider to follow song when back is pressed
        player.currentTimeProperty().addListener(new ChangeListener<Duration>()
        {
            @Override
            public void changed(ObservableValue<? extends Duration> observableValue, Duration oldTime, Duration newTime) {
                musicTime.setValue(newTime.toSeconds());
            }
        });

    } //end of onClickBack

    /**
     * On mouse.
     *
     * @param mouseDragEvent the mouse drag event
     */
//this method should make the slider slide when dragged but doesn't
    public void onMouse(MouseDragEvent mouseDragEvent)
    {
        /*
        Get progress slider to be move-able to change time in song
        This is currently not working
        */
        musicTime.setOnMouseClicked(mouseEvent -> player.seek(Duration.seconds(musicTime.getValue())));

    } //end of onMouse

    /**
     * On click stop.
     */
//This method stops the current player
    public void onClickStop()
    {
        player.stop();
    }
}
