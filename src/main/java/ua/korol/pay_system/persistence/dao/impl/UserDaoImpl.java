package ua.korol.pay_system.persistence.dao.impl;

import ua.korol.pay_system.persistence.dao.UserDao;
import ua.korol.pay_system.persistence.model.User;
import ua.korol.pay_system.persistence.model.real.UserImpl;
import ua.korol.pay_system.persistence.utils.JdbcTemplate;
import ua.korol.pay_system.persistence.utils.ResultSetExtractor;

import javax.sql.DataSource;
import java.sql.Connection;


public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

    public UserDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private ResultSetExtractor<User> extractor = resultSet -> {
        User user = new UserImpl();
        user.setId(resultSet.getLong("id"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setSecondName(resultSet.getString("second_name"));
        user.setLastName(resultSet.getString("last_name"));
        user.setEmail(resultSet.getString("email"));
        user.setBirthday(resultSet.getTimestamp("year_of_birth"));
        user.setMobilePhone(resultSet.getString("mobile_phone"));
        return user;
    };

    private static final String SQL_GET_BY_ID = "SELECT * FROM \"users\" WHERE id = ?;";

    private static final String SQL_GET_BY_USERNAME = "SELECT * FROM \"users\" WHERE email = ?;";

    private static final String SQL_INSERT = "INSERT INTO \"users\"(first_name," +
            " second_name, last_name, email, year_of_birth, mobile_phone) " +
            "VALUES (?,?,?,?,?,?);";

    private static final String SQL_DELETE = "DELETE FROM \"users\" WHERE id = ?;";

    private static final String SQL_UPDATE = "UPDATE \"users\" SET first_name = ?," +
            " second_name = ?, last_name = ?, email = ?, year_of_birth = ?, mobile_phone = ?" +
            " WHERE id = ?;";

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User getById(Long id) {
        return jdbcTemplate.queryWithParameters(SQL_GET_BY_ID, extractor, id);
    }

    @Override
    public User getByUsername(String email) {
        return jdbcTemplate.queryWithParameters(SQL_GET_BY_USERNAME, extractor, email);
    }

    @Override
    public long insertUser(User user) {
        return jdbcTemplate.insert(SQL_INSERT, user.getFirstName(), user.getSecondName(),
                user.getLastName(), user.getEmail(), user.getBirthday(), user.getMobilePhone());
    }

    @Override
    public long insertUser(User user, Connection connection) {
        return jdbcTemplate.insert(SQL_INSERT, connection, user.getFirstName(), user.getSecondName(),
                user.getLastName(), user.getEmail(), user.getBirthday(), user.getMobilePhone());
    }

    @Override
    public long deleteUser(User user) {
        return jdbcTemplate.update(SQL_DELETE, user.getId());
    }

    @Override
    public long updateUser(User user) {
        return jdbcTemplate.update(SQL_UPDATE, user.getFirstName(), user.getSecondName(),
                user.getLastName(), user.getEmail(), user.getBirthday(), user.getMobilePhone(),
                user.getId());
    }
}

