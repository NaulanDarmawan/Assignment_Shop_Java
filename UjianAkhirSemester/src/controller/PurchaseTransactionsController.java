package controller;

import model.PurchaseTransactionDataAccessObject;
import model.PurchaseTransactionModel;
import model.PurchaseTransactionTable;
import view.FormPurchaseTransactions;
//------------------------------------------------------------------------------
import java.util.List;
import javax.swing.JOptionPane;

public class PurchaseTransactionsController {

    FormPurchaseTransactions formPurchaseTransactions;
    List<PurchaseTransactionModel> listPurchaseTransactions;
    PurchaseTransactionDataAccessObject daoPurchaseTransactions = new PurchaseTransactionDataAccessObject();
    PurchaseTransactionModel modelPurchaseTransactions = new PurchaseTransactionModel();

    public PurchaseTransactionsController(FormPurchaseTransactions formPurchaseTransactions) {
        this.formPurchaseTransactions = formPurchaseTransactions;
        listPurchaseTransactions = daoPurchaseTransactions.listPurchaseTransactions();
    }

    public void viewListPurchaseTransactions() {
        PurchaseTransactionTable modeltablePurchaseTransactions = new PurchaseTransactionTable(listPurchaseTransactions);
        formPurchaseTransactions.getTablePurchaseTransactions().setModel(modeltablePurchaseTransactions);
    }

    public void savePurchaseTransactions() {
        modelPurchaseTransactions.setPurchaseTransactions(
                Integer.parseInt(formPurchaseTransactions.gettfPurchaseNumber()),
                formPurchaseTransactions.getspPurchaseDate(),
                formPurchaseTransactions.getspShippedDate(),
                formPurchaseTransactions.gettfComments(),
                formPurchaseTransactions.gettfSupplierId(),
                formPurchaseTransactions.gettfSupplierFirstName(),
                formPurchaseTransactions.gettfSupplierLastName(),
                formPurchaseTransactions.gettfProductCode(),
                formPurchaseTransactions.gettfProductName(),
                Integer.parseInt(formPurchaseTransactions.gettfQuantity()),
                Float.parseFloat(formPurchaseTransactions.gettfProductPriceEach()),
                Float.parseFloat(formPurchaseTransactions.gettfProductTotalPrice())
        );
        if (daoPurchaseTransactions.findPurchaseTransactions(modelPurchaseTransactions.getPurchaseNumber()) == true) {
            //if id customers exists then update data
            daoPurchaseTransactions.updatePurchaseTransactions(modelPurchaseTransactions);
            JOptionPane.showMessageDialog(formPurchaseTransactions, "Updating data was successful");
        } else {
            daoPurchaseTransactions.addPurchaseTransactions(modelPurchaseTransactions);
            JOptionPane.showMessageDialog(formPurchaseTransactions, "Adding data was successful");
        }
    }

    public void deletePurchaseTransactions() {
        daoPurchaseTransactions.deletePurchaseTransactions(formPurchaseTransactions.gettfPurchaseNumber());
        JOptionPane.showMessageDialog(formPurchaseTransactions, "Deleting data was successful");
    }
}
