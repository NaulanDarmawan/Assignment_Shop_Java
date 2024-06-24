package model;

import controller.DbConnection;
import model.ProductModel;
//------------------------------------------------------------------------------
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProductDataAccessObject {
    Connection connection;
    //---Konstanta untuk perintah SQL -----
    final String insert   = "insert into products set ProductCode=?, ProductName=?, ProductLine=?, ProductScale=?, ProductVendor=?, ProductDescription=?, QuantityInStock=?, BuyPrice=?, SalePrice=?;";
    final String update   = "update products set ProductName=?, ProductLine=?, ProductScale=?, ProductVendor=?, ProductDescription=?, QuantityInStock=?, BuyPrice=?, SalePrice=? where ProductCode=?;";
    final String delete   = "delete from products where ProductCode=?;";
    final String alldata  = "select * from products order by ProductCode asc;";
    
    //Constructor class --> create a connection to the database server
    public ProductDataAccessObject() {
        connection = DbConnection.getConnection();
    }
    
    //Add data products method -------------------
    public void addProducts(ProductModel modelProducts) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, modelProducts.getProductCode());
            statement.setString(2, modelProducts.getProductName());
            statement.setString(3, modelProducts.getProductLine());
            statement.setString(4, modelProducts.getProductScale());
            statement.setString(5, modelProducts.getProductVendor());
            statement.setString(6, modelProducts.getProductDescription());
            statement.setString(7, modelProducts.getQuantityInStock());
            statement.setString(8, modelProducts.getBuyPrice());
            statement.setString(9, modelProducts.getSalePrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tambah data Products gagal " + e.getMessage());
        }
    }
    
    //Update data products method -------------------
    public void updateProducts(ProductModel modelProducts) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, modelProducts.getProductName());
            statement.setString(2, modelProducts.getProductLine());
            statement.setString(3, modelProducts.getProductScale());
            statement.setString(4, modelProducts.getProductVendor());
            statement.setString(5, modelProducts.getProductDescription());
            statement.setString(6, modelProducts.getQuantityInStock());
            statement.setString(7, modelProducts.getBuyPrice());
            statement.setString(8, modelProducts.getSalePrice());
            statement.setString(9, modelProducts.getProductCode());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Rubah data Products gagal " + e.getMessage());
        }
    }
    
    //Delete data products method -------------------
    public void deleteProducts(String ProductCode) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, ProductCode);
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hapus data Products gagal " + e.getMessage());
        }
    }
    
    //Find data products method -------------------
    public boolean findProducts(String ProductCode) {
        boolean found = false;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from products where ProductCode="+ ProductCode);
            rs.next();
            if (rs.getRow() > 0) {
                //JOptionPane.showMessageDialog(null, Id + " Found");
                found = true;
            }
        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Pencarian data Products gagal " + e.getMessage());
        }
        return found;
    }
    
    //Make a list pproducts method ----------------
    public List<ProductModel> listProducts() {
        List<ProductModel> arraylistProducts = null;
        try {
            arraylistProducts = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(alldata);
            while (rs.next()) {
                ProductModel modelProducts = new ProductModel();
                modelProducts.setProducts(
                    rs.getString("ProductCode"),
                    rs.getString("ProductName"),
                    rs.getString("ProductLine"),
                    rs.getString("ProductScale"),
                    rs.getString("ProductVendor"),
                    rs.getString("ProductDescription"),
                    rs.getInt("QuantityInStock"),
                    rs.getFloat("BuyPrice"),
                    rs.getFloat("SalePrice")
                );
                arraylistProducts.add(modelProducts);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arraylistProducts;
    }    
}
