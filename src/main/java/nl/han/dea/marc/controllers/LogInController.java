package nl.han.dea.marc.controllers;

import nl.han.dea.marc.dtos.LogInRequestDTO;
import nl.han.dea.marc.dtos.LogInResponseDTO;
import nl.han.dea.marc.services.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
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
            logInResponseDTO.setUser(logInRequestDTO.getUser());
            logInResponseDTO.setToken(userService.getToken(logInRequestDTO.getUser(), logInRequestDTO.getPassword()));

            return Response.ok(logInResponseDTO).build();
        }
        else {
            return Response.status(401).build();
        }
    }

    @Inject
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

//                logInResponseDTO.setUser(userService.getUser(logInRequestDTO.getUser()));
//                logInResponseDTO.getToken();