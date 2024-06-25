/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**********************
 * @author myoenoes
 **********************/

package model;

public class SalesTransactionsModel {
    private String SaleDate, ShippedDate, Status, Comments, FirstName, LastName;
    private String ProductCode, ProductName;
    private int SalesNumber, CustomerId, Quantity;
    private float PriceEach, TotalPrice;
    
    //Set data method ---------------------
    public void setSales(
        int SalesNumber, String SaleDate, String ShippedDate, 
        String Status, String Comments, int CustomerId)
    {
        this.SalesNumber = SalesNumber;
        this.SaleDate    = SaleDate;
        this.ShippedDate = ShippedDate;
        this.Status      = Status;
        this.Comments    = Comments;
        this.CustomerId  = CustomerId;
    }

    public void setSalesDetils(
        int SalesNumber, String ProductCode, 
        int Quantity, float PriceEach)
    {
        this.SalesNumber = SalesNumber;
        this.ProductCode = ProductCode;
        this.Quantity    = Quantity;
        this.PriceEach   = PriceEach;
    }

    public void setProduts(String ProductCode, int Quantity){
        this.ProductCode = ProductCode;
        this.Quantity    = Quantity;
    }

    public void setSalesTransactions(
        int SalesNumber, String SaleDate, String ShippedDate, 
        String Status, String Comments, int CustomerId, String FirstName, 
        String LastName, String ProductCode, String ProductName, 
        int Quantity, float PriceEach, float TotalPrice)
    {
        this.SalesNumber = SalesNumber;
        this.SaleDate    = SaleDate;
        this.ShippedDate = ShippedDate;
        this.Status      = Status;
        this.Comments    = Comments;
        this.CustomerId  = CustomerId;
        this.FirstName   = FirstName;
        this.LastName    = LastName;
        this.ProductCode = ProductCode;
        this.ProductName = ProductName;
        this.Quantity    = Quantity;
        this.PriceEach   = PriceEach;
        this.TotalPrice  = TotalPrice;
    }

    //Get data method ----------------------
    public String getSalesNumber() {
        return Integer.toString(SalesNumber);
    }
    
    public String getSaleDate() {
        return SaleDate;
    }
    
    public String getShippedDate() {
        return ShippedDate;
    }
    
    public String getStatus() {
        return Status;
    }
    
    public String getComments() {
        return Comments;
    }
    
    public String getCustomerId() {
        return Integer.toString(CustomerId);
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
