package client;

public class Redirect {
    private static final Controller controller = new Controller();

    public static void loginMenu() {
        System.out.print("\n");
        controller.loginMenu();
    }
    public static void dashboard() {
        System.out.print("\n");
        controller.dashboard();
    }
}
