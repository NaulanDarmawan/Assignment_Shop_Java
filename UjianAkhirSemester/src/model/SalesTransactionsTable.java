/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**********************
 * @author myoenoes
 **********************/

package model;

import model.SalesTransactionsModel;
//--------------------------------
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class SalesTransactionsTable extends AbstractTableModel {
    List<SalesTransactionsModel> listSalesTransactions;         //ok
    
    public SalesTransactionsTable(List<SalesTransactionsModel> listSalesTransactions) {
        this.listSalesTransactions = listSalesTransactions;     //ok
    }

    @Override
    public int getRowCount() {
        return listSalesTransactions.size();            //ok
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
            case 0 -> listSalesTransactions.get(rowIndex).getProductCode();
            case 1 -> listSalesTransactions.get(rowIndex).getProductName();
            case 2 -> listSalesTransactions.get(rowIndex).getQuantity();   
            case 3 -> listSalesTransactions.get(rowIndex).getPriceEach();
            case 4 -> listSalesTransactions.get(rowIndex).getTotalPrice();
            default -> null;
        }; 
    }
    
}
