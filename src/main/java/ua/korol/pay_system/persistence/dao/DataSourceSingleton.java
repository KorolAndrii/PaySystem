package ua.korol.pay_system.persistence.dao;

import org.postgresql.ds.PGPoolingDataSource;
import ua.korol.pay_system.config.PropertiesReader;

import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceSingleton {
    private DataSource dataSource;

    private static PropertiesReader propertiesReader = PropertiesReader.getInstance();

    private String databasePassword = propertiesReader.readPropertiesFile("db.password");

    private String databaseServerName = propertiesReader.readPropertiesFile("db.server.name");

    private String databaseUsername = propertiesReader.readPropertiesFile("db.username");

    private String databaseName = propertiesReader.readPropertiesFile("db.name");

    private int maxConnections = Integer.parseInt(propertiesReader.readPropertiesFile("db.connections"));

    private DataSourceSingleton() {
        try {
            dataSource = setUpDataSource();
            System.out.println("Data source has been created");
        } catch (NamingException e) {
            System.out.println("Cannot set up data source" + e);
        }
    }

    private static class DataSourceSingletonHolder{
        public static final DataSourceSingleton HOLDER_INSTANCE = new DataSourceSingleton();
        private DataSourceSingletonHolder() {
        }
    }

    public static DataSource getInstance() {
        return DataSourceSingletonHolder.HOLDER_INSTANCE.getDataSource();
    }

    private DataSource setUpDataSource() throws NamingException {
        PGPoolingDataSource pgDataSource = new PGPoolingDataSource();
        pgDataSource.setDataSourceName("dataSource");
        pgDataSource.setServerName(databaseServerName);
        pgDataSource.setDatabaseName(databaseName);
        pgDataSource.setUser(databaseUsername);
        pgDataSource.setPassword(databasePassword);
        pgDataSource.setMaxConnections(maxConnections);
        return pgDataSource;
    }

    private DataSource getDataSource(){
        return dataSource;
    }
}
