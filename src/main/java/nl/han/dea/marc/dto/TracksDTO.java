package nl.han.dea.marc.dto;

import nl.han.dea.marc.datasource.PlaylistsDAO;
import nl.han.dea.marc.model.Track;

import java.sql.SQLException;
import java.util.ArrayList;

public class TracksDTO {
    public ArrayList<Track> tracks;

    public TracksDTO(int id) throws SQLException {
        if(id == 1){
            tracks = new PlaylistsDAO().getPlaylists().get(0).getTracks();
        }else {
            tracks = new PlaylistsDAO().getPlaylists().get(1).getTracks();
        }
    }
}
