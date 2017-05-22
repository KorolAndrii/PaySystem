package ua.korol.pay_system.service.impl;

import ua.korol.pay_system.persistence.dao.AccountDao;
import ua.korol.pay_system.persistence.dao.DaoFactory;
import ua.korol.pay_system.persistence.dao.DataSourceSingleton;
import ua.korol.pay_system.persistence.dao.UserDao;
import ua.korol.pay_system.persistence.model.Account;
import ua.korol.pay_system.persistence.model.User;
import ua.korol.pay_system.persistence.model.proxy.UserProxy;
import ua.korol.pay_system.persistence.model.real.AccountImpl;
import ua.korol.pay_system.service.UserService;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private AccountDao accountDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
        accountDao = DaoFactory.getAccountDao();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public User getUserByUsername(String id) {
        return userDao.getByUsername(id);
    }

    @Override
    public long insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public long deleteUser(User user) {
        return userDao.deleteUser(user);
    }

    @Override
    public long updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean registration(User user) {
        try (Connection connection = DataSourceSingleton.getInstance().getConnection()) {
            connection.setAutoCommit(false);
            long userId = userDao.insertUser(user, connection);
            System.out.println(userId);
            Account account = new AccountImpl();
            account.setBalance(0.0);
            account.setUser(new UserProxy(userId));
            accountDao.insertAccount(account, connection);
            connection.commit();
        } catch (SQLException e) {
            System.out.println("[eqyz");
            return false;
        }
        return true;
    }
}
