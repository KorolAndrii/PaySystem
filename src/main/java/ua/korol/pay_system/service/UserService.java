package ua.korol.pay_system.service;

import ua.korol.pay_system.persistence.model.User;

public interface UserService extends Service{
    User getUserById(Long id);

    User getUserByUsername(String id);

    long insertUser(User user);

    long deleteUser(User user);

    boolean registration(User user);

    long updateUser(User user);
}
