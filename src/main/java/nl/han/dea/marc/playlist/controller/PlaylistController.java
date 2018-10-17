package nl.han.dea.marc.playlist.controller;

import nl.han.dea.marc.playlist.datasource.TracksDAO;
import nl.han.dea.marc.playlist.dto.PlaylistsDTO;
import nl.han.dea.marc.playlist.dto.TracksDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.swing.JOptionPane.showMessageDialog;

@Path("/playlists")
public class PlaylistController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlaylists(@QueryParam("token") String token) {
        if (token.equals("test")) {
            PlaylistsDTO playlistsDTO = new PlaylistsDTO();//todo playlist met tracks wordt al gevult mag leeg zijn.
            playlistsDTO.setLength(4000);
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
    public Response getTracksForPlaylist(@PathParam("id") int id) {
        TracksDTO tracksDTO = new TracksDTO(id);
        return Response.ok(tracksDTO).build();
    }
//
//
//    @GET
//    @Path("/{id}/tracks")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response show(@PathParam("id") int id) {
//        TrackCollectionDTO trackCollection = trackDAO.allForPlaylistId(id);
//        if (trackCollection == null) {
//            return Response.status(404).build();
//        }
//        return Response.ok(trackCollection).build();
//    }

}
