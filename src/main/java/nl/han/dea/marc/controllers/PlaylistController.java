package nl.han.dea.marc.controllers;

import nl.han.dea.marc.dtos.PlaylistDTO;
import nl.han.dea.marc.dtos.PlaylistsDTO;
import nl.han.dea.marc.dtos.TrackDTO;
import nl.han.dea.marc.dtos.TracksDTO;
import nl.han.dea.marc.services.PlayListService;
import nl.han.dea.marc.services.TrackService;
import org.codehaus.jackson.map.ObjectMapper;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;

@Path("/playlists")
public class PlaylistController {

    private PlayListService playListService;
    private TrackService tracksService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlaylists(@QueryParam("token") String token) {
        PlaylistsDTO playlistsDTO = playListService.getPlaylists(token);
        return Response.ok(playlistsDTO).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addPlaylist(String body, @QueryParam("token") String token) {
        ObjectMapper mapper = new ObjectMapper();
        String playlistName = null;
        try {
            playlistName = mapper.readValue(body, PlaylistDTO.class).getName();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        playListService.addPlaylist(playlistName, token);
        PlaylistsDTO playlistsDTO = playListService.getPlaylists(token);
        return Response.ok(playlistsDTO).build();
    }

    @GET
    @Path("{id}/tracks")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response getTracksForPlaylist(@PathParam("id") int id) throws SQLException {
        TracksDTO tracksDTO = tracksService.getTracks(id);
        return Response.ok(tracksDTO).build();
    }

    @POST
    @Path("{id}/tracks")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addTrackToPlaylist(String body, @PathParam("id") int id, @QueryParam("token") String token) throws SQLException {
        ObjectMapper mapper = new ObjectMapper();
        TrackDTO track = null;
        try {
            track = mapper.readValue(body, TrackDTO.class);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        playListService.addTrackToPlaylist(id, track, tracksService);
        TracksDTO tracksDTO = tracksService.getTracks(id);
        return Response.ok(tracksDTO).build();
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response editPlaylist(String body, @QueryParam("token") String token, @PathParam("id") int id) {
        ObjectMapper mapper = new ObjectMapper();
        String newPlaylistName = null;
        try {
            newPlaylistName = mapper.readValue(body, PlaylistDTO.class).getName();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        playListService.updatePlaylist(id, newPlaylistName);
        PlaylistsDTO playlistsDTO = playListService.getPlaylists(token);
        return Response.ok(playlistsDTO).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response deletePlaylist(@QueryParam("token") String token, @PathParam("id") int id) {
        playListService.deletePlaylist(id);
        PlaylistsDTO playlistsDTO = playListService.getPlaylists(token);
        return Response.ok(playlistsDTO).build();
    }

    @Inject
    public void setPlayListService(PlayListService playListService) {
        this.playListService = playListService;
    }

    @Inject
    public void setTracksService(TrackService tracksService) {
        this.tracksService = tracksService;
    }

}