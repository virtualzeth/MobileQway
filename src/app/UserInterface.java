package app;

import handlers.ErrorHandler;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);

    protected int loginMenu() {
        while (true) {
            System.out.println("[1] Login");
            System.out.println("[2] Create Account");
            System.out.println("[0] Exit");

            System.out.print("Input: ");
            int input = scanner.nextInt();
            scanner.nextLine();
            if(input >= 0 && input <= 2) return input;
            else ErrorHandler.invalidInputError();
        }
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
