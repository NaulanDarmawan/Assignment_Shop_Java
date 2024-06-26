/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**********************
 * @author myoenoes
 **********************/

package model;

public class ModelPurchaseTransactions {
    private String PurchaseDate, ShippedDate, Comments, FirstName, LastName;
    private String ProductCode, ProductName;
    private int PurchaseNumber, SupplierId, Quantity;
    private float PriceEach, TotalPrice;
    
    //Set data method ---------------------
    public void setPurchase(
        int PurchaseNumber, String PurchaseDate, String ShippedDate, 
        String Comments, int SupplierId)
    {
        this.PurchaseNumber = PurchaseNumber;
        this.PurchaseDate    = PurchaseDate;
        this.ShippedDate = ShippedDate;
        this.Comments    = Comments;
        this.SupplierId  = SupplierId;
    }

    public void setPurchaseDetils(
        int PurchaseNumber, String ProductCode, 
        int Quantity, float PriceEach)
    {
        this.PurchaseNumber = PurchaseNumber;
        this.ProductCode = ProductCode;
        this.Quantity    = Quantity;
        this.PriceEach   = PriceEach;
    }

    public void setProducts(String ProductCode, int Quantity){
        this.ProductCode = ProductCode;
        this.Quantity    = Quantity;
    }

    public void setPurchaseTransactions(
        int PurchaseNumber, String PurchaseDate, String ShippedDate, 
        String Comments, int SupplierId, String FirstName, 
        String LastName, String ProductCode, String ProductName, 
        int Quantity, float PriceEach, float TotalPrice)
    {
        this.PurchaseNumber = PurchaseNumber;
        this.PurchaseDate   = PurchaseDate;
        this.ShippedDate    = ShippedDate;
        this.Comments       = Comments;
        this.SupplierId     = SupplierId;
        this.FirstName      = FirstName;
        this.LastName       = LastName;
        this.ProductCode    = ProductCode;
        this.ProductName    = ProductName;
        this.Quantity       = Quantity;
        this.PriceEach      = PriceEach;
        this.TotalPrice     = TotalPrice;
    }

    //Get data method ----------------------
    public String getPurchaseNumber() {
        return Integer.toString(PurchaseNumber);
    }
    
    public String getPurchaseDate() {
        return PurchaseDate;
    }
    
    public String getShippedDate() {
        return ShippedDate;
    }
    
    public String getComments() {
        return Comments;
    }
    
    public String getSupplierId() {
        return Integer.toString(SupplierId);
    }
    
    public String getFirstName() {
        return FirstName;
    }
    
    public String getLastName() {
        return LastName;
    }
    
    public String getProductCode() {
        return ProductCode;
    }
    
    public String getProductName() {
        return ProductName;
    }
    
    public String getQuantity() {
        return Integer.toString(Quantity);
    }
    
    public String getPriceEach() {
        return Float.toString(PriceEach);
    }
    
    public String getTotalPrice() {
        return Float.toString(TotalPrice);
    }
    
}
