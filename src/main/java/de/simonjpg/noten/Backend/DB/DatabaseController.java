package de.simonjpg.noten.Backend.DB;

import de.simonjpg.noten.Backend.Fach;

import java.util.List;

/**
 * Interface DatabaseController.
 *
 * <p>
 *     Controls SQL statements
 * </p>
 * @author SimonJpg
 * @version 2.0
 * @since 28.12.2022
 */

public interface DatabaseController {
    List<Fach> select(String table);
    Fach selectById(int id);
    boolean create(Fach fach, String table);
    boolean updateById(int id, Fach fach, String table);
    boolean deleteById(int id, String table);
}
