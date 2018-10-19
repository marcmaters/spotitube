package nl.han.dea.marc.controllers;

import nl.han.dea.marc.dto.LogInRequestDTO;
import nl.han.dea.marc.dto.LogInResponseDTO;
import nl.han.dea.marc.services.UserService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class LogInController {

    private UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LogInRequestDTO logInRequestDTO) {

        if (userService.authenticate(logInRequestDTO.getUser(), logInRequestDTO.getPassword())) {
            LogInResponseDTO logInResponseDTO = new LogInResponseDTO();
            logInResponseDTO.setUser("Marc");
            logInResponseDTO.setToken("test");

            return Response.ok(logInResponseDTO).build();
        }
        else {
            return Response.status(401).build();
        }
    }

    @Inject
    public void setUserService(nl.han.dea.marc.services.UserService userService) {
        this.userService = userService;
    }
}
