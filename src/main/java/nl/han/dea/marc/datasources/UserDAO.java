package nl.han.dea.marc.datasources;

import nl.han.dea.marc.config.JDBCConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    Connection connection;

    public UserDAO() {connection = JDBCConnector.CONNECTION;}

    public String getUser(String user) throws SQLException {
        String getUser;
        ResultSet rsUser = connection.createStatement().executeQuery("select user from spotitube.user where user = '"+user+"';");
        rsUser.next();
        getUser = rsUser.getString(1);
        return getUser;
    }

    public String getPassword(String password) throws SQLException {
        String getPassword;
        ResultSet rsPassword = connection.createStatement().executeQuery("select password from spotitube.user where password = '"+password+"';");
        rsPassword.next();
        getPassword = rsPassword.getString(1);
        return getPassword;
    }
}
