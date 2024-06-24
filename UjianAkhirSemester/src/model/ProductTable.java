package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProductTable extends AbstractTableModel{
    List<ProductModel> listProducts;
    
    public ProductTable(List<ProductModel> listProducts) {
        this.listProducts = listProducts;     
    }
    
    @Override
    public int getRowCount() {
        return listProducts.size();            
    }

    @Override
    public int getColumnCount() {
        return 9;                               
    }
    
    @Override
    public String getColumnName(int column) {
        return switch (column) {                
            case 0 -> "Product Code";
            case 1 -> "Product Name";
            case 2 -> "Product Line";    
            case 3 -> "Product Scale";
            case 4 -> "Product Vendor";
            case 5 -> "Product Description";
            case 6 -> "Quantity In Stock";
            case 7 -> "Buy Price";
            case 8 -> "Sale Price";
            default -> null;
        };
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {           
            case 0 -> listProducts.get(rowIndex).getProductCode();
            case 1 -> listProducts.get(rowIndex).getProductName();
            case 2 -> listProducts.get(rowIndex).getProductLine();   
            case 3 -> listProducts.get(rowIndex).getProductScale();
            case 4 -> listProducts.get(rowIndex).getProductVendor();
            case 5 -> listProducts.get(rowIndex).getProductDescription();
            case 6 -> listProducts.get(rowIndex).getQuantityInStock();
            case 7 -> listProducts.get(rowIndex).getBuyPrice();
            case 8 -> listProducts.get(rowIndex).getSalePrice();
            default -> null;
        }; 
    }
}
