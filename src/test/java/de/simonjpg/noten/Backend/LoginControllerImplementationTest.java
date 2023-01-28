package de.simonjpg.noten.Backend;

import de.simonjpg.noten.Backend.Security.SHA256;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerImplementationTest {
    private final LoginControllerImplementation loginController = new LoginControllerImplementation("jdbc:mysql://localhost:3306/test");
    private final SHA256 sha256 = new SHA256();

    @Test
    void init() {
        assertNotNull(loginController);
    }

    @Test
    void select() {
        // given
        List<User> expected = new ArrayList<>();
        expected.add(new User(
                "Max Mustermann",
                "Muster@Email.de",
                sha256.hash("SuperSecretPassword")
        ));

        // when
        List<User> actual = loginController.select();

        // then
        assertEquals(expected.get(0).getUsername(), actual.get(0).getUsername());
        assertEquals(expected.get(0).getEmail() ,actual.get(0).getEmail());
        assertEquals(expected.get(0).getPassword(), actual.get(0).getPassword());
    }

    @Test
    void selectById() {
        // given
        User expected = new User(
                "Max Mustermann",
                "Muster@Email.de",
                sha256.hash("SuperSecretPassword"));

        // when
        User actual = loginController.selectById(1);

        // then
        assertEquals(expected.getUsername(), actual.getUsername());
        assertEquals(expected.getEmail() ,actual.getEmail());
        assertEquals(expected.getPassword(), actual.getPassword());
    }

    @Test
    void create() {
        // given
        User actual = new User("Max Mustermann", "Muster@Email.de", "SuperSecretPassword");
        User user1 = new User(
                "Max Mustermann",
                "'OR '1'='1",
                "SuperSecretPassword"
        );
        User user2 = new User(
                "Max Mustermann",
                "Muster@Email.de",
                "'OR '1'='1"
        );
        User user3 = new User(
                "'OR '1'='1",
                "Muster@Email.de",
                "SuperSecretPassword"
        );
        assertFalse(loginController.create(user1));
        assertFalse(loginController.create(user2));
        assertFalse(loginController.create(user3));
        assertTrue(loginController.create(actual));
    }

    @Test
    void updateById() {
        // given
        User actual = new User("Max Mustermann", "Muster@Email.de", "SuperSecretPassword");
        User user1 = new User(
                "Max Mustermann",
                "'OR '1'='1",
                "SuperSecretPassword"
        );
        User user2 = new User(
                "Max Mustermann",
                "Muster@Email.de",
                "'OR '1'='1"
        );
        User user3 = new User(
                "'OR '1'='1",
                "Muster@Email.de",
                "SuperSecretPassword"
        );

        // then
        assertFalse(loginController.updateById(1, user1));
        assertFalse(loginController.updateById(1, user2));
        assertFalse(loginController.updateById(1, user3));
        assertTrue(loginController.updateById(1, actual));
    }

    @Test
    void deleteById() {
        assertTrue(loginController.deleteById(2));
    }
}