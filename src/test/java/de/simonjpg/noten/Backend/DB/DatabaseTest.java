package de.simonjpg.noten.Backend.DB;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    @Test
    void init() {
        // given
        Database db = new Database();

        try {
            Connection connection = db.init("jdbc:mysql://localhost:3306/test");
            assertFalse(connection.isClosed());
        } catch (SQLException e) {
            fail("No open connection.");
        }
    }
}