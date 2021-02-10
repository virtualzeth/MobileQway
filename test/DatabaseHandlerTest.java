import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import persistance.DatabaseHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseHandlerTest {
    @Test
    public void connectionNotNull() throws SQLException {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        Connection conn = databaseHandler.connect();

        Assertions.assertNotNull(conn);
        conn.close();
    }
}
