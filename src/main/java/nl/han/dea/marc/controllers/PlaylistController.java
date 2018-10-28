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
        if (token.equals("test")) {
            PlaylistsDTO playlistsDTO = playListService.getPlaylists();
            return Response.ok(playlistsDTO).build();
        }
        else {
            return Response.status(401).build();
        }
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addPlaylist(String body, @QueryParam("token") String token) {
        if (token.equals("test")) {
            ObjectMapper mapper = new ObjectMapper();
            String playlistName = null;
            try {
                playlistName = mapper.readValue(body, PlaylistDTO.class).getName();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            playListService.addPlaylist(playlistName);
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
    public Response getTracksForPlaylist(@PathParam("id") int id) throws SQLException {
        TracksDTO tracksDTO = tracksService.getTracks(id);
        return Response.ok(tracksDTO).build();
    }

    @POST
    @Path("{id}/tracks")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addTrackToPlaylist(String body, @PathParam("id") int id, @QueryParam("token") String token) throws SQLException {
        if (token.equals("test")) {
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
        else {
            return Response.status(401).build();
        }
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response editPlaylist(String body, @QueryParam("token") String token, @PathParam("id") int id) {
        if (token.equals("test")) {
            ObjectMapper mapper = new ObjectMapper();
            String newPlaylistName = null;
            try {
                newPlaylistName = mapper.readValue(body, PlaylistDTO.class).getName();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            playListService.updatePlaylist(id, newPlaylistName);
            PlaylistsDTO playlistsDTO = playListService.getPlaylists();
            return Response.ok(playlistsDTO).build();
        }
        else {
            return Response.status(401).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response deletePlaylist(@QueryParam("token") String token, @PathParam("id") int id) {
        if (token.equals("test")) {
            playListService.deletePlaylist(id);
            PlaylistsDTO playlistsDTO = playListService.getPlaylists();
            return Response.ok(playlistsDTO).build();
        }
        else {
            return Response.status(401).build();
        }
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