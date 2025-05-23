// koneksi ke database (phpMyAdmin)
// data propreti database berada di resources/config
// ganti variabel DB_PROPERTIES_URL sesuai url file "db.properties" di simpan
package com.catering.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    private static Properties properties;
    private static DatabaseConnection instance;
    private static Connection connection;
    private static final String getDatabaseUsername = "user";
    private static final String getDatabasePassword = "password";
    private static final String getDatabaseURL = "url";
    private static final String getDriverClass = "driver";
    private static final String DB_PROPERTIES_URL = "/home/achi/Netbeans-8.0.2/Application Project/src/resources/config/db.properties";

    private DatabaseConnection() {

    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
            com.catering.util.Console.logInfo("Connection has initialized successfully");
        }
        return instance;

    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                properties = loadProperties();
                Class.forName(properties.getProperty(getDriverClass));
                connection = DriverManager.getConnection(properties.getProperty(getDatabaseURL), properties.getProperty(getDatabaseUsername), properties.getProperty(getDatabasePassword));
                com.catering.util.Console.log("Connected");
            } catch (SQLException e) {
                com.catering.util.Console.logError("Failed to connect: " + e.getMessage());
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                com.catering.util.Console.logError("Driver not found: " + e.getMessage());
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                com.catering.util.Console.logError("Invalid configuration: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Memuat file properti
    static Properties loadProperties() {
        properties = new java.util.Properties();
        try (InputStream input = new FileInputStream(DB_PROPERTIES_URL)) {
            properties.load(input);
            com.catering.util.Console.log("Properties loaded.");
        } catch (FileNotFoundException e) {
            com.catering.util.Console.logError("Properties not found: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            com.catering.util.Console.logError("Failed to load: " + e.getMessage());
            e.printStackTrace();
        }
        return properties;
    }
}
