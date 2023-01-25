package de.simonjpg.noten.Backend;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class BackendControllerTest.
 *
 * <p>
 *     This class tests if input validation could lead to SQL Injection.
 * </p>
 *
 * @since 6.1.2023
 * @version 1.0
 * @author SimonJpg
 */

public class BackendControllerTest {
    private final BackendController controller = new BackendController("jdbc:mysql://localhost:3306/test");

    @Test
    void create() {
        assertFalse(controller.create(new Fach("'", 1), "q1"));
        assertFalse(controller.create(new Fach("\"", 1), "q1"));
        assertFalse(controller.create(new Fach("'SELECT", 1), "q1"));
        assertFalse(controller.create(new Fach("USE;", 1), "q1"));

        assertTrue(controller.create(new Fach("Mathe", 15), "q1"));
        assertTrue(controller.create(new Fach("Mathe", 15), "q2"));
        assertTrue(controller.create(new Fach("Mathe", 15), "q3"));
        assertTrue(controller.create(new Fach("Mathe", 15), "q4"));
    }

    @Test
    void updateById() {
        assertFalse(controller.updateById(1, new Fach("'", 1), "q1"));
        assertFalse(controller.updateById(1, new Fach("\"", 1), "q1"));
        assertFalse(controller.updateById(1, new Fach("'SELECT", 1), "q1"));
        assertFalse(controller.updateById(1, new Fach("USE;", 1), "q1"));

        assertTrue(controller.updateById(1, new Fach("Mathe", 1), "q1"));
        assertTrue(controller.updateById(1, new Fach("Mathe", 1), "q2"));
        assertTrue(controller.updateById(1, new Fach("Mathe", 1), "q3"));
        assertTrue(controller.updateById(1, new Fach("Mathe", 1), "q4"));
    }

    @Test
    void select() {
        assertEquals(1, controller.select("q1").get(0).getNote());
        assertEquals(1, controller.select("q2").get(0).getNote());
        assertEquals(1, controller.select("q3").get(0).getNote());
        assertEquals(1, controller.select("q4").get(0).getNote());
    }

    @Test
    void selectById() {
        assertEquals(1, controller.selectById(1).getNote());
    }

    @Test
    void deleteById() {
        assertTrue(controller.deleteById(2, "q1"));
        assertTrue(controller.deleteById(2, "q2"));
        assertTrue(controller.deleteById(2, "q3"));
        assertTrue(controller.deleteById(2, "q4"));
    }
}