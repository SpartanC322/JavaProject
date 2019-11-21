package BensBanginBeats;

import javafx.stage.FileChooser;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Playlist extends AbstractPlaylist
{

    static List<String> songList = new ArrayList<String>();

    public static void createPlaylist(int counter)
    {

        String filePath;
        FileChooser newFileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select mp3..","*.mp3");
        newFileChooser.getExtensionFilters().add(filter);
        File file = newFileChooser.showOpenDialog(null);
        filePath = file.toURI().toString();
        //filePath = file.toString();

        songList.add(counter,filePath);

    }

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

    }

}