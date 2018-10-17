package nl.han.dea.marc.playlist.dto;

import nl.han.dea.marc.playlist.datasource.TracksDAO;
import nl.han.dea.marc.playlist.model.Track;
import nl.han.dea.marc.playlist.model.Playlist;

import java.util.ArrayList;

public class PlaylistsDTO {

    ArrayList<Playlist> playlists = new ArrayList<>();
    private int length;

    public PlaylistsDTO(){
        TracksDAO tracksDAO = new TracksDAO();
        playlists.add(new Playlist(1, "hitzone1", true, tracksDAO.getHitzone1Tracks()));
        playlists.add(new Playlist(2, "hitzone2", true, new TracksDAO().hitzone2Tracks));
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
