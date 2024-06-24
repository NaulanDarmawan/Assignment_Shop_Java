package model;

import controller.DbConnection;
import model.CustomerModel;
//------------------------------------------------------------------------------
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CustomerDataAccessObject {
    Connection connection;
    //---Konstanta untuk perintah SQL -----
    final String insert   = "insert into customers set id=?, FirstName=?, LastName=?, DateOfBirth=?, Gender=?, phone=?, address=?, city=?, country=?;";
    final String update   = "update customers set FirstName=?, LastName=?, DateOfBirth=?, Gender=?, phone=?, address=?, city=?, country=? where id=?;";
    final String delete   = "delete from customers where id=?;";
    final String alldata  = "select * from customers order by id asc;";

    //Constructor class --> create a connection to the database server
    public CustomerDataAccessObject() {
        connection = DbConnection.getConnection();
    }
    
    //Add data customers method -------------------
    public void addCustomers(CustomerModel modelCustomers) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, modelCustomers.getId());
            statement.setString(2, modelCustomers.getFirstName());
            statement.setString(3, modelCustomers.getLastName());
            statement.setString(4, modelCustomers.getDateOfBirth());
            statement.setString(5, modelCustomers.getGender());
            statement.setString(6, modelCustomers.getPhone());
            statement.setString(7, modelCustomers.getAddress());
            statement.setString(8, modelCustomers.getCity());
            statement.setString(9, modelCustomers.getCountry());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tambah data Customers gagal " + e.getMessage());
        }
    }

    //Update data customers method -------------------
    public void updateCustomers(CustomerModel modelCustomers) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, modelCustomers.getFirstName());
            statement.setString(2, modelCustomers.getLastName());
            statement.setString(3, modelCustomers.getDateOfBirth());
            statement.setString(4, modelCustomers.getGender());
            statement.setString(5, modelCustomers.getPhone());
            statement.setString(6, modelCustomers.getAddress());
            statement.setString(7, modelCustomers.getCity());
            statement.setString(8, modelCustomers.getCountry());
            statement.setString(9, modelCustomers.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Rubah data Customers gagal " + e.getMessage());
        }
    }

    //Delete data customers method -------------------
    public void deleteCustomers(String Id) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, Id);
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hapus data Customers gagal " + e.getMessage());
        }
    }

    //Find data customer method -------------------
    public boolean findCustomers(String Id) {
        boolean found = false;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from customers where id="+Id);
            rs.next();
            if (rs.getRow() > 0) {
                //JOptionPane.showMessageDialog(null, Id + " Found");
                found = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Pencarian data Customers gagal " + e.getMessage());
        }
        return found;
    }
    
    //Make a list customers method ----------------
    public List<CustomerModel> listCustomers() {
        List<CustomerModel> arraylistCustomers = null;
        try {
            arraylistCustomers = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(alldata);
            while (rs.next()) {
                CustomerModel modelCustomers = new CustomerModel();
                modelCustomers.setCustomers(
                    rs.getInt("id"),
                    rs.getString("FirstName"),
                    rs.getString("LastName"),
                    rs.getString("DateOfBirth"),
                    rs.getString("Gender"),
                    rs.getString("Phone"),
                    rs.getString("address"),
                    rs.getString("city"),
                    rs.getString("country")
                );
                arraylistCustomers.add(modelCustomers);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arraylistCustomers;
    }    
}
