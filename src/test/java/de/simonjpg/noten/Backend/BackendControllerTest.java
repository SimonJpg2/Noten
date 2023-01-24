package de.simonjpg.noten.Backend;

import org.junit.jupiter.api.Test;

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

    @Test
    void create() {
        // given
        BackendController controller = new BackendController();

        assertFalse(controller.create(new Fach("'", 1), "q1"));
        assertFalse(controller.create(new Fach("\"", 1), "q1"));
        assertFalse(controller.create(new Fach("'SELECT", 1), "q1"));
        assertFalse(controller.create(new Fach("USE;", 1), "q1"));
    }

    @Test
    void updateById() {
        // given
        BackendController controller = new BackendController();

        assertFalse(controller.updateById(1, new Fach("'", 1), "q1"));
        assertFalse(controller.updateById(1, new Fach("\"", 1), "q1"));
        assertFalse(controller.updateById(1, new Fach("'SELECT", 1), "q1"));
        assertFalse(controller.updateById(1, new Fach("USE;", 1), "q1"));
    }
}