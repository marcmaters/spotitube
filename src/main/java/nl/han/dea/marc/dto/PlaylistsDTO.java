package nl.han.dea.marc.dto;

import nl.han.dea.marc.datasource.PlaylistsDAO;
import nl.han.dea.marc.model.Playlist;

import java.sql.SQLException;
import java.util.ArrayList;

public class PlaylistsDTO {

    ArrayList<Playlist> playlists = new ArrayList<>();
    private int length;

    public PlaylistsDTO() throws SQLException {
        PlaylistsDAO playlistsDAO = new PlaylistsDAO();
        playlists = playlistsDAO.getPlaylists();
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
