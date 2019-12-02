package BensBanginBeats;

import java.io.*;
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
               // System.out.println("From writeToFile" + listOfSongs.get(i));
            }

        }

    }


   public static String fillTextArea() throws IOException {

        String songList = "";

       File fr = new File("MusicPlayer/src/BensBanginBeats/playlistHistory.txt");

       BufferedReader br = new BufferedReader(new FileReader(fr));

       ArrayList<String> fileArray = new ArrayList<>();

       int i = 0;
       String st;
       while((st = br.readLine()) != null)
       {

           System.out.println(st);

           songList = songList + st;
           //fileArray.add(i,st);

          // System.out.println("From fillTextArea " + br.readLine());

           i++;
       }

       return songList;

   }

}



