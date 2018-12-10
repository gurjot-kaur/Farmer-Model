/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.WarehouseManagerRole;

import userinterface.FarmerRole.*;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.USFDEnterprise;
import Business.Produce.Produce;
import Business.Organization.FarmerOrganization;
import Business.Organization.Organization;
import Business.Organization.WarehouseOrganization;
import Business.Produce.ProduceDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ProduceRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class WarehouseWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private WarehouseOrganization warehouseOrganization;
    private ProduceDirectory produceDirectory;
    private USFDEnterprise enterprise;
   public static boolean flag = false;
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public WarehouseWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization,Enterprise enterprise, EcoSystem business,ProduceDirectory produceDirectory) {
     initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.enterprise = (USFDEnterprise)enterprise;
        this.warehouseOrganization = (WarehouseOrganization)organization;
        this.produceDirectory = produceDirectory;
        populateTable();
        populateCropTable();
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)workRequestJTable.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request : warehouseOrganization.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[5];
            row[0] = request;
            row[1] = request.getSender().getEmployee().getName();
            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[3] = request.getStatus();
            row[4] = request.getCropQty();
            model.addRow(row);
        }
    }
    
    public void populateCropTable(){
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
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        assignJButton = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        produceTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Sender", "Receiver", "Status", "Crop Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);
        if (workRequestJTable.getColumnModel().getColumnCount() > 0) {
            workRequestJTable.getColumnModel().getColumn(0).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(1).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(2).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(3).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(4).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 217, 726, 122));

        assignJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });
        add(assignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 379, 230, -1));

        processJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(706, 379, 170, -1));

        produceTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        produceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Crop Name", "Quantity", "Price", "Farmer", "Raw Material"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(produceTable);
        if (produceTable.getColumnModel().getColumnCount() > 0) {
            produceTable.getColumnModel().getColumn(0).setResizable(false);
            produceTable.getColumnModel().getColumn(1).setResizable(false);
            produceTable.getColumnModel().getColumn(2).setResizable(false);
            produceTable.getColumnModel().getColumn(3).setResizable(false);
        }

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 558, 726, 170));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/City-Warehouse-icon.png"))); // NOI18N
        jLabel1.setText("Warehouse Manager");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 27, 390, 85));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/crop-icon (1).png"))); // NOI18N
        jLabel2.setText("Produce Request");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 178, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/crop-icon (1).png"))); // NOI18N
        jLabel3.setText("Produce Inventory");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 519, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null,"Please select a row before proceeding");
        }
        
            String cropName = workRequestJTable.getModel().getValueAt(selectedRow, 0).toString();
            int cropQty = Integer.parseInt((String.valueOf(workRequestJTable.getModel().getValueAt(selectedRow, 4))));

            int i =0;
            int cropQntyProduce = 0;
            String tempName = null;
            for(int j = 0; j <produceTable.getRowCount(); j++)
            {
             tempName = produceTable.getModel().getValueAt(j, i).toString();
             //System.out.println(tempName);
                if(tempName.equals(cropName)){
                i++;
               
                cropQntyProduce = Integer.parseInt((String.valueOf(produceTable.getModel().getValueAt(j, i))));
                break;
                }
            }
            
            if (cropQntyProduce == 0)
        {
            JOptionPane.showMessageDialog(null,"Cannot assign this job, please go farmer");
            flag = true;
            processJButton.setEnabled(false);
        }
            else{
            
            if (tempName.equals(cropName))
            {
                if (cropQty <= cropQntyProduce)
                    {
                        WorkRequest request = (WorkRequest)workRequestJTable.getValueAt(selectedRow, 0);
                        request.setReceiver(userAccount);
                        request.setStatus("Pending");
            
                        for(Produce produce : produceDirectory.getProduceList()){
                            if (tempName.equals((String)produce.getCropName()))
                            {
                                produce.setCropQuantity(cropQntyProduce - cropQty);
                                request.setCropQty(0);
                            }
                            populateCropTable();
                            populateTable();
                        }  
 
                    }
                else if (cropQty > cropQntyProduce)
                {
                    WorkRequest request = (WorkRequest)workRequestJTable.getValueAt(selectedRow, 0);
                    request.setReceiver(userAccount);
                    request.setStatus("Pending");
                    request.setCropQty(cropQty - cropQntyProduce);
                    
                    for(Produce produce : produceDirectory.getProduceList()){
                    if (tempName.equals((String)produce.getCropName()) || (!tempName.equals((String)produce.getCropName())))
                    {
                        produce.setCropQuantity(0);
                        request.setCropQty(cropQty - cropQntyProduce);
                        flag = true;
                    }
                    
                    populateCropTable();
                    populateTable();
                    }  
                }
            
            }
            }
       
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed
        
        int selectedRow = workRequestJTable.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null,"Please select a row before proceeding");
        }
        
        ProduceRequest request = (ProduceRequest)workRequestJTable.getValueAt(selectedRow, 0);
     
        request.setStatus("Processing");
        
        ProcessRequestJPanel processWorkRequestJPanel = new ProcessRequestJPanel(userProcessContainer, request);
        userProcessContainer.add("ProcessProduceJPanel", processWorkRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_processJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton processJButton;
    private javax.swing.JTable produceTable;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
