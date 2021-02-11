package server;

import handlers.ErrorHandler;
import server.reporters.AccountReporter;

import java.security.SecureRandom;
import java.sql.Connection;
import java.util.Arrays;

public class AccountHandler {
    public static void createAccount(String phoneNumber, String password, String name) {
        Connection conn = DatabaseHandler.connect();

        if(conn != null) {
            if(!AccountReporter.userExists(conn, phoneNumber)) {
                String salt = generateSalt();

            } else ErrorHandler.userExistsError();
        } else ErrorHandler.noConnectionError();
    }
    private static String generateSalt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : salt) {
            stringBuilder.append(b).append("&");
        }
        return stringBuilder.toString();
    }
}
