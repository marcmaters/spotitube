package nl.han.dea.marc.playlist;

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
            playlistsDTO.setPlaylists(1, "Hitzone 1", true, null);
            playlistsDTO.setPlaylists(2, "Hitzone 2", true, null);
            playlistsDTO.setLength(4000);
            return Response.ok(playlistsDTO).build();
        }
        else {
            return Response.status(401).build();
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}/tracks")
    public Response getTracksForPlaylist(@QueryParam("token") String token) {
        if (token.equals("test")) {
            TrackDAO trackDAO = new TrackDAO();
            PlaylistsDTO playlistsDTO = new PlaylistsDTO();
            playlistsDTO.setPlaylists(1, "Hitzone 1", true, trackDAO.getHitzone1());
            return Response.ok(trackDAO).build();
        }
        else {
            return Response.status(401).build();
        }
    }

}
