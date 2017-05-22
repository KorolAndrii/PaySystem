package ua.korol.pay_system.persistence.dao;

import ua.korol.pay_system.persistence.dao.impl.*;

import java.util.HashMap;
import java.util.Map;

public class DaoFactory {
    private static Map<String, Dao> daoMap = new HashMap<>();

    public static UserDao getUserDao() {
        UserDao userDao = (UserDaoImpl)daoMap.get(UserDao.class.getSimpleName());
        if (userDao == null) {
            userDao = new UserDaoImpl(DataSourceSingleton.getInstance());
            daoMap.put(UserDao.class.getSimpleName(), userDao);
        }
        return userDao;
    }

    public static AccountDao getAccountDao() {
        AccountDao accountDao = (AccountDaoImpl)daoMap.get(AccountDao.class.getSimpleName());
        if (accountDao == null) {
            accountDao = new AccountDaoImpl(DataSourceSingleton.getInstance());
            daoMap.put(AccountDao.class.getSimpleName(), accountDao);
        }
        return accountDao;
    }

    public static CardDao getCardDao() {
        CardDao cardDao = (CardDaoImpl)daoMap.get(CardDao.class.getSimpleName());
        if (cardDao == null) {
            cardDao = new CardDaoImpl(DataSourceSingleton.getInstance());
            daoMap.put(CardDao.class.getSimpleName(), cardDao);
        }
        return cardDao;
    }

    public static PaymentDao getPaymentDao() {
        PaymentDao paymentDao = (PaymentDaoImpl)daoMap.get(PaymentDao.class.getSimpleName());
        if (paymentDao == null) {
            paymentDao = new PaymentDaoImpl(DataSourceSingleton.getInstance());
            daoMap.put(PaymentDao.class.getSimpleName(), paymentDao);
        }
        return paymentDao;
    }

    public static PaymentTemplateDao getPaymentTemplateDao() {
        PaymentTemplateDao paymentTemplateDao = (PaymentTemplateDaoImpl)daoMap.get(PaymentTemplateDao.class.getSimpleName());
        if (paymentTemplateDao == null) {
            paymentTemplateDao = new PaymentTemplateDaoImpl(DataSourceSingleton.getInstance());
            daoMap.put(PaymentTemplateDao.class.getSimpleName(), paymentTemplateDao);
        }
        return paymentTemplateDao;
    }
}
