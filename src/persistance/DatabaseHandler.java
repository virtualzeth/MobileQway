package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler {
    private Connection connect() {
        String url = "jdbc:sqlite:database.db";
        try {
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.printf("ERROR: Could not establish a connection to %s", url);
            return null;
        }
    }
}
