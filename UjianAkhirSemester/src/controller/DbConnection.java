package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DbConnection {

    public static Connection connection;
    public static Statement statement;

    public static Connection getConnection() {
        String URL = "jdbc:mysql://localhost:3306/";
        String database = "pbo_semester02";
        String username = "root";
        String password = "";

        try {
            connection = DriverManager.getConnection(URL + database, username, password);
            statement = connection.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi Ke MySql Gagal ! " + e.getMessage());
        }

        return connection;
    }
    
    public static void closeConnection() {
        try {
            if(connection != null) {
                connection.close();
                JOptionPane.showMessageDialog(null, "Berhasil Log Out Dari MySQL !");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Log Out Dari MySQL ! " + e.getMessage());
        }
    }
}
