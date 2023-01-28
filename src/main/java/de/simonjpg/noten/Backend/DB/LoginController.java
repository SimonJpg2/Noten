package de.simonjpg.noten.Backend.DB;

import de.simonjpg.noten.Backend.Repository.User;

import java.util.List;

public interface LoginController {
    List<User> select();
    User selectById(int id);
    boolean create(User user);
    boolean updateById(int id, User user);
    boolean deleteById(int id);
}
