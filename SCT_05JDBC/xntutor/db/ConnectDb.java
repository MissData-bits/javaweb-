package com.xntutor.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDb {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/testdb?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "123456";

    public static Connection getConnection() {
        Connection con = null;

        try {
            // STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // STEP 3: Open a connection
            System.out.println("Connecting to testdb database...");
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}