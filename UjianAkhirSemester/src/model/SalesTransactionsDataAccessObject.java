/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**********************
 * @author myoenoes
 **********************/

package model;

import controller.DbConnection;
import model.SalesTransactionsModel;
import view.FormSalesTransactions;
//------------------------------------------------------------------------------
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SalesTransactionsDataAccessObject {
    Connection connection;
    //---Konstanta untuk perintah SQL -----
    final String insert_sales = 
            "insert into sales set "
            + "SalesNumber=?, SaleDate=?, ShippedDate=?, Status=?, Comments=?, "
            + "CustomerId=?;";
    final String insert_salesdetails = 
            "insert into salesdetails set "
            + "SalesNumber=?, ProductCode=?, Quantity=?, PriceEach=?;";
    final String insert_sales_transactions = 
            "insert into sales_transactions set "
            + "SalesNumber=?, SaleDate=?, ShippedDate=?, Status=?, Comments=?, "
            + "CustomerId=?, FirstName=?, LastName=?, ProductCode=?, ProductName=?, "
            + "Quantity=?, PriceEach=?, TotalPrice=?;";
    final String update_sales_transactions = 
            "update sales_transactions set "
            + "SaleDate=?, ShippedDate=?, Status=?, Comments=?, "
            + "CustomerId=?, FirstName=?, LastName=?, "
            + "ProductName=?, Quantity=?, PriceEach=?, TotalPrice=? "
            + "where SalesNumber=? and ProductCode=?;";
    final String delete_sales_transactions = 
            "delete from sales_transactions where SalesNumber=? and ProductCode=?;";
    final String delete_all_sales_transactions = 
            "delete from sales_transactions";
    final String get_all_sales_transactions = 
            "insert into sales_transactions ("
            + "select a.SalesNumber, b.SaleDate, b.ShippedDate, "
            + "b.`Status`, b.Comments, b.CustomerId, d.FirstName,"
            + "d.LastName, a.ProductCode, c.ProductName, a.Quantity,"
            + "a.PriceEach, a.Quantity*a.PriceEach as TotalPrice "
            + "from salesdetails as a "
            + "left join sales as b on a.SalesNumber=b.SalesNumber "
            + "left join products as c on c.ProductCode=a.ProductCode "
            + "left join customers as d on d.id=b.CustomerId "
            + "where a.SalesNumber = ?);";
    final String alldata = 
            "select * from sales_transactions "
            + "order by SalesNumber asc, ProductCode asc;";
    final String update_products =  
            "update products set QuantityInStock=QuantityInStock - ? "
            + "where ProductCode = ?;";

        //Constructor class --> create a connection to the database server
    public SalesTransactionsDataAccessObject(){
        connection = DbConnection.getConnection();
    }

    //Add data Sales method -------------------
    public void addSales(SalesTransactionsModel modelSalesTransactions){
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(insert_sales);
            statement.setString(1, modelSalesTransactions.getSalesNumber());
            statement.setString(2, modelSalesTransactions.getSaleDate());
            statement.setString(3, modelSalesTransactions.getShippedDate());
            statement.setString(4, modelSalesTransactions.getStatus());
            statement.setString(5, modelSalesTransactions.getComments());
            statement.setString(6, modelSalesTransactions.getCustomerId());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tambah data Sales gagal " + e.getMessage());
        }
    }

    public void addSalesDetils(SalesTransactionsModel modelSalesTransactions){
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(insert_salesdetails);
            statement.setString(1, modelSalesTransactions.getSalesNumber());
            statement.setString(2, modelSalesTransactions.getProductCode());
            statement.setString(3, modelSalesTransactions.getQuantity());
            statement.setString(4, modelSalesTransactions.getPriceEach());
            statement.executeUpdate();            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tambah data Sales Detil Transactions gagal " + e.getMessage());
        }
    }

    //Add data SalesTransactions method -------------------
    public void addSalesTransactions(SalesTransactionsModel modelSalesTransactions){
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(insert_sales_transactions);
            statement.setString( 1, modelSalesTransactions.getSalesNumber());
            statement.setString( 2, modelSalesTransactions.getSaleDate());
            statement.setString( 3, modelSalesTransactions.getShippedDate());
            statement.setString( 4, modelSalesTransactions.getStatus());
            statement.setString( 5, modelSalesTransactions.getComments());
            statement.setString( 6, modelSalesTransactions.getCustomerId());
            statement.setString( 7, modelSalesTransactions.getFirstName());
            statement.setString( 8, modelSalesTransactions.getLastName());
            statement.setString( 9, modelSalesTransactions.getProductCode());
            statement.setString(10, modelSalesTransactions.getProductName());
            statement.setString(11, modelSalesTransactions.getQuantity());
            statement.setString(12, modelSalesTransactions.getPriceEach());
            statement.setString(13, modelSalesTransactions.getTotalPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tambah data Sales Transactions gagal " + e.getMessage());
        }
    }

    //Update data SalesTransactions method -------------------
    public void updateSalesTransactions(SalesTransactionsModel modelSalesTransactions){
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(update_sales_transactions);
            statement.setString( 1, modelSalesTransactions.getSaleDate());
            statement.setString( 2, modelSalesTransactions.getShippedDate());
            statement.setString( 3, modelSalesTransactions.getStatus());
            statement.setString( 4, modelSalesTransactions.getComments());
            statement.setString( 5, modelSalesTransactions.getCustomerId());
            statement.setString( 6, modelSalesTransactions.getFirstName());
            statement.setString( 7, modelSalesTransactions.getLastName());
            statement.setString( 8, modelSalesTransactions.getProductName());
            statement.setString( 9, modelSalesTransactions.getQuantity());
            statement.setString(10, modelSalesTransactions.getPriceEach());
            statement.setString(11, modelSalesTransactions.getTotalPrice());
            statement.setString(12, modelSalesTransactions.getSalesNumber());
            statement.setString(13, modelSalesTransactions.getProductCode());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Rubah data Sales gagal " + e.getMessage());
        }
    }

    //Delete data SalesTransactions method -------------------
    public void deleteSalesTransactions(String SalesNumber, String ProductCode) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(delete_sales_transactions);
            statement.setString(1, SalesNumber);
            statement.setString(2, ProductCode);
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hapus data Sales Transactions gagal " + e.getMessage());
        }
    }

    //Delete all data SalesTransactions method -------------------
    public void deleteAllSalesTransactions() {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(delete_all_sales_transactions);
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hapus semua data Sales Transactions gagal " + e.getMessage());
        }
    }

    //Get all data SalesTransactions method -------------------
    public void getAllSalesTransactions(String SalesNumber) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(get_all_sales_transactions);
            statement.setString(1, SalesNumber);
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ambil semua data Sales Transactions gagal " + e.getMessage());
        }
    }

    //Find data SalesTransactions method -------------------
    public boolean findSalesTransactions(String SalesNumber, String ProductCode) {
        boolean found = false;
        String Query = 
                "select * from salesdetails "
                + "where SalesNumber="+SalesNumber+" "
                + "and ProductCode='"+ProductCode+"';";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(Query);
            rs.next();
            if (rs.getRow() > 0) {
                JOptionPane.showMessageDialog(null, ProductCode + " Found");
                found = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Pencarian data Sales Transactions gagal " + e.getMessage());
        }
        return found;
    }
    
    //Update data QuantityInStock Products method -------------------
    public void updateProducts(SalesTransactionsModel modelSalesTransactions){
        PreparedStatement statement;
        try {
            JOptionPane.showMessageDialog(null, "sql : " + update_products);
            JOptionPane.showMessageDialog(null, "sql : " + modelSalesTransactions.getQuantity());
            JOptionPane.showMessageDialog(null, "sql : " + modelSalesTransactions.getProductCode());
            statement = connection.prepareStatement(update_products);
            statement.setString(1, modelSalesTransactions.getQuantity());
            statement.setString(2, modelSalesTransactions.getProductCode());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Rubah data Stok Products gagal " + e.getMessage());
        }
    }

    //Make a list SalesTransactions method ----------------
    public List<SalesTransactionsModel> listSalesTransactions(String SalesNumber) {
        List<SalesTransactionsModel> arraylistSalesTransactions = null;
        try {
            //-----------------------------------------------------------
            //this.deleteAllSalesTransactions();  // hapus semua item sales transaksi
            this.getAllSalesTransactions(SalesNumber); // ambil semua item sales transaksi
            //-----------------------------------------------------------
            arraylistSalesTransactions = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(alldata);
            while (rs.next()) {
                SalesTransactionsModel modelSalesTransactions = new SalesTransactionsModel();
                modelSalesTransactions.setSalesTransactions(
                    rs.getInt("SalesNumber"),
                    rs.getString("SaleDate"),
                    rs.getString("ShippedDate"),
                    rs.getString("Status"),
                    rs.getString("Comments"),
                    rs.getInt("CustomerId"),
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

