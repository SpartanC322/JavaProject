package BensBanginBeats;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteMusicFiles {

    public static void writeToFile(ArrayList<String> listOfSongs) throws IOException {

        File textFile = new File("MusicPlayer/src/BensBanginBeats/playlistHistory.txt");
        FileWriter fw = new FileWriter(textFile, true);

        String[] line = new String[100];

        try (BufferedWriter bw = new BufferedWriter(fw)) {

            for (int i = 0; i < listOfSongs.size(); i++) {

                bw.write("Song: " + listOfSongs.get(i));
                bw.write(System.lineSeparator());
                bw.flush();
                System.out.println(listOfSongs.get(i));
            }

        }

    }

}


