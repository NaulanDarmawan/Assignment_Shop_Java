package model;
import controller.DbConnection;
import model.PurchaseTransactionModel;
//------------------------------------------------------------------------------
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PurchaseTransactionDataAccessObject {
    Connection connection;
    //---Konstanta untuk perintah SQL -----
    final String insert   = "insert into purchase_transactions set purchaseNumber=?, purchaseDate=?, ShippedDate=?, comments=?, supplierId=?, FirstName=?, Lastname=?, ProductCode=?, ProductName=?, Quantity=?, PriceEach=?, TotalPrice=?;";
    final String update   = "update purchase_transactions set comments=?, Quantity=?, PriceEach=?, TotalPrice=? where purchaseNumber=?;";
    final String delete   = "delete from purchase_transactions where purchaseNumber=?;";
    final String alldata  = "select * from purchase_transactions order by purchaseNumber asc;";

    //Constructor class --> create a connection to the database server
    public PurchaseTransactionDataAccessObject() {
        connection = DbConnection.getConnection();
    }
    
     //Add data Purchase method -------------------
    public void addPurchaseTransactions(PurchaseTransactionModel modelPurchaseTransactions) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, modelPurchaseTransactions.getPurchaseNumber());
            statement.setString(2, modelPurchaseTransactions.getPurchaseDate());
            statement.setString(3, modelPurchaseTransactions.getShippedDate());
            statement.setString(4, modelPurchaseTransactions.getComments());
            statement.setString(5, modelPurchaseTransactions.getSupplierId());
            statement.setString(6, modelPurchaseTransactions.getFirstName());
            statement.setString(7, modelPurchaseTransactions.getLastName());
            statement.setString(8, modelPurchaseTransactions.getProductCode());
            statement.setString(9, modelPurchaseTransactions.getProductName());
            statement.setString(10, modelPurchaseTransactions.getQuantity());
            statement.setString(11, modelPurchaseTransactions.getPriceEach());
            statement.setString(12, modelPurchaseTransactions.getTotalPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tambah data Purchase gagal " + e.getMessage());
        }
    }
    
    //Update data Purchase method -------------------
    public void updatePurchaseTransactions(PurchaseTransactionModel modelPurchaseTransactions) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, modelPurchaseTransactions.getComments());
            statement.setString(2, modelPurchaseTransactions.getQuantity());
            statement.setString(3, modelPurchaseTransactions.getPriceEach());
            statement.setString(4, modelPurchaseTransactions.getTotalPrice());
            statement.setString(5, modelPurchaseTransactions.getPurchaseNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Rubah data Purchase gagal " + e.getMessage());
        }
    }
    
    //Delete data customers method -------------------
    public void deletePurchaseTransactions(String Id) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, Id);
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hapus data Purchase gagal " + e.getMessage());
        }
    }
    
    //Find data Purchase method -------------------
    public boolean findPurchaseTransactions(String Id) {
        boolean found = false;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from purchase_transactions where purchaseNumber="+Id);
            rs.next();
            if (rs.getRow() > 0) {
                //JOptionPane.showMessageDialog(null, Id + " Found");
                found = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Pencarian data Purchase gagal " + e.getMessage());
        }
        return found;
    }
    
    //Make a list Sales method ----------------
    public List<PurchaseTransactionModel> listPurchaseTransactions() {
        List<PurchaseTransactionModel> arraylistPurchaseTransactions = null;
        try {
            arraylistPurchaseTransactions = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(alldata);
            while (rs.next()) {
                PurchaseTransactionModel modelPurchaseTransactions = new PurchaseTransactionModel();
                modelPurchaseTransactions.setPurchaseTransactions(
                    rs.getInt("PurchaseNumber"),
                    rs.getString("PurchaseDate"),
                    rs.getString("ShippedDate"),
                    rs.getString("Comments"),
                    rs.getString("SupplierId"),
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
