package controller;

import model.SupplierDataAccessObject;
import model.SupplierModel;
import model.SupplierTable;
import view.InternalFormSupplier;
//------------------------------------------------------------------------------
import java.util.List;
import javax.swing.JOptionPane;

public class SupplierController {
    InternalFormSupplier InternalFormSupplier;                            
    List<SupplierModel> listSuppliers;                     
    SupplierDataAccessObject daoSuppliers = new SupplierDataAccessObject();         
    SupplierModel modelSuppliers = new SupplierModel(); 
    
    public SupplierController(InternalFormSupplier InternalFormSupplier) {
        this.InternalFormSupplier = InternalFormSupplier;                 
        listSuppliers = daoSuppliers.listSuppliers();       
    }
    
    public void viewListSuppliers(){
        SupplierTable modeltableSuppliers = new SupplierTable(listSuppliers);
        InternalFormSupplier.getTableSuppliers().setModel(modeltableSuppliers);
    }
    
    public void saveSuppliers(){
        modelSuppliers.setSuppliers(
            InternalFormSupplier.gettfId(), 
            InternalFormSupplier.gettfFirstName(),
            InternalFormSupplier.gettfLastName(),
            InternalFormSupplier.gettfPhone(), 
            InternalFormSupplier.gettfAddress(), 
            InternalFormSupplier.gettfPostalCode(),
            InternalFormSupplier.gettfCity(), 
            InternalFormSupplier.gettfCountry()
        );
        if (daoSuppliers.findSuppliers(modelSuppliers.getId()) == true){
            //if id customers exists then update data
            daoSuppliers.updateSuppliers(modelSuppliers);
            JOptionPane.showMessageDialog(InternalFormSupplier, "Updating data was successful");
        } else {
            daoSuppliers.addSuppliers(modelSuppliers);
            JOptionPane.showMessageDialog(InternalFormSupplier, "Adding data was successful");
        }
    }
    
    public void deleteSuppliers(){
        daoSuppliers.deleteSuppliers(Integer.toString(InternalFormSupplier.gettfId()));
        JOptionPane.showMessageDialog(InternalFormSupplier, "Deleting data was successful");
    }
}
