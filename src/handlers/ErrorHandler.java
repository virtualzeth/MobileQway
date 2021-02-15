package handlers;

import client.Redirect;

public class ErrorHandler {
    public static void invalidInputError() {
        System.out.println("ERROR: INVALID INPUT");
        System.out.println("Please enter a valid number.");
    }
    public static void invalidNameError() {
        System.out.println("ERROR: INVALID NAME");
        System.out.println("Please only use letters in the english language.");
        Redirect.loginMenu();
    }
    public static void invalidPhoneNumberError() {
        System.out.println("ERROR: INVALID PHONE NUMBER");
        System.out.println("Numbers must be 8 characters long");
        Redirect.loginMenu();
    }
    public static void invalidPasswordError() {
        System.out.println("ERROR: INVALID PASSWORD");
        System.out.println("Passwords must contain at least eight characters, at least one number and both lower and uppercase letters.");
        System.out.println("Only letters and numbers are allowed.");
        Redirect.loginMenu();
    }
    public static void passwordMatchError() {
        System.out.println("ERROR: INCORRECT PASSWORD");
        System.out.println("The password you have entered does not match with this user's password.");
        Redirect.loginMenu();
    }
    public static void noConnectionError() {
        System.out.println("ERROR: NO CONNECTION");
        System.out.println("Could not establish a connection to the server.");
        Redirect.loginMenu();
    }
    public static void userExistsError() {
        System.out.println("ERROR: USER ALREADY EXISTS");
        Redirect.loginMenu();
    }
    public static void credentialsRetrievalError() {
        System.out.println("ERROR: FAILED CREDENTIALS RETRIEVAL");
        System.out.println("Could not find credentials.");
        Redirect.loginMenu();
    }
}
