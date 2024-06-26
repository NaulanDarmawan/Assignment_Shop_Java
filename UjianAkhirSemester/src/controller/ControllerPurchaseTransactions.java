/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**********************
 * @author myoenoes
 **********************/

package controller;

import model.DAOPurchaseTransactions;
import model.ModelPurchaseTransactions;
import model.ModelTablePurchaseTransactions;
import view.FormPurchaseTransactions1;
//------------------------------------------------------------------------------
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerPurchaseTransactions {
    FormPurchaseTransactions1 formPurchaseTransactions;                            
    List<ModelPurchaseTransactions> listPurchaseTransactions;                     
    DAOPurchaseTransactions daoPurchaseTransactions = new DAOPurchaseTransactions();         
    ModelPurchaseTransactions modelPurchaseTransactions = new ModelPurchaseTransactions();   
    
    public ControllerPurchaseTransactions(FormPurchaseTransactions1 formPurchaseTransactions) {
        this.formPurchaseTransactions = formPurchaseTransactions;                 
        listPurchaseTransactions = daoPurchaseTransactions.listPurchaseTransactions("");       
    }

    public void viewListPurchaseTransactions(String PurchaseNumber){
        ModelTablePurchaseTransactions modeltablePurchaseTransactions = new ModelTablePurchaseTransactions(listPurchaseTransactions);
        formPurchaseTransactions.getTablePurchaseTransactions().setModel(modeltablePurchaseTransactions);
    }
    
    public void deletePurchaseTransactions(){
        daoPurchaseTransactions.deletePurchaseTransactions(
                String.valueOf(formPurchaseTransactions.gettfPurchaseNumber()),
                formPurchaseTransactions.gettfProductCode()
        );
        JOptionPane.showMessageDialog(null, "Deleting data was successful");
    }   
}
