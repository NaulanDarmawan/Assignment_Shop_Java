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
    SalesTransactionModel modelSalesTransactions = new SalesTransactionModel(); 
    
    public SalesTransactionsController(FormSalesTransactions formSalesTransactions) {
        this.formSalesTransactions = formSalesTransactions;                 
        listSalesTransactions = daoSalesTransactions.listSalesTransactions();       
    }
    
    public void viewListSalesTransactions(){
        SalesTransactionTable modeltableSalesTransactions = new SalesTransactionTable(listSalesTransactions);
        formSalesTransactions.getTableSalesTransactions().setModel(modeltableSalesTransactions);
    }
    
    public void saveSalesTransactions(){
        modelSalesTransactions.setSalesTransactions(
            Integer.parseInt(formSalesTransactions.gettfSalesNumber()),
            formSalesTransactions.getspSaleDate(),
            formSalesTransactions.getspShippedDate(),
            formSalesTransactions.gettfTransactionStatus(), 
            formSalesTransactions.gettfComments(), 
            formSalesTransactions.gettfCustomerId(),
            formSalesTransactions.gettfCustomerFirstName(), 
            formSalesTransactions.gettfCustomerLastName(),
            formSalesTransactions.gettfProductCode(),
            formSalesTransactions.gettfProductName(),
            Integer.parseInt(formSalesTransactions.gettfQuantity()),
            Float.parseFloat(formSalesTransactions.gettfProductPriceEach()),
            Float.parseFloat(formSalesTransactions.gettfProductTotalPrice())
        );
        if (daoSalesTransactions.findSalesTransactions(modelSalesTransactions.getSalesNumber()) == true){
            //if id customers exists then update data
            daoSalesTransactions.updateSalesTransactions(modelSalesTransactions);
            JOptionPane.showMessageDialog(formSalesTransactions, "Updating data was successful");
        } else {
            daoSalesTransactions.addSalesTransactions(modelSalesTransactions);
            JOptionPane.showMessageDialog(formSalesTransactions, "Adding data was successful");
        }
    }
    
    public void deleteSalesTransactions(){
        daoSalesTransactions.deleteSalesTransactions(formSalesTransactions.gettfSalesNumber());
        JOptionPane.showMessageDialog(formSalesTransactions, "Deleting data was successful");
    }
}
