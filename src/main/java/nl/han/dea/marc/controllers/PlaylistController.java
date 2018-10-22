package nl.han.dea.marc.controllers;

import nl.han.dea.marc.dto.PlaylistsDTO;
import nl.han.dea.marc.dto.TracksDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.DriverManager;
import java.sql.SQLException;

@Path("/playlists")
public class PlaylistController {
    private PlaylistsDTO playlistsDTO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlaylists(@QueryParam("token") String token) {
        if (token.equals("test")) {
            if (playlistsDTO == null) {
                playlistsDTO = new PlaylistsDTO();
                playlistsDTO.setLength(4000);
//                JdbcMsSql.getDbConnection();
                try {
                    DriverManager.getConnection("jdbc:mysql://localhost/spotitube");

                }
                catch (SQLException ex) {
                    // handle any errors
                    System.out.println("SQLException: " + ex.getMessage());
                    System.out.println("SQLState: " + ex.getSQLState());
                    System.out.println("VendorError: " + ex.getErrorCode());
                }
            }
            return Response.ok(playlistsDTO).build();
        }
        else {
            return Response.status(401).build();
        }
    }

    @GET
    @Path("{id}/tracks")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response getTracksForPlaylist(@PathParam("id") int id) {//todo: zorgen dat de playlist wordt verwijderd zodra een andere playlist geselecteerd wordt.
        TracksDTO tracksDTO = new TracksDTO(id);
        return Response.ok(tracksDTO).build();
    }
}