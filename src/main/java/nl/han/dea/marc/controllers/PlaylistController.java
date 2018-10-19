package nl.han.dea.marc.controllers;

import nl.han.dea.marc.dto.PlaylistsDTO;
import nl.han.dea.marc.dto.TracksDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/playlists")
public class PlaylistController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlaylists(@QueryParam("token") String token) {
        if (token.equals("test")) {
            PlaylistsDTO playlistsDTO = new PlaylistsDTO();
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
    public Response getTracksForPlaylist(@PathParam("id") int id) {//todo: zorgen dat de playlist wordt verwijderd zodra een andere playlist geselecteerd wordt.
        if ("id".equals(Integer.toString(id))) {
            TracksDTO tracksDTO = new TracksDTO(id);
            return Response.ok(tracksDTO).build();
        }
        else {
            TracksDTO tracksDTO = new TracksDTO(id);
            return Response.ok(tracksDTO).build();
        }
    }
}