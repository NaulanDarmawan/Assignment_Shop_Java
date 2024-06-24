package model;

public class ProductModel {

    private String ProductCode, ProductName, ProductLine, ProductScale, ProductVendor, ProductDescription;
    private int QuantityInStock;
    private float BuyPrice, SalePrice;

    //Set data method ---------------------
    public void setProducts(String ProductCode, String ProductName, String ProductLine, String ProductScale, String ProductVendor, String ProductDescription, int QuantityInStock, float BuyPrice, float SalePrice) {
        this.ProductCode        = ProductCode;
        this.ProductName        = ProductName;
        this.ProductLine        = ProductLine;
        this.ProductScale       = ProductScale;
        this.ProductVendor      = ProductVendor;
        this.ProductDescription = ProductDescription;
        this.QuantityInStock    = QuantityInStock;
        this.BuyPrice           = BuyPrice;
        this.SalePrice          = SalePrice;
    }
    
    //Get data method ----------------------
    public String getProductCode() {
        return ProductCode;
    }
    
    public String getProductName() {
        return ProductName;
    }
    
    public String getProductLine() {
        return ProductLine;
    }
    
    public String getProductScale() {
        return ProductScale;
    }
    
    public String getProductVendor() {
        return ProductVendor;
    }
    
    public String getProductDescription() {
        return ProductDescription;
    }
    
    public String getQuantityInStock() {
        return Integer.toString(QuantityInStock);
    }
    
    public String getBuyPrice() {
        return Float.toString(BuyPrice);
    }
    
    public String getSalePrice() {
        return Float.toString(SalePrice);
    }
}
