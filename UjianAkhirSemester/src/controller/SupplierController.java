package controller;

import model.SupplierDataAccessObject;
import model.SupplierModel;
import model.SupplierTable;
import view.FormSuppliers;
//------------------------------------------------------------------------------
import java.util.List;
import javax.swing.JOptionPane;

public class SupplierController {
    FormSuppliers formSuppliers;                            
    List<SupplierModel> listSuppliers;                     
    SupplierDataAccessObject daoSuppliers = new SupplierDataAccessObject();         
    SupplierModel modelSuppliers = new SupplierModel(); 
    
    public SupplierController(FormSuppliers formSuppliers) {
        this.formSuppliers = formSuppliers;                 
        listSuppliers = daoSuppliers.listSuppliers();       
    }
    
    public void viewListSuppliers(){
        SupplierTable modeltableSuppliers = new SupplierTable(listSuppliers);
        formSuppliers.getTableSuppliers().setModel(modeltableSuppliers);
    }
    
    public void saveSuppliers(){
        modelSuppliers.setSuppliers(
            formSuppliers.gettfId(), 
            formSuppliers.gettfFirstName(),
            formSuppliers.gettfLastName(),
            formSuppliers.gettfPhone(), 
            formSuppliers.gettfAddress(), 
            formSuppliers.gettfPostalCode(),
            formSuppliers.gettfCity(), 
            formSuppliers.gettfCountry()
        );
        if (daoSuppliers.findSuppliers(modelSuppliers.getId()) == true){
            //if id customers exists then update data
            daoSuppliers.updateSuppliers(modelSuppliers);
            JOptionPane.showMessageDialog(formSuppliers, "Updating data was successful");
        } else {
            daoSuppliers.addSuppliers(modelSuppliers);
            JOptionPane.showMessageDialog(formSuppliers, "Adding data was successful");
        }
    }
    
    public void deleteSuppliers(){
        daoSuppliers.deleteSuppliers(Integer.toString(formSuppliers.gettfId()));
        JOptionPane.showMessageDialog(formSuppliers, "Deleting data was successful");
    }
}
