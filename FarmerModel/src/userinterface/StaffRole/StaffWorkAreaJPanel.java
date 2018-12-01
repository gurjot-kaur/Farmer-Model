/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.StaffRole;

import userinterface.CustomerRole.*;
import Business.EcoSystem;
import Business.Enterprise.*;
import Business.Enterprise.USFDEnterprise;
import Business.Network.Network;
import Business.Organization.*;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.*;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import sun.applet.AppletViewer;

/**
 *
 * @author raunak
 */
public class StaffWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private StaffOrganization organization;
    private USFDEnterprise enterprise;
    private UserAccount userAccount;

    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    private EcoSystem business;
    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    public StaffWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, StaffOrganization organization, Enterprise enterprise,EcoSystem business) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = (USFDEnterprise)enterprise;
        this.userAccount = account;
        this.business = business;
        valueLabel.setText(enterprise.getName());
        populateCustomerRequestTable();
      
        
    }


    public void populateCustomerRequestTable(){
     DefaultTableModel model = (DefaultTableModel)workRequestJTable1.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[4];
            row[0] = request;
            row[1] = request.getSender().getEmployee().getName();
            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[3] = request.getStatus();
            
            model.addRow(row);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        refreshJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        workRequestJTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        sendToFarmerJButton = new javax.swing.JButton();
        sendToWarehouseJButton = new javax.swing.JButton();
        sendToSupp = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 27, 127, 30));

        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 27, 158, 26));

        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 90, -1, -1));

        workRequestJTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Receiver", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(workRequestJTable1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 133, 375, 96));

        jLabel1.setText("Customer Request");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 94, -1, -1));

        sendToFarmerJButton.setText("Send to Farmer");
        sendToFarmerJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendToFarmerJButtonActionPerformed(evt);
            }
        });
        add(sendToFarmerJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 247, -1, -1));

        sendToWarehouseJButton.setText("Send to Warehouse Manager");
        sendToWarehouseJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendToWarehouseJButtonActionPerformed(evt);
            }
        });
        add(sendToWarehouseJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 247, -1, -1));

        sendToSupp.setText("Send to Supplier");
        sendToSupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendToSuppActionPerformed(evt);
            }
        });
        add(sendToSupp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 110, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateCustomerRequestTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void sendToFarmerJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToFarmerJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable1.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        ProduceRequest request = (ProduceRequest)workRequestJTable1.getValueAt(selectedRow, 0);
        request.setStatus("sent to farmer ");
        populateCustomerRequestTable();
        userAccount.getWorkQueue().getWorkRequestList().add(request);
        
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof FarmerOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
        }
        
    }//GEN-LAST:event_sendToFarmerJButtonActionPerformed

    private void sendToWarehouseJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToWarehouseJButtonActionPerformed
        // TODO add your handling code here:
      int selectedRow = workRequestJTable1.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        ProduceRequest request = (ProduceRequest)workRequestJTable1.getValueAt(selectedRow, 0);
        request.setStatus("sent to warehouse");
        populateCustomerRequestTable();
        userAccount.getWorkQueue().getWorkRequestList().add(request);
        
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof WarehouseOrganization){
                org = organization;
                break;
            }
            else if (organization instanceof WarehouseOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
        }
    }//GEN-LAST:event_sendToWarehouseJButtonActionPerformed

    private void sendToSupplierJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToSupplierJButtonActionPerformed
        int selectedRow = workRequestJTable1.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        ProduceRequest request = (ProduceRequest)workRequestJTable1.getValueAt(selectedRow, 0);
        request.setStatus("sent to Manufacturer.Supplier ");
        populateCustomerRequestTable();
        userAccount.getWorkQueue().getWorkRequestList().add(request);
        
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof ManufacturerSupplierOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
        }
        
    }//GEN-LAST:event_sendToSupplierJButtonActionPerformed

    private void sendToSuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToSuppActionPerformed
         int selectedRow = workRequestJTable1.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        ProduceRequest request = (ProduceRequest)workRequestJTable1.getValueAt(selectedRow, 0);
        request.setStatus("sent to supplier ");
        populateCustomerRequestTable();
        userAccount.getWorkQueue().getWorkRequestList().add(request);
        
        Organization org = null;
        for (Network network: business.getNetworkList()){
               
            for (Enterprise e: network.getEnterpriseDirectory().getEnterpriseList())
            {   
                
                if (e instanceof ManufacturerEnterprise)
                {
                   for (Organization organization : e.getOrganizationDirectory().getOrganizationList()){
            
            if (organization instanceof ManufacturerSupplierOrganization){
                org = organization;
                System.out.println(org);
                break;
            }
        }
            if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
            } 
                }
                
            }
        }
        
    }//GEN-LAST:event_sendToSuppActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JButton sendToFarmerJButton;
    private javax.swing.JButton sendToSupp;
    private javax.swing.JButton sendToWarehouseJButton;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JTable workRequestJTable1;
    // End of variables declaration//GEN-END:variables
}
