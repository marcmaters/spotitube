package nl.han.dea.marc.login;

import nl.han.dea.marc.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

public class LogInControllerTest {

    @Test
    public void testIfUserServiceAgreesReturnsOk()	{
        //Setup
        LogInController logInController = new LogInController();
        UserService userService = Mockito.mock(UserService.class);
        logInController.setUserService(userService);

        Mockito.when(userService.authenticate("Marc", "test")).thenReturn(true);

        LogInRequestDTO logInRequestDTO = new LogInRequestDTO();
        logInRequestDTO.setUser("Marc");
        logInRequestDTO.setPassword("test");
        //Test
        Response test = logInController.login(logInRequestDTO);

        //Verify
        Assert.assertEquals(200, test.getStatus());
    }

    @Test
    public void testIfUserServiceAgreesReturns401()	{
        //Setup
        LogInController logInController = new LogInController();
        UserService userService = Mockito.mock(UserService.class);
        logInController.setUserService(userService);

        Mockito.when(userService.authenticate(Mockito.anyString(), Mockito.anyString())).thenReturn(false);

        LogInRequestDTO logInRequestDTO = new LogInRequestDTO();
        logInRequestDTO.setUser("Marc");
        logInRequestDTO.setPassword("test");

        //Test
        Response test = logInController.login(logInRequestDTO);

        //Verify
        Assert.assertEquals(401, test.getStatus());
    }
}
