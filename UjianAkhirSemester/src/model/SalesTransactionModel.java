package model;

public class SalesTransactionModel {

    private int SalesNumber;
    private String SaleDate, ShippedDate, Status, Comments, CustomerId, FirstName, LastName, ProductCode, ProductName;
    private int Quantity;
    private float PriceEach, TotalPrice;

    //Set data method ---------------------
    public void setSalesTransactions(int SalesNumber, String SaleDate,
            String ShippedDate, String Status, String Comments, String CustomerId,
            String FirstName, String LastName, String ProductCode, String ProductName,
            int Quantity, float PriceEach, float TotalPrice) {

        this.SalesNumber = SalesNumber;
        this.SaleDate = SaleDate;
        this.ShippedDate = ShippedDate;
        this.Status = Status;
        this.Comments = Comments;
        this.CustomerId = CustomerId;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.ProductCode = ProductCode;
        this.ProductName = ProductName;
        this.Quantity = Quantity;
        this.PriceEach = PriceEach;
        this.TotalPrice = TotalPrice;
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
        return CustomerId;
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
