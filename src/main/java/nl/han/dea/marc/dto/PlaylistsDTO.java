package nl.han.dea.marc.dto;

import nl.han.dea.marc.datasource.TracksDAO;
import nl.han.dea.marc.model.Playlist;

import java.util.ArrayList;

public class PlaylistsDTO {

    ArrayList<Playlist> playlists = new ArrayList<>();
    private int length;

    public PlaylistsDTO(){
        playlists.add(new Playlist(1, "Hitzone1", true, TracksDAO.HITZONE1));
        playlists.add(new Playlist(2, "Hitzone2", true, TracksDAO.HITZONE2));
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
