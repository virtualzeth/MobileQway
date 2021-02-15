package server.account;

import client.State;
import handlers.ErrorHandler;
import handlers.ValidationHandler;
import server.DatabaseHandler;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccountHandler {
    public static boolean loginAccount(String phoneNumber, String password) {
        Connection conn = DatabaseHandler.connect();

        if(conn != null) {
            if(AccountReporter.userExists(conn, phoneNumber)) {
                byte[][] credentials = AccountReporter.getCredentials(conn, phoneNumber);

                if(credentials != null) {
                    try {
                        byte[] hash = PBKDF2Hash(credentials[0], phoneNumber);

                        if(ValidationHandler.validateHash(credentials[1], hash)) {
                            State.setState(phoneNumber);
                            return true;
                        } else ErrorHandler.incorrectPasswordError();
                    } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }
                } else ErrorHandler.credentialsRetrievalError();
            } else ErrorHandler.userExistsError();
        } else ErrorHandler.noConnectionError();
        return false;
    }
    public static boolean createAccount(String phoneNumber, String password, String name) {
        Connection conn = DatabaseHandler.connect();

        if(conn != null) {
            if(!AccountReporter.userExists(conn, phoneNumber)) {
                byte[] salt = generateSalt();
                try {
                    byte[] hash = PBKDF2Hash(salt, password);
                    AccountReporter.storeNewAccount(conn, phoneNumber, salt, hash, name, getCurrentDate());
                    conn.close();

                    State.setState(phoneNumber);
                    return true;
                } catch (NoSuchAlgorithmException | InvalidKeySpecException | SQLException e) {
                    e.printStackTrace();
                }
            } else ErrorHandler.userExistsError();
        } else ErrorHandler.noConnectionError();
        return false;
    }
    private static byte[] generateSalt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return salt;

    }
    private static byte[] PBKDF2Hash(byte[] salt, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, 64536, 128);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        return secretKeyFactory.generateSecret(keySpec).getEncoded();
    }
    private static String getCurrentDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dateTimeFormatter.format(now);
    }
}
