/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import code.*;

/**
 *
 * @author Sableng
 */
public class TestGUI extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public TestGUI() {
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

        jFileChooser = new javax.swing.JFileChooser();
        jOptionPane = new javax.swing.JOptionPane();
        jButtonBrowse = new javax.swing.JButton();
        jTextFieldPath = new javax.swing.JTextField();
        jPanelPreview = new javax.swing.JPanel();
        jLabelPreview = new javax.swing.JLabel();
        jLabelLearningRate = new javax.swing.JLabel();
        jTextFieldLearningRate = new javax.swing.JTextField();
        jLabelEpoch = new javax.swing.JLabel();
        jSliderEpoch = new javax.swing.JSlider();
        jButtonKenali = new javax.swing.JButton();
        jSeparatorPemisah = new javax.swing.JSeparator();
        jScrollPaneJarak = new javax.swing.JScrollPane();
        jTableJarak = new javax.swing.JTable();
        jLabelKesimpulan = new javax.swing.JLabel();
        jLabelHasil = new javax.swing.JLabel();

        jFileChooser.setDialogTitle("Pilih File Gambar");

        jOptionPane.setName(""); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Digit Recognition LVQ");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(300, 70));
        setResizable(false);

        jButtonBrowse.setText("Browse");
        jButtonBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBrowseActionPerformed(evt);
            }
        });

        jTextFieldPath.setEditable(false);
        jTextFieldPath.setText("Path File");
        jTextFieldPath.setName(""); // NOI18N

        jPanelPreview.setBorder(javax.swing.BorderFactory.createTitledBorder("Preview"));
        jPanelPreview.setToolTipText("");

        javax.swing.GroupLayout jPanelPreviewLayout = new javax.swing.GroupLayout(jPanelPreview);
        jPanelPreview.setLayout(jPanelPreviewLayout);
        jPanelPreviewLayout.setHorizontalGroup(
            jPanelPreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelPreview, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanelPreviewLayout.setVerticalGroup(
            jPanelPreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelPreview, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
        );

        jLabelLearningRate.setText("Ubah Learning Rate");

        jTextFieldLearningRate.setText("0.8");

        jLabelEpoch.setText("Setting Epoch");

        jSliderEpoch.setMajorTickSpacing(50);
        jSliderEpoch.setMaximum(300);
        jSliderEpoch.setMinorTickSpacing(25);
        jSliderEpoch.setPaintLabels(true);
        jSliderEpoch.setPaintTicks(true);

        jButtonKenali.setText("Kenali Angka");
        jButtonKenali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKenaliActionPerformed(evt);
            }
        });

        jTableJarak.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {"Epoch", "Alpha",
                "d0", "d1", "d2", "d3", "d4",
                "d5", "d6", "d7", "d8", "d9",
                "Min(d)"
            }
        ));
        jTableJarak.getTableHeader().setResizingAllowed(false);
        jTableJarak.getTableHeader().setReorderingAllowed(false);
        jScrollPaneJarak.setViewportView(jTableJarak);

        jLabelKesimpulan.setText("PROGRAM MENGENALI GAMBAR SEBAGAI ANGKA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparatorPemisah, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelLearningRate)
                                    .addComponent(jLabelEpoch)
                                    .addComponent(jButtonBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldLearningRate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(74, 74, 74)
                                                .addComponent(jButtonKenali, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jTextFieldPath, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jSliderEpoch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelPreview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabelKesimpulan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelHasil, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPaneJarak)))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelPreview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonBrowse)
                            .addComponent(jTextFieldPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldLearningRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelLearningRate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEpoch)
                            .addComponent(jSliderEpoch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonKenali, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(jSeparatorPemisah, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneJarak, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelKesimpulan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelHasil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBrowseActionPerformed
        //Browse File
        if (jFileChooser.showOpenDialog(this) == jFileChooser.APPROVE_OPTION) {
            jTextFieldPath.setText(jFileChooser.getSelectedFile().getAbsolutePath());
            //preview gambar            
            ImageIcon icon = new ImageIcon(jFileChooser.getSelectedFile().getPath());
            icon.setImage(icon.getImage().getScaledInstance(jLabelPreview.getWidth(), jLabelPreview.getHeight(), 0));
            jLabelPreview.setIcon(icon);
        }
    }//GEN-LAST:event_jButtonBrowseActionPerformed

    private void jButtonKenaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKenaliActionPerformed
        if (jLabelPreview.getIcon() != null) {
            //list objek
            ImageHelper imgHelper = new ImageHelper();
            DigitRecognition awal = null;
            try {
                awal = new DigitRecognition(jFileChooser.getSelectedFile().getAbsolutePath());
            } catch (IOException ex) {
                Logger.getLogger(TestGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            //set file dataUji
            awal.cariBenar();
            LVQ lvq = new LVQ(awal.angkaDataUji);

            lvq.setData(awal.dataUji, awal.dataLatih);
            //set learning rate
            lvq.setLearningRate(Double.parseDouble(jTextFieldLearningRate.getText()));
            //set epoch
            lvq.setEpoch(jSliderEpoch.getValue());

            //update tabel
            DefaultTableModel model_w = new DefaultTableModel(new Object[][]{}, new String[]{
                "Epoch", "Alpha", "d0", "d1", "d2", "d3", "d4",
                "d5", "d6", "d7", "d8", "d9", "Min(d)"});
            jTableJarak.setModel(model_w);
            Object nilaiKolom[] = new Object[jTableJarak.getColumnCount()];
            //sama seperti method lvq.doIterasi();
            lvq.setBobot();
            int iterasi = 1;
            do {
                lvq.menghitungJarak();
                lvq.terdekat();
                lvq.updateBobot();
                lvq.learningRate = 0.98 * lvq.learningRate;
                nilaiKolom[0] = iterasi;
                nilaiKolom[1] = lvq.learningRate;
                nilaiKolom[2] = lvq.jarak[0];
                nilaiKolom[3] = lvq.jarak[1];
                nilaiKolom[4] = lvq.jarak[2];
                nilaiKolom[5] = lvq.jarak[3];
                nilaiKolom[6] = lvq.jarak[4];
                nilaiKolom[7] = lvq.jarak[5];
                nilaiKolom[8] = lvq.jarak[6];
                nilaiKolom[9] = lvq.jarak[7];
                nilaiKolom[10] = lvq.jarak[8];
                nilaiKolom[11] = lvq.jarak[9];
                nilaiKolom[12] = lvq.hasil;
                model_w.addRow(nilaiKolom);
                lvq.epoch--;
                iterasi++;
            } while (lvq.epoch != 0);
//            lvq.menghitungJarak();
//            lvq.terdekat();

            //tampilkan hasil
            jLabelHasil.setText(Integer.toString(lvq.hasil));
        } else {
            jOptionPane.showMessageDialog(null, "Tidak ada gambar terpilih");
        }
    }//GEN-LAST:event_jButtonKenaliActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TestGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TestGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TestGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBrowse;
    private javax.swing.JButton jButtonKenali;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JLabel jLabelEpoch;
    private javax.swing.JLabel jLabelHasil;
    private javax.swing.JLabel jLabelKesimpulan;
    private javax.swing.JLabel jLabelLearningRate;
    private javax.swing.JLabel jLabelPreview;
    private javax.swing.JOptionPane jOptionPane;
    private javax.swing.JPanel jPanelPreview;
    private javax.swing.JScrollPane jScrollPaneJarak;
    private javax.swing.JSeparator jSeparatorPemisah;
    private javax.swing.JSlider jSliderEpoch;
    private javax.swing.JTable jTableJarak;
    private javax.swing.JTextField jTextFieldLearningRate;
    private javax.swing.JTextField jTextFieldPath;
    // End of variables declaration//GEN-END:variables
}