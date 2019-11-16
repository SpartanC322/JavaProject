import java.io.File;
import java.util.Arrays;

public class Playlist
{

    public static File[] getPlaylist()
    {

        File songDirectory = new File("Test Music");

        File[] songsInDirectory = songDirectory.listFiles();

        Arrays.sort(songsInDirectory);

        return songsInDirectory;

    }

}
