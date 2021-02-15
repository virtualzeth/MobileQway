package client;

public class UserState {
    private static final String undefined = "UNDEFINED";
    private static String name = undefined, phoneNumber = undefined;

    public static String getName() {
        return name;
    }
}
