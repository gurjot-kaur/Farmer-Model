/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ProducerRole;

import userinterface.*;
import userinterface.SupplierRole.*;
import userinterface.StaffRole.*;
import userinterface.CustomerRole.*;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ManufacturerEnterprise;
import Business.Organization.*;
import Business.RawMaterial.RawMaterial;
import Business.RawMaterial.RawMaterialDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.*;
import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class ManufacturerProducerJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private ManufacturerProductionOrganization organization;
    private ManufacturerEnterprise enterprise;
    private UserAccount userAccount;
    private RawMaterialDirectory rmDirectory;
           
    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    private EcoSystem business;
    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    public ManufacturerProducerJPanel(JPanel userProcessContainer, UserAccount account, ManufacturerProductionOrganization organization, Enterprise enterprise,EcoSystem business, RawMaterialDirectory rmDirectory) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = (ManufacturerEnterprise)enterprise;
        this.userAccount = account;
        this.business = business;
        this.rmDirectory = rmDirectory;
        valueLabel.setText(enterprise.getName());
        populateSuppRequestTable();
        populateRMTable();
        
    }


    public void populateSuppRequestTable(){
    DefaultTableModel model = (DefaultTableModel)workRequestRMJTable.getModel();
        
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
        jScrollPane2 = new javax.swing.JScrollPane();
        workRequestRMJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        processJButton = new javax.swing.JButton();
        assignJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        rmNameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        quantityTextField = new javax.swing.JTextField();
        addCropButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        rmJTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("Enterprise :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 127, 30));

        valueLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 80, 158, 26));

        workRequestRMJTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        workRequestRMJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        jScrollPane2.setViewportView(workRequestRMJTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 195, 637, 96));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Plants-Hand-Planting-icon (2).png"))); // NOI18N
        jLabel1.setText("Raw Material Requests");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 150, -1, -1));

        processJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(681, 324, 150, -1));

        assignJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });
        add(assignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 324, 150, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Plants-Hand-Planting-icon (2).png"))); // NOI18N
        jLabel2.setText("Raw Material");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 650, -1, -1));

        rmNameTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(rmNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 652, 200, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/price-comparison-icon.png"))); // NOI18N
        jLabel3.setText("Quantity");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 718, 136, -1));

        quantityTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        quantityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityTextFieldActionPerformed(evt);
            }
        });
        quantityTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quantityTextFieldKeyTyped(evt);
            }
        });
        add(quantityTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 720, 200, -1));

        addCropButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addCropButton.setText("Add raw material");
        addCropButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCropButtonActionPerformed(evt);
            }
        });
        add(addCropButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 779, -1, -1));

        rmJTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rmJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Raw Material", "Quantity", "Producer"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(rmJTable);
        if (rmJTable.getColumnModel().getColumnCount() > 0) {
            rmJTable.getColumnModel().getColumn(0).setResizable(false);
            rmJTable.getColumnModel().getColumn(1).setResizable(false);
            rmJTable.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 487, 637, 130));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/producer.png"))); // NOI18N
        jLabel4.setText("Producer");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 13, 289, 60));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Plants-Hand-Planting-icon (2).png"))); // NOI18N
        jLabel5.setText("Raw Material Produced");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 448, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void sendToSupplierJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToSupplierJButtonActionPerformed
        int selectedRow = workRequestRMJTable.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        ProduceRequest request = (ProduceRequest)workRequestRMJTable.getValueAt(selectedRow, 0);
        request.setStatus("sent to Manufacturer.Supplier ");
        populateSuppRequestTable();
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

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed

        int selectedRow = workRequestRMJTable.getSelectedRow();

        if (selectedRow < 0){
            return;
        }

        ProduceRequest request = (ProduceRequest)workRequestRMJTable.getValueAt(selectedRow, 0);

        request.setStatus("Processing");

        ProcessProduceRequestRMJPanel processWorkRequestJPanel = new ProcessProduceRequestRMJPanel(userProcessContainer, request);
        userProcessContainer.add("ProcessProduceRequestRMJPanel", processWorkRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_processJButtonActionPerformed

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

        int selectedRow = workRequestRMJTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null,"Please select a row before proceeding");
        }

        WorkRequest request = (WorkRequest)workRequestRMJTable.getValueAt(selectedRow, 0);
        request.setReceiver(userAccount);
        request.setStatus("Pending");
        populateSuppRequestTable();

    }//GEN-LAST:event_assignJButtonActionPerformed

    private void addCropButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCropButtonActionPerformed
        // TODO add your handling code here:
        /*try
        {
            if(rmNameTextField.getText().equals("") || quantityTextField.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Please fill all the details");
            else if (checkIfRMExists(rmNameTextField.getText()))
            {
                RawMaterial rm =  rmDirectory.addRM();
                rm.setMaterialName(rmNameTextField.getText());
                rm.setMaterialQuantity(Integer.parseInt(quantityTextField.getText()));
                rm.setProducerName(userAccount.getUsername());
                populateRMTable();
            }
            else {JOptionPane.showMessageDialog(null,"Material already added to the list");}

        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,"Please enter a number in Quantity");
        }*/
        try 
        {
        if(rmNameTextField.getText().equals("") || quantityTextField.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Please fill all the details");
         else if (checkIfRMExists(rmNameTextField.getText()))
        {
            RawMaterial rm =  rmDirectory.addRM();
            rm.setMaterialName(rmNameTextField.getText());
            rm.setMaterialQuantity(Integer.parseInt(quantityTextField.getText()));
           
            rm.setProducerName(userAccount.getUsername());
            populateRMTable();
        }
        else {
             String tempName = null;   
             int cropQty = Integer.parseInt(quantityTextField.getText());
             int i = 0;
             String cropName = rmNameTextField.getText();
             for(int j = 0; j <rmJTable.getRowCount(); j++){
             tempName = rmJTable.getModel().getValueAt(j, i).toString();
             
             if(tempName.equalsIgnoreCase(cropName)){
                i++;
               
                cropQty = Integer.parseInt((String.valueOf(rmJTable.getModel().getValueAt(j, i)))) + cropQty;
                 //System.out.println("New qunty" +cropQty);
                
                for (RawMaterial rm : rmDirectory.getRawMaterial())
                {
                    if (rm.getMaterialName().equalsIgnoreCase(cropName))
                     rm.setMaterialQuantity(cropQty);
                }
                break;
            }
        }
             populateRMTable();
            }
        }
        catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null,"Please enter a number in Quantity  and price");
            }
        quantityTextField.setText("");
        rmNameTextField.setText("");
    }//GEN-LAST:event_addCropButtonActionPerformed

    private void quantityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTextFieldActionPerformed
         
    }//GEN-LAST:event_quantityTextFieldActionPerformed

    private void quantityTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityTextFieldKeyTyped
        char vchar = evt.getKeyChar();
        if(!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACK_SPACE) || (vchar == KeyEvent.VK_DELETE)){
        getToolkit().beep();
        evt.consume();
        }
    }//GEN-LAST:event_quantityTextFieldKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCropButton;
    private javax.swing.JButton assignJButton;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton processJButton;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JTable rmJTable;
    private javax.swing.JTextField rmNameTextField;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JTable workRequestRMJTable;
    // End of variables declaration//GEN-END:variables

    private boolean checkIfRMExists(String text) {
        boolean flag = true;
        for (RawMaterial rm: rmDirectory.getRawMaterial()){
            String temp = rm.getMaterialName();
            if(temp == null)
            {   
                break;
            }
            else if (temp.equalsIgnoreCase(text))
            {
                flag = false;
                break;
            }
                else
                flag = true;
        } 
        
        return flag;
    }

    private void populateRMTable() {
         DefaultTableModel model = (DefaultTableModel)rmJTable.getModel();
        
        model.setRowCount(0);
        
        for(RawMaterial rm : rmDirectory.getRawMaterial()){
            Object[] row = new Object[4];
            row[0] = rm;
            row[1] = rm.getMaterialQuantity();
            row[2] = rm.getProducerName();
            //row[3] = userAccount.getUsername();
            
            model.addRow(row);
        }
    }
}
