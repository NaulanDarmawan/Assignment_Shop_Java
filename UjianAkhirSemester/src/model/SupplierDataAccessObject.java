package model;

import controller.DbConnection;
import model.SupplierModel;
//------------------------------------------------------------------------------
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SupplierDataAccessObject {
    Connection connection;
    //---Konstanta untuk perintah SQL -----
    final String insert   = "insert into supplier set id=?, FirstName=?, LastName=?, phone=?, address=?, PostalCode=?, city=?, country=?;";
    final String update   = "update supplier set FirstName=?, LastName=?, phone=?, address=?, PostalCode=?, city=?, country=? where id=?;";
    final String delete   = "delete from supplier where id=?;";
    final String alldata  = "select * from supplier order by id asc;";
    
    //Constructor class --> create a connection to the database server
    public SupplierDataAccessObject() {
        connection = DbConnection.getConnection();
    }
    
    //Add data customers method -------------------
    public void addSuppliers(SupplierModel modelSuppliers) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, modelSuppliers.getId());
            statement.setString(2, modelSuppliers.getFirstName());
            statement.setString(3, modelSuppliers.getLastName());
            statement.setString(4, modelSuppliers.getPhone());
            statement.setString(5, modelSuppliers.getAddress());
            statement.setString(6, modelSuppliers.getPostalCode());
            statement.setString(7, modelSuppliers.getCity());
            statement.setString(8, modelSuppliers.getCountry());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tambah data Suppliers gagal " + e.getMessage());
        }
    }
    
    //Update data customers method -------------------
    public void updateSuppliers(SupplierModel modelSuppliers) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, modelSuppliers.getFirstName());
            statement.setString(2, modelSuppliers.getLastName());
            statement.setString(3, modelSuppliers.getPhone());
            statement.setString(4, modelSuppliers.getAddress());
            statement.setString(5, modelSuppliers.getPostalCode());
            statement.setString(6, modelSuppliers.getCity());
            statement.setString(7, modelSuppliers.getCountry());
            statement.setString(8, modelSuppliers.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Rubah data Suppliers gagal " + e.getMessage());
        }
    }
    
    //Delete data customers method -------------------
    public void deleteSuppliers(String Id) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, Id);
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hapus data Suppliers gagal " + e.getMessage());
        }
    }
    
    //Find data customer method -------------------
    public boolean findSuppliers(String Id) {
        boolean found = false;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from supplier where id="+Id);
            rs.next();
            if (rs.getRow() > 0) {
                //JOptionPane.showMessageDialog(null, Id + " Found");
                found = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Pencarian data Suppliers gagal " + e.getMessage());
        }
        return found;
    }
    
    //Make a list customers method ----------------
    public List<SupplierModel> listSuppliers() {
        List<SupplierModel> arraylistSuppliers = null;
        try {
            arraylistSuppliers = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(alldata);
            while (rs.next()) {
                SupplierModel modelSuppliers = new SupplierModel();
                modelSuppliers.setSuppliers(
                    rs.getInt("id"),
                    rs.getString("FirstName"),
                    rs.getString("LastName"),
                    rs.getString("Phone"),
                    rs.getString("address"),
                    rs.getString("PostalCode"),
                    rs.getString("city"),
                    rs.getString("country")
                );
                arraylistSuppliers.add(modelSuppliers);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arraylistSuppliers;
    }
}
