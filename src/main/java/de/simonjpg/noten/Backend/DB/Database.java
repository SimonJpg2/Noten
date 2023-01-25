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
    private String url = "jdbc:mysql://localhost:3306/noten";
    private Connection connection;

    public Connection init() {
        System.out.println("Connecting to Database...\n");

        try {
            connection = DriverManager.getConnection(url, "root", "your password");
            System.out.println("Connection established.\n");
            return connection;
        } catch (SQLException e) {
            System.err.printf("Connection failed:%n %s", e.getMessage());
            return null;
        }
    }

    /**
     * method init.
     *
     * <p>
     *     This method should only be used for the testcase.
     * </p>
     *
     * @param url the url to the database.
     * @return an {@link java.sql.Connection} instance.
     */
    public Connection init(String url) {
        if (url == null) {
            return null;
        }
        this.url = url;
        return init();
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
