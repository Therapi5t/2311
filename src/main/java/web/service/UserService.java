package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(User user);

    User getByIdUser(Long id);

    void addUser(User user);

    User getUserById(long id);

    void updateUser(long id, User user);
}
