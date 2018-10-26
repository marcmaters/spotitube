package nl.han.dea.marc.services;

import nl.han.dea.marc.datasources.PlaylistsDAO;
import nl.han.dea.marc.dtos.TrackDTO;
import nl.han.dea.marc.dtos.TracksDTO;

import java.util.List;

public class TrackService {

    public TracksDTO getTracks(int id) {
        List<TrackDTO> tracks = new PlaylistsDAO().getPlaylists().get(id - 1).getTracks();
        TracksDTO tracksDTO = new TracksDTO();
        tracksDTO.setTracks(tracks);
        return tracksDTO;
    }

}
