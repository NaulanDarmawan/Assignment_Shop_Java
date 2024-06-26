/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**********************
 * @author myoenoes
 **********************/

package model;

import controller.DbConnection;
import model.ModelPurchaseTransactions;
import view.FormPurchaseTransactions;
//------------------------------------------------------------------------------
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOPurchaseTransactions {
    Connection connection;
    //---Konstanta untuk perintah SQL -----
    final String insert_purchase = 
            "insert into purchase set "
            + "purchaseNumber=?, PurchaseDate=?, ShippedDate=?, Comments=?, "
            + "SupplierId=?;";
    final String insert_purchasedetails = 
            "insert into purchasedetails set "
            + "PurchaseNumber=?, ProductCode=?, Quantity=?, PriceEach=?;";
    final String insert_purchase_transactions = 
            "insert into purchase_transactions set "
            + "PurchaseNumber=?, PurchaseDate=?, ShippedDate=?, Comments=?, "
            + "SupplierId=?, FirstName=?, LastName=?, ProductCode=?, ProductName=?, "
            + "Quantity=?, PriceEach=?, TotalPrice=?;";
    final String update_purchase_transactions = 
            "update purchase_transactions set "
            + "PurchaseDate=?, ShippedDate=?, Comments=?, "
            + "SupplierId=?, FirstName=?, LastName=?, "
            + "ProductName=?, Quantity=?, PriceEach=?, TotalPrice=? "
            + "where PurchaseNumber=? and ProductCode=?;";
    final String delete_purchase_transactions = 
            "delete from purchase_transactions where PurchaseNumber=? and ProductCode=?;";
    final String delete_all_purchase_transactions = 
            "delete from purchase_transactions";
    final String get_all_purchase_transactions = 
            "insert into purchase_transactions ("
            + "select a.PurchaseNumber, b.PurchaseDate, b.ShippedDate, "
            + " b.Comments, b.SupplierId, d.FirstName,"
            + "d.LastName, a.ProductCode, c.ProductName, a.Quantity,"
            + "a.PriceEach, a.Quantity*a.PriceEach as TotalPrice "
            + "from purchasedetails as a "
            + "left join purchase as b on a.PurchaseNumber=b.PurchaseNumber "
            + "left join products as c on c.ProductCode=a.ProductCode "
            + "left join supplier as d on d.id=b.SupplierId "
            + "where a.PurchaseNumber = ?);";
    final String alldata = 
            "select * from purchase_transactions "
            + "order by PurchaseNumber asc, ProductCode asc;";
    final String update_products =
    "UPDATE products " +
    "SET QuantityInStock = QuantityInStock + ?, " +
    "    BuyPrice = ?, " +
    "    SalePrice = (? * 1.10) " +
    "WHERE ProductCode = ?;";

        //Constructor class --> create a connection to the database server
    public DAOPurchaseTransactions(){
        connection = DbConnection.getConnection();
    }

    //Add data Sales method -------------------
    public void addPurchase(ModelPurchaseTransactions modelPurchaseTransactions){
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(insert_purchase);
            statement.setString(1, modelPurchaseTransactions.getPurchaseNumber());
            statement.setString(2, modelPurchaseTransactions.getPurchaseDate());
            statement.setString(3, modelPurchaseTransactions.getShippedDate());
            statement.setString(4, modelPurchaseTransactions.getComments());
            statement.setString(5, modelPurchaseTransactions.getSupplierId());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tambah data Purchase gagal " + e.getMessage());
        }
    }

    public void addPurchaseDetils(ModelPurchaseTransactions modelPurchaseTransactions){
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(insert_purchasedetails);
            statement.setString(1, modelPurchaseTransactions.getPurchaseNumber());
            statement.setString(2, modelPurchaseTransactions.getProductCode());
            statement.setString(3, modelPurchaseTransactions.getQuantity());
            statement.setString(4, modelPurchaseTransactions.getPriceEach());
            statement.executeUpdate();            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tambah data Purchase Detail Transactions gagal " + e.getMessage());
        }
    }

    //Add data SalesTransactions method -------------------
    public void addPurchaseTransactions(ModelPurchaseTransactions modelPurchaseTransactions){
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(insert_purchase_transactions);
            statement.setString( 1, modelPurchaseTransactions.getPurchaseNumber());
            statement.setString( 2, modelPurchaseTransactions.getPurchaseDate());
            statement.setString( 3, modelPurchaseTransactions.getShippedDate());
            statement.setString( 4, modelPurchaseTransactions.getComments());
            statement.setString( 5, modelPurchaseTransactions.getSupplierId());
            statement.setString( 6, modelPurchaseTransactions.getFirstName());
            statement.setString( 7, modelPurchaseTransactions.getLastName());
            statement.setString( 8, modelPurchaseTransactions.getProductCode());
            statement.setString(9, modelPurchaseTransactions.getProductName());
            statement.setString(10, modelPurchaseTransactions.getQuantity());
            statement.setString(11, modelPurchaseTransactions.getPriceEach());
            statement.setString(12, modelPurchaseTransactions.getTotalPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tambah data Purchase Transactions gagal " + e.getMessage());
        }
    }

    //Update data SalesTransactions method -------------------
    public void updatePurchaseTransactions(ModelPurchaseTransactions modelPurchaseTransactions){
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(update_purchase_transactions);
            statement.setString( 1, modelPurchaseTransactions.getPurchaseDate());
            statement.setString( 2, modelPurchaseTransactions.getShippedDate());
            statement.setString( 3, modelPurchaseTransactions.getComments());
            statement.setString( 4, modelPurchaseTransactions.getSupplierId());
            statement.setString( 5, modelPurchaseTransactions.getFirstName());
            statement.setString( 6, modelPurchaseTransactions.getLastName());
            statement.setString( 7, modelPurchaseTransactions.getProductName());
            statement.setString( 8, modelPurchaseTransactions.getQuantity());
            statement.setString(9, modelPurchaseTransactions.getPriceEach());
            statement.setString(10, modelPurchaseTransactions.getTotalPrice());
            statement.setString(11, modelPurchaseTransactions.getPurchaseNumber());
            statement.setString(12, modelPurchaseTransactions.getProductCode());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Rubah data Purchase gagal " + e.getMessage());
        }
    }

    //Delete data SalesTransactions method -------------------
    public void deletePurchaseTransactions(String PurchaseNumber, String ProductCode) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(delete_purchase_transactions);
            statement.setString(1, PurchaseNumber);
            statement.setString(2, ProductCode);
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hapus data Purchase Transactions gagal " + e.getMessage());
        }
    }

    //Delete all data PurchaseTransactions method -------------------
    public void deleteAllPurchaseTransactions() {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(delete_all_purchase_transactions);
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hapus semua data Purchase Transactions gagal " + e.getMessage());
        }
    }

    //Get all data SalesTransactions method -------------------
    public void getAllPurchaseTransactions(String PurchaseNumber) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(get_all_purchase_transactions);
            statement.setString(1, PurchaseNumber);
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ambil semua data Sales Transactions gagal " + e.getMessage());
        }
    }

    //Find data PurchaseTransactions method -------------------
    public boolean findPurchaseTransactions(String PurchaseNumber, String ProductCode) {
        boolean found = false;
        String Query = 
                "select * from purchasedetails "
                + "where PurchaseNumber="+PurchaseNumber+" "
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
            JOptionPane.showMessageDialog(null, "Pencarian data Purchase Transactions gagal " + e.getMessage());
        }
        return found;
    }
    
    //Update data QuantityInStock Products method -------------------
    public void updateProducts(ModelPurchaseTransactions modelPurchaseTransactions) {
    PreparedStatement statement;
    try {
        final String update_products = 
                "UPDATE products " +
                "SET QuantityInStock = QuantityInStock + ?, " +
                "    BuyPrice = ?, " +
                "    SalePrice = BuyPrice * 1.10 " +
                "WHERE ProductCode = ?;";
        
        JOptionPane.showMessageDialog(null, "sql : " + update_products);
        JOptionPane.showMessageDialog(null, "sql : " + modelPurchaseTransactions.getQuantity());
        JOptionPane.showMessageDialog(null, "sql : " + modelPurchaseTransactions.getProductCode());

        statement = connection.prepareStatement(update_products);
        statement.setString(1, modelPurchaseTransactions.getQuantity());
        statement.setFloat(2, Float.parseFloat(modelPurchaseTransactions.getPriceEach())); // Assuming getPriceEach() returns BuyPrice
        statement.setString(3, modelPurchaseTransactions.getProductCode());
        statement.executeUpdate();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Rubah data Stok Products gagal " + e.getMessage());
    }
}


    //Make a list SalesTransactions method ----------------
    public List<ModelPurchaseTransactions> listPurchaseTransactions(String PurchaseNumber) {
        List<ModelPurchaseTransactions> arraylistPurchaseTransactions = null;
        try {
            //-----------------------------------------------------------
            //this.deleteAllSalesTransactions();  // hapus semua item sales transaksi
            this.getAllPurchaseTransactions(PurchaseNumber); // ambil semua item sales transaksi
            //-----------------------------------------------------------
            arraylistPurchaseTransactions = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(alldata);
            while (rs.next()) {
                ModelPurchaseTransactions modelPurchaseTransactions = new ModelPurchaseTransactions();
                modelPurchaseTransactions.setPurchaseTransactions(
                    rs.getInt("PurchaseNumber"),
                    rs.getString("PurchaseDate"),
                    rs.getString("ShippedDate"),
                    rs.getString("Comments"),
                    rs.getInt("SupplierId"),
                    rs.getString("FirstName"),
                    rs.getString("LastName"),
                    rs.getString("ProductCode"),
                    rs.getString("ProductName"),
                    rs.getInt("Quantity"),
                    rs.getFloat("PriceEach"),
                    rs.getFloat("TotalPrice")
                );
                arraylistPurchaseTransactions.add(modelPurchaseTransactions);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arraylistPurchaseTransactions;
    }            
}
