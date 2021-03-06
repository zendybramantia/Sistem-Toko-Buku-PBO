/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

/**
 *
 * @author zendy
 */
public class TransaksiView extends javax.swing.JFrame implements buttonInterface{

    /**
     * Creates new form Transaksi
     */
    public TransaksiView() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbBuku = new javax.swing.JComboBox<>();
        spinnerJumlah = new javax.swing.JSpinner();
        buttonTambah = new javax.swing.JButton();
        buttonReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTransaksi = new javax.swing.JTable();
        buttonKonfirmasi = new javax.swing.JButton();
        buttonBatal = new javax.swing.JButton();
        buttonRiwayat = new javax.swing.JButton();
        totalHarga = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setText("TRANSAKSI");

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel2.setText("Pilih Buku");

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel3.setText("Jumlah");

        cbBuku.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        cbBuku.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Buku" }));

        spinnerJumlah.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        spinnerJumlah.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        buttonTambah.setBackground(new java.awt.Color(255, 255, 255));
        buttonTambah.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        buttonTambah.setText("Tambah");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahActionPerformed(evt);
            }
        });

        buttonReset.setBackground(new java.awt.Color(255, 255, 255));
        buttonReset.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        buttonReset.setText("Reset");

        tableTransaksi.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tableTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Judul Buku", "Jumlah", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableTransaksi);

        buttonKonfirmasi.setBackground(new java.awt.Color(255, 255, 255));
        buttonKonfirmasi.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        buttonKonfirmasi.setText("Konfirmasi");

        buttonBatal.setBackground(new java.awt.Color(255, 255, 255));
        buttonBatal.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        buttonBatal.setText("Batal");

        buttonRiwayat.setBackground(new java.awt.Color(255, 255, 255));
        buttonRiwayat.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        buttonRiwayat.setText("Riwayat Transaksi");

        totalHarga.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        totalHarga.setText("Total Harga : ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalHarga)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(83, 83, 83))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(63, 63, 63)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(spinnerJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(buttonTambah)
                            .addGap(18, 18, 18)
                            .addComponent(buttonReset)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonRiwayat))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(buttonKonfirmasi)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonBatal))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spinnerJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonTambah)
                    .addComponent(buttonReset)
                    .addComponent(buttonRiwayat))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(totalHarga)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonKonfirmasi)
                    .addComponent(buttonBatal))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonTambahActionPerformed

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
            java.util.logging.Logger.getLogger(TransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBatal;
    private javax.swing.JButton buttonKonfirmasi;
    private javax.swing.JButton buttonReset;
    private javax.swing.JButton buttonRiwayat;
    private javax.swing.JButton buttonTambah;
    private javax.swing.JComboBox<String> cbBuku;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinnerJumlah;
    private javax.swing.JTable tableTransaksi;
    private javax.swing.JLabel totalHarga;
    // End of variables declaration//GEN-END:variables


    public JButton getButtonBatal() {
        return buttonBatal;
    }


    public JButton getButtonKonfirmasi() {
        return buttonKonfirmasi;
    }

    public JButton getButtonReset() {
        return buttonReset;
    }

    public JButton getButtonTambah() {
        return buttonTambah;
    }

    public JComboBox<String> getCbBuku() {
        return cbBuku;
    }

    public JSpinner getSpinnerJumlah() {
        return spinnerJumlah;
    }

    public JTable getTableTransaksi() {
        return tableTransaksi;
    }

    public JButton getButtonRiwayat() {
        return buttonRiwayat;
    }

    public JLabel getTotalHarga() {
        return totalHarga;
    }
    
    @Override
    public void addListener(ActionListener e) {
        buttonBatal.addActionListener(e);
        buttonTambah.addActionListener(e);
        buttonKonfirmasi.addActionListener(e);
        buttonReset.addActionListener(e);
        buttonRiwayat.addActionListener(e);
    }

    public void addTableRow(Object[] objects){
        DefaultTableModel model = (DefaultTableModel) tableTransaksi.getModel();
        model.addRow(objects);
    }

    public void fillCbBuku(String[] arr){
        for (int i = 0;i<arr.length;i++){
            cbBuku.addItem(arr[i]);
        }
    }
}
