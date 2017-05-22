package ua.korol.pay_system.persistence.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetExtractor<T> {
    T extractData(ResultSet resultSet) throws SQLException;
}
