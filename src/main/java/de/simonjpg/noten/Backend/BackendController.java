package de.simonjpg.noten.Backend;

import de.simonjpg.noten.Backend.DB.Database;
import de.simonjpg.noten.Backend.DB.DatabaseController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class BackendController.
 *
 * <p>
 *     Implementation of SQL statements.
 * </p>
 * @author SimonJpg
 * @version 3.0
 * @since 29.12.2022
 */

public class BackendController implements DatabaseController {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private final String[] forbiddenChars = {"'", "\"", ")", "(", ";", "-"};

    /**
     * Constructor BackendController.
     *
     * <p>
     *     Initializes a connection to the underlying MySQL Database.
     *
     *     Could cause a NullPointerException if connection to DB failed.
     * </p>
     */

    public BackendController() {
        connection = new Database().init();
    }

    /**
     * Method select.
     *
     * <p>
     *     select all subjects of q1 table.
     * </p>
     *
     * @return a {@link java.util.List} instance.
     */
    @Override
    public List<Fach> select(String table) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("SELECT * FROM " + table);
            resultSet = statement.getResultSet();

            List<Fach> fachList = new ArrayList<>();

            while (resultSet.next()) {
               fachList.add(new Fach(
                       resultSet.getInt("id"),
                       resultSet.getString("fach").trim(),
                       resultSet.getInt("note")
               ));
            }
            resultSet.close();
            return  fachList;
        } catch (SQLException | NullPointerException e) {
            System.err.println(e.getMessage());
            preparedStatement = null;
            resultSet = null;
            return new ArrayList<>();
        }

    }

    /**
     * Method selectById.
     *
     * <p>
     *     Selects a subject by id.
     * </p>
     *
     * @param id an {@link java.lang.Integer} the id.
     * @return a {@link de.simonjpg.noten.Backend.Fach} instance.
     */

    @Override
    public Fach selectById(int id) {
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM q1 WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();

            Fach fach = new Fach(
                    resultSet.getInt("id"),
                    resultSet.getString("fach"),
                    resultSet.getInt("note")
            );

            preparedStatement.close();
            resultSet.close();
            return fach;
        } catch (SQLException | NullPointerException e) {
            System.err.println(e.getMessage());
            preparedStatement = null;
            resultSet = null;
            return new Fach();
        }
    }

    /**
     * Method create.
     *
     * <p>
     *     Creates new subject in Database.
     * </p>
     *
     * @param fach the {@link de.simonjpg.noten.Backend.Fach} to be added.
     * @return a {@link java.lang.Boolean} if succeeded.
     */

    @Override
    public boolean create(Fach fach, String table) {
        for (String str : forbiddenChars) {
            if (fach.getName().contains(str)) {
                System.err.println("Forbidden character, could lead to SQL Injection\n");
                return false;
            }
        }

        String statementQ1 = "INSERT INTO q1 (fach, note) VALUES (?, ?)";
        String statementQ2 = "INSERT INTO q2 (fach, note) VALUES (?, ?)";
        String statementQ3 = "INSERT INTO q3 (fach, note) VALUES (?, ?)";
        String statementQ4 = "INSERT INTO q4 (fach, note) VALUES (?, ?)";

        String statement = table.equals("q1") ? statementQ1 : table.equals("q2") ? statementQ2 : table.equals("q3") ? statementQ3 : statementQ4;

        try {
            preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, fach.getName());
            preparedStatement.setInt(2, fach.getNote());
            boolean success = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            return success;
        } catch (SQLException | NullPointerException e) {
            System.err.println(e.getMessage());
            preparedStatement = null;
            return false;
        }
    }

    /**
     * Method updateById.
     *
     * <p>
     *     Updates existing subject entry by id.
     * </p>
     * @param id the {@link java.lang.Integer} id.
     * @param fach the updatet {@link de.simonjpg.noten.Backend.Fach}.
     * @return a {@link java.lang.Boolean} if succeeded.
     */

    @Override
    public boolean updateById(int id, Fach fach, String table) {
        for (String str : forbiddenChars) {
            if (fach.getName().contains(str)) {
                System.err.println("Forbidden character, could lead to SQL Injection\n");
                return false;
            }
        }

        String statementQ1 = "UPDATE q1 SET fach = ?, note = ? WHERE id = ?";
        String statementQ2 = "UPDATE q2 SET fach = ?, note = ? WHERE id = ?";
        String statementQ3 = "UPDATE q3 SET fach = ?, note = ? WHERE id = ?";
        String statementQ4 = "UPDATE q4 SET fach = ?, note = ? WHERE id = ?";

        String statement = table.equals("q1") ? statementQ1 : table.equals("q2") ? statementQ2 : table.equals("q3") ? statementQ3 : statementQ4;

        try {
            preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, fach.getName());
            preparedStatement.setInt(2, fach.getNote());
            preparedStatement.setInt(3, id);
            boolean success = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            return success;
        } catch (SQLException | NullPointerException e) {
            System.err.println(e.getMessage());
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
    public boolean deleteById(int id, String table) {
        String statementQ1 = "DELETE FROM q1 WHERE id = ?";
        String statementQ2 = "DELETE FROM q2 WHERE id = ?";
        String statementQ3 = "DELETE FROM q3 WHERE id = ?";
        String statementQ4 = "DELETE FROM q4 WHERE id = ?";

        String statement = table.equals("q1") ? statementQ1 : table.equals("q2") ? statementQ2 : table.equals("q3") ? statementQ3 : statementQ4;

        try {
            preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setInt(1, id);
            boolean success = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            return success;
        } catch (SQLException | NullPointerException e) {
            System.err.println(e.getMessage());
            preparedStatement = null;
            return false;
        }
    }
}
