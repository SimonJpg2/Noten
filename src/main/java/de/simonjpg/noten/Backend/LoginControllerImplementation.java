package de.simonjpg.noten.Backend;

import de.simonjpg.noten.Backend.DB.LoginController;

import java.util.List;

public class LoginControllerImplementation implements LoginController {

    // TODO implement method logic

    @Override
    public List<User> select() {
        return null;
    }

    @Override
    public User selectById(int id) {
        return null;
    }

    @Override
    public boolean create(User user) {
        return false;
    }

    @Override
    public boolean updateById(int id, User user) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
