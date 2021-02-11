package server;

import handlers.ErrorHandler;
import server.reporters.AccountReporter;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Connection;

public class AccountHandler {
    public static void createAccount(String phoneNumber, String password, String name) {
        Connection conn = DatabaseHandler.connect();

        if(conn != null) {
            if(!AccountReporter.userExists(conn, phoneNumber)) {
                byte[] salt = generateSalt();
                byte[] hash;
                try {
                    hash = PBKDF2Hash(salt, password);
                } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                    e.printStackTrace();
                }

            } else ErrorHandler.userExistsError();
        } else ErrorHandler.noConnectionError();
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
}
