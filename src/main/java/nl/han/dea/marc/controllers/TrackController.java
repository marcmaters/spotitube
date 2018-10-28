package nl.han.dea.marc.controllers;

import nl.han.dea.marc.dtos.TracksDTO;
import nl.han.dea.marc.services.TrackService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/tracks")
public class TrackController {
    TrackService trackService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTracks(@QueryParam("token") String token) {
        if (token.equals("test")) {
            TracksDTO tracksDTO = null;
            try {
                tracksDTO = trackService.getAllTracks();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return Response.ok(tracksDTO).build();
        }
        else {
            return Response.status(401).build();
        }
    }

    @Inject
    public void setTrackService(TrackService trackService) {
        this.trackService = trackService;
    }

}
