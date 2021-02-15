package server.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class AccountReporter {
    private static final String codeSplitter = "&#&";
    protected static boolean userExists(Connection conn, String phoneNumber) {
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
    protected static byte[][] getCredentials(Connection conn, String phoneNumber) {
        String sql = "SELECT * FROM credentials WHERE phone_number=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, phoneNumber);
            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()) {
                byte[] salt = translateEncoding(resultSet.getString(2));
                byte[] hash = translateEncoding(resultSet.getString(3));
                return new byte[][]{salt, hash};
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    protected static String[] getUserStateFromUsers(Connection conn, String phoneNumber) {
        String sql = "SELECT * FROM users WHERE phone_number=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, phoneNumber);
            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()) return new String[]{resultSet.getString("phone_number"),
                    resultSet.getString("name"), resultSet.getString("registration_date")};
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    protected static void storeNewAccount(Connection conn, String phoneNumber, byte[] salt, byte[] hash, String name, String date) {
        stringIntoTable(conn, "users", phoneNumber, name, date);
        stringIntoTable(conn, "credentials", phoneNumber, translateEncoding(salt), translateEncoding(hash));
    }
    protected static void stringIntoTable(Connection conn, String table, String string1, String string2, String string3) {
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
    protected static String translateEncoding(byte[] code) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : code) {
            stringBuilder.append(b).append(codeSplitter);
        }
        return stringBuilder.toString();
    }
    protected static byte[] translateEncoding(String code) {
        String[] byteString = code.split(codeSplitter);
        byte[] byteArray = new byte[byteString.length];
        for (int i = 0; i < byteArray.length; i++) {
            byteArray[i] = Byte.parseByte(byteString[i]);
        }
        return byteArray;
    }
}
