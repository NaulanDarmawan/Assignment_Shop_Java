/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**********************
 * @author myoenoes
 **********************/

package model;

import model.ModelPurchaseTransactions;
//--------------------------------
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTablePurchaseTransactions extends AbstractTableModel {
    List<ModelPurchaseTransactions> listPurchaseTransactions;         //ok
    
    public ModelTablePurchaseTransactions(List<ModelPurchaseTransactions> listPurchaseTransactions) {
        this.listPurchaseTransactions = listPurchaseTransactions;     //ok
    }

    @Override
    public int getRowCount() {
        return listPurchaseTransactions.size();            //ok
    }

    @Override
    public int getColumnCount() {
        return 5;                               //ok
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {                //ok
            case 0 -> "Product Code";
            case 1 -> "Products Name";
            case 2 -> "Quantity";    
            case 3 -> "Price Each";
            case 4 -> "TotalPrice";
            default -> null;
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {           //ok
            case 0 -> listPurchaseTransactions.get(rowIndex).getProductCode();
            case 1 -> listPurchaseTransactions.get(rowIndex).getProductName();
            case 2 -> listPurchaseTransactions.get(rowIndex).getQuantity();   
            case 3 -> listPurchaseTransactions.get(rowIndex).getPriceEach();
            case 4 -> listPurchaseTransactions.get(rowIndex).getTotalPrice();
            default -> null;
        }; 
    }
    
}
