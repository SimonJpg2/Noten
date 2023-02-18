package de.simonjpg.noten.Backend.Repository;

import java.util.UUID;

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
    private String uuid;

    public User() {
    }

    public User(String username, String email, String password, String uuid) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.uuid = uuid;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(int id, String username, String email, String password, String uuid) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.uuid = uuid;
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

    public String getUuid() {
        return uuid;
    }
}
