package robo.gui;

import java.awt.BorderLayout;
import javax.swing.JTextField;

/*
 * RoboGUI Main Panel
 */

/**
 *
 * @author john
 */
public class Main_Panel extends javax.swing.JPanel {

    private String name;
    /**
     * Creates new form Main_Panel
     */
    public Main_Panel() {
        initComponents();
    }

    Main_Panel(BorderLayout borderLayout) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    Main_Panel(String netName)  {
        initComponents();
        PRINTER_DETAILS.setText(netName);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        PRINTER_DETAILS = new javax.swing.JTextField();

        jButton1.setText("Quit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        PRINTER_DETAILS.setEditable(false);
        PRINTER_DETAILS.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        PRINTER_DETAILS.setForeground(new java.awt.Color(255, 0, 51));
        PRINTER_DETAILS.setBorder(null);
        PRINTER_DETAILS.setFocusable(false);
        PRINTER_DETAILS.setName(""); // NOI18N
        PRINTER_DETAILS.setOpaque(false);
        PRINTER_DETAILS.setRequestFocusEnabled(false);
        PRINTER_DETAILS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRINTER_DETAILSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(PRINTER_DETAILS, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(PRINTER_DETAILS, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        RoboGui.SaveProperties();
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void PRINTER_DETAILSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRINTER_DETAILSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PRINTER_DETAILSActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PRINTER_DETAILS;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
