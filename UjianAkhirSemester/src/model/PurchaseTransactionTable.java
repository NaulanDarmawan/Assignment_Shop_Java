package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PurchaseTransactionTable extends AbstractTableModel {
    List<PurchaseTransactionModel> listPurchaseTransactions;
    
    public PurchaseTransactionTable(List<PurchaseTransactionModel> listPurchaseTransactions) {
        this.listPurchaseTransactions = listPurchaseTransactions;     
    }
    
    @Override
    public int getRowCount() {
        return listPurchaseTransactions.size();            
    }
    
    @Override
    public int getColumnCount() {
        return 12;                               
    }
    
    @Override
    public String getColumnName(int column) {
        return switch (column) {                
            case 0 -> "Purchase Number";
            case 1 -> "Purchase Date";
            case 2 -> "Shipped Date";    
            case 3 -> "Comments";
            case 4 -> "SupplierId";
            case 5 -> "FirstName";
            case 6 -> "LastName";
            case 7 -> "ProductCode";
            case 8 -> "ProductName";
            case 9 -> "Quantity";
            case 10 -> "PriceEach";
            case 11 -> "TotalPrice";
            default -> null;
        };
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {           
            case 0 -> listPurchaseTransactions.get(rowIndex).getPurchaseNumber();
            case 1 -> listPurchaseTransactions.get(rowIndex).getPurchaseDate();
            case 2 -> listPurchaseTransactions.get(rowIndex).getShippedDate();
            case 3 -> listPurchaseTransactions.get(rowIndex).getComments();
            case 4 -> listPurchaseTransactions.get(rowIndex).getSupplierId();
            case 5 -> listPurchaseTransactions.get(rowIndex).getFirstName();
            case 6 -> listPurchaseTransactions.get(rowIndex).getLastName();
            case 7 -> listPurchaseTransactions.get(rowIndex).getProductCode();
            case 8 -> listPurchaseTransactions.get(rowIndex).getProductName();
            case 9 -> listPurchaseTransactions.get(rowIndex).getQuantity();
            case 10 -> listPurchaseTransactions.get(rowIndex).getPriceEach();
            case 11 -> listPurchaseTransactions.get(rowIndex).getTotalPrice();
            default -> null;
        }; 
    }
}
