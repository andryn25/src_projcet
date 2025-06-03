// Kelas ini bertugas mengatur koneksi ke database (menggunakan file konfigurasi .properties)
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

    // Objek properti untuk menyimpan konfigurasi dari file db.properties
    private static Properties properties;

    // Instance tunggal (singleton)
    private static DatabaseConnection instance;

    // Objek koneksi database
    private static Connection connection;

    // Nama-nama key yang digunakan untuk mengambil nilai dari file db.properties
    private static final String getDatabaseUsername = "user";
    private static final String getDatabasePassword = "password";
    private static final String getDatabaseURL = "url";
    private static final String getDriverClass = "driver";

    // Lokasi file konfigurasi db.properties (ubah sesuai kebutuhan)
    private static final String DB_PROPERTIES_URL = "/home/achi/Netbeans-8.0.2/Application Project/src/resources/config/db.properties";

    // Konstruktor privat agar tidak bisa di-instantiate dari luar
    private DatabaseConnection() {}

    /**
     * Mengembalikan instance tunggal DatabaseConnection.
     * Jika belum dibuat, maka akan dibuat terlebih dahulu.
     * @return 
     */
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
            com.catering.util.Console.logInfo("Connection has initialized successfully");
        }
        return instance;
    }

    /**
     * Mengembalikan objek Connection yang aktif ke database.
     * Jika belum terkoneksi, akan mencoba membuat koneksi baru.
     * @return 
     */
    public Connection getConnection() {
        if (connection == null) {
            try {
                // Memuat konfigurasi dari file properti
                properties = loadProperties();

                // Memuat driver JDBC
                Class.forName(properties.getProperty(getDriverClass));

                // Membuka koneksi menggunakan informasi dari properti
                connection = DriverManager.getConnection(
                    properties.getProperty(getDatabaseURL),
                    properties.getProperty(getDatabaseUsername),
                    properties.getProperty(getDatabasePassword)
                );

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

    /**
     * Membaca dan memuat file konfigurasi (db.properties).
     * @return Objek Properties yang berisi konfigurasi database
     */
    static Properties loadProperties() {
        properties = new Properties();
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
