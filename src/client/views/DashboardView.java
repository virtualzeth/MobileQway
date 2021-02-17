package client.views;

import client.UserState;
import handlers.ErrorHandler;

public class DashboardView extends View {
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
}
