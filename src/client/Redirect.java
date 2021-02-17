package client;

import client.controllers.loginController;

public class Redirect {
    private static final loginController LOGIN_CONTROLLER = new loginController();

    public static void loginMenu() {
        System.out.print("\n");
        LOGIN_CONTROLLER.loginMenu();
    }
    public static void dashboard() {
        System.out.print("\n");
        LOGIN_CONTROLLER.dashboard();
    }
}
