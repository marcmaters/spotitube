package nl.han.dea.marc.playlist;

import java.util.ArrayList;

public class PlaylistsDTO {

    ArrayList<Playlist> playlists = new ArrayList<>();
    private int length;

    public ArrayList<Playlist> setPlaylists(int id, String name, boolean owner, Track[] tracks) {
        playlists.add(new Playlist(id, name, owner, tracks));
        return playlists;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

}
