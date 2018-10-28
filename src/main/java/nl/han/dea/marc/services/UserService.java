package nl.han.dea.marc.services;

import nl.han.dea.marc.datasources.UserDAO;
import nl.han.dea.marc.dtos.LogInRequestDTO;

import javax.inject.Inject;
import java.sql.SQLException;

public class UserService {

    UserDAO userDAO;

    public boolean authenticate(String user, String password) {
        try {
            return user.equals(userDAO.getUser(user)) && password.equals(userDAO.getPassword(password));
        }
        catch (SQLException e) {
            e.printStackTrace();
        } return false;
    }

    @Inject
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public String getToken() {

    }
}
