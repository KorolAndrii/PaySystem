package ua.korol.pay_system.service;

import ua.korol.pay_system.persistence.model.Account;

public interface AccountService extends Service {
    Account getAccountById(Long id);

    long insertAccount(Account account);

    long deleteAccount(Account account);

    long updateAccount(Account account);
}
