package nl.han.dea.marc.login;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class LogInController {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LogInRequestDTO logInRequestDTO) {

        if (logInRequestDTO.getUser().equals("Marc")) {
            LogInResponseDTO loginresponsedto = new LogInResponseDTO();
            loginresponsedto.setUser("Marc");
            loginresponsedto.setToken("adasdasd");

            return Response.ok(loginresponsedto).build();
        }
        else {
            return Response.status(401).build();
        }
    }
}
