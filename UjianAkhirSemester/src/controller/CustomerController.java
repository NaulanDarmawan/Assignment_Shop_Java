package controller;

import model.CustomerDataAccessObject;
import model.CustomerModel;
import model.CustomerTable;
import view.InternalFormCustomers;
//------------------------------------------------------------------------------
import java.util.List;
import javax.swing.JOptionPane;

public class CustomerController {
    InternalFormCustomers InternalFormCustomers;                            
    List<CustomerModel> listCustomers;                     
    CustomerDataAccessObject daoCustomers = new CustomerDataAccessObject();         
    CustomerModel modelCustomers = new CustomerModel();   
    
    public CustomerController(InternalFormCustomers InternalFormCustomers) {
        this.InternalFormCustomers = InternalFormCustomers;                 
        listCustomers = daoCustomers.listCustomers();       
    }
    
    public void viewListCustomers(){
        CustomerTable modeltableCustomers = new CustomerTable(listCustomers);
        InternalFormCustomers.getTableCustomers().setModel(modeltableCustomers);
    }

    public void saveCustomers(){
        modelCustomers.setCustomers(
            InternalFormCustomers.gettfId(), 
            InternalFormCustomers.gettfFirstName(),
            InternalFormCustomers.gettfLastName(),
            InternalFormCustomers.getspDateOfBirth(), 
            InternalFormCustomers.getcbGender(), 
            InternalFormCustomers.gettfPhone(), 
            InternalFormCustomers.gettfAddress(), 
            InternalFormCustomers.gettfCity(), 
            InternalFormCustomers.gettfCountry()
        );
        if (daoCustomers.findCustomers(modelCustomers.getId()) == true){
            //if id customers exists then update data
            daoCustomers.updateCustomers(modelCustomers);
            JOptionPane.showMessageDialog(InternalFormCustomers, "Updating data was successful");
        } else {
            daoCustomers.addCustomers(modelCustomers);
            JOptionPane.showMessageDialog(InternalFormCustomers, "Adding data was successful");
        }
    }
    
    public void deleteCustomer(){
        daoCustomers.deleteCustomers(Integer.toString(InternalFormCustomers.gettfId()));
        JOptionPane.showMessageDialog(InternalFormCustomers, "Deleting data was successful");
    }
}
