package nl.han.dea.marc.services;

import nl.han.dea.marc.datasources.TracksDAO;
import nl.han.dea.marc.dtos.TracksDTO;

import javax.inject.Inject;
import java.sql.SQLException;

public class TrackService {

    TracksDAO tracksDAO;

    public TracksDTO getTracks(int playlistId) throws SQLException {
        TracksDTO tracksDTO = new TracksDTO();
        tracksDTO.setTracks(tracksDAO.getTracks(playlistId));
        return tracksDTO;
    }

    public TracksDTO getAllTracks() throws SQLException {
        TracksDTO tracksDTO = new TracksDTO();
        tracksDTO.setTracks(tracksDAO.getAllTracks());
        return tracksDTO;
    }

    @Inject
    public void setTrackDAO(TracksDAO tracksDAO) {this.tracksDAO = tracksDAO;}
}
