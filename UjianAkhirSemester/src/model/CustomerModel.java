package model;
public class CustomerModel {
    private int Id;
    private String FirstName, LastName, DateOfBirth, Gender, Phone, Address, City, Country;
    
    //Set data method ---------------------
    public void setCustomers(int Id, String FirstName, String LastName, String DateOfBirth, String Gender, String Phone, String Address, String City, String Country) {
        this.Id          = Id;
        this.FirstName   = FirstName;
        this.LastName    = LastName;
        this.DateOfBirth = DateOfBirth;
        this.Gender      = Gender;
        this.Phone       = Phone;
        this.Address     = Address;
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
    
    public String getDateOfBirth() {
        return DateOfBirth;
    }
    
    public String getGender() {
        return Gender;
    }
    
    public String getPhone() {
        return Phone;
    }
    
    public String getAddress() {
        return Address;
    }
    
    public String getCity() {
        return City;
    }
    
    public String getCountry() {
        return Country;
    }
}
