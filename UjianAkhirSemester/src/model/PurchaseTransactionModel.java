package model;
public class PurchaseTransactionModel {
    private int PurchaseNumber;
    private String PurchaseDate, ShippedDate, Comments, SupplierId, FirstName, LastName, ProductCode, ProductName;
    private int Quantity;
    private float PriceEach, TotalPrice;

    //Set data method ---------------------
    public void setPurchaseTransactions(int PurchaseNumber, String PurchaseDate,
            String ShippedDate, String Comments, String SupplierId,
            String FirstName, String LastName, String ProductCode, String ProductName,
            int Quantity, float PriceEach, float TotalPrice) {

        this.PurchaseNumber = PurchaseNumber;
        this.PurchaseDate = PurchaseDate;
        this.ShippedDate = ShippedDate;
        this.Comments = Comments;
        this.SupplierId = SupplierId;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.ProductCode = ProductCode;
        this.ProductName = ProductName;
        this.Quantity = Quantity;
        this.PriceEach = PriceEach;
        this.TotalPrice = TotalPrice;
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
        return SupplierId;
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
