package nl.han.dea.marc.playlist;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

public class Playlist {

    private String playlistname;
    private Track[] tracks;
    private int count;

    public Playlist(String playlistname) {
        this.playlistname = playlistname;
        this.tracks = new Track[12];
        this.count = 0;
    }

    public String getPlaylistname() {
        return playlistname;
    }

    public void setPlaylistname(String playlistname) {
        this.playlistname = playlistname;
    }

    public Track[] getTracks() {
        return tracks;
    }

    public void setTracks(Track[] tracks) {
        this.tracks = tracks;
    }

    public void add(Track a) {
        if (count == tracks.length) {
            showMessageDialog(null, "To many tracks where added", "Boom", ERROR_MESSAGE);
        }
        tracks[count] = a;
        count++;
    }

    public void print() {
        String result = "NumSongs = " + count + " / PlayList song limit = " + tracks.length + "\n";

        for (int i = 0; i < count; i++) {
            result += ("songList[" + i + "] = <" + tracks[i] + ">\n");
        }
        System.out.println(result + "\n");
    }
}
