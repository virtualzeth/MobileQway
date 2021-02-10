package app;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);

    public int menu() {
        while (true) {
            System.out.println("[1] Login");
            System.out.println("[2] Create Account");
            System.out.println("[0] Exit");

            System.out.print("Input: ");
            int input = scanner.nextInt();
            if(input >= 0 && input <= 2) return input;
            else System.out.println("Invalid input...");
        }
    }
}
