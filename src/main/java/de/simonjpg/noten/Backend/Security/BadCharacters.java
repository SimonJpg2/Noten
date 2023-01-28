package de.simonjpg.noten.Backend.Security;

/**
 * Class BadCharacters.
 *
 * <p>
 *     This class contains bad characters which could lead to SQL-Injections.
 * </p>
 *
 * @version 1.0
 * @since 28.1.2023
 * @author SimonJpg
 */

public class BadCharacters {
    public static final String[] FORBIDDEN = {"'", "\"", ")", "(", ";", "-"};
}
