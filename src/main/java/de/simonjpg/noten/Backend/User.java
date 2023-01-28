package de.simonjpg.noten.Backend;

/**
 * Class User.
 *
 * <p>
 *     This class represents a user for this application.
 * </p>
 *
 * @version 1.0
 * @since 28.1.2023
 * @author SimonJpg
 */

public class User {
    private int id;
    private String username;
    private String email;
    private String password;

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
