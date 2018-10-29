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

    private Connection connection;

    public PlaylistsDAO() {
        connection = JDBCConnector.CONNECTION;
    }

    public List<PlaylistDTO> getPlaylists(String token) {
        try (ResultSet rsPlaylist = connection.createStatement().executeQuery("select playlist_id, name, owner from spotitube.playlist where token = "+token+";")) {
            ArrayList<PlaylistDTO> playlists = new ArrayList<>();
            while (rsPlaylist.next()) {
                PlaylistDTO playlist = new PlaylistDTO();
                playlist.setId( rsPlaylist.getInt(1));
                playlist.setName(rsPlaylist.getString(2));
                playlist.setOwner(rsPlaylist.getBoolean(3));
                playlists.add(playlist);
            }
            return playlists;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getLengthFromPlaylists() {
        int totalLength = 0;
        try (ResultSet rsPlaylist = connection.createStatement().executeQuery("select playlist_id, name, owner from spotitube.playlist")) {
            while (rsPlaylist.next()) {
                String sumQuery = "select sum(duration) from spotitube.track where track_id in (select track_id from spotitube.tracksinplaylist where playlist_id = " + rsPlaylist.getInt(1) + ")";
                try (ResultSet rsLength = connection.createStatement().executeQuery(sumQuery)) {
                    while(rsLength.next()){
                        totalLength += rsLength.getInt(1);
                    }
                }
            }
            return totalLength;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return 0; //todo refactor
        }
    }

    public void updatePlaylists(int playlistId, String newPlaylistName) {
        try {
            String update = "UPDATE spotitube.playlist SET name = '"+newPlaylistName+"' WHERE playlist_id = "+playlistId+";";
            connection.createStatement().executeUpdate(update);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();  // Multiple streams were opened. Only the last is closed.
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void setPlaylist (String playlistName, String token) {
        String add = "INSERT INTO spotitube.playlist (name, owner, token) VALUES ('"+playlistName+"', true, "+token+")";
        try {
            connection.createStatement().executeUpdate(add);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePlaylists(int playListId) {
        String delete = "DELETE FROM spotitube.playlist WHERE playlist_id = "+playListId+";";
        try {
            connection.createStatement().executeUpdate(delete);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTrackToPlaylist(int playlistId, TrackDTO track) {
        String add = "INSERT INTO spotitube.tracksinplaylist (playlist_id, track_id) VALUES ("+playlistId+", "+track.getId()+")";
        String  update= "UPDATE spotitube.track SET offline_available = "+track.isOfflineAvailable()+" WHERE track_id = "+track.getId()+";";
        try {
            connection.createStatement().executeUpdate(add);
            connection.createStatement().executeUpdate(update);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}





