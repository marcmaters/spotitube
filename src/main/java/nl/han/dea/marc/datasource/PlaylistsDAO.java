package nl.han.dea.marc.datasource;

import nl.han.dea.marc.config.JDBCConnector;
import nl.han.dea.marc.model.Playlist;
import nl.han.dea.marc.model.Track;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaylistsDAO {

    Connection connection;

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    ArrayList<Playlist> playlists;
//    String statement = "SELECT `guid`, `grade`, `studentID`, `name` FROM `students` where `guid`=?";
//    PreparedStatement dbStatement = connection.prepareStatement(statement);

    public PlaylistsDAO() throws SQLException {
        connection = JDBCConnector.CONNECTION;
        playlists = new ArrayList<>();
        receiveAllPlaylistsFromDb();
    }

    private void receiveAllPlaylistsFromDb() throws SQLException {
        try (ResultSet rsPlaylist = connection.createStatement().executeQuery("select * from PLAYLIST")) {

            while (rsPlaylist.next()) {
                ArrayList<Track> tracksInPlaylist = new ArrayList<>();
                try (ResultSet rsTracksInPlaylist = connection.createStatement().executeQuery("select * from spotitube.track where track_id in (select track_id from spotitube.tracksinplaylist where playlist_id = " + rsPlaylist.getInt(1) + ")")) {
                    try {
                        while (rsTracksInPlaylist.next()) {
                            Track track = new Track(
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
                Playlist playlist = new Playlist(
                        rsPlaylist.getInt(1),
                        rsPlaylist.getString(2),
                        rsPlaylist.getBoolean(3),
                        tracksInPlaylist
                );
                playlists.add(playlist);
            }
        }
    }
//
//    private void updatePlaylistInDb(int id) throws SQLException {
//        String statement = "update spotitube.playlist set name =? where playlist_id =?";
//        PreparedStatement dbStatement = connection.prepareStatement(statement);
//        dbStatement.setInt(1, playlists.get(id));
//        }

}
