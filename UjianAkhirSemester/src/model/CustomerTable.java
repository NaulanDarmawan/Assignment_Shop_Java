package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CustomerTable extends AbstractTableModel {
    List<CustomerModel> listCustomers;         

    public CustomerTable(List<CustomerModel> listCustomers) {
        this.listCustomers = listCustomers;     
    }

    @Override
    public int getRowCount() {
        return listCustomers.size();            
    }

    @Override
    public int getColumnCount() {
        return 9;                               
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {                
            case 0 -> "ID Customers";
            case 1 -> "First Name";
            case 2 -> "Last Name";    
            case 3 -> "Date of Birth";
            case 4 -> "Gender";
            case 5 -> "Phone Number";
            case 6 -> "Address";
            case 7 -> "City";
            case 8 -> "Country";
            default -> null;
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {           
            case 0 -> listCustomers.get(rowIndex).getId();
            case 1 -> listCustomers.get(rowIndex).getFirstName();
            case 2 -> listCustomers.get(rowIndex).getLastName();   
            case 3 -> listCustomers.get(rowIndex).getDateOfBirth();
            case 4 -> listCustomers.get(rowIndex).getGender();
            case 5 -> listCustomers.get(rowIndex).getPhone();
            case 6 -> listCustomers.get(rowIndex).getAddress();
            case 7 -> listCustomers.get(rowIndex).getCity();
            case 8 -> listCustomers.get(rowIndex).getCountry();
            default -> null;
        }; 
    }
}