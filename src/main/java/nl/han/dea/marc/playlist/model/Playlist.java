package nl.han.dea.marc.playlist.model;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

public class Playlist {

    private int id;
    private String name;
    private boolean owner;
    private Track[] tracks;
    private int count;

    public Playlist(int id, String name, boolean owner, Track[] tracks) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.tracks = tracks;
        this.count = 0;
    }

    public void add(Track a) {
        if (count == tracks.length) {
            showMessageDialog(null, "To many tracks where added", "Boom", ERROR_MESSAGE);
        }
        tracks[count] = a;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOwner() {
        return owner;
    }

    public void setOwner(boolean owner) {
        this.owner = owner;
    }

    public Track[] getTracks() {
        return tracks;
    }

    public void setTracks(Track[] tracks) {
        this.tracks = tracks;
    }

    public void print() {
        String result = "NumSongs = " + count + " / PlayList song limit = " + tracks.length + "\n";

        for (int i = 0; i < count; i++) {
            result += ("songList[" + i + "] = <" + tracks[i] + ">\n");
        }
        System.out.println(result + "\n");
    }


}
