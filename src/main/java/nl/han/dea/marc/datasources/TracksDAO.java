package nl.han.dea.marc.datasources;

import nl.han.dea.marc.config.JDBCConnector;
import nl.han.dea.marc.dtos.TrackDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TracksDAO {

    Connection connection;
    ArrayList<TrackDTO> tracks;

    public TracksDAO() throws SQLException {
        connection = JDBCConnector.CONNECTION;
        tracks = new ArrayList<>();
        receiveAllTracksFromDb();
    }

    private void receiveAllTracksFromDb() throws SQLException {
        ResultSet rs = connection.createStatement().executeQuery("select * from track");

        while (rs.next()) {
            TrackDTO track = new TrackDTO(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDouble(4),
                    rs.getString(5),
                    rs.getInt(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getBoolean(9));
            tracks.add(track);
        }
    }
}
