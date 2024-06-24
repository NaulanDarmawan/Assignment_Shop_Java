package model;
public class SupplierModel {
    private int Id;
    private String FirstName, LastName, Phone, Address, PostalCode, City, Country;
    
    //Set data method ---------------------
    public void setSuppliers(int Id, String FirstName, String LastName, String Phone, String Address, String PostalCode,String City, String Country) {
        this.Id          = Id;
        this.FirstName   = FirstName;
        this.LastName    = LastName;
        this.Phone       = Phone;
        this.Address     = Address;
        this.PostalCode  = PostalCode;
        this.City        = City;
        this.Country     = Country;
    }
    
    //Get data method ----------------------
    public String getId() {
        return Integer.toString(Id);
    }
    
    public String getFirstName() {
        return FirstName;
    }
    
    public String getLastName() {
        return LastName;
    }
    
    public String getPhone() {
        return Phone;
    }
    
    public String getAddress() {
        return Address;
    }
    
    public String getPostalCode() {
        return PostalCode;
    }
    
    public String getCity() {
        return City;
    }
    
    public String getCountry() {
        return Country;
    }
}
