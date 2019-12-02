//Example of an abstract class

package BensBanginBeats;

import java.util.ArrayList;

/**
 * The type Abstract playlist.
 */
public abstract class AbstractPlaylist implements PlaylistInterface
{
    private ArrayList<String> songList;

    /**
     * Gets playlist.
     *
     * @param songList the song list
     * @return the playlist
     */
    public static ArrayList<String> getPlaylist(ArrayList<String> songList) {
        return null;
    }
}
