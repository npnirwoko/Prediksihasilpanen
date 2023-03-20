/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Boundry;

import Controller.ProsesManager;
import Entity.Dokumen;
//import java.io.File;
import java.util.ArrayList;
//import javax.swing.JFileChooser;
//import javax.swing.JOptionPane;
//import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class NewJFrame1 extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame1
     */
    public NewJFrame1() {
        initComponents();

    }

    public NewJFrame1(String nama_file) {
        initComponents();
        ProsesManager pm = new ProsesManager();
        Dokumen dkm = new Dokumen();
        ArrayList<ArrayList> data = dkm.load_excel(nama_file);

        //dari file yang telah di upload langsung di kirim ke class proses prediksi pada proses manager
        pm.do_proses_prediksi(data);
        //dikembalikan nilai data dari proses manager ke fungsi button proses untuk ditampilkan pada table
        ArrayList<Double> prediksi = pm.prediksi;
        ArrayList<Double> selisih = pm.selisih;
        ArrayList<Double> mean = pm.mean;
        ArrayList<ArrayList> angka = pm.data_angka;
        DefaultTableModel data_header = new DefaultTableModel(new String[]{
            "Hasil Panen Real Zt",
            "Hasil Prediksi ZT",
            "[ Zt- ZT]",
//            "[ Zt- ZT] / Zt *100",
            "[ Zt- ZT] / Zt ",
        }, 0);
        Table1.setModel(data_header); // set table header
        double pembagian = 12;
        double sum_mean_all = 0;
        for (int i = 0; i < prediksi.size(); i++) {
//            System.out.println(prediksi.size());
//            System.out.println(angka.get(2));
            sum_mean_all += mean.get(i);
            System.out.println("----");
            System.out.println(i);

            data_header.addRow(new Object[]{
                //menampilkan data pada table
                Double.parseDouble(angka.get(i).get(2).toString()),
                prediksi.get(i),
                selisih.get(i),
                mean.get(i)
            });
        }
        
        mean_error_text.setText(String.valueOf(sum_mean_all));
        jLabel2.setText(String.valueOf(pembagian));
        double persen_error = (sum_mean_all /12)*100;
        jLabel3.setText(String.valueOf(persen_error));
        //nilai persen keberhasilan didapat dari 100% - total akhir mean error %
        double persen_total = 100 - persen_error;
        jLabel4.setText(String.valueOf(persen_total));
        
        
        
//        ProsesManager pm = new ProsesManager();
//        Dokumen dkm = new Dokumen();
//        ArrayList<ArrayList> data = dkm.load_excel(nama_file);
//
//        //dari file yang telah di upload langsung di kirim ke class proses prediksi pada proses manager
//        pm.do_proses_prediksi(data);
//        //dikembalikan nilai data dari proses manager ke fungsi button proses untuk ditampilkan pada table
//        ArrayList<Double> prediksi = pm.prediksi;
//        ArrayList<Double> selisih = pm.selisih;
//        ArrayList<Double> mean = pm.mean;
//        ArrayList<ArrayList> angka = pm.data_angka;
//        DefaultTableModel data_header = new DefaultTableModel(new String[]{
//            "Bulan",
//            "Hasil panen",
//            "pemupukan",
//            "Bulan",
//            "Hasil panen",
//            "Prediksi"
//        }, 0);
//        Table1.setModel(data_header); // set table header
//
//        double sum_mean_all = 0;
//        for (int i = 0; i < prediksi.size(); i++) {
////            System.out.println(prediksi.size());
////            System.out.println(angka.get(2));
//            sum_mean_all += mean.get(i);
//            System.out.println("----");
//            System.out.println(i);
//
//            data_header.addRow(new Object[]{
//                //menampilkan data pada table
//                i + 1,
//                Double.parseDouble(angka.get(i).get(0).toString()),
//                Double.parseDouble(angka.get(i).get(1).toString()),
//                i + 2,
//                Double.parseDouble(angka.get(i).get(2).toString()),
//                prediksi.get(i)
//            });
//        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        mean_error_text = new java.awt.TextField();
        jLabel2 = new java.awt.TextField();
        jLabel3 = new java.awt.TextField();
        jLabel4 = new java.awt.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Bulan", "Hasil Panen", "Pemupukan", "Bulan", "Hasil Panen", "Prediksi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table1);

        mean_error_text.setText("textField1");
        mean_error_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mean_error_textActionPerformed(evt);
            }
        });

        jLabel2.setText("textField1");

        jLabel3.setText("textField1");
        jLabel3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLabel3ActionPerformed(evt);
            }
        });

        jLabel4.setText("textField1");
        jLabel4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLabel4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(371, 371, 371)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(mean_error_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mean_error_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new NewJFrame2().setVisible(true);
//        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void mean_error_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mean_error_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mean_error_textActionPerformed

    private void jLabel4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLabel4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4ActionPerformed

    private void jLabel3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLabel3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3ActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table1;
    private javax.swing.JButton jButton1;
    private java.awt.TextField jLabel2;
    private java.awt.TextField jLabel3;
    private java.awt.TextField jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.TextField mean_error_text;
    // End of variables declaration//GEN-END:variables
}
