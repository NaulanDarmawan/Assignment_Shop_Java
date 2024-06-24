package controller;

import model.CustomerDataAccessObject;
import model.CustomerModel;
import model.CustomerTable;
import view.FormCustomers;
//------------------------------------------------------------------------------
import java.util.List;
import javax.swing.JOptionPane;

public class CustomerController {
    FormCustomers formCustomers;                            
    List<CustomerModel> listCustomers;                     
    CustomerDataAccessObject daoCustomers = new CustomerDataAccessObject();         
    CustomerModel modelCustomers = new CustomerModel();   
    
    public CustomerController(FormCustomers formCustomers) {
        this.formCustomers = formCustomers;                 
        listCustomers = daoCustomers.listCustomers();       
    }
    
    public void viewListCustomers(){
        CustomerTable modeltableCustomers = new CustomerTable(listCustomers);
        formCustomers.getTableCustomers().setModel(modeltableCustomers);
    }

    public void saveCustomers(){
        modelCustomers.setCustomers(
            formCustomers.gettfId(), 
            formCustomers.gettfFirstName(),
            formCustomers.gettfLastName(),
            formCustomers.getspDateOfBirth(), 
            formCustomers.getcbGender(), 
            formCustomers.gettfPhone(), 
            formCustomers.gettfAddress(), 
            formCustomers.gettfCity(), 
            formCustomers.gettfCountry()
        );
        if (daoCustomers.findCustomers(modelCustomers.getId()) == true){
            //if id customers exists then update data
            daoCustomers.updateCustomers(modelCustomers);
            JOptionPane.showMessageDialog(formCustomers, "Updating data was successful");
        } else {
            daoCustomers.addCustomers(modelCustomers);
            JOptionPane.showMessageDialog(formCustomers, "Adding data was successful");
        }
    }
    
    public void deleteCustomer(){
        daoCustomers.deleteCustomers(Integer.toString(formCustomers.gettfId()));
        JOptionPane.showMessageDialog(formCustomers, "Deleting data was successful");
    }
}
