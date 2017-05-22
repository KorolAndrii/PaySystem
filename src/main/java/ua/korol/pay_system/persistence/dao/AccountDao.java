package ua.korol.pay_system.persistence.dao;

import ua.korol.pay_system.persistence.model.Account;

import java.sql.Connection;

public interface AccountDao extends Dao {
    Account getById(Long id);

    Account getByUserId(Long userId);

    long insertAccount(Account account);

    long deleteAccount(Account account);

    long updateAccount(Account account);

    long insertAccount(Account account, Connection connection);
}

