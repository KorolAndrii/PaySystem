package ua.korol.pay_system.persistence.utils;


import javax.sql.DataSource;
import java.math.BigInteger;
import java.sql.*;

public class JdbcTemplate {
    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int update(String sql, Object... objects) {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            int rowNum = 1;
            for (Object object : objects) {
                statement.setObject(rowNum++, object);
            }
            return statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Cannot update objects");
            return 0;
        }
    }

    public int update(String sql, Connection connection, Object... objects) {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            int rowNum = 1;
            for (Object object : objects) {
                statement.setObject(rowNum++, object);
            }
            return statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Cannot update objects");
            return 0;
        }
    }

    public Long insert(String sql, Object... objects) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            return insert(statement, objects);
        } catch (SQLException e) {
            System.out.println("Cannot insert objects" + e);
            return 0L;
        }
    }

    public Long insert(String sql, Connection connection, Object... objects) {
        // TODO: 13.04.2017 what to do?
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            return insert(statement, objects);
        } catch (SQLException e) {
            System.out.println("Cannot insert objects" + e);
            return 0L;
        }
    }

    private Long insert(PreparedStatement statement, Object... objects) {
        int rowNum = 1;
        try {
            for (Object object : objects) {
                statement.setObject(rowNum++, object);
            }
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getLong(1);
            }
        } catch (SQLException e) {
            System.out.println("Cannot insert objects" + e);
        }
        return 0L;
    }

    public <T> T queryWithParameters(String sql, ResultSetExtractor<T> resultSetExtractor, Object... objects) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            int rowNum = 1;
            for (Object object : objects) {
                statement.setObject(rowNum++, object);
            }
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSetExtractor.extractData(resultSet);
            }
        } catch (SQLException e) {
            System.out.println("Cannot read object" + e);
        }
        return null;
        BigInteger
    }
}
