package nl.han.dea.marc.config;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class LoadDriver {
    public static void main(String[] argv) {

        System.out.println("-------- MySQL JDBC Connection Testing ------------");

        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/spotitube", "spotitube", "spotitube");

        }
        catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        }
        else {
            System.out.println("Failed to make connection!");
        }
    }
}
