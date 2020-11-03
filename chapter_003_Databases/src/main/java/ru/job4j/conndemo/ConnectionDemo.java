package ru.job4j.conndemo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDemo {
    private static final String PROPS = "/app.properties";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        try (InputStream is = ConnectionDemo.class.getResourceAsStream(PROPS)) {
            Properties props = new Properties();
            props.load(is);
            try (Connection connection = DriverManager.getConnection(props.getProperty("db.url"),
                    props.getProperty("db.user"), props.getProperty("db.password"))) {
                DatabaseMetaData metaData = connection.getMetaData();
                System.out.println(metaData.getUserName());
                System.out.println(metaData.getURL());
            }
        } catch (IOException e) {
            throw new IllegalStateException("Invalid config file " + PROPS);
        }
    }
}
