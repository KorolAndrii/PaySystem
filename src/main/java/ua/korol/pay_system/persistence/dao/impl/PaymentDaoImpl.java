package ua.korol.pay_system.persistence.dao.impl;

import ua.korol.pay_system.persistence.dao.PaymentDao;
import ua.korol.pay_system.persistence.model.Payment;
import ua.korol.pay_system.persistence.model.proxy.AccountProxy;
import ua.korol.pay_system.persistence.model.real.PaymentImpl;
import ua.korol.pay_system.persistence.utils.JdbcTemplate;
import ua.korol.pay_system.persistence.utils.ResultSetExtractor;

import javax.sql.DataSource;
import java.sql.Connection;

public class PaymentDaoImpl implements PaymentDao {
    private JdbcTemplate jdbcTemplate;

    public PaymentDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private ResultSetExtractor<Payment> extractor = resultSet -> {
        Payment payment = new PaymentImpl();
        payment.setId(resultSet.getLong("id"));
        payment.setPayDate(resultSet.getTimestamp("pay_date"));
        payment.setAddress(resultSet.getString("address"));
        payment.setAmount(resultSet.getDouble("amount"));
        payment.setAccount(new AccountProxy(resultSet.getLong("account_id")));
        return payment;
    };

    private static final String SQL_GET_BY_ID = "SELECT * FROM \"payment\" WHERE id = ?;";

    private static final String SQL_GET_BY_PAY_DATE = "SELECT * FROM \"payment\" WHERE number = ?;";

    private static final String SQL_INSERT = "INSERT INTO \"payment\" (pay_date," +
            " address, amount, account_id) VALUES (?,?,?,?);";

    private static final String SQL_DELETE = "DELETE FROM \"payment\" WHERE id = ?;";

    private static final String SQL_UPDATE = "UPDATE \"payment\" SET pay_date = ?," +
            " address = ?, amount = ?, account_id = ? WHERE id = ?;";

    @Override
    public Payment getById(Long id) {
        return jdbcTemplate.queryWithParameters(SQL_GET_BY_ID, extractor, id);
    }

    @Override
    public long insertPayment(Payment payment) {
        return jdbcTemplate.insert(SQL_INSERT, payment.getPayDate(), payment.getAddress(),
                payment.getAmount(), payment.getAccount().getId());
    }

    @Override
    public long insertPayment(Payment payment, Connection connection) {
        return jdbcTemplate.insert(SQL_INSERT, connection, payment.getPayDate(), payment.getAddress(),
                payment.getAmount(), payment.getAccount().getId());
    }

    @Override
    public long deletePayment(Payment payment) {
        return jdbcTemplate.update(SQL_DELETE, payment.getId());
    }

    @Override
    public long updatePayment(Payment payment) {
        return jdbcTemplate.update(SQL_UPDATE, payment.getPayDate(), payment.getAddress(),
                payment.getAmount(), payment.getAccount().getId(), payment.getId());
    }
}
