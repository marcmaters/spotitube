package nl.han.dea.marc.datasource;

import nl.han.dea.marc.config.LoadDriver;
import nl.han.dea.marc.model.Playlist;
import nl.han.dea.marc.model.Track;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaylistsDAO {

    Connection connection;

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    ArrayList<Playlist> playlists;

    public PlaylistsDAO() throws SQLException {
        connection = LoadDriver.CONNECTION;
        playlists = new ArrayList<>();
        receiveAllPlaylistsFromDb();
    }

    private void receiveAllPlaylistsFromDb() throws SQLException {
        ResultSet rsPlaylist = connection.createStatement().executeQuery("select * from PLAYLIST");

        while (rsPlaylist.next()) {
            ArrayList<Track> tracksInPlaylist = new ArrayList<>();
            ResultSet rsTracksInPlaylist = connection.createStatement().executeQuery("select * from spotitube.track where track_id in (select track_id from spotitube.tracksinplaylist where playlist_id = " + rsPlaylist.getInt(1) + ")");
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
