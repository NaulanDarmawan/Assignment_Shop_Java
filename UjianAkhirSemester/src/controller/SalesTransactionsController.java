package controller;

import model.SalesTransactionDataAccessObject;
import model.SalesTransactionModel;
import model.SalesTransactionTable;
import view.FormSalesTransactions;
//------------------------------------------------------------------------------
import java.util.List;
import javax.swing.JOptionPane;

public class SalesTransactionsController {
    FormSalesTransactions formSalesTransactions;                            
    List<SalesTransactionModel> listSalesTransactions;                     
    SalesTransactionDataAccessObject daoSalesTransactions = new SalesTransactionDataAccessObject();         
    SalesTransactionModel modeltableSalesTransactions = new SalesTransactionModel(); 
    
    public SalesTransactionsController(FormSalesTransactions formSalesTransactions) {
        this.formSalesTransactions = formSalesTransactions;                 
        listSalesTransactions = daoSalesTransactions.listSalesTransactions();       
    }
    
    public void viewListSalesTransactions(){
        SalesTransactionTable modeltableSalesTransactions = new SalesTransactionTable(listSalesTransactions);
        formSalesTransactions.getTableSalesTransactions().setModel(modeltableSalesTransactions);
    }
    
    public void saveSalesTransactions(){
        modeltableSalesTransactions.SetSalesTransactions(
            formSalesTransactions.g(), 
            formSalesTransactions.gettfFirstName(),
            formSalesTransactions.gettfLastName(),
            formSalesTransactions.gettfPhone(), 
            formSalesTransactions.gettfAddress(), 
            formSalesTransactions.gettfPostalCode(),
            formSalesTransactions.gettfCity(), 
            formSalesTransactions.gettfCountry()
        );
        if (daoSalesTransactions.findSuppliers(modelSuppliers.getId()) == true){
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
