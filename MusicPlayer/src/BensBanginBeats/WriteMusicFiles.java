//this class does file reading and writing
package BensBanginBeats;

import java.io.*;
import java.util.ArrayList;

/**
 * The type Write music files.
 */
public class WriteMusicFiles {

    /**
     * Write to file.
     *
     * @param listOfSongs the list of songs
     * @throws IOException the io exception
     */
//this method writes the selected songs to the text file for storage
    public static void writeToFile(ArrayList<String> listOfSongs) throws IOException {
        File textFile = new File("MusicPlayer/src/BensBanginBeats/playlistHistory.txt");
        FileWriter fw = new FileWriter(textFile, true);

        try (BufferedWriter bw = new BufferedWriter(fw)) {
            for (int i = 0; i < listOfSongs.size(); i++) {
                bw.write("Song: " + listOfSongs.get(i));
                bw.write(System.lineSeparator());
                bw.flush();
            }

        }

    } //end of writeToFile

    /**
     * Fill text area string.
     *
     * @return the string
     * @throws IOException the io exception
     */
//this method should show all songs from the text file in the textarea but it seems to only show the first one
   public static String fillTextArea() throws IOException {

        String songList = "";

       File fr = new File("MusicPlayer/src/BensBanginBeats/playlistHistory.txt");

       BufferedReader br = new BufferedReader(new FileReader(fr));

       int i = 0;
       String st;
       while((st = br.readLine()) != null)
       {

           System.out.println(st);

           songList = songList + st;

           i++;

       }

       return songList;

   } //end of fillTextArea

} //end of WriteMusicFiles



