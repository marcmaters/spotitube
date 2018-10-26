package nl.han.dea.marc.dtos;

import nl.han.dea.marc.datasources.PlaylistsDAO;
import java.util.ArrayList;
import java.util.List;

public class TracksDTO {

    List<TrackDTO> tracks = new ArrayList<>();

    public void setTracks(List<TrackDTO> tracks) {
        this.tracks = tracks;
    }

    public List<TrackDTO> getTracks() {
        return tracks;
    }

//    public TracksDTO(int id) {
//        tracks = new PlaylistsDAO().getPlaylists().get(id - 1).getTracks();
//    }
}
