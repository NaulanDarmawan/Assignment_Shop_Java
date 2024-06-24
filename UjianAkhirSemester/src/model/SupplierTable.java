package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class SupplierTable extends AbstractTableModel {

    List<SupplierModel> listSuppliers;

    public SupplierTable(List<SupplierModel> listSuppliers) {
        this.listSuppliers = listSuppliers;
    }

    @Override
    public int getRowCount() {
        return listSuppliers.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 ->
                "ID Suppliers";
            case 1 ->
                "First Name";
            case 2 ->
                "Last Name";
            case 3 ->
                "Phone";
            case 4 ->
                "Address";
            case 5 ->
                "Postal Code";
            case 6 ->
                "City";
            case 7 ->
                "Country";
            default ->
                null;
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 ->
                listSuppliers.get(rowIndex).getId();
            case 1 ->
                listSuppliers.get(rowIndex).getFirstName();
            case 2 ->
                listSuppliers.get(rowIndex).getLastName();
            case 3 ->
                listSuppliers.get(rowIndex).getPhone();
            case 4 ->
                listSuppliers.get(rowIndex).getAddress();
            case 5 ->
                listSuppliers.get(rowIndex).getPostalCode();
            case 6 ->
                listSuppliers.get(rowIndex).getCity();
            case 7 ->
                listSuppliers.get(rowIndex).getCountry();
            default ->
                null;
        };
    }
}
