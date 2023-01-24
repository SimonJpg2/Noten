package de.simonjpg.noten.Backend.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class Database.
 * Class to connect to MySQL DB.
 *
 * @author  SimonJpg
 * @version 2.0
 * @since 28.12.2022
 */

public class Database {
    private final String url = "jdbc:mysql://localhost:3306/noten";
    private Connection connection;

    public Connection init() {
        System.out.println("Connecting to Database...\n");

        try {
            connection = DriverManager.getConnection(url, "root", "SET YOUR PASSWORD HERE");
            System.out.println("Connection established.\n");
            return connection;
        } catch (SQLException e) {
            System.err.printf("Connection failed:%n %s", e.getMessage());
            return null;
        }
    }

    @SuppressWarnings("unused")
    public void close() {
        try {
            connection.close();
            System.out.println("Connection closed.");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
