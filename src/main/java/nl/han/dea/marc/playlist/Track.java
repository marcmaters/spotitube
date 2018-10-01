package nl.han.dea.marc.playlist;

public class Track {

    private String name;
    private String artist;
    private String album;
    private int length;

    public Track(String name, String artist, String album, int length) {
        this.name = name;
        this.artist = artist;
        this.album = album;
        this. length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
