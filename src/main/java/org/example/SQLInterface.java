package org.example;

import java.sql.*;

public class SQLInterface {
    public static Connection conn = null;

    private static String databaseName = "PrayForGospel_Database";
    private static String username = "prayforgospel";
    private static String password = "PrayForGospel2024@!@";

    public static void LoadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName +
                    "?user=" + username + "&password=" + password);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static ResultSet executeQuery(String query) {
        ResultSet rs = null;
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return rs;
    }

    public static void executeUpdate(String query) {
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void closeResources(ResultSet rs, PreparedStatement pstmt) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                // ignore
            }
        }

        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                // ignore
            }
        }
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                // ignore
            }
        }
    }


}
