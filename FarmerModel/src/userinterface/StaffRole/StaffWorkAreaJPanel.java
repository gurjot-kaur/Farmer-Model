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
import Business.Produce.Produce;
import Business.Produce.ProduceDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import sun.applet.AppletViewer;
import static userinterface.WarehouseManagerRole.WarehouseWorkAreaJPanel.flag;

/**
 *
 * @author raunak
 */
public class StaffWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private StaffOrganization organization;
    private USFDEnterprise enterprise;
    private UserAccount userAccount;
    private ProduceDirectory produceDirectory;
    

    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    private EcoSystem business;
    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    public StaffWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, StaffOrganization organization, Enterprise enterprise,EcoSystem business,ProduceDirectory produceDirectory ) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = (USFDEnterprise)enterprise;
        this.userAccount = account;
        this.business = business;
        this.produceDirectory = produceDirectory;
        valueLabel.setText(enterprise.getName());
        populateCustomerRequestTable();
        populateProduceTable();
        
        
        if (flag == true)
        {  
            sendToFarmerJButton.setEnabled(true);
            sendToWarehouseJButton.setEnabled(false);
        }
        
    }

    public void populateCustomerRequestTable(){
     DefaultTableModel model = (DefaultTableModel)workRequestJTable1.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[6];
            row[0] = request;
            row[1] = request.getSender().getEmployee().getName();
            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[3] = request.getStatus();
            row[4] = request.getCropQty();
            row[5] = request.getRawMaterialQty();
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
        jScrollPane3 = new javax.swing.JScrollPane();
        produceTable = new javax.swing.JTable();

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
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Receiver", "Status", "Crop Quantity", "Raw Material Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        workRequestJTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                workRequestJTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(workRequestJTable1);
        if (workRequestJTable1.getColumnModel().getColumnCount() > 0) {
            workRequestJTable1.getColumnModel().getColumn(0).setResizable(false);
            workRequestJTable1.getColumnModel().getColumn(1).setResizable(false);
            workRequestJTable1.getColumnModel().getColumn(2).setResizable(false);
            workRequestJTable1.getColumnModel().getColumn(3).setResizable(false);
            workRequestJTable1.getColumnModel().getColumn(4).setResizable(false);
            workRequestJTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 780, 96));

        jLabel1.setText("Customer Request");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 94, -1, -1));

        sendToFarmerJButton.setText("Send to Farmer");
        sendToFarmerJButton.setEnabled(false);
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
        add(sendToSupp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 150, 40));

        produceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Crop Name", "Quantity", "Price", "Farmer"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(produceTable);
        if (produceTable.getColumnModel().getColumnCount() > 0) {
            produceTable.getColumnModel().getColumn(0).setResizable(false);
            produceTable.getColumnModel().getColumn(1).setResizable(false);
            produceTable.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, -1, 170));
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
        
        
         sendToWarehouseJButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                    JButton source = (JButton) e.getSource();
                    source.setEnabled(false);
                    source.setBackground(Color.GREEN);
            }
    });
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

    private void workRequestJTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_workRequestJTable1MouseClicked
       disableWarehouseButton();
    }//GEN-LAST:event_workRequestJTable1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable produceTable;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JButton sendToFarmerJButton;
    private javax.swing.JButton sendToSupp;
    private javax.swing.JButton sendToWarehouseJButton;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JTable workRequestJTable1;
    // End of variables declaration//GEN-END:variables

    private void populateProduceTable() {
        DefaultTableModel model = (DefaultTableModel)produceTable.getModel();
        
        model.setRowCount(0);
        
        for(Produce produce : produceDirectory.getProduceList()){
            Object[] row = new Object[4];
            row[0] = produce;
            row[1] = produce.getCropQuantity();
            row[2] = produce.getCropPrice();
            //row[3] = userAccount.getUsername();
            row[3] = produce.getFarmerName();
            model.addRow(row);
            
        }
        checkforProduce();
    }
    
             

    private void checkforProduce() {
        
        int i = 1;
        
        for (int j = 0; j < produceTable.getRowCount(); j++) {
           int tempQuantity = Integer.parseInt((String.valueOf(produceTable.getModel().getValueAt(j, i)))) ;
            if(tempQuantity == 0){
                  int delay = 4000; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                JOptionPane.showMessageDialog(null,"Send produce request for" + "to farmer");
      }
  };
                Timer myTimer = new Timer(delay, taskPerformer);
                myTimer.setRepeats(false);
                myTimer.start();
                //JOptionPane.showMessageDialog(null,"Send produce request to farmer");
            }
        }
    }

    private void disableWarehouseButton() {
        int selectedRow = workRequestJTable1.getSelectedRow();
        String requestedCrop = workRequestJTable1.getModel().getValueAt(selectedRow, 0).toString();
        int i = 0;
        String tempName = null;
        for(int j = 0;j < produceTable.getRowCount(); j++) {
            tempName = produceTable.getModel().getValueAt(j, i).toString();
             //System.out.println(tempName);
                if(!(tempName.equals(requestedCrop))){
               continue; 
                }
                else {sendToWarehouseJButton.setEnabled(true);}
        }
        }
    
    
}
