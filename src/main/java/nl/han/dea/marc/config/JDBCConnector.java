package nl.han.dea.marc.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnector {

    private JDBCConnector() {
        throw new IllegalStateException("JDBC Connector class");
    }

    public static Connection connection;
    static {
        try {
            Properties p = new Properties();
            try (FileInputStream fis = new FileInputStream("C:\\Informatica\\Jaar 4\\OOSE\\DEA\\Spotitube\\src\\main\\java\\nl\\han\\dea\\marc\\config\\app.properties")) {

                p.load(fis);
            }
            String drivername = (String) p.get("drivername");
            String url = (String) p.get("url");
            String username = (String) p.get("username");
            String password = (String) p.get("password");

            Class.forName(drivername);
            connection = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

}
