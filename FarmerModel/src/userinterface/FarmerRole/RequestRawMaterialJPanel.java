/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.FarmerRole;

import userinterface.CustomerRole.*;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.FarmerOrganization;
import Business.Organization.Organization;
import Business.Organization.StaffOrganization;
import Business.Produce.Produce;
import Business.Produce.ProduceDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ProduceRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class RequestRawMaterialJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
     private ProduceDirectory produceDirectory;
    
    /**
     * Creates new form RequestLabTestJPanel
     */
    public RequestRawMaterialJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise,ProduceDirectory produceDirectory) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.produceDirectory = produceDirectory;
        valueLabel.setText(enterprise.getName());
        //populateCropCombo();
        populateRMCombo();


       
                }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        requestTestJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        messageJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        valueLabel = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();
        rmCoboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        requestTestJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        requestTestJButton.setText("Submit");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Raw Material");

        messageJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        messageJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageJTextFieldActionPerformed(evt);
            }
        });
        messageJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                messageJTextFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                messageJTextFieldKeyTyped(evt);
            }
        });

        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back-icon (2).png"))); // NOI18N
        backJButton.setText("Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        valueLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("Enterprise :");

        rmCoboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rmCoboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmCoboBoxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Request Raw Material");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Quantity");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(269, 269, 269)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(289, 289, 289)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rmCoboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(messageJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(186, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(requestTestJButton)
                .addGap(374, 374, 374))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(rmCoboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(messageJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addComponent(requestTestJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 293, Short.MAX_VALUE)
                .addComponent(backJButton))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed
        
        //String message = messageJTextField.getText();
        //int materialQuantity = Integer.parseInt(messageJTextField.getText());
        
        String message = (String) rmCoboBox.getSelectedItem();
        //String rawMaterial = (String) cropCombo.getSelectedItem();
        /*if(rawMaterial.equalsIgnoreCase("rice") && message.equalsIgnoreCase("food scraps")){
            JOptionPane.showMessageDialog(null,"Not a suitable raw material for rice");
           
        } */
        if (messageJTextField.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please mention the quantity before proceeding");
        }
        else
        {
        ProduceRequest request = new ProduceRequest();
        request.setMessage(message);
        request.setSender(userAccount);
        request.setStatus("Sent");
        request.setRawMaterialQty(Integer.parseInt(messageJTextField.getText()));

        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof StaffOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
            userAccount.getWorkQueue().getWorkRequestList().add(request);
        }
        JOptionPane.showMessageDialog(null, "Request done successfully");
        }
    }//GEN-LAST:event_requestTestJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        FarmerWorkAreaJPanel cwjp = (FarmerWorkAreaJPanel) component;
        cwjp.populateRequestRMTable();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_backJButtonActionPerformed

    private void rmCoboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmCoboBoxActionPerformed
        
    }//GEN-LAST:event_rmCoboBoxActionPerformed

    private void messageJTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_messageJTextFieldKeyPressed
         
    }//GEN-LAST:event_messageJTextFieldKeyPressed

    private void messageJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_messageJTextFieldActionPerformed

    private void messageJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_messageJTextFieldKeyTyped
        char vchar = evt.getKeyChar();
        if(!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACK_SPACE) || (vchar == KeyEvent.VK_DELETE)){
        getToolkit().beep();
        evt.consume();
    } 
    }//GEN-LAST:event_messageJTextFieldKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField messageJTextField;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JComboBox rmCoboBox;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables

    private void populateCropCombo() {
       
        /*for(Produce produce: produceDirectory.getProduceList())
        {   
            if (produce.getCropName().isEmpty())
            {
                break;
            }
            else
            {
            Object row[] = new Object[2];
            row[0]= produce.getCropName();

            cropCombo.addItem(row[0]);  
            }
        }
          */  
    }

    private void populateRMCombo() {
        
       
        
            rmCoboBox.addItem("biosolids");
            rmCoboBox.addItem("manures");
            rmCoboBox.addItem("organic fertilizers");
            rmCoboBox.addItem("worm tea");
            rmCoboBox.addItem("vermicompost");
        
        //populateRMCombo();
    }

   
}
