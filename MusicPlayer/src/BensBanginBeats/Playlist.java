//this class creates the playlist by adding the currently selected file to the arraylist using the counter that is passed into it

package BensBanginBeats;

import javafx.stage.FileChooser;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Playlist.
 */
public class Playlist extends AbstractPlaylist
{

    private static List<String> songList = new ArrayList<String>();

    /**
     * Sets playlist.
     *
     * @param counter the counter
     */
//This method creates the playlist
    //Knowledge of File Chooser obtained from:https://docs.oracle.com/javase/tutorial/uiswing/components/filechooser.html
    public static void setPlaylist(int counter)
    {

        //This method let's the user choose the file to play and it gets added to the next index of the arraylist
        String filePath;
        FileChooser newFileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select mp3..","*.mp3");
        newFileChooser.getExtensionFilters().add(filter);
        File file = newFileChooser.showOpenDialog(null);
        filePath = file.toURI().toString();

        songList.add(counter,filePath);
    } //end of setPlaylist

    /**
     * Gets playlist.
     *
     * @return the playlist
     */
//This method returns the Playlist array
    public static ArrayList<String> getPlaylist()
    {
        if(songList.size() == 0)
        {
            return null;
        }
        else
        {
            return (ArrayList<String>) songList;
        }
    } //end of getPlaylist

} //end of Playlist