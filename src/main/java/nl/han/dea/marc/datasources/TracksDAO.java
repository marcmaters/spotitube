package nl.han.dea.marc.datasources;

import nl.han.dea.marc.config.JDBCConnector;
import nl.han.dea.marc.dtos.TrackDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TracksDAO {

    Connection connection;

    public TracksDAO() {
        connection = JDBCConnector.CONNECTION;
    }

    public List<TrackDTO> getTracks(int playlistId) throws SQLException {
        List<TrackDTO> tracksInPlaylist = new ArrayList<>();
        ResultSet rsTracksInPlaylist = connection.createStatement().executeQuery("select * from spotitube.track where track_id in (select track_id from spotitube.tracksinplaylist where playlist_id = " + playlistId + ")");
        while (rsTracksInPlaylist.next()) {
            TrackDTO track = new TrackDTO();
            track.setId(rsTracksInPlaylist.getInt(1));
            track.setTitle(rsTracksInPlaylist.getString(2));
            track.setPerformer(rsTracksInPlaylist.getString(3));
            track.setDuration(rsTracksInPlaylist.getInt(4));
            track.setAlbum(rsTracksInPlaylist.getString(5));
            track.setPlaycount(rsTracksInPlaylist.getInt(6));
            track.setPublicationDate(rsTracksInPlaylist.getString(7));
            track.setDescription(rsTracksInPlaylist.getString(8));
            track.setOfflineAvailable(rsTracksInPlaylist.getBoolean(9));
            tracksInPlaylist.add(track);
        }
        return tracksInPlaylist;
    }

    public List<TrackDTO> getAllTracks() throws SQLException {
        List<TrackDTO> tracksInPlaylist = new ArrayList<>();
        ResultSet rsTracksInPlaylist = connection.createStatement().executeQuery("select * from spotitube.track");
        while (rsTracksInPlaylist.next()) {
            TrackDTO track = new TrackDTO();
            track.setId(rsTracksInPlaylist.getInt(1));
            track.setTitle(rsTracksInPlaylist.getString(2));
            track.setPerformer(rsTracksInPlaylist.getString(3));
            track.setDuration(rsTracksInPlaylist.getInt(4));
            track.setAlbum(rsTracksInPlaylist.getString(5));
            track.setPlaycount(rsTracksInPlaylist.getInt(6));
            track.setPublicationDate(rsTracksInPlaylist.getString(7));
            track.setDescription(rsTracksInPlaylist.getString(8));
            track.setOfflineAvailable(rsTracksInPlaylist.getBoolean(9));
            tracksInPlaylist.add(track);
            //todo dubplicate code
        }
        return tracksInPlaylist;
    }
}
