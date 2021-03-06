/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.WarehouseManagerRole;


import Business.WorkQueue.ProduceRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class ProcessRequestJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    ProduceRequest request;
    /**
     * Creates new form ProcessWorkRequestJPanel
     */
    public ProcessRequestJPanel(JPanel userProcessContainer, ProduceRequest request) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        populateResultCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        submitJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        resultCombo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        submitJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        submitJButton.setText("Submit Result");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        add(submitJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 430, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Produce Result");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 361, 176, -1));

        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back-icon (2).png"))); // NOI18N
        backJButton.setText("Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 728, -1, -1));

        resultCombo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(resultCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 358, 248, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/crop-icon.png"))); // NOI18N
        jLabel2.setText("Produce Request Result");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 57, 375, 86));
    }// </editor-fold>//GEN-END:initComponents
    
    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        WarehouseWorkAreaJPanel wwjp = (WarehouseWorkAreaJPanel) component;
        wwjp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        //request.setTestResult(resultJTextField.getText());
        //request.setStatus("Completed");
        String status = (String) resultCombo.getSelectedItem();

        request.setStatus(status);
    }//GEN-LAST:event_submitJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox resultCombo;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables

    private void populateResultCombo() {
        resultCombo.addItem("Completed");
           }
}
