package server;

import controls.ErrorHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler {
    public static Connection connect() {
        String url = "jdbc:sqlite:database.db";
        try {
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            ErrorHandler.NoConnectionError();
            return null;
        }
    }
}
