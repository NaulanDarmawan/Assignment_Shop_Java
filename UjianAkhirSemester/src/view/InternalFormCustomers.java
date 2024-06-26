/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import controller.CustomerController;
//------------------------------------------------------------------------------
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class InternalFormCustomers extends javax.swing.JInternalFrame {

    /**
     * Creates new form InternalFormCustpmers
     */
    
    CustomerController controllerCustomers;
    int hitung;

    /**
     * Creates new form FormCustomers
     */
    public InternalFormCustomers() {
        initComponents();
        ShowCustomersData();
        IdOtomatis();
        this.hitung = Integer.parseInt(input_id.getText());
    }

    public void ShowCustomersData() {
        controllerCustomers = new CustomerController(this);   
        controllerCustomers.viewListCustomers();               
    }

    public void setTableCustomers(JTable tableCustomers) {
        this.table_customers = tableCustomers;
    }

    public JTable getTableCustomers() {
        return this.table_customers;
    }

    public int gettfId() {
        return Integer.parseInt(this.input_id.getText());
    }

    public String gettfFirstName() {
        return this.input_firstName.getText();
    }

    public String gettfLastName() {
        return this.input_lastName.getText();
    }

    public String getspDateOfBirth() {
        String DateOfBrith = input_dateOfBirth.getValue().toString();
        String Year = DateOfBrith.substring(24);
        String Month = DateOfBrith.substring(4, 7);
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
        String Day = DateOfBrith.substring(8, 10);
        return Year + "-" + Month + "-" + Day;
    }

    public String getcbGender() {
        return input_gender.getItemAt(input_gender.getSelectedIndex());
    }

    public String gettfPhone() {
        return input_phoneNumber.getText();
    }

    public String gettfAddress() {
        return input_address.getText();
    }

    public String gettfCity() {
        return input_city.getText();
    }

    public String gettfCountry() {
        return input_country.getText();
    }

    private void EmptyForm() {
        int Year = java.time.LocalDate.now().getYear();
        int Month = java.time.LocalDate.now().getMonthValue();
        int Day = java.time.LocalDate.now().getDayOfMonth();
        Calendar calendar = new GregorianCalendar(Year, Month - 1, Day);
        //----------------------------------------------------------
        input_firstName.setText(null);
        input_lastName.setText(null);
        input_dateOfBirth.setValue(calendar.getTime());
        input_gender.setSelectedIndex(0);
        input_phoneNumber.setText(null);
        input_address.setText(null);
        input_city.setText(null);
        input_country.setText(null);
    }

    private void FillForm(int RecNum) {
        input_id.setText(table_customers.getModel().getValueAt(RecNum, 0).toString());
        input_firstName.setText(table_customers.getModel().getValueAt(RecNum, 1).toString());
        input_lastName.setText(table_customers.getModel().getValueAt(RecNum, 2).toString());
        //----------------------------------------------------------------------
        String Date = table_customers.getModel().getValueAt(RecNum, 3).toString();
        int Year = Integer.parseInt(Date.substring(0, 4));
        int Month = Integer.parseInt(Date.substring(5, 7));
        int Day = Integer.parseInt(Date.substring(8, 10));
        Calendar calendar = new GregorianCalendar(Year, Month - 1, Day);
        input_dateOfBirth.setValue(calendar.getTime());
        //----------------------------------------------------------------------       
        input_gender.setSelectedItem(table_customers.getModel().getValueAt(RecNum, 4).toString());
        input_phoneNumber.setText(table_customers.getModel().getValueAt(RecNum, 5).toString());
        input_address.setText(table_customers.getModel().getValueAt(RecNum, 6).toString());
        input_city.setText(table_customers.getModel().getValueAt(RecNum, 7).toString());
        input_country.setText(table_customers.getModel().getValueAt(RecNum, 8).toString());
    }
    
     private void IdOtomatis() {
        input_id.requestFocus();
        int RowCount = table_customers.getModel().getRowCount();
        String id_terakhir = table_customers.getValueAt(RowCount - 1, 0).toString();
        int id_otomatis = Integer.parseInt(id_terakhir) + 1;
        input_id.setText("" + String.valueOf(id_otomatis));
        this.hitung = Integer.parseInt(input_id.getText());
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        input_dateOfBirth = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        input_gender = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        input_phoneNumber = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        input_address = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        input_city = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        input_country = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        button_insertUpdate = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        button_save = new javax.swing.JButton();
        input_id = new javax.swing.JTextField();
        button_delete = new javax.swing.JButton();
        input_firstName = new javax.swing.JTextField();
        button_exit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        input_lastName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_customers = new javax.swing.JTable();

        input_dateOfBirth.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        input_dateOfBirth.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(1715848337817L), null, java.util.Calendar.DAY_OF_MONTH));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Last Name            :");

        input_gender.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        input_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Date Of Birth       :");

        input_phoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Gender                  :");

        input_address.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Phone Number    :");

        input_city.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Address                 :");

        input_country.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("City                        :");

        button_insertUpdate.setBackground(new java.awt.Color(102, 255, 0));
        button_insertUpdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button_insertUpdate.setText("Insert / Update");
        button_insertUpdate.setBorder(null);
        button_insertUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_insertUpdateActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Country                 :");

        button_save.setBackground(new java.awt.Color(153, 153, 255));
        button_save.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button_save.setText("Save");
        button_save.setBorder(null);
        button_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_saveActionPerformed(evt);
            }
        });

        input_id.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        input_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                input_idKeyReleased(evt);
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

        input_firstName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        button_exit.setBackground(new java.awt.Color(255, 153, 102));
        button_exit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button_exit.setText("Exit");
        button_exit.setBorder(null);
        button_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_exitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("id                           :");

        input_lastName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("First Name           :");

        table_customers.setModel(new javax.swing.table.DefaultTableModel(
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
        table_customers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_customersMouseClicked(evt);
            }
        });
        table_customers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table_customersKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table_customers);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(input_phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(input_address, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(input_country, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(input_city, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(input_gender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(input_dateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(input_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(input_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(input_id, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_insertUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_save, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_exit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(input_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(input_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(input_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(button_insertUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(input_dateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(input_gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(input_phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(input_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(input_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(input_country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(button_save, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_insertUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_insertUpdateActionPerformed
        // TODO add your handling code here:
        IdOtomatis();
    }//GEN-LAST:event_button_insertUpdateActionPerformed

    private void button_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_saveActionPerformed
        // TODO add your handling code here:
        if (input_id.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID is Empty");
        } else {
            controllerCustomers.saveCustomers();
            EmptyForm();
        }
        ShowCustomersData();
        input_id.requestFocus();
        IdOtomatis();
    }//GEN-LAST:event_button_saveActionPerformed

    private void input_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_idKeyReleased
        // TODO add your handling code here:
        this.hitung = Integer.parseInt(input_id.getText());
        if (evt.getKeyCode() == evt.VK_UP) {
            hitung++;
            input_id.setText("" + hitung);
        } else if (evt.getKeyCode() == evt.VK_DOWN) {
            if (hitung > 1) {
                hitung--;
                input_id.setText("" + hitung);
            } else {
                hitung = 1;
                input_id.setText("" + hitung);
            }
        }

        int RowCount = table_customers.getModel().getRowCount();
        for (int RecNum = 0; RecNum < RowCount; RecNum++) {
            if (input_id.getText().equals(table_customers.getValueAt(RecNum, 0).toString())) {
                //JOptionPane.showMessageDialog(null, "Id Ketemu");
                FillForm(RecNum);
                break;
            } else {
                EmptyForm();
            }
        }
    }//GEN-LAST:event_input_idKeyReleased

    private void button_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_deleteActionPerformed
        // TODO add your handling code here:
        if (input_id.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID is Empty");
        } else {
            controllerCustomers.deleteCustomer();
        }
        ShowCustomersData();
        EmptyForm();
        input_id.requestFocus();
    }//GEN-LAST:event_button_deleteActionPerformed

    private void button_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_exitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_button_exitActionPerformed

    private void table_customersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_customersMouseClicked
        // TODO add your handling code here:
        FillForm(table_customers.getSelectedRow());
    }//GEN-LAST:event_table_customersMouseClicked

    private void table_customersKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table_customersKeyReleased
        // TODO add your handling code here:
        FillForm(table_customers.getSelectedRow());
    }//GEN-LAST:event_table_customersKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_delete;
    private javax.swing.JButton button_exit;
    private javax.swing.JButton button_insertUpdate;
    private javax.swing.JButton button_save;
    private javax.swing.JTextField input_address;
    private javax.swing.JTextField input_city;
    private javax.swing.JTextField input_country;
    private javax.swing.JSpinner input_dateOfBirth;
    private javax.swing.JTextField input_firstName;
    private javax.swing.JComboBox<String> input_gender;
    private javax.swing.JTextField input_id;
    private javax.swing.JTextField input_lastName;
    private javax.swing.JTextField input_phoneNumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_customers;
    // End of variables declaration//GEN-END:variables
}
