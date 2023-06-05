package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(User user);

    User getByIdUser(Long id);

    User getUser(long id);
}
