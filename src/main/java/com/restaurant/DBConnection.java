package com.restaurant;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/restaurant_db?useSSL=false&serverTimezone=UTC";
            String user = "root";
            String password = "Ammu@2000";

            con = DriverManager.getConnection(url, user, password);

            System.out.println("Database Connected ✅");

        } catch (Exception e) {
            System.out.println("Database Connection Failed ❌");
            e.printStackTrace();
        }

        return con;
    }
}