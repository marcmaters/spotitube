package nl.han.dea.marc.services;

public class UserService {

    public boolean authenticate(String user, String password) {
        return "Marc".equals(user);
    }
}
