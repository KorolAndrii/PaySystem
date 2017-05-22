package ua.korol.pay_system.persistence.dao.impl;

import ua.korol.pay_system.persistence.dao.PaymentTemplateDao;
import ua.korol.pay_system.persistence.model.PaymentTemplate;
import ua.korol.pay_system.persistence.model.proxy.AccountProxy;
import ua.korol.pay_system.persistence.model.real.PaymentTemplateImpl;
import ua.korol.pay_system.persistence.utils.JdbcTemplate;
import ua.korol.pay_system.persistence.utils.ResultSetExtractor;

import javax.sql.DataSource;

public class PaymentTemplateDaoImpl implements PaymentTemplateDao {
    private JdbcTemplate jdbcTemplate;

    public PaymentTemplateDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private ResultSetExtractor<PaymentTemplate> extractor = resultSet -> {
        PaymentTemplate paymentTemplate = new PaymentTemplateImpl();
        paymentTemplate.setId(resultSet.getLong("id"));
        paymentTemplate.setName(resultSet.getString("name"));
        paymentTemplate.setRequisites(resultSet.getString("requisites"));
        paymentTemplate.setState(resultSet.getBoolean("template_state"));
        paymentTemplate.setRegularPaymentDate(resultSet.getTimestamp("regular_date"));
        paymentTemplate.setAccount(new AccountProxy(resultSet.getLong("account_id")));
        return paymentTemplate;
    };

    private static final String SQL_GET_BY_ID = "SELECT * FROM \"payment_template\" WHERE id = ?;";

    private static final String SQL_GET_BY_NAME = "SELECT * FROM \"payment_template\" WHERE name = ?;";

    private static final String SQL_INSERT = "INSERT INTO \"payment_template\"(requisites," +
            " template_state, regular_date, account_id, name) VALUES (?,?,?,?,?);";

    private static final String SQL_DELETE = "DELETE FROM \"payment_template\" WHERE id = ?;";

    private static final String SQL_UPDATE = "UPDATE \"payment_template\" SET requisites = ?," +
            " template_state = ?, regular_date = ?, name = ? WHERE id = ?;";


    @Override
    public PaymentTemplate getById(Long id) {
        return jdbcTemplate.queryWithParameters(SQL_GET_BY_ID, extractor, id);
    }

    @Override
    public PaymentTemplate getByTemplateName(String name) {
        return jdbcTemplate.queryWithParameters(SQL_GET_BY_NAME, extractor, name);
    }

    @Override
    public long insertPaymentTemplate(PaymentTemplate paymentTemplate) {
        return jdbcTemplate.insert(SQL_INSERT, paymentTemplate.getRequisites(), paymentTemplate.getState(),
                paymentTemplate.getRegularPaymentDate(), paymentTemplate.getAccount().getId(), paymentTemplate.getName());
    }

    @Override
    public long deletePaymentTemplate(PaymentTemplate paymentTemplate) {
        return jdbcTemplate.update(SQL_DELETE, paymentTemplate.getId());
    }

    @Override
    public long updatePaymentTemplate(PaymentTemplate paymentTemplate) {
        return jdbcTemplate.update(SQL_UPDATE, paymentTemplate.getRequisites(), paymentTemplate.getState(),
                paymentTemplate.getRegularPaymentDate(), paymentTemplate.getName(), paymentTemplate.getId());
    }
}
