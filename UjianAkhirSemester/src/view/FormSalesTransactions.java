package view;

import controller.SalesTransactionsController;
//------------------------------------------------------------------------------
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class FormSalesTransactions extends javax.swing.JFrame {

    SalesTransactionsController controllerSalesTransactions;
    
    public FormSalesTransactions() {
        initComponents();
        setLocationRelativeTo(null);
        ShowSalesTransactionsData();
    }
    
    public void ShowSalesTransactionsData() {
        controllerSalesTransactions = new SalesTransactionsController(this);
        controllerSalesTransactions.viewListSalesTransactions();
    }
    
    public void setTableSalesTransactions(JTable tableSalesTransactions) {
        this.table_sales_transaction = tableSalesTransactions;
    }

    public JTable getTableSalesTransactions() {
        return this.table_sales_transaction;
    }
    
    public String gettfSalesNumber() {
        return this.input_salesNumber.getText();
    }
    
    public String gettfCustomerId() {
        return this.input_customer_id.getText();
    }
    
    public String gettfCustomerFirstName() {
        return this.input_customer_firstName.getText();
    }
    
    public String gettfCustomerLastName() {
        return this.input_customer_lastName.getText();
    }
    
    public String getspSaleDate() {
        String SaleDate = input_saleDate.getValue().toString();
        String Year = SaleDate.substring(24);
        String Month = SaleDate.substring(4, 7);
        switch (Month) {
            case "Jan" ->
                Month = "01";
            case "Feb" ->
                Month = "02";
            case "Mar" ->
                Month = "03";
            case "Apr" ->
                Month = "04";
            case "May" ->
                Month = "04";
            case "Jun" ->
                Month = "06";
            case "Jul" ->
                Month = "07";
            case "Aug" ->
                Month = "08";
            case "Sep" ->
                Month = "09";
            case "Oct" ->
                Month = "10";
            case "Nov" ->
                Month = "11";
            case "Dec" ->
                Month = "12";
        }
        String Day = SaleDate.substring(8, 10);
        return Year + "-" + Month + "-" + Day;
    }
    
    public String getspShippedDate() {
        String ShippedDate = input_shippedDate.getValue().toString();
        String Year = ShippedDate.substring(24);
        String Month = ShippedDate.substring(4, 7);
        switch (Month) {
            case "Jan" ->
                Month = "01";
            case "Feb" ->
                Month = "02";
            case "Mar" ->
                Month = "03";
            case "Apr" ->
                Month = "04";
            case "May" ->
                Month = "04";
            case "Jun" ->
                Month = "06";
            case "Jul" ->
                Month = "07";
            case "Aug" ->
                Month = "08";
            case "Sep" ->
                Month = "09";
            case "Oct" ->
                Month = "10";
            case "Nov" ->
                Month = "11";
            case "Dec" ->
                Month = "12";
        }
        String Day = ShippedDate.substring(8, 10);
        return Year + "-" + Month + "-" + Day;
    }
    
    public String gettfTransactionStatus() {
        return input_transactionStatus.getItemAt(input_transactionStatus.getSelectedIndex());
    }
    
    public String gettfComments() {
        return this.input_comments.getText();
    }
    
    public String gettfProductCode() {
        return this.input_productCode.getText();
    }
    
    public String gettfProductName() {
        return this.input_productName.getText();
    }
    
    public String gettfProductPriceEach() {
        return this.input_productPriceEach.getText();
    }
    
    public String gettfProductTotalPrice() {
        return this.input_productTotalPrice.getText();
    }
    
    private void EmptyForm() {
        int Year = java.time.LocalDate.now().getYear();
        int Month = java.time.LocalDate.now().getMonthValue();
        int Day = java.time.LocalDate.now().getDayOfMonth();
        Calendar calendar = new GregorianCalendar(Year, Month - 1, Day);
        //----------------------------------------------------------
        input_salesNumber.setText(null);
        input_customer_id.setText(null);
        input_customer_firstName.setText(null);
        input_customer_lastName.setText(null);
        input_saleDate.setValue(calendar.getTime());
        input_shippedDate.setValue(calendar.getTime());
        input_transactionStatus.setSelectedIndex(0);
        input_comments.setText(null);
        input_productCode.setText(null);
        input_productName.setText(null);
        input_productQuantity.setText(null);
        input_productPriceEach.setText(null);
        input_productTotalPrice.setText(null);
    }

    private void FillForm(int RecNum) {
        input_salesNumber.setText(table_sales_transaction.getModel().getValueAt(RecNum, 0).toString());
        input_customer_id.setText(table_sales_transaction.getModel().getValueAt(RecNum, 1).toString());
        input_customer_firstName.setText(table_sales_transaction.getModel().getValueAt(RecNum, 2).toString());
        input_customer_lastName.setText(table_sales_transaction.getModel().getValueAt(RecNum, 3).toString());
        
        //----------------------------------------------------------------------
        String SaleDate = table_sales_transaction.getModel().getValueAt(RecNum, 4).toString();
        int Year = Integer.parseInt(SaleDate.substring(0, 4));
        int Month = Integer.parseInt(SaleDate.substring(5, 7));
        int Day = Integer.parseInt(SaleDate.substring(8, 10));
        Calendar calendar = new GregorianCalendar(Year, Month - 1, Day);
        input_saleDate.setValue(calendar.getTime());
        //---------------------------------------------------------------------- 
        
        //----------------------------------------------------------------------
        String ShippedDate = table_sales_transaction.getModel().getValueAt(RecNum, 5).toString();
        int Year2 = Integer.parseInt(ShippedDate.substring(0, 4));
        int Month2 = Integer.parseInt(ShippedDate.substring(5, 7));
        int Day2 = Integer.parseInt(ShippedDate.substring(8, 10));
        Calendar calendar2 = new GregorianCalendar(Year, Month - 1, Day);
        input_saleDate.setValue(calendar.getTime());
        //----------------------------------------------------------------------  
        
        input_description.setText(table_sales_transaction.getModel().getValueAt(RecNum, 5).toString());
        input_stock.setText(table_sales_transaction.getModel().getValueAt(RecNum, 6).toString());
        input_buyPrice.setText(table_sales_transaction.getModel().getValueAt(RecNum, 7).toString());
        input_salePrice.setText(table_sales_transaction.getModel().getValueAt(RecNum, 8).toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        input_saleDate = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        input_shippedDate = new javax.swing.JSpinner();
        input_transactionStatus = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        input_productCode = new javax.swing.JTextField();
        input_productName = new javax.swing.JTextField();
        input_productQuantity = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        input_comments = new javax.swing.JTextArea();
        input_productPriceEach = new javax.swing.JTextField();
        input_productTotalPrice = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        button_insertUpdate = new javax.swing.JButton();
        button_save = new javax.swing.JButton();
        button_delete = new javax.swing.JButton();
        button_exit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_sales_transaction = new javax.swing.JTable();
        input_customer_firstName = new javax.swing.JTextField();
        input_customer_lastName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        input_salesNumber = new javax.swing.JTextField();
        input_customer_id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        input_saleDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        input_saleDate.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(1715848337817L), null, java.util.Calendar.DAY_OF_MONTH));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Sale Date");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Shipped Date");

        input_shippedDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        input_shippedDate.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(1715848337817L), null, java.util.Calendar.DAY_OF_MONTH));

        input_transactionStatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        input_transactionStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "In Process", "Shipped", "Resolved", "On Hold", "Disputed", "Cancelled" }));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Transaction Status :");

        input_productCode.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        input_productName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        input_productQuantity.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Product Code       :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Comments           :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Quantity               :");

        input_comments.setColumns(20);
        input_comments.setRows(5);
        jScrollPane2.setViewportView(input_comments);

        input_productPriceEach.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        input_productTotalPrice.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Price Each             :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Total Price            :");

        button_insertUpdate.setBackground(new java.awt.Color(102, 255, 0));
        button_insertUpdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button_insertUpdate.setText("Insert / Update");
        button_insertUpdate.setBorder(null);
        button_insertUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_insertUpdateActionPerformed(evt);
            }
        });

        button_save.setBackground(new java.awt.Color(153, 153, 255));
        button_save.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button_save.setText("Save");
        button_save.setBorder(null);
        button_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_saveActionPerformed(evt);
            }
        });

        button_delete.setBackground(new java.awt.Color(255, 51, 51));
        button_delete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button_delete.setText("Delete");
        button_delete.setBorder(null);
        button_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_deleteActionPerformed(evt);
            }
        });

        button_exit.setBackground(new java.awt.Color(255, 153, 102));
        button_exit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button_exit.setText("Exit");
        button_exit.setBorder(null);
        button_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_exitActionPerformed(evt);
            }
        });

        table_sales_transaction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_sales_transaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_sales_transactionMouseClicked(evt);
            }
        });
        table_sales_transaction.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table_sales_transactionKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table_sales_transaction);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(input_productTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(input_productPriceEach, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(input_saleDate, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(input_shippedDate, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(input_transactionStatus, 0, 201, Short.MAX_VALUE)
                                        .addGap(146, 146, 146))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(input_productQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(input_productCode, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(input_productName, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_insertUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_save, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_exit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input_saleDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(input_shippedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(input_transactionStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(input_productCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(input_productName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(input_productQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(input_productPriceEach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button_insertUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(button_save, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(input_productTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        input_customer_firstName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        input_customer_lastName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Sales Number      :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Customers               :");

        input_salesNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        input_salesNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                input_salesNumberKeyReleased(evt);
            }
        });

        input_customer_id.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(input_customer_id)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(input_customer_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(input_salesNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(input_customer_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(input_salesNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input_customer_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input_customer_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_insertUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_insertUpdateActionPerformed
        // TODO add your handling code here:
        input_salesNumber.requestFocus();
    }//GEN-LAST:event_button_insertUpdateActionPerformed

    private void button_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_saveActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_button_saveActionPerformed

    private void button_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_deleteActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_button_deleteActionPerformed

    private void button_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_exitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_button_exitActionPerformed

    private void table_sales_transactionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_sales_transactionMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_table_sales_transactionMouseClicked

    private void table_sales_transactionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table_sales_transactionKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_table_sales_transactionKeyReleased

    private void input_salesNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_salesNumberKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_input_salesNumberKeyReleased

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
            java.util.logging.Logger.getLogger(FormSalesTransactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSalesTransactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSalesTransactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSalesTransactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSalesTransactions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_delete;
    private javax.swing.JButton button_exit;
    private javax.swing.JButton button_insertUpdate;
    private javax.swing.JButton button_save;
    private javax.swing.JTextArea input_comments;
    private javax.swing.JTextField input_customer_firstName;
    private javax.swing.JTextField input_customer_id;
    private javax.swing.JTextField input_customer_lastName;
    private javax.swing.JTextField input_productCode;
    private javax.swing.JTextField input_productName;
    private javax.swing.JTextField input_productPriceEach;
    private javax.swing.JTextField input_productQuantity;
    private javax.swing.JTextField input_productTotalPrice;
    private javax.swing.JSpinner input_saleDate;
    private javax.swing.JTextField input_salesNumber;
    private javax.swing.JSpinner input_shippedDate;
    private javax.swing.JComboBox<String> input_transactionStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_sales_transaction;
    // End of variables declaration//GEN-END:variables
}
