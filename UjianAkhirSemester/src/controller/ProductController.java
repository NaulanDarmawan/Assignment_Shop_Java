package controller;

import model.ProductDataAccessObject;
import model.ProductModel;
import model.ProductTable;
import view.FormProducts;
//------------------------------------------------------------------------------
import java.util.List;
import javax.swing.JOptionPane;

public class ProductController {
    FormProducts formProducts;                            
    List<ProductModel> listProducts;                     
    ProductDataAccessObject daoProducts = new ProductDataAccessObject();         
    ProductModel modelProducts = new ProductModel();
    
    public ProductController(FormProducts formProducts) {
        this.formProducts = formProducts;                 
        listProducts = daoProducts.listProducts();       
    }
    
    public void viewListProducts(){
        ProductTable modeltableProducts = new ProductTable(listProducts);
        formProducts.getTableSuppliers().setModel(modeltableProducts);
    }
    
    public void saveProducts(){
        modelProducts.setProducts(
            formProducts.gettfProductCode(), 
            formProducts.gettfProductName(),
            formProducts.gettfProductLine(),
            formProducts.gettfProductScale(), 
            formProducts.gettfProductVendor(), 
            formProducts.gettfProductDescription(),
            Integer.parseInt(formProducts.gettfQuantityInStock()),
            Float.parseFloat(formProducts.gettfBuyPrice()),
            Float.parseFloat(formProducts.gettfSalePrice())
        );
        if (daoProducts.findProducts(modelProducts.getProductCode()) == true){
            //if id customers exists then update data
            daoProducts.updateProducts(modelProducts);
            JOptionPane.showMessageDialog(formProducts, "Updating data was successful");
        } else {
            daoProducts.addProducts(modelProducts);
            JOptionPane.showMessageDialog(formProducts, "Adding data was successful");
        }
    }
    
    public void deleteProducts(){
        daoProducts.deleteProducts(formProducts.gettfProductCode());
        JOptionPane.showMessageDialog(formProducts, "Deleting data was successful");
    }
}
