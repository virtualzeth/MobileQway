package client;

import handlers.ErrorHandler;
import handlers.ValidationHandler;
import server.account.AccountHandler;

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
        String phoneNumber = userInterface.askForPhoneNumber();
        if(ValidationHandler.validatePhoneNumber(phoneNumber)) {
            String password = userInterface.askForPassword();

            if(ValidationHandler.validatePassword(password)) {
                boolean success = AccountHandler.loginAccount(phoneNumber, password);
                if(success) {
                    UserState.setState(phoneNumber);
                    Redirect.dashboard();
                }

            } else ErrorHandler.invalidPasswordError();
        } else ErrorHandler.invalidPhoneNumberError();
    }
    private void createAccount() {
        String name = userInterface.askForName();
        if(ValidationHandler.validateName(name)) {
            String phoneNumber = userInterface.askForPhoneNumber().replace(" ", "").replace("-", "").replace(".", "").replace("_", "");

            if(ValidationHandler.validatePhoneNumber(phoneNumber)) {
                String password = userInterface.askForPassword();

                if(ValidationHandler.validatePassword(password)) {
                    boolean success = AccountHandler.createAccount(phoneNumber, password, name);
                    if(success) {
                        UserState.setState(phoneNumber);
                        Redirect.dashboard();
                    }

                } else ErrorHandler.invalidPasswordError();
            } else ErrorHandler.invalidPhoneNumberError();
        } else ErrorHandler.invalidNameError();
    }
}
