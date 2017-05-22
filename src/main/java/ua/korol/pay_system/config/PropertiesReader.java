package ua.korol.pay_system.config;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static final String PROPERTIES_FILE = "app.properties";

    private static Logger log = Logger.getLogger(PropertiesReader.class.getName());

    private static volatile PropertiesReader instance;

    private PropertiesReader() {

    }

    public static PropertiesReader getInstance() {
        PropertiesReader propertiesReader = instance;
        if (propertiesReader == null) {
            synchronized (PropertiesReader.class) {
                propertiesReader = instance;
                if (propertiesReader == null) {
                    propertiesReader = new PropertiesReader();
                }
            }
        }
        return propertiesReader;
    }

    public String readPropertiesFile(String propertyKey) {
        Properties properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            properties.load(inputStream);

        } catch (IOException e) {
            log.error("Can't find file" + e);
        }
        return properties.getProperty(propertyKey);
    }
}
