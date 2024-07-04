//@author Naulan Darmawan

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

    private DecimalFormat kursIndonesia;
    private DecimalFormatSymbols formatRp;

    public Main() {
        initComponents();
        formatMataUangIndonesia();
    }

    private void formatMataUangIndonesia() {
        kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);
        kursIndonesia.setMaximumFractionDigits(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tf_nomor_rekening = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_nama_pelanggan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmb_bulan_tagihan = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmb_kelas_pelanggan = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tf_meter_lalu = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tf_tarif_1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tf_meter_sekarang = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tf_pemakaian = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tf_tarif_2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tf_tarif_3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        tf_total_biaya_air = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        tf_sewa_meter = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        tf_administrasi = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        tf_total_tagihan = new javax.swing.JTextField();
        btn_hitung = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_keluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setForeground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel1.setText("BUKTI PEMBAYARAN REKENING AIR");

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel2.setText("PERUSAHAAN DAERAH AIR MINUM KOTA MALANG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(171, 171, 171))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(99, 99, 99))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel2.setForeground(new java.awt.Color(51, 153, 255));

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel5.setText("Nomor Rekening");

        tf_nomor_rekening.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tf_nomor_rekening.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_nomor_rekeningFocusLost(evt);
            }
        });
        tf_nomor_rekening.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_nomor_rekeningKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel6.setText("Nama Pelanggan");

        tf_nama_pelanggan.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tf_nama_pelanggan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_nama_pelangganFocusLost(evt);
            }
        });
        tf_nama_pelanggan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_nama_pelangganKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel7.setText("Bulan Tagihan");

        cmb_bulan_tagihan.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cmb_bulan_tagihan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel8.setText("Kelas Pelanggan");

        cmb_kelas_pelanggan.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cmb_kelas_pelanggan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kelas 1", "Kelas 2", "Kelas 3" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_nomor_rekening)
                    .addComponent(cmb_bulan_tagihan, 0, 184, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(tf_nama_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(cmb_kelas_pelanggan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_nomor_rekening, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tf_nama_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmb_bulan_tagihan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cmb_kelas_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel4.setText("Identitas Pelanggan");

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel9.setText("Biaya Air");

        jPanel3.setBackground(new java.awt.Color(153, 255, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel3.setForeground(new java.awt.Color(51, 153, 255));

        jLabel10.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel10.setText("Meter Lalu");

        tf_meter_lalu.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tf_meter_lalu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_meter_laluKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel11.setText("Tarif 1");

        tf_tarif_1.setEditable(false);
        tf_tarif_1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tf_tarif_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel12.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel12.setText("Meter Sekarang");

        tf_meter_sekarang.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tf_meter_sekarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_meter_sekarangKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel14.setText("Pemakaian");

        tf_pemakaian.setEditable(false);
        tf_pemakaian.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tf_pemakaian.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel15.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel15.setText("Tarif 2");

        tf_tarif_2.setEditable(false);
        tf_tarif_2.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tf_tarif_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel16.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel16.setText("Tarif 3");

        tf_tarif_3.setEditable(false);
        tf_tarif_3.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tf_tarif_3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_meter_lalu, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_meter_sekarang, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_pemakaian, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel11))))
                .addGap(69, 69, 69)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_tarif_3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_tarif_2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_tarif_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tf_meter_lalu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(tf_tarif_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tf_meter_sekarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(tf_tarif_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(tf_pemakaian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(tf_tarif_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel13.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel13.setText("Total Tagihan");

        jPanel4.setBackground(new java.awt.Color(255, 153, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel4.setForeground(new java.awt.Color(51, 153, 255));

        jLabel18.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel18.setText("Total Biaya Air");

        tf_total_biaya_air.setEditable(false);
        tf_total_biaya_air.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tf_total_biaya_air.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel21.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel21.setText("Sewa Meter");

        tf_sewa_meter.setEditable(false);
        tf_sewa_meter.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tf_sewa_meter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel22.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel22.setText("Administrasi");

        tf_administrasi.setEditable(false);
        tf_administrasi.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tf_administrasi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel23.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel23.setText("Total Tagihan");

        tf_total_tagihan.setEditable(false);
        tf_total_tagihan.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tf_total_tagihan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn_hitung.setBackground(new java.awt.Color(0, 204, 51));
        btn_hitung.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        btn_hitung.setForeground(new java.awt.Color(255, 255, 255));
        btn_hitung.setText("Hitung");
        btn_hitung.setBorder(null);
        btn_hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hitungActionPerformed(evt);
            }
        });

        btn_clear.setBackground(new java.awt.Color(255, 153, 51));
        btn_clear.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        btn_clear.setForeground(new java.awt.Color(255, 255, 255));
        btn_clear.setText("Clear");
        btn_clear.setBorder(null);
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_keluar.setBackground(new java.awt.Color(255, 51, 51));
        btn_keluar.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        btn_keluar.setForeground(new java.awt.Color(255, 255, 255));
        btn_keluar.setText("Keluar");
        btn_keluar.setBorder(null);
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_hitung, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(141, 141, 141)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tf_total_tagihan, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tf_total_biaya_air, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tf_administrasi, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tf_sewa_meter, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_total_biaya_air, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(tf_sewa_meter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(tf_administrasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(tf_total_tagihan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btn_hitung, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel13)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hitungActionPerformed
        // Hitung Pemakaian -- Nomor Empat
        try {
            int meter_sekarang = Integer.parseInt(tf_meter_sekarang.getText());
            int meter_lalu = Integer.parseInt(tf_meter_lalu.getText());
            int pemakaian = meter_sekarang - meter_lalu;
            tf_pemakaian.setText(String.valueOf(pemakaian));

            // Hitung Tarif Dengan Pembagiannya -- Nomor Lima & Nomor Enam
            int biaya_air;

            if (pemakaian <= 5) {
                biaya_air = 5 * 2000;
                tf_tarif_1.setText(String.valueOf(5 * 2000));
                tf_tarif_2.setText(String.valueOf(kursIndonesia.format(0)));
                tf_tarif_3.setText(String.valueOf(kursIndonesia.format(0)));
                tf_total_biaya_air.setText(String.valueOf(kursIndonesia.format(biaya_air)));
            } else if (pemakaian <= 15) {
                biaya_air = pemakaian * 2000;
                tf_tarif_1.setText(String.valueOf(pemakaian * 2000));
                tf_tarif_2.setText(String.valueOf(kursIndonesia.format(0)));
                tf_tarif_3.setText(String.valueOf(kursIndonesia.format(0)));
                tf_total_biaya_air.setText(String.valueOf(kursIndonesia.format(biaya_air)));
            } else if (pemakaian <= 30) {
                biaya_air = 15 * 2000 + (pemakaian - 15) * 2500;
                tf_tarif_1.setText(String.valueOf(kursIndonesia.format(15 * 2000)));
                tf_tarif_2.setText(String.valueOf(kursIndonesia.format((pemakaian - 15) * 2500)));
                tf_tarif_3.setText(String.valueOf(kursIndonesia.format(0)));
                tf_total_biaya_air.setText(String.valueOf(kursIndonesia.format(biaya_air)));
            } else {
                biaya_air = 15 * 2000 + 15 * 2500 + (pemakaian - 30) * 3500;
                tf_tarif_1.setText(String.valueOf(kursIndonesia.format(15 * 2000)));
                tf_tarif_2.setText(String.valueOf(kursIndonesia.format(15 * 2500)));
                tf_tarif_3.setText(String.valueOf(kursIndonesia.format((pemakaian - 30) * 3500)));
                tf_total_biaya_air.setText(String.valueOf(kursIndonesia.format(biaya_air)));
            }

            // Set Administrasi -- Nomor 7
            int biaya_administrasi = 5000;
            tf_administrasi.setText(kursIndonesia.format(biaya_administrasi));

            // Set Sewa Meter -- Nomor 8
            int biaya_sewa_meter = 0;
            String kelas = cmb_kelas_pelanggan.getSelectedItem().toString(); // Kelas 1
            switch (kelas) {
                case "Kelas 1":
                    biaya_sewa_meter = 5000;
                    tf_sewa_meter.setText(kursIndonesia.format(biaya_sewa_meter));
                    break;
                case "Kelas 2":
                    biaya_sewa_meter = 3500;
                    tf_sewa_meter.setText(kursIndonesia.format(biaya_sewa_meter));
                    break;
                case "Kelas 3":
                    biaya_sewa_meter = 2500;
                    tf_sewa_meter.setText(kursIndonesia.format(biaya_sewa_meter));
                    break;
            }

            // Hitung Total Tagihan -- Nomor 9
            int biaya_total_tagihan = biaya_air + biaya_administrasi + biaya_sewa_meter;
            tf_total_tagihan.setText(String.valueOf(kursIndonesia.format(biaya_total_tagihan)));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }//GEN-LAST:event_btn_hitungActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // Nomor 10
        tf_nomor_rekening.setText("");
        tf_nama_pelanggan.setText("");
        cmb_bulan_tagihan.setSelectedIndex(0);
        cmb_kelas_pelanggan.setSelectedIndex(0);
        tf_meter_lalu.setText("");
        tf_meter_sekarang.setText("");
        tf_pemakaian.setText("");
        tf_tarif_1.setText("");
        tf_tarif_2.setText("");
        tf_tarif_3.setText("");
        tf_total_biaya_air.setText("");
        tf_sewa_meter.setText("");
        tf_administrasi.setText("");
        tf_total_tagihan.setText("");
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
        // Nomor 11
        dispose();
    }//GEN-LAST:event_btn_keluarActionPerformed

    private void tf_meter_laluKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_meter_laluKeyTyped
        // Mencegah Memasukkan Huruf
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_tf_meter_laluKeyTyped

    private void tf_meter_sekarangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_meter_sekarangKeyTyped
        // Mencegah Memasukkan Huruf
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_tf_meter_sekarangKeyTyped

    private void tf_nama_pelangganKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_nama_pelangganKeyTyped
        // Mencegah Memasukkan Huruf
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_tf_nama_pelangganKeyTyped

    private void tf_nomor_rekeningKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_nomor_rekeningKeyTyped
        // Mencegah Memasukkan Huruf
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_tf_nomor_rekeningKeyTyped

    private void tf_nomor_rekeningFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_nomor_rekeningFocusLost
        // TODO add your handling code here:
        if (tf_nomor_rekening.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mohon Isi Nomor Rekening Terlebih Dahulu");
            tf_nomor_rekening.requestFocus();
        }
    }//GEN-LAST:event_tf_nomor_rekeningFocusLost

    private void tf_nama_pelangganFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_nama_pelangganFocusLost
        // TODO add your handling code here:
        if (tf_nama_pelanggan.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mohon Isi Nama Pelanggan Terlebih Dahulu");
            tf_nama_pelanggan.requestFocus();
        }
    }//GEN-LAST:event_tf_nama_pelangganFocusLost

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_hitung;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JComboBox<String> cmb_bulan_tagihan;
    private javax.swing.JComboBox<String> cmb_kelas_pelanggan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField tf_administrasi;
    private javax.swing.JTextField tf_meter_lalu;
    private javax.swing.JTextField tf_meter_sekarang;
    private javax.swing.JTextField tf_nama_pelanggan;
    private javax.swing.JTextField tf_nomor_rekening;
    private javax.swing.JTextField tf_pemakaian;
    private javax.swing.JTextField tf_sewa_meter;
    private javax.swing.JTextField tf_tarif_1;
    private javax.swing.JTextField tf_tarif_2;
    private javax.swing.JTextField tf_tarif_3;
    private javax.swing.JTextField tf_total_biaya_air;
    private javax.swing.JTextField tf_total_tagihan;
    // End of variables declaration//GEN-END:variables
}
