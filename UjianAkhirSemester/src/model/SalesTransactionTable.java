package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class SalesTransactionTable   extends AbstractTableModel{
    List<SalesTransactionModel> listSalesTransactions;
    
    public SalesTransactionTable(List<SalesTransactionModel> listSalesTransactions) {
        this.listSalesTransactions = listSalesTransactions;     
    }
    
    @Override
    public int getRowCount() {
        return listSalesTransactions.size();            
    }

    @Override
    public int getColumnCount() {
        return 13;                               
    }
    
    @Override
    public String getColumnName(int column) {
        return switch (column) {                
            case 0 -> "Sales Number";
            case 1 -> "Sale Date";
            case 2 -> "Shipped Date";    
            case 3 -> "Status";
            case 4 -> "Comments";
            case 5 -> "CustomerId";
            case 6 -> "FirstName";
            case 7 -> "LastName";
            case 8 -> "ProductCode";
            case 9 -> "ProductName";
            case 10 -> "Quantity";
            case 11 -> "PriceEach";
            case 12 -> "TotalPrice";
            default -> null;
        };
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {           
            case 0 -> listSalesTransactions.get(rowIndex).getSalesNumber();
            case 1 -> listSalesTransactions.get(rowIndex).getSaleDate();
            case 2 -> listSalesTransactions.get(rowIndex).getShippedDate();
            case 3 -> listSalesTransactions.get(rowIndex).getStatus();
            case 4 -> listSalesTransactions.get(rowIndex).getComments();
            case 5 -> listSalesTransactions.get(rowIndex).getCustomerId();
            case 6 -> listSalesTransactions.get(rowIndex).getFirstName();
            case 7 -> listSalesTransactions.get(rowIndex).getLastName();
            case 8 -> listSalesTransactions.get(rowIndex).getProductCode();
            case 9 -> listSalesTransactions.get(rowIndex).getProductName();
            case 10 -> listSalesTransactions.get(rowIndex).getQuantity();
            case 11 -> listSalesTransactions.get(rowIndex).getPriceEach();
            case 12 -> listSalesTransactions.get(rowIndex).getTotalPrice();
            default -> null;
        }; 
    }
    
}
