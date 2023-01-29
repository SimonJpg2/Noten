package de.simonjpg.noten.Backend.Controller;

import de.simonjpg.noten.Backend.DB.Database;
import de.simonjpg.noten.Backend.DB.LoginController;
import de.simonjpg.noten.Backend.Repository.User;
import de.simonjpg.noten.Backend.Security.SHA256;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static de.simonjpg.noten.Backend.Security.BadCharacters.FORBIDDEN;

/**
 * Class LoginControllerImplementation.
 *
 * <p>
 *     This class contains logic to store data of the user in a database.
 * </p>
 *
 * @version 1.0
 * @since 28.1.2023
 * @author SimonJpg
 * @see de.simonjpg.noten.Backend.DB.LoginController
 */

public class LoginControllerImplementation implements LoginController {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private final SHA256 sha256;

    /**
     * Constructor LoginControllerImplementation.
     *
     * <p>
     *     Creates connection to database login.
     * </p>
     *
     * @since 28.1.2023
     * @author SimonJpg
     */

    public LoginControllerImplementation() {
        this.connection = new Database().init("jdbc:mysql://localhost:3306/login");
        sha256 = new SHA256();
    }

    /**
     * Constructor LoginControllerImplementation.
     *
     * <p>
     *     Creates connection to database test.
     * </p>
     *
     * @since 28.1.2023
     * @author SimonJpg
     */

    public LoginControllerImplementation(String url) {
        this.connection = new Database().init(url);
        sha256 = new SHA256();
    }

    /**
     * Method select.
     *
     * <p>
     *     selects all users from database login
     * </p>
     *
     * @return an {@link java.util.List} instance.
     */

    @Override
    public List<User> select() {
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM users");
            resultSet = preparedStatement.executeQuery();

            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                users.add(
                        new User(
                                resultSet.getInt("id"),
                                resultSet.getString("username"),
                                resultSet.getString("email"),
                                resultSet.getString("password")
                        )
                );
            }
            resultSet.close();
            preparedStatement.close();
            return users;
        } catch (SQLException | NullPointerException e) {
            System.err.printf("selection failed: %s", e.getMessage());
            preparedStatement = null;
            resultSet = null;
            return new ArrayList<>();
        }
    }

    /**
     * Method selectById.
     *
     * <p>
     *     Selects a user by id.
     * </p>
     *
     * @param id an {@link java.lang.Integer} the id.
     * @return a {@link User} instance.
     */

    @Override
    public User selectById(int id) {
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            User user = new User(
                    resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("email"),
                    resultSet.getString("password")
            );
            resultSet.close();
            preparedStatement.close();
            return user;
        } catch (SQLException | NullPointerException e) {
            System.err.printf("selectById failed: %s", e.getMessage());
            preparedStatement = null;
            resultSet = null;
            return new User();
        }
    }

    /**
     * Method create.
     *
     * <p>
     *     Creates new user in Database.
     *     Hashes the email and password before it is stored in the database.
     * </p>
     *
     * @param user the {@link User} to be added.
     * @return a {@link java.lang.Boolean} if succeeded.
     */

    @Override
    public boolean create(User user) {
        for (String str : FORBIDDEN) {
            if (user.getUsername().contains(str) || user.getEmail().contains(str) || user.getPassword().contains(str)) {
                System.err.println("Forbidden character, could lead to SQL Injection\n");
                return false;
            }
        }

        try {
            preparedStatement = connection.prepareStatement("INSERT INTO users (username, email, password) VALUES (?, ?, ?)");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, sha256.hash(user.getPassword()));
            boolean success = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            return success;
        } catch (SQLException | RuntimeException e) {
            System.err.printf("Insertion failed: %s", e.getMessage());
            preparedStatement = null;
            return false;
        }
    }

    /**
     * Method updateById.
     *
     * <p>
     *     Updates existing user entry by id.
     *     Hashes the email and password before it is stored in the database.
     * </p>
     * @param id the {@link java.lang.Integer} id.
     * @param user the updatet {@link User}.
     * @return a {@link java.lang.Boolean} if succeeded.
     */

    @Override
    public boolean updateById(int id, User user) {
        for (String str : FORBIDDEN) {
            if (user.getUsername().contains(str) || user.getEmail().contains(str) || user.getPassword().contains(str)) {
                System.err.println("Forbidden character, could lead to SQL Injection\n");
                return false;
            }
        }

        try {
            preparedStatement = connection.prepareStatement("UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, sha256.hash(user.getPassword()));
            preparedStatement.setInt(4, id);
            boolean success = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            return success;
        } catch (SQLException | RuntimeException e) {
            System.err.printf("UpdateById failed: %s", e.getMessage());
            preparedStatement = null;
            return false;
        }
    }

    /**
     * Method deleteById.
     *
     * <p>
     *     Deletes an existing entry by id.
     * </p>
     * @param id the {@link java.lang.Integer} id.
     * @return a {@link java.lang.Boolean} if succeeded.
     */

    @Override
    public boolean deleteById(int id) {
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            preparedStatement.setInt(1, id);
            boolean success = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            return success;
        } catch (SQLException | NullPointerException e) {
            System.err.printf("DeleteById failed: %s", e.getMessage());
            preparedStatement = null;
            return false;
        }
    }
}
