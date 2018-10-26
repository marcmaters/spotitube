package nl.han.dea.marc.controllers;

import nl.han.dea.marc.dtos.PlaylistsDTO;
import nl.han.dea.marc.dtos.TracksDTO;
import nl.han.dea.marc.services.PlayListService;
import nl.han.dea.marc.services.TrackService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/playlists")
public class PlaylistController {

    private PlayListService playListService;
    private TrackService tracksService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlaylists(@QueryParam("token") String token) {
        if (token.equals("test")) {
            PlaylistsDTO playlistsDTO = playListService.getPlaylists();
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
        TracksDTO tracksDTO = tracksService.getTracks(id);
        return Response.ok(tracksDTO).build();
    }

    //    @PUT
//    @Path("{id}/playlists")
//    @Produces({MediaType.APPLICATION_JSON})
//    @Consumes({MediaType.APPLICATION_JSON})
//    public Response editPlaylist(@QueryParam("token") String token, @PathParam("id") int id) throws SQLException{
//        if(token.equals("test")) {
//
//        }
//    }

    @Inject
    public void setPlayListService(PlayListService playListService) {
        this.playListService = playListService;
    }

    @Inject
    public void setTracksService(TrackService tracksService) {
        this.tracksService = tracksService;
    }

}