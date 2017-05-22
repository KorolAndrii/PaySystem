package ua.korol.pay_system.service.impl;

import ua.korol.pay_system.persistence.dao.AccountDao;
import ua.korol.pay_system.persistence.dao.CardDao;
import ua.korol.pay_system.persistence.model.Account;
import ua.korol.pay_system.service.AccountService;

public class AccountServiceImpl implements AccountService{
    private AccountDao accountDao;
    private CardDao cardDao;

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account getAccountById(Long id) {
        return accountDao.getById(id);
    }

    @Override
    public long insertAccount(Account account) {
        return accountDao.insertAccount(account);
    }

    @Override
    public long deleteAccount(Account account) {
        return accountDao.deleteAccount(account);
    }

    @Override
    public long updateAccount(Account account) {
        return accountDao.updateAccount(account);
    }


}
