package client.controllers;

import client.Redirect;
import client.UserState;
import client.views.loginView;
import handlers.ErrorHandler;
import handlers.ValidationHandler;
import server.account.AccountHandler;

public class loginController {
    client.views.loginView loginView = new loginView();

    public void loginMenu() {
        switch (loginView.loginMenu()) {
            case 0 -> exit();
            case 1 -> login();
            case 2 -> createAccount();
            default -> ErrorHandler.invalidInputError();
        }
    }
    public void dashboard() {
        // TODO
        switch (loginView.dashboard()) {
            case 0 -> exit();
            default -> ErrorHandler.invalidInputError();
        }
    }
    private void exit() {
        System.exit(0);
    }
    private void login() {
        String phoneNumber = loginView.askForPhoneNumber();
        if(ValidationHandler.validatePhoneNumber(phoneNumber)) {
            String password = loginView.askForPassword();

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
        String name = loginView.askForName();
        if(ValidationHandler.validateName(name)) {
            String phoneNumber = loginView.askForPhoneNumber().replace(" ", "").replace("-", "").replace(".", "").replace("_", "");

            if(ValidationHandler.validatePhoneNumber(phoneNumber)) {
                String password = loginView.askForPassword();

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
