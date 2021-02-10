package app;

public class Controller {

    UserInterface userInterface = new UserInterface();

    public void menu() {
        switch (userInterface.menu()) {
            case 0 -> exit();
            case 1 -> login();
            case 2 -> createAccount();
            default -> System.out.println("ERROR: inputError");
        }
    }
    private void exit() {
        System.exit(0);
    }
    public void login() {

    }
    public void createAccount() {

    }
}
