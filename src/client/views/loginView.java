package client.views;

import client.UserState;
import handlers.ErrorHandler;

import java.util.Scanner;

public class loginView {
    Scanner scanner = new Scanner(System.in);
    
    private int input() {
        System.out.print("Input: ");
        String input = scanner.nextLine();
        return handlers.ValidationHandler.validateNumber99(input) ? Integer.parseInt(input) : -1;
    }
    public int loginMenu() {
        while (true) {
            System.out.println("[1] Login");
            System.out.println("[2] Create Account");
            System.out.println("[0] Exit");

            int input = input();
            if(input >= 0 && input <= 2) return input;
            else ErrorHandler.invalidInputError();
        }
    }
    public int dashboard() {
        System.out.printf("Welcome the dashboard %s!\n\n", UserState.getName());
        while (true) {
            System.out.println("[1] Transfer funds");
            System.out.println("[2] Add card");
            System.out.println("[3] Update card");
            System.out.println("[4] Update address");
            System.out.println("[0] Exit");

            int input = input();
            if(input >= 0 && input <= 4) return input;
            else ErrorHandler.invalidInputError();
        }
    }
    public String askForName() {
        System.out.print("Full name: ");
        return scanner.nextLine();
    }
    public String askForPhoneNumber() {
        System.out.print("Phone number: ");
        return scanner.nextLine();
    }
    public String askForPassword() {
        System.out.print("Password: ");
        return scanner.nextLine();
    }
}
