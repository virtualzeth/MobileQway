package server;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ToolHandler {
    public static String getCurrentDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dateTimeFormatter.format(now);
    }
}
