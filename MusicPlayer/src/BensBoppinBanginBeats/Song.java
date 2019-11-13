package BensBoppinBanginBeats;

public class Song
{
 private String name;
 private String album;
 private String artist;

    public Song()
    {
        this.name = " ";
        this.album = " ";
        this.artist = " ";
    }

    public Song(String name, String album, String artist)
    {
        this.name = name;
        this.album = album;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
