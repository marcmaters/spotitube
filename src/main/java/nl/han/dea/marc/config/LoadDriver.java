package nl.han.dea.marc.config;

import nl.han.dea.marc.model.Track;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

public class LoadDriver {

    public static Connection CONNECTION;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            CONNECTION = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/spotitube", "spotitube", "spotitube");
        }
        catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
