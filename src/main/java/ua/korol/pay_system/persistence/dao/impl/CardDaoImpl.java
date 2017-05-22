package ua.korol.pay_system.persistence.dao.impl;

import ua.korol.pay_system.persistence.dao.CardDao;
import ua.korol.pay_system.persistence.model.Card;
import ua.korol.pay_system.persistence.model.proxy.AccountProxy;
import ua.korol.pay_system.persistence.model.real.CardImpl;
import ua.korol.pay_system.persistence.utils.JdbcTemplate;
import ua.korol.pay_system.persistence.utils.ResultSetExtractor;

import javax.sql.DataSource;
import java.sql.Connection;

public class CardDaoImpl implements CardDao {
    private JdbcTemplate jdbcTemplate;

    public CardDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private ResultSetExtractor<Card> extractor = resultSet -> {
        Card card = new CardImpl();
        card.setId(resultSet.getLong("id"));
        card.setNumber(resultSet.getString("number"));
        card.setValidity(resultSet.getTimestamp("validity"));
        card.setCvv(resultSet.getString("cvv"));
        card.setStatus(resultSet.getBoolean("status"));
        card.setLimit(resultSet.getDouble("card_limit"));
        card.setPinCode(resultSet.getString("pin_code"));
        card.setAccount(new AccountProxy(resultSet.getLong("id_account")));
        card.setBalance(resultSet.getDouble("balance"));
        return card;
    };

    private static final String SQL_GET_BY_ID = "SELECT * FROM \"card\" WHERE id = ?;";

    private static final String SQL_GET_BY_ACCOUNT_ID = "SELECT * FROM \"card\" WHERE account.id = ?;";

    private static final String SQL_GET_BY_NUMBER = "SELECT * FROM \"card\" WHERE number = ?;";

    private static final String SQL_GET_MAIN_CARD = "SELECT * FROM \"card\" WHERE main = ?;";

    private static final String SQL_INSERT = "INSERT INTO \"card\"(number," +
            " validity, cvv, status, card_limit, pin_code, account_id, balance) " +
            "VALUES (?,?,?,?,?,?,?,?);";

    private static final String SQL_DELETE = "DELETE FROM \"card\" WHERE id = ?;";

    private static final String SQL_UPDATE = "UPDATE \"card\" SET number = ?," +
            " validity = ?, cvv = ?, status = ?, card_limit = ?, pin_code = ?," +
            " id_account = ?, balance = ? WHERE card.id = ?;";

    private static final String SQL_UPDATE_BALANCE_BY_EMAIL = "UPDATE \"card\" SET balance = ?" +
            " WHERE card.id = (SELECT card.id FROM \"card\" JOIN \"account\" ON account.id = card.id_account" +
            " JOIN \"users\" ON  account.id_user = users.id  WHERE users.email = ?)";



    @Override
    public Card getById(Long id) {
        return jdbcTemplate.queryWithParameters(SQL_GET_BY_ID, extractor, id);
    }

    @Override
    public Card getByAccountId(Long id) {
        return jdbcTemplate.queryWithParameters(SQL_GET_BY_ACCOUNT_ID, extractor, id);
    }


    @Override
    public Card getByCardNumber(Integer number) {
        return jdbcTemplate.queryWithParameters(SQL_GET_BY_NUMBER, extractor, number);
    }

    @Override
    public Card getCardByMajorities(boolean status) {
        return jdbcTemplate.queryWithParameters(SQL_GET_MAIN_CARD, extractor, status);
    }

    @Override
    public long insertCard(Card card) {
        return jdbcTemplate.insert(SQL_INSERT, card.getNumber(), card.getValidity(),
                card.getCvv(), card.isStatus(), card.getLimit(), card.getPinCode(),
                card.getAccount().getId(), card.getBalance(), card.getId());
    }

    @Override
    public long deleteCard(Card card) {
        return jdbcTemplate.update(SQL_DELETE, card.getId());
    }

    @Override
    public long updateCard(Card card) {
        return jdbcTemplate.update(SQL_UPDATE, card.getNumber(), card.getValidity(),
                card.getCvv(), card.isStatus(), card.getLimit(), card.getPinCode(),
                card.getAccount().getId(), card.getBalance(), card.getId());
    }

    @Override
    public long updateCard(Card card, Connection connection) {
        return jdbcTemplate.update(SQL_UPDATE, connection, card.getNumber(), card.getValidity(),
                card.getCvv(), card.isStatus(), card.getLimit(), card.getPinCode(),
                card.getAccount().getId(), card.getBalance(), card.getId());
    }

    @Override
    public long updateBalanceByEmail(String email, Double amount, Connection connection) {
        return jdbcTemplate.update(SQL_UPDATE_BALANCE_BY_EMAIL, connection, amount, email);
    }

}
