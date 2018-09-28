package nl.han.dea.marc.playlist;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/playlists")

public class PlaylistController {

    @GET
    public Response getPlaylists () {
        return Response.ok(PlaylistDTO).build();
    }
}
