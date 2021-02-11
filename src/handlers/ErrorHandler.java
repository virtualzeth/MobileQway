package handlers;

import app.Redirect;

public class ErrorHandler {
    public static void invalidInputError() {
        System.out.println("ERROR: INVALID INPUT");
        System.out.println("Please enter a valid number.");
    }
    public static void invalidPhoneNumberError() {
        System.out.println("ERROR: INVALID PHONE NUMBER");
        System.out.println("Numbers must be 8 characters long");
        Redirect.loginMenu();
    }
    public static void invalidPasswordError() {
        System.out.println("ERROR: INVALID PASSWORD");
        System.out.println("Password must contain at least eight characters, at least one number and both lower and uppercase letters.");
        System.out.println("Only letters and numbers are allowed.");
        Redirect.loginMenu();
    }
    public static void noConnectionError() {
        System.out.println("ERROR: NO CONNECTION");
        System.out.println("Could not establish a connection to the server");
        Redirect.loginMenu();
    }
    public static void userExistsError() {

    }
}
