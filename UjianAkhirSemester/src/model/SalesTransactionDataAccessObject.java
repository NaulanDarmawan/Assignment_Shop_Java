package model;

import controller.DbConnection;
import model.SalesTransactionModel;
//------------------------------------------------------------------------------
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SalesTransactionDataAccessObject {
    Connection connection;
    //---Konstanta untuk perintah SQL -----
    final String insert   = "insert into sales_transactions set SalesNumber=?, SaleDate=?, ShippedDate=?, Status=?, Comments=?, CustomerId=?, FirstName=?, Lastname=?, ProductCode=?, ProductName=?, Quantity=?, PriceEach=?, TotalPrice=?;";
    final String update   = "update sales_transactions set Comments=?, Quantity=?, PriceEach=?, TotalPrice=? where SalesNumber=?;";
    final String delete   = "delete from sales_transactions where SalesNumber=?;";
    final String alldata  = "select * from sales_transactions order by SalesNumber asc;";

    //Constructor class --> create a connection to the database server
    public SalesTransactionDataAccessObject() {
        connection = DbConnection.getConnection();
    }
    
    //Add data customers method -------------------
    public void addSalesTransactions(SalesTransactionModel modelSalesTransactions) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, modelSalesTransactions.getSalesNumber());
            statement.setString(2, modelSalesTransactions.getSaleDate());
            statement.setString(3, modelSalesTransactions.getShippedDate());
            statement.setString(4, modelSalesTransactions.getStatus());
            statement.setString(5, modelSalesTransactions.getComments());
            statement.setString(6, modelSalesTransactions.getCustomerId());
            statement.setString(7, modelSalesTransactions.getFirstName());
            statement.setString(8, modelSalesTransactions.getLastName());
            statement.setString(9, modelSalesTransactions.getProductCode());
            statement.setString(10, modelSalesTransactions.getProductName());
            statement.setString(11, modelSalesTransactions.getQuantity());
            statement.setString(12, modelSalesTransactions.getPriceEach());
            statement.setString(13, modelSalesTransactions.getTotalPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tambah data Sales gagal " + e.getMessage());
        }
    }
    
     //Update data customers method -------------------
    public void updateSalesTransactions(SalesTransactionModel modelSalesTransactions) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, modelSalesTransactions.getComments());
            statement.setString(2, modelSalesTransactions.getQuantity());
            statement.setString(3, modelSalesTransactions.getPriceEach());
            statement.setString(4, modelSalesTransactions.getTotalPrice());
            statement.setString(5, modelSalesTransactions.getSalesNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Rubah data Sales gagal " + e.getMessage());
        }
    }
    
    //Delete data customers method -------------------
    public void deleteSalesTransactions(String Id) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, Id);
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hapus data Sales gagal " + e.getMessage());
        }
    }
    
    //Find data Sales method -------------------
    public boolean findSalesTransactions(String Id) {
        boolean found = false;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from sales_transactions where SalesNumber="+Id);
            rs.next();
            if (rs.getRow() > 0) {
                //JOptionPane.showMessageDialog(null, Id + " Found");
                found = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Pencarian data Sales gagal " + e.getMessage());
        }
        return found;
    }
    
    //Make a list Sales method ----------------
    public List<SalesTransactionModel> listSalesTransactions() {
        List<SalesTransactionModel> arraylistSalesTransactions = null;
        try {
            arraylistSalesTransactions = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(alldata);
            while (rs.next()) {
                SalesTransactionModel modelSalesTransactions = new SalesTransactionModel();
                modelSalesTransactions.setSalesTransactions(
                    rs.getInt("SalesNumber"),
                    rs.getString("SaleDate"),
                    rs.getString("ShippedDate"),
                    rs.getString("Status"),
                    rs.getString("Comments"),
                    rs.getString("CustomerId"),
                    rs.getString("FirstName"),
                    rs.getString("LastName"),
                    rs.getString("ProductCode"),
                    rs.getString("ProductName"),
                    rs.getInt("Quantity"),
                    rs.getFloat("PriceEach"),
                    rs.getFloat("TotalPrice")
                );
                arraylistSalesTransactions.add(modelSalesTransactions);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arraylistSalesTransactions;
    }    
}
