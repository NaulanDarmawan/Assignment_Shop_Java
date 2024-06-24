package view;

import controller.PurchaseTransactionsController;
//------------------------------------------------------------------------------
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class FormPurchaseTransactions extends javax.swing.JFrame {

    PurchaseTransactionsController controllerPurchaseTransactions;
    int hitung;

    public FormPurchaseTransactions() {
        initComponents();
        setLocationRelativeTo(null);
        ShowPurchaseTransactionsData();
        IdOtomatis();
        this.hitung = Integer.parseInt(input_purchaseNumber.getText());
    }
    
    public void ShowPurchaseTransactionsData() {
        controllerPurchaseTransactions = new PurchaseTransactionsController(this);
        controllerPurchaseTransactions.viewListPurchaseTransactions();
    }
    
    public void setTablePurchaseTransactions(JTable tablePurchaseTransactions) {
        this.table_purchase_transactions = tablePurchaseTransactions;
    }
    
    public JTable getTablePurchaseTransactions() {
        return this.table_purchase_transactions;
    }

    public String gettfPurchaseNumber() {
        return this.input_purchaseNumber.getText();
    }
    
    public String gettfSupplierId() {
        return this.input_supplier_id.getText();
    }

    public String gettfSupplierFirstName() {
        return this.input_supplier_firstName.getText();
    }
    
    public String gettfSupplierLastName() {
        return this.input_supplier_lastName.getText();
    }
    
    public String getspPurchaseDate() {
        String SaleDate = input_purchaseDate.getValue().toString();
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

    public String gettfComments() {
        return this.input_comments.getText();
    }

    public String gettfProductCode() {
        return this.input_productCode.getText();
    }
    
    public String gettfQuantity() {
        return this.input_productQuantity.getText();
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
        input_purchaseNumber.setText(null);
        input_supplier_id.setText(null);
        input_supplier_firstName.setText(null);
        input_supplier_lastName.setText(null);
        input_purchaseDate.setValue(calendar.getTime());
        input_shippedDate.setValue(calendar.getTime());
        input_comments.setText(null);
        input_productCode.setText(null);
        input_productName.setText(null);
        input_productQuantity.setText(null);
        input_productPriceEach.setText(null);
        input_productTotalPrice.setText(null);
    }
    
    private void FillForm(int RecNum) {
        input_purchaseNumber.setText(table_purchase_transactions.getModel().getValueAt(RecNum, 0).toString());
        //----------------------------------------------------------------------
        String PurchaseDate = table_purchase_transactions.getModel().getValueAt(RecNum, 1).toString();
        int Year = Integer.parseInt(PurchaseDate.substring(0, 4));
        int Month = Integer.parseInt(PurchaseDate.substring(5, 7));
        int Day = Integer.parseInt(PurchaseDate.substring(8, 10));
        Calendar calendar = new GregorianCalendar(Year, Month - 1, Day);
        input_purchaseDate.setValue(calendar.getTime());
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        String ShippedDate = table_purchase_transactions.getModel().getValueAt(RecNum, 2).toString();
        int Year2 = Integer.parseInt(ShippedDate.substring(0, 4));
        int Month2 = Integer.parseInt(ShippedDate.substring(5, 7));
        int Day2 = Integer.parseInt(ShippedDate.substring(8, 10));
        Calendar calendar2 = new GregorianCalendar(Year2, Month2 - 1, Day2);
        input_shippedDate.setValue(calendar2.getTime());
        //----------------------------------------------------------------------  
        input_comments.setText(table_purchase_transactions.getModel().getValueAt(RecNum, 3).toString());
        input_supplier_id.setText(table_purchase_transactions.getModel().getValueAt(RecNum, 4).toString());
        input_supplier_firstName.setText(table_purchase_transactions.getModel().getValueAt(RecNum, 5).toString());
        input_supplier_lastName.setText(table_purchase_transactions.getModel().getValueAt(RecNum, 6).toString());
        input_productCode.setText(table_purchase_transactions.getModel().getValueAt(RecNum, 7).toString());
        input_productName.setText(table_purchase_transactions.getModel().getValueAt(RecNum, 8).toString());
        input_productQuantity.setText(table_purchase_transactions.getModel().getValueAt(RecNum, 9).toString());
        input_productPriceEach.setText(table_purchase_transactions.getModel().getValueAt(RecNum, 10).toString());
        input_productTotalPrice.setText(table_purchase_transactions.getModel().getValueAt(RecNum, 11).toString());
    }
    
    private void IdOtomatis() {
        input_purchaseNumber.requestFocus();
        int RowCount = table_purchase_transactions.getModel().getRowCount();
        String id_terakhir = table_purchase_transactions.getValueAt(RowCount - 1, 0).toString();
        int id_otomatis = Integer.parseInt(id_terakhir) + 1;
        input_purchaseNumber.setText("" + String.valueOf(id_otomatis));
        this.hitung = Integer.parseInt(input_purchaseNumber.getText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        input_purchaseNumber = new javax.swing.JTextField();
        input_supplier_id = new javax.swing.JTextField();
        input_productQuantity = new javax.swing.JTextField();
        input_productPriceEach = new javax.swing.JTextField();
        input_productTotalPrice = new javax.swing.JTextField();
        button_insertUpdate = new javax.swing.JButton();
        button_save = new javax.swing.JButton();
        button_delete = new javax.swing.JButton();
        button_exit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_purchase_transactions = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        input_comments = new javax.swing.JTextArea();
        input_supplier_firstName = new javax.swing.JTextField();
        input_supplier_lastName = new javax.swing.JTextField();
        input_purchaseDate = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        input_shippedDate = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        input_productCode = new javax.swing.JTextField();
        input_productName = new javax.swing.JTextField();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Purchase Number      :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Product Code       :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Comments           :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Quantity               :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Price Each             :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Total Price            :");

        input_purchaseNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        input_purchaseNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                input_purchaseNumberKeyReleased(evt);
            }
        });

        input_supplier_id.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        input_productQuantity.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        input_productPriceEach.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        input_productTotalPrice.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

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

        table_purchase_transactions.setModel(new javax.swing.table.DefaultTableModel(
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
        table_purchase_transactions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_purchase_transactionsMouseClicked(evt);
            }
        });
        table_purchase_transactions.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table_purchase_transactionsKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table_purchase_transactions);

        input_comments.setColumns(20);
        input_comments.setRows(5);
        jScrollPane2.setViewportView(input_comments);

        input_supplier_firstName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        input_supplier_lastName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        input_purchaseDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        input_purchaseDate.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(1715848337817L), null, java.util.Calendar.DAY_OF_MONTH));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Purchase Date");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Shipped Date");

        input_shippedDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        input_shippedDate.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(1715848337817L), null, java.util.Calendar.DAY_OF_MONTH));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Supplier                :");

        input_productCode.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        input_productName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(input_supplier_id)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(input_supplier_firstName))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(input_productQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(input_productTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(input_productPriceEach, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(input_productCode, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(input_productName))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(input_purchaseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(129, 129, 129)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(input_supplier_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button_insertUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_save, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_exit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(input_shippedDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(29, 29, 29))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel10)
                        .addGap(12, 12, 12)
                        .addComponent(input_purchaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addGap(209, 209, 209))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(input_purchaseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input_supplier_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input_supplier_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input_supplier_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(input_shippedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(input_purchaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11)))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addComponent(jLabel6))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(button_insertUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(button_save, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(input_productCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(input_productName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(input_productQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(input_productPriceEach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(input_productTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_insertUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_insertUpdateActionPerformed
        // TODO add your handling code here:
        input_purchaseNumber.requestFocus();
        IdOtomatis();
    }//GEN-LAST:event_button_insertUpdateActionPerformed

    private void button_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_saveActionPerformed
        // TODO add your handling code here:
        if (input_purchaseNumber.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Purchase is Empty");
        } else {
            controllerPurchaseTransactions.savePurchaseTransactions();
            EmptyForm();
        }
        ShowPurchaseTransactionsData();
        input_purchaseNumber.requestFocus();
        IdOtomatis();
    }//GEN-LAST:event_button_saveActionPerformed

    private void button_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_deleteActionPerformed
        // TODO add your handling code here:
        if (input_purchaseNumber.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Sales Number is Empty");
        } else {
            controllerPurchaseTransactions.deletePurchaseTransactions();
        }
        ShowPurchaseTransactionsData();
        EmptyForm();
        input_purchaseNumber.requestFocus();
    }//GEN-LAST:event_button_deleteActionPerformed

    private void button_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_exitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_button_exitActionPerformed

    private void input_purchaseNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_purchaseNumberKeyReleased
        // TODO add your handling code here:
        this.hitung = Integer.parseInt(input_purchaseNumber.getText());
        if (evt.getKeyCode() == evt.VK_UP) {
            hitung++;
            input_purchaseNumber.setText("" + hitung);
        } else if (evt.getKeyCode() == evt.VK_DOWN) {
            if (hitung > 1) {
                hitung--;
                input_purchaseNumber.setText("" + hitung);
            } else {
                hitung = 1;
                input_purchaseNumber.setText("" + hitung);
            }
        }
        
        int RowCount = table_purchase_transactions.getModel().getRowCount();
        for (int RecNum = 0; RecNum < RowCount; RecNum++) {
            if (input_purchaseNumber.getText().equals(table_purchase_transactions.getValueAt(RecNum, 0).toString())) {
                //JOptionPane.showMessageDialog(null, "Id Ketemu");
                FillForm(RecNum);
                break;
            } else {
                EmptyForm();
            }
        }
    }//GEN-LAST:event_input_purchaseNumberKeyReleased

    private void table_purchase_transactionsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table_purchase_transactionsKeyReleased
        // TODO add your handling code here:
        FillForm(table_purchase_transactions.getSelectedRow());
    }//GEN-LAST:event_table_purchase_transactionsKeyReleased

    private void table_purchase_transactionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_purchase_transactionsMouseClicked
        // TODO add your handling code here:
        FillForm(table_purchase_transactions.getSelectedRow());
    }//GEN-LAST:event_table_purchase_transactionsMouseClicked

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
            java.util.logging.Logger.getLogger(FormPurchaseTransactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPurchaseTransactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPurchaseTransactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPurchaseTransactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPurchaseTransactions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_delete;
    private javax.swing.JButton button_exit;
    private javax.swing.JButton button_insertUpdate;
    private javax.swing.JButton button_save;
    private javax.swing.JTextArea input_comments;
    private javax.swing.JTextField input_productCode;
    private javax.swing.JTextField input_productName;
    private javax.swing.JTextField input_productPriceEach;
    private javax.swing.JTextField input_productQuantity;
    private javax.swing.JTextField input_productTotalPrice;
    private javax.swing.JSpinner input_purchaseDate;
    private javax.swing.JTextField input_purchaseNumber;
    private javax.swing.JSpinner input_shippedDate;
    private javax.swing.JTextField input_supplier_firstName;
    private javax.swing.JTextField input_supplier_id;
    private javax.swing.JTextField input_supplier_lastName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_purchase_transactions;
    // End of variables declaration//GEN-END:variables
}
