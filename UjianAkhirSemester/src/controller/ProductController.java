package controller;

import model.ProductDataAccessObject;
import model.ProductModel;
import model.ProductTable;
import view.InternalFormProducts;
//------------------------------------------------------------------------------
import java.util.List;
import javax.swing.JOptionPane;

public class ProductController {
    InternalFormProducts InternalFormProducts;                            
    List<ProductModel> listProducts;                     
    ProductDataAccessObject daoProducts = new ProductDataAccessObject();         
    ProductModel modelProducts = new ProductModel();
    
    public ProductController(InternalFormProducts InternalFormProducts) {
        this.InternalFormProducts = InternalFormProducts;                 
        listProducts = daoProducts.listProducts();       
    }
    
    public void viewListProducts(){
        ProductTable modeltableProducts = new ProductTable(listProducts);
        InternalFormProducts.getTableSuppliers().setModel(modeltableProducts);
    }
    
    public void saveProducts(){
        modelProducts.setProducts(
            InternalFormProducts.gettfProductCode(), 
            InternalFormProducts.gettfProductName(),
            InternalFormProducts.gettfProductLine(),
            InternalFormProducts.gettfProductScale(), 
            InternalFormProducts.gettfProductVendor(), 
            InternalFormProducts.gettfProductDescription(),
            Integer.parseInt(InternalFormProducts.gettfQuantityInStock()),
            Float.parseFloat(InternalFormProducts.gettfBuyPrice()),
            Float.parseFloat(InternalFormProducts.gettfSalePrice())
        );
        if (daoProducts.findProducts(modelProducts.getProductCode()) == true){
            //if id customers exists then update data
            daoProducts.updateProducts(modelProducts);
            JOptionPane.showMessageDialog(InternalFormProducts, "Updating data was successful");
        } else {
            daoProducts.addProducts(modelProducts);
            JOptionPane.showMessageDialog(InternalFormProducts, "Adding data was successful");
        }
    }
    
    public void deleteProducts(){
        daoProducts.deleteProducts(InternalFormProducts.gettfProductCode());
        JOptionPane.showMessageDialog(InternalFormProducts, "Deleting data was successful");
    }
}
