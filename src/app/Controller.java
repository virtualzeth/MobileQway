package app;

import handlers.ErrorHandler;
import server.AccountHandler;

public class Controller {

    UserInterface userInterface = new UserInterface();

    public void loginMenu() {
        switch (userInterface.loginMenu()) {
            case 0 -> exit();
            case 1 -> login();
            case 2 -> createAccount();
            default -> ErrorHandler.invalidInputError();
        }
    }
    private void exit() {
        System.exit(0);
    }
    private void login() {

    }
    private void createAccount() {
        String phoneNumber = userInterface.askForPhoneNumber().replace(" ", "").replace("-", "").replace(".", "").replace("_", "");
        String password = userInterface.askForPassword();
        AccountHandler.createAccountInitialization(phoneNumber, password);
    }
}
