package ua.korol.pay_system.persistence.dao.impl;

import ua.korol.pay_system.persistence.dao.AccountDao;
import ua.korol.pay_system.persistence.model.Account;
import ua.korol.pay_system.persistence.model.Card;
import ua.korol.pay_system.persistence.model.Payment;
import ua.korol.pay_system.persistence.model.PaymentTemplate;
import ua.korol.pay_system.persistence.model.proxy.CardProxy;
import ua.korol.pay_system.persistence.model.proxy.PaymentProxy;
import ua.korol.pay_system.persistence.model.proxy.PaymentTemplateProxy;
import ua.korol.pay_system.persistence.model.proxy.UserProxy;
import ua.korol.pay_system.persistence.model.real.AccountImpl;
import ua.korol.pay_system.persistence.utils.JdbcTemplate;
import ua.korol.pay_system.persistence.utils.ResultSetExtractor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private JdbcTemplate jdbcTemplate;

    public AccountDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private ResultSetExtractor<Account> extractor = resultSet -> {
        Account account = new AccountImpl();
        account.setId(resultSet.getLong("id"));
        account.setBalance(resultSet.getDouble("balance"));
        account.setUser(new UserProxy(resultSet.getLong("id_user")));
        account.setCards(getCards(account.getId()));
        account.setPayments(getPayments(account.getId()));
        account.setPaymentTemplates(getPaymentTemplates(account.getId()));
        return account;
    };


    private static final String SQL_GET_BY_ID = "SELECT * FROM \"account\" WHERE id = ?;";

    private static final String SQL_GET_BY_USER_ID = "SELECT * FROM \"account\" WHERE id_user = ?;";

    private static final String SQL_INSERT = "INSERT INTO \"account\" (balance," +
            " id_user) VALUES (?,?);";

    private static final String SQL_DELETE = "DELETE FROM \"account\" WHERE id = ?;";

    private static final String SQL_UPDATE = "UPDATE \"account\" SET balance = ?," +
            " id_user = ? WHERE id = ?;";


    @Override
    public Account getById(Long id) {
        return jdbcTemplate.queryWithParameters(SQL_GET_BY_ID, extractor, id);
    }

    @Override
    public Account getByUserId(Long userId) {
        return jdbcTemplate.queryWithParameters(SQL_GET_BY_USER_ID, extractor, userId);
    }

    @Override
    public long insertAccount(Account account) {
        return jdbcTemplate.insert(SQL_INSERT, account.getBalance(), account.getUser().getId());
    }

    @Override
    public long deleteAccount(Account account) {
        return jdbcTemplate.update(SQL_DELETE, account.getId());
    }

    @Override
    public long updateAccount(Account account) {
        return jdbcTemplate.update(SQL_UPDATE, account.getBalance(),
                account.getUser().getId(), account.getId());
    }

    @Override
    public long insertAccount(Account account, Connection connection) {
        return jdbcTemplate.insert(SQL_INSERT, connection, account.getBalance(), account.getUser().getId());
    }

    private List<Card> getCards(Long accountId) {
        return jdbcTemplate.queryWithParameters("SELECT * FROM \"card\" WHERE id_account = ?", resultSet -> {
            List<Card> cards = new ArrayList<>();
            do {
                cards.add(new CardProxy(resultSet.getLong("id")));
            } while (resultSet.next());
            return cards;
        }, accountId);
    }

    private List<Payment> getPayments(Long paymentId) {
        return jdbcTemplate.queryWithParameters("SELECT * FROM \"payment\" WHERE account_id = ?", resultSet -> {
            List<Payment> payments = new ArrayList<>();
            do {
                payments.add(new PaymentProxy(resultSet.getLong("id")));
            } while (resultSet.next());
            return payments;
        }, paymentId);
    }

    private List<PaymentTemplate> getPaymentTemplates(Long paymentTemplateId) {
        return jdbcTemplate.queryWithParameters("SELECT * FROM \"payment_template\" WHERE account_id = ?", resultSet -> {
            List<PaymentTemplate> paymentTemplates = new ArrayList<>();
            do {
                paymentTemplates.add(new PaymentTemplateProxy(resultSet.getLong("id")));
            } while (resultSet.next());
            return paymentTemplates;
        }, paymentTemplateId);
    }
}
