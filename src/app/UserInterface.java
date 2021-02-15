package app;

import handlers.ErrorHandler;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    
    private int input() {
        System.out.print("Input: ");
        String input = scanner.nextLine();
        return handlers.ValidationHandler.validateNumber99(input) ? Integer.parseInt(input) : -1;
    }
    protected int loginMenu() {
        while (true) {
            System.out.println("[1] Login");
            System.out.println("[2] Create Account");
            System.out.println("[0] Exit");

            int input = input();
            if(input >= 0 && input <= 2) return input;
            else ErrorHandler.invalidInputError();
        }
    }
    protected int dashboard() {
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
    protected String askForName() {
        System.out.println("Full name: ");
        return scanner.nextLine();
    }
    protected String askForPhoneNumber() {
        System.out.println("Phone number: ");
        return scanner.nextLine();
    }
    protected String askForPassword() {
        System.out.println("Password: ");
        return scanner.nextLine();
    }
}
