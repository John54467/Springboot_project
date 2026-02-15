package io.reflectoring.jvcart.seed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseCreator {
    // Usage: run from IDE or with: mvn -Dexec.mainClass=io.reflectoring.jvcart.seed.DatabaseCreator exec:java
    public static void main(String[] args) {
        String host = System.getProperty("db.host", "localhost");
        String port = System.getProperty("db.port", "3306");
        String user = System.getProperty("db.user", "root");
        String pass = System.getProperty("db.password", "Johnny135#");
        String dbName = System.getProperty("db.name", "jvcart");

        String url = "jdbc:mysql://" + host + ":" + port + "/?serverTimezone=UTC&useSSL=false";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, pass);
                 Statement stmt = conn.createStatement()) {
                String sql = "CREATE DATABASE IF NOT EXISTS `" + dbName + "` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci";
                stmt.executeUpdate(sql);
                System.out.println("Database '" + dbName + "' ensured (created if it did not exist).");
            }
        } catch (Exception e) {
            System.err.println("Failed to create database '" + dbName + "': " + e.getMessage());
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }
}
