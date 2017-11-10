
import java.awt.Dimension;
import java.awt.Toolkit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sever
 */
public class detailsDialog extends javax.swing.JDialog {

    /**
     * Creates new form dialogDetails
     */
    
    public int alarmID;
    
    public detailsDialog(java.awt.Frame parent, boolean modal, int anID) {
        super(parent, modal);
        initComponents();
        alarmID = anID;
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int iWidth = (screenSize.width - this.getWidth()) / 2;
        int iHeight = (screenSize.height - this.getHeight()) / 2;
        setLocation(iWidth, iHeight);
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetails = new javax.swing.JTextArea();
        btnAPPLY = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnACK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alarm details");
        setModal(true);
        setResizable(false);

        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtDetails.setColumns(20);
        txtDetails.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDetails.setRows(5);
        jScrollPane1.setViewportView(txtDetails);

        btnAPPLY.setText("Apply changes");
        btnAPPLY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAPPLYActionPerformed(evt);
            }
        });

        jButton2.setText("Open TT");

        btnACK.setText("ACK");
        btnACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnACKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAPPLY, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnACK, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAPPLY)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(btnACK))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnAPPLYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAPPLYActionPerformed
       
        String s = txtDetails.getText();
        echipament e = (echipament) mainWindow.model.lista.get(alarmID);
        e.setDetails(s);
        mainWindow.database.runUpdate("update netscan set details='"+s+"' where deviceName='"+e.getName()+"';");
        mainWindow.model.fireTableDataChanged();
        
    }//GEN-LAST:event_btnAPPLYActionPerformed

    private void btnACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnACKActionPerformed
       
        echipament e = (echipament) mainWindow.model.lista.get(alarmID);
        e.setMonitor("sever.constantin");
        mainWindow.database.runUpdate("update netscan set monitor='"+e.getMonitor()+"' where deviceName='"+e.getName()+"';");
        mainWindow.model.fireTableDataChanged();
    }//GEN-LAST:event_btnACKActionPerformed

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
            java.util.logging.Logger.getLogger(detailsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(detailsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(detailsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(detailsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
    }

    public String getTxtDetails() {
        return txtDetails.getText();
    }

    public void setTxtDetails(String txtDetails) {
        this.txtDetails.setText(txtDetails);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnACK;
    private javax.swing.JButton btnAPPLY;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDetails;
    // End of variables declaration//GEN-END:variables
}
