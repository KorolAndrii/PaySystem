package ua.korol.pay_system.persistence.dao;

import ua.korol.pay_system.persistence.model.User;

import java.sql.Connection;

public interface UserDao extends Dao {
    User getById(Long id);

    User getByUsername(String id);

    long insertUser(User user);

    long deleteUser(User user);

    long updateUser(User user);

    long insertUser(User user, Connection connection);
}
