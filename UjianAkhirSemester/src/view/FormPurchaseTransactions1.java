package view;

import controller.ControllerPurchaseTransactions;
import controller.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//------------------------------------------------------------------------------
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.DAOPurchaseTransactions;
import model.ModelPurchaseTransactions;
import model.ModelTablePurchaseTransactions;

public class FormPurchaseTransactions1 extends javax.swing.JFrame {
    Connection connection;
    ControllerPurchaseTransactions controllerPurchaseTransactions;
    DAOPurchaseTransactions daoPurchaseTransactions = new DAOPurchaseTransactions();         
    ModelPurchaseTransactions modelPurchaseTransactions = new ModelPurchaseTransactions();   
    List<ModelPurchaseTransactions> listPurchaseTransactions;    
    
    public FormPurchaseTransactions1() {
        connection = DbConnection.getConnection();
        initComponents();
        setLocationRelativeTo(null);
        FillForm(tfPurchaseNumber.getText(), tfSupplierId.getText());
        tfPurchaseNumber.requestFocus();
    }
    
    public void ShowPurchaseTransactionsData() {
        controllerPurchaseTransactions = new ControllerPurchaseTransactions(this);    //ok
        controllerPurchaseTransactions.viewListPurchaseTransactions(tfPurchaseNumber.getText());//ok
    }
    
    private void setTablePurchaseTransactions(JTable tablePurchaseTransactions) {
        this.tablePurchaseTransactions = tablePurchaseTransactions;
    }
    
    private void setspPurchaseDate(String PurchaseDate){
        int Year, Month, Day;
        Calendar calendar;
        Year  = Integer.parseInt(PurchaseDate.substring(0,4));
        Month = Integer.parseInt(PurchaseDate.substring(5,7));
        Day   = Integer.parseInt(PurchaseDate.substring(8,10));
        calendar = new GregorianCalendar(Year, Month-1, Day);
        spPurchaseDate.setValue(calendar.getTime());
    }

    private void setspShippedDate(String ShippedDate){
        int Year, Month, Day;
        Calendar calendar;
        Year  = Integer.parseInt(ShippedDate.substring(0,4));
        Month = Integer.parseInt(ShippedDate.substring(5,7));
        Day   = Integer.parseInt(ShippedDate.substring(8,10));
        calendar = new GregorianCalendar(Year, Month-1, Day);
        spShippedDate.setValue(calendar.getTime());
    }
    
    private void settfComments(String Comments){
        tfComments.setText(Comments);
    }

    private void settfSupplierId(String SupplierId){
        tfSupplierId.setText(SupplierId);
    }

    private void settfFirstName(String FirstName){
        tfFirstName.setText(FirstName);
    }

    private void settfLastName(String LastName){
        tfLastName.setText(LastName);
    }
    
    private void settfProductCode(String ProductCode){
        tfProductCode.setText(ProductCode);
    }
    
    private void settfProductName(String ProductName){
        tfProductName.setText(ProductName);
    }
    
    private void settfQuantity(int Quantity){
        tfQuantity.setText(String.valueOf(Quantity));
    }

    private void settfPriceEach(float PriceEach){
        tfPriceEach.setText(String.valueOf(PriceEach));
    }

    private void settfTotalPrice(float TotalPrice){
        tfTotalPrice.setText(String.valueOf(TotalPrice));
    }
    
    public JTable getTablePurchaseTransactions() {
        return tablePurchaseTransactions;
    }
    
    public int gettfPurchaseNumber(){
        return Integer.parseInt(tfPurchaseNumber.getText());
    }

    public String getspPurchaseDate(){
        String PurchaseDate = spPurchaseDate.getValue().toString();
        String Year  = PurchaseDate.substring(24);
        String Month  = PurchaseDate.substring(4, 7);
        switch (Month) {
            case "Jan" -> Month = "01";
            case "Feb" -> Month = "02";
            case "Mar" -> Month = "03";
            case "Apr" -> Month = "04";
            case "May" -> Month = "04";
            case "Jun" -> Month = "06";
            case "Jul" -> Month = "07";
            case "Aug" -> Month = "08";
            case "Sep" -> Month = "09";
            case "Oct" -> Month = "10";
            case "Nov" -> Month = "11";
            case "Dec" -> Month = "12";
        }
        String Day = PurchaseDate.substring(8, 10);
        return Year+"-"+Month+"-"+Day;
    }

    public String getspShippedDate(){
        String ShippedDate = spShippedDate.getValue().toString();
        String Year  = ShippedDate.substring(24);
        String Month  = ShippedDate.substring(4, 7);
        switch (Month) {
            case "Jan" -> Month = "01";
            case "Feb" -> Month = "02";
            case "Mar" -> Month = "03";
            case "Apr" -> Month = "04";
            case "May" -> Month = "04";
            case "Jun" -> Month = "06";
            case "Jul" -> Month = "07";
            case "Aug" -> Month = "08";
            case "Sep" -> Month = "09";
            case "Oct" -> Month = "10";
            case "Nov" -> Month = "11";
            case "Dec" -> Month = "12";
        }
        String Day = ShippedDate.substring(8, 10);
        return Year+"-"+Month+"-"+Day;
    }
    
    public String gettfComments(){
        return tfComments.getText();
    }

    public int gettfSupplierId(){
        return Integer.parseInt(tfSupplierId.getText());
    }

    public String gettfFirstName(){
        return tfFirstName.getText();
    }

    public String gettfLastName(){
        return tfLastName.getText();
    }
    
    public String gettfProductCode(){
        return tfProductCode.getText();
    }
    
    public String gettfProductName(){
        return tfProductName.getText();
    }
    
    public int gettfQuantity(){
        return Integer.parseInt(tfQuantity.getText());
    }

    public float gettfPriceEach(){
        return Float.parseFloat(tfPriceEach.getText());
    }

    public float gettfTotalPrice(){
        return Float.parseFloat(tfTotalPrice.getText());
    }

    private void settfGrandTotal(String PurchaseNumber){
        String Query = 
                "select sum(Quantity * PriceEach) as grandtotal "
                + "from Purchase_transactions "
                + "where PurchaseNumber="+PurchaseNumber+" "
                + "group by PurchaseNumber;";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(Query);
            rs.next();
            if (rs.getRow()>0){
                tfGrandTotal.setText(rs.getString("grandtotal"));
            }
        } catch (SQLException e){}
    }

    private boolean findPurchaseTransactions(String PurchaseNumber) {
        boolean found = false;
        String Query = "select * from purchase where PurchaseNumber="+PurchaseNumber+";";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(Query);
            rs.next();
            if (rs.getRow()>0){
                setspPurchaseDate(rs.getString("PurchaseDate"));
                setspShippedDate(rs.getString("ShippedDate"));
                settfComments(rs.getString("Comments"));
                settfSupplierId(rs.getString("SupplierId"));
                settfGrandTotal(rs.getString("PurchaseNumber"));
                found = true; 
            }
        } catch (SQLException e){}
        return found;
    }

    private boolean findSupplier(String SupplierId) {
        boolean found = false;
        String Query = "select * from supplier where id="+SupplierId+";";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(Query);
            rs.next();
            if (rs.getRow() > 0) {
                settfFirstName(rs.getString("FirstName"));
                settfLastName(rs.getString("LastName"));
                found = true; 
            }
        } catch (SQLException e){}
        return found;
    }
    
    private boolean findProductsInPurchaseTransactions(String ProductCode){
        boolean found = false;
        String Query = "select * from purchase_transactions where ProductCode='"+ProductCode+"';";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(Query);
            rs.next();
            if (rs.getRow() > 0) {
                settfProductName(rs.getString("ProductName"));
                settfQuantity(rs.getInt("Quantity"));
                settfPriceEach(rs.getFloat("BuyPrice"));
                settfTotalPrice(rs.getFloat("TotalPrice"));
                found = true; 
            }
        } catch (SQLException e){}
        return found;
    }
    
    private boolean findProducts(String ProductCode) {
        boolean found = false;
        String Query = "select * from products where ProductCode='"+ProductCode+"';";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(Query);
            rs.next();
            if (rs.getRow() > 0) {
                settfProductName(rs.getString("ProductName"));
                settfQuantity(1);
                settfPriceEach(rs.getFloat("BuyPrice"));
                settfTotalPrice(gettfQuantity() * gettfPriceEach());
                findProductsInPurchaseTransactions(ProductCode);
                found = true; 
            }
        } catch (SQLException e){}
        return found;
    }

    public boolean findPurchaseDetilTransactions(String PurchaseNumber, String ProductCode) {
        boolean found = false;
        String Query = 
                "select * from purchase_transactions "
                + "where PurchaseNumber="+PurchaseNumber+" "
                + "and ProductCode='"+ProductCode+"';";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(Query);
            rs.next();
            if (rs.getRow() > 0) {
                //JOptionPane.showMessageDialog(null, ProductCode + " Found");
                found = true;
            }
        } catch (SQLException e){}
        return found;
    }
    
    private void EmptyForm() {
        int Year = java.time.LocalDate.now().getYear();
        int Month = java.time.LocalDate.now().getMonthValue();
        int Day = java.time.LocalDate.now().getDayOfMonth();
        Calendar calendar = new GregorianCalendar(Year, Month-1, Day);
        //----------------------------------------------------------
        //tfSalesNumber.setText(null);
        tfSupplierId.setText(null);
        tfFirstName.setText(null);
        tfLastName.setText(null);
        spPurchaseDate.setValue(calendar.getTime());
        spShippedDate.setValue(calendar.getTime());
        tfComments.setText(null);
        tfProductCode.setText(null);
        tfProductName.setText(null);
        tfQuantity.setText(null);
        tfPriceEach.setText(null);
        tfTotalPrice.setText(null);
    }
    
    private void FillForm(String PurchaseNumber, String SupplierId) {
        findSupplier(SupplierId);
        listPurchaseTransactions = daoPurchaseTransactions.listPurchaseTransactions(PurchaseNumber);       
        ModelTablePurchaseTransactions modeltablePurchaseTransactions = new ModelTablePurchaseTransactions(listPurchaseTransactions);
        this.getTablePurchaseTransactions().setModel(modeltablePurchaseTransactions);
        settfGrandTotal(tfPurchaseNumber.getText());
    }
    
    private void setTablePurchaseTransactions(String PurchaseNumber) {
        listPurchaseTransactions = daoPurchaseTransactions.listPurchaseTransactions(PurchaseNumber);       
        ModelTablePurchaseTransactions modeltablePurchaseTransactions = new ModelTablePurchaseTransactions(listPurchaseTransactions);
        this.getTablePurchaseTransactions().setModel(modeltablePurchaseTransactions);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfSupplierId = new javax.swing.JTextField();
        tfFirstName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfPurchaseNumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfLastName = new javax.swing.JTextField();
        spPurchaseDate = new javax.swing.JSpinner();
        spShippedDate = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tfProductCode = new javax.swing.JTextField();
        tfProductName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfQuantity = new javax.swing.JTextField();
        tfPriceEach = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfTotalPrice = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        tfGrandTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePurchaseTransactions = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        tfComments = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Purchase Transactions");
        setBackground(new java.awt.Color(204, 255, 255));

        tfSupplierId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfSupplierIdFocusLost(evt);
            }
        });
        tfSupplierId.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tfSupplierIdPropertyChange(evt);
            }
        });
        tfSupplierId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSupplierIdKeyReleased(evt);
            }
        });

        tfFirstName.setEditable(false);

        jLabel2.setText("Supplier");

        jLabel3.setText("Purchase Date");

        tfPurchaseNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfPurchaseNumberFocusLost(evt);
            }
        });
        tfPurchaseNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPurchaseNumberActionPerformed(evt);
            }
        });
        tfPurchaseNumber.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tfPurchaseNumberPropertyChange(evt);
            }
        });
        tfPurchaseNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPurchaseNumberKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPurchaseNumberKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfPurchaseNumberKeyTyped(evt);
            }
        });

        jLabel4.setText("Shipped Date");

        tfLastName.setEditable(false);
        tfLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLastNameActionPerformed(evt);
            }
        });

        spPurchaseDate.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(-1248282900000L), null, java.util.Calendar.DAY_OF_MONTH));
        spPurchaseDate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        spShippedDate.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(-1248282900000L), null, java.util.Calendar.DAY_OF_MONTH));
        spShippedDate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel6.setText("Purchase Number");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel7.setText("Product Code");

        tfProductCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfProductCodeFocusLost(evt);
            }
        });
        tfProductCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfProductCodeActionPerformed(evt);
            }
        });
        tfProductCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfProductCodeKeyReleased(evt);
            }
        });

        tfProductName.setEditable(false);

        jLabel8.setText("Quantity");

        jLabel9.setText("Price Each");

        tfQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfQuantityKeyReleased(evt);
            }
        });

        tfPriceEach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPriceEachActionPerformed(evt);
            }
        });
        tfPriceEach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPriceEachKeyReleased(evt);
            }
        });

        jLabel10.setText("Total Price");

        tfTotalPrice.setEditable(false);
        tfTotalPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTotalPriceActionPerformed(evt);
            }
        });

        btnAdd.setText("Add Item");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete Item");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfPriceEach, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(tfPriceEach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(tfTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        btnSave.setText("Save Transaction");
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnExit))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        jLabel11.setText("Grand Total");

        tfGrandTotal.setEditable(false);
        tfGrandTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfGrandTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tfGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablePurchaseTransactions.setBackground(new java.awt.Color(204, 255, 255));
        tablePurchaseTransactions.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tablePurchaseTransactions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product Code", "Product Name", "Quantity", "Price Each", "Total Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePurchaseTransactions.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablePurchaseTransactions.setRowHeight(23);
        tablePurchaseTransactions.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablePurchaseTransactions.setShowGrid(true);
        tablePurchaseTransactions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePurchaseTransactionsMouseClicked(evt);
            }
        });
        tablePurchaseTransactions.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablePurchaseTransactionsKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablePurchaseTransactionsKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablePurchaseTransactions);
        if (tablePurchaseTransactions.getColumnModel().getColumnCount() > 0) {
            tablePurchaseTransactions.getColumnModel().getColumn(0).setResizable(false);
            tablePurchaseTransactions.getColumnModel().getColumn(0).setPreferredWidth(100);
            tablePurchaseTransactions.getColumnModel().getColumn(1).setPreferredWidth(250);
            tablePurchaseTransactions.getColumnModel().getColumn(2).setResizable(false);
            tablePurchaseTransactions.getColumnModel().getColumn(2).setPreferredWidth(50);
            tablePurchaseTransactions.getColumnModel().getColumn(3).setResizable(false);
            tablePurchaseTransactions.getColumnModel().getColumn(3).setPreferredWidth(100);
            tablePurchaseTransactions.getColumnModel().getColumn(4).setResizable(false);
            tablePurchaseTransactions.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        jLabel12.setText("Comments");

        tfComments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCommentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfComments, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfSupplierId, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(spPurchaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spShippedDate, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfPurchaseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPurchaseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSupplierId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spPurchaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(spShippedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfComments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfPurchaseNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPurchaseNumberActionPerformed
    }//GEN-LAST:event_tfPurchaseNumberActionPerformed

    private void tfPurchaseNumberPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tfPurchaseNumberPropertyChange
    }//GEN-LAST:event_tfPurchaseNumberPropertyChange

    private void tfPurchaseNumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPurchaseNumberKeyPressed
    }//GEN-LAST:event_tfPurchaseNumberKeyPressed
        
    private void tfPurchaseNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPurchaseNumberKeyReleased
        if (findPurchaseTransactions(tfPurchaseNumber.getText()) == true) {
            FillForm(tfPurchaseNumber.getText(), tfSupplierId.getText());
        } else {
           daoPurchaseTransactions.deleteAllPurchaseTransactions();  // hapus semua item purchase transaksi
           setTablePurchaseTransactions(tfPurchaseNumber.getText());
           EmptyForm();
        }
    }//GEN-LAST:event_tfPurchaseNumberKeyReleased

    private void tfPurchaseNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPurchaseNumberKeyTyped
    }//GEN-LAST:event_tfPurchaseNumberKeyTyped

    private void tfTotalPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTotalPriceActionPerformed
    }//GEN-LAST:event_tfTotalPriceActionPerformed

    public void saveSalesDetilTransactions(){
        
    }
    
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (tfProductCode.getText().isEmpty()) JOptionPane.showMessageDialog(null, "Product Code is Empty");
        else {
            //JOptionPane.showMessageDialog(null, "simpan transaksi");
            modelPurchaseTransactions.setPurchaseTransactions(
                gettfPurchaseNumber(), 
                getspPurchaseDate(),
                getspShippedDate(),
                gettfComments(),
                gettfSupplierId(),
                gettfFirstName(),
                gettfLastName(),
                gettfProductCode(),
                gettfProductName(),
                gettfQuantity(),
                gettfPriceEach(),
                gettfTotalPrice()
            );       
            if (findPurchaseDetilTransactions(
                    tfPurchaseNumber.getText(), 
                    tfProductCode.getText()) == true){
                daoPurchaseTransactions.updatePurchaseTransactions(modelPurchaseTransactions);
                //JOptionPane.showMessageDialog(null, "Updating data was successful");
            } else {
                daoPurchaseTransactions.addPurchaseTransactions(modelPurchaseTransactions);
                //JOptionPane.showMessageDialog(null, "Adding data was successful");
            }
        }
        ShowPurchaseTransactionsData();
        settfGrandTotal(tfPurchaseNumber.getText());
        tfProductCode.requestFocus();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (tfProductCode.getText().isEmpty()) JOptionPane.showMessageDialog(null, "Product Code is Empty");
        else controllerPurchaseTransactions.deletePurchaseTransactions();
        ShowPurchaseTransactionsData();
        settfGrandTotal(tfPurchaseNumber.getText());
        tfProductCode.requestFocus();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tablePurchaseTransactionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePurchaseTransactionsMouseClicked
        FillPurchaseDetilTransactions(tablePurchaseTransactions.getSelectedRow());
    }//GEN-LAST:event_tablePurchaseTransactionsMouseClicked

    private void tablePurchaseTransactionsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablePurchaseTransactionsKeyPressed
    }//GEN-LAST:event_tablePurchaseTransactionsKeyPressed

    private void FillPurchaseDetilTransactions(int RecNum) {
        tfProductCode.setText(tablePurchaseTransactions.getModel().getValueAt(RecNum, 0).toString());
        tfProductName.setText(tablePurchaseTransactions.getModel().getValueAt(RecNum, 1).toString());
        tfQuantity.setText(tablePurchaseTransactions.getModel().getValueAt(RecNum, 2).toString());
        tfPriceEach.setText(tablePurchaseTransactions.getModel().getValueAt(RecNum, 3).toString());
        tfTotalPrice.setText(tablePurchaseTransactions.getModel().getValueAt(RecNum, 4).toString());
    }
    
    private void tablePurchaseTransactionsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablePurchaseTransactionsKeyReleased
        FillPurchaseDetilTransactions(tablePurchaseTransactions.getSelectedRow());
    }//GEN-LAST:event_tablePurchaseTransactionsKeyReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int RowCount, RecNum;
        if (tfPurchaseNumber.getText().isEmpty()) JOptionPane.showMessageDialog(null, "Purchase Number is Empty");
        else {
            //JOptionPane.showMessageDialog(null, "simpan header sales transaksi");
            modelPurchaseTransactions.setPurchase(
                gettfPurchaseNumber(), 
                getspPurchaseDate(),
                getspShippedDate(),
                gettfComments(),
                gettfSupplierId()
            );       
            daoPurchaseTransactions.addPurchase(modelPurchaseTransactions);
            RowCount = tablePurchaseTransactions.getModel().getRowCount();
            for (RecNum = 0; RecNum < RowCount; RecNum++) {
                //Insert into table PurchaseDetils
                modelPurchaseTransactions.setPurchaseDetils(
                        gettfPurchaseNumber(), 
                        tablePurchaseTransactions.getModel().getValueAt(RecNum, 0).toString(),
                        Integer.parseInt(tablePurchaseTransactions.getModel().getValueAt(RecNum, 2).toString()),
                        Float.parseFloat(tablePurchaseTransactions.getModel().getValueAt(RecNum, 3).toString())
                );
                daoPurchaseTransactions.addPurchaseDetils(modelPurchaseTransactions);
                
                //update QuantityInStock table Products
                modelPurchaseTransactions.setProducts(
                        tablePurchaseTransactions.getModel().getValueAt(RecNum, 0).toString(),
                        Integer.parseInt(tablePurchaseTransactions.getModel().getValueAt(RecNum, 2).toString())
                );
                daoPurchaseTransactions.updateProducts(modelPurchaseTransactions);
            }    
        }
        ShowPurchaseTransactionsData();
        settfGrandTotal(tfPurchaseNumber.getText());
        tfPurchaseNumber.requestFocus();
        daoPurchaseTransactions.deleteAllPurchaseTransactions();
        dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
       daoPurchaseTransactions.deleteAllPurchaseTransactions();
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void tfGrandTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfGrandTotalActionPerformed
    }//GEN-LAST:event_tfGrandTotalActionPerformed

    private void tfSupplierIdPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tfSupplierIdPropertyChange
    }//GEN-LAST:event_tfSupplierIdPropertyChange

    private void tfLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLastNameActionPerformed
    }//GEN-LAST:event_tfLastNameActionPerformed

    private void tfSupplierIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSupplierIdKeyReleased
        if (findSupplier(tfSupplierId.getText()) == false) {
            tfFirstName.setText(null);
            tfLastName.setText(null);
        }
    }//GEN-LAST:event_tfSupplierIdKeyReleased

    private void tfPurchaseNumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPurchaseNumberFocusLost
        if (findPurchaseTransactions(tfPurchaseNumber.getText()) == true) {
            JOptionPane.showMessageDialog(null, "Purchase Number "+tfPurchaseNumber.getText()+" sudah ada");
            tfPurchaseNumber.requestFocus();
        } else EmptyForm();
    }//GEN-LAST:event_tfPurchaseNumberFocusLost

    private void tfSupplierIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfSupplierIdFocusLost
        if (findSupplier(tfSupplierId.getText()) == false) {
            tfFirstName.setText(null);
            tfLastName.setText(null);
            JOptionPane.showMessageDialog(null, "Supplier ID "+tfSupplierId.getText()+" tidak ada");
            tfSupplierId.requestFocus();
        }
    }//GEN-LAST:event_tfSupplierIdFocusLost

    private void tfProductCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfProductCodeKeyReleased
        if (findProducts(tfProductCode.getText()) == false) {
            tfProductName.setText(null);
            tfQuantity.setText(null);
            tfPriceEach.setText(null);
            tfTotalPrice.setText(null);
        }
    }//GEN-LAST:event_tfProductCodeKeyReleased

    private void tfProductCodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfProductCodeFocusLost
        if (findProducts(tfProductCode.getText()) == false) {
            tfProductName.setText(null);
            tfQuantity.setText(null);
            tfPriceEach.setText(null);
            tfTotalPrice.setText(null);
            JOptionPane.showMessageDialog(null, "Product Code "+tfProductCode.getText()+" tidak ada");
            tfProductCode.requestFocus();
        }
    }//GEN-LAST:event_tfProductCodeFocusLost

    private void tfQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQuantityKeyReleased
        settfTotalPrice(gettfQuantity() * gettfPriceEach());
    }//GEN-LAST:event_tfQuantityKeyReleased

    private void tfPriceEachKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPriceEachKeyReleased
        settfTotalPrice(gettfQuantity() * gettfPriceEach());
    }//GEN-LAST:event_tfPriceEachKeyReleased

    private void tfCommentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCommentsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCommentsActionPerformed

    private void tfProductCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfProductCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfProductCodeActionPerformed

    private void tfPriceEachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPriceEachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPriceEachActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormPurchaseTransactions1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPurchaseTransactions1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPurchaseTransactions1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPurchaseTransactions1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPurchaseTransactions1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spPurchaseDate;
    private javax.swing.JSpinner spShippedDate;
    private javax.swing.JTable tablePurchaseTransactions;
    private javax.swing.JTextField tfComments;
    private javax.swing.JTextField tfFirstName;
    private javax.swing.JTextField tfGrandTotal;
    private javax.swing.JTextField tfLastName;
    private javax.swing.JTextField tfPriceEach;
    private javax.swing.JTextField tfProductCode;
    private javax.swing.JTextField tfProductName;
    private javax.swing.JTextField tfPurchaseNumber;
    private javax.swing.JTextField tfQuantity;
    private javax.swing.JTextField tfSupplierId;
    private javax.swing.JTextField tfTotalPrice;
    // End of variables declaration//GEN-END:variables
}
