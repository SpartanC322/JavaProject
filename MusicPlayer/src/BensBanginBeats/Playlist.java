package BensBanginBeats;

import java.io.File;
import java.util.ArrayList;

public class Playlist extends AbstractPlaylist
{
    private static ArrayList<String> songList = null;

    public static void createPlaylist(String chosenFile, int counter)
    {
         songList = new ArrayList<String>();

        songList.set(counter,chosenFile);
        //getPlaylist(songList);

    }

    public static ArrayList<String> getPlaylist()
    {
        if(songList.size() == 0)
        {
            return null;
        }
        else
        {
            return songList;
        }

    }

    /*public static File[] getPlaylist()
    {

        File songDirectory = new File("Test Music");

        File[] songsInDirectory = songDirectory.listFiles();

        Arrays.sort(songsInDirectory);


        return songsInDirectory;

    }*/

}
