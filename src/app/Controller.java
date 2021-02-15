package app;

import handlers.ErrorHandler;
import handlers.ValidationHandler;
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
    public void dashboard() {
        // TODO
        switch (userInterface.dashboard()) {
            case 0 -> exit();
            default -> ErrorHandler.invalidInputError();
        }
    }
    private void exit() {
        System.exit(0);
    }
    private void login() {

    }
    private void createAccount() {
        String name = userInterface.askForName();
        String phoneNumber = userInterface.askForPhoneNumber().replace(" ", "").replace("-", "").replace(".", "").replace("_", "");
        String password = userInterface.askForPassword();
        if(ValidationHandler.validateName(name)) {
            boolean isValidPhoneNumber = ValidationHandler.validatePhoneNumber(phoneNumber);
            boolean isValidPassword = ValidationHandler.validatePassword(password);

            if(isValidPhoneNumber) {
                if(isValidPassword) {
                    AccountHandler.createAccount(phoneNumber, password, name);
                } else ErrorHandler.invalidPasswordError();
            } else ErrorHandler.invalidPhoneNumberError();
        } else ErrorHandler.invalidNameError();
    }
}
