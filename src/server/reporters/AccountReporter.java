package server.reporters;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountReporter {
    public static boolean userExists(Connection conn, String phoneNumber) {
        String sql = "SELECT * FROM users WHERE phone_number=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, phoneNumber);
            ResultSet resultSet = stmt.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
    }
    public static void storeNewAccount(Connection conn, String phoneNumber, byte[] salt, byte[] hash, String name, String date) {
        stringIntoTable(conn, "users", phoneNumber, name, date);
        stringIntoTable(conn, "credentials", phoneNumber, translateEncoding(salt), translateEncoding(hash));
    }
    private static void stringIntoTable(Connection conn, String table, String string1, String string2, String string3) {
        String sql = String.format("INSERT INTO %s VALUES (?, ?, ?)", table);
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, string1);
            stmt.setString(2, string2);
            stmt.setString(3, string3);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static String translateEncoding(byte[] salt) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : salt) {
            stringBuilder.append(b).append("&#&");
        }
        return stringBuilder.toString();
    }
}
