package nl.han.dea.marc.datasources;

import nl.han.dea.marc.config.JDBCConnector;
import nl.han.dea.marc.dtos.PlaylistDTO;
import nl.han.dea.marc.dtos.TrackDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaylistsDAO {

    Connection connection;

    public PlaylistsDAO() {
        connection = JDBCConnector.CONNECTION;
    }

    public List<PlaylistDTO> getPlaylists() {
        try (ResultSet rsPlaylist = connection.createStatement().executeQuery("select * from spotitube.playlist")) {

            while (rsPlaylist.next()) {
                ArrayList<TrackDTO> tracksInPlaylist = new ArrayList<>();
                try (ResultSet rsTracksInPlaylist = connection.createStatement().executeQuery("select * from spotitube.track where track_id in (select track_id from spotitube.tracksinplaylist where playlist_id = " + rsPlaylist.getInt(1) + ")")) {
                    try {
                        while (rsTracksInPlaylist.next()) {
                            TrackDTO track = new TrackDTO(
                                    rsTracksInPlaylist.getInt(1),
                                    rsTracksInPlaylist.getString(2),
                                    rsTracksInPlaylist.getString(3),
                                    rsTracksInPlaylist.getDouble(4),
                                    rsTracksInPlaylist.getString(5),
                                    rsTracksInPlaylist.getInt(6),
                                    rsTracksInPlaylist.getString(7),
                                    rsTracksInPlaylist.getString(8),
                                    rsTracksInPlaylist.getBoolean(9));
                            tracksInPlaylist.add(track);
                        }
                    }
                    finally {
                        rsTracksInPlaylist.close();
                    }
                }
                PlaylistDTO playlist = new PlaylistDTO(
                        rsPlaylist.getInt(1),
                        rsPlaylist.getString(2),
                        rsPlaylist.getBoolean(3),
                        tracksInPlaylist
                );
                ArrayList<PlaylistDTO> playlists = new ArrayList<>();
                playlists.add(playlist);
                return playlists;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        } return new ArrayList<>();
    }

//
//    private void updatePlaylistInDb(int id) throws SQLException {
//        String statement = "update spotitube.playlist set name =? where playlist_id =?";
//        PreparedStatement dbStatement = connection.prepareStatement(statement);
//        dbStatement.setInt(1, playlists.get(id));
//        }

}
