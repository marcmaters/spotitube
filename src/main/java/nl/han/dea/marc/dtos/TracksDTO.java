package nl.han.dea.marc.dtos;

import nl.han.dea.marc.datasources.PlaylistsDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class TracksDTO {
    public ArrayList<TrackDTO> tracks;

    public TracksDTO(int id) throws SQLException {
        if(id == 1){
            tracks = new PlaylistsDAO().getPlaylists().get(0).getTracks();
        }else {
            tracks = new PlaylistsDAO().getPlaylists().get(1).getTracks();
        }
    }
}
