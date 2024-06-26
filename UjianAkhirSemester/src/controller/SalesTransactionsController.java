/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**********************
 * @author myoenoes
 **********************/

package controller;

import model.SalesTransactionsDataAccessObject;
import model.SalesTransactionsModel;
import model.SalesTransactionsTable;
import view.InternalFormSalesTransactions;
//------------------------------------------------------------------------------
import java.util.List;
import javax.swing.JOptionPane;

public class SalesTransactionsController {
    InternalFormSalesTransactions formSalesTransactions;                            
    List<SalesTransactionsModel> listSalesTransactions;                     
    SalesTransactionsDataAccessObject daoSalesTransactions = new SalesTransactionsDataAccessObject();         
    SalesTransactionsModel modelSalesTransactions = new SalesTransactionsModel();   
    
    public SalesTransactionsController(InternalFormSalesTransactions formSalesTransactions) {
        this.formSalesTransactions = formSalesTransactions;                 
        listSalesTransactions = daoSalesTransactions.listSalesTransactions("");       
    }

    public void viewListSalesTransactions(String SalesNumber){
        SalesTransactionsTable modeltableSalesTransactions = new SalesTransactionsTable(listSalesTransactions);
        formSalesTransactions.getTableSalesTransactions().setModel(modeltableSalesTransactions);
    }
    
    public void deleteSalesTransactions(){
        daoSalesTransactions.deleteSalesTransactions(
                String.valueOf(formSalesTransactions.gettfSalesNumber()),
                formSalesTransactions.gettfProductCode()
        );
        JOptionPane.showMessageDialog(null, "Deleting data was successful");
    }   
}
