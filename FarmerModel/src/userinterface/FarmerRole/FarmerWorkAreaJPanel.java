/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.FarmerRole;

import Business.EcoSystem;

import Business.Enterprise.Enterprise;
import Business.Enterprise.USFDEnterprise;
import Business.Produce.Produce;
import Business.Organization.FarmerOrganization;
import Business.Organization.Organization;
import Business.Organization.StaffOrganization;
import Business.Produce.ProduceDirectory;
import Business.RawMaterial.*;
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
public class FarmerWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private FarmerOrganization farmerOrganization;
    private USFDEnterprise enterprise;
    private ProduceDirectory produceDirectory;
    private RawMaterialDirectory rmDirectory;
           
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */

    public FarmerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization,Enterprise enterprise ,EcoSystem business,ProduceDirectory produceDirectory, RawMaterialDirectory rmDirectory) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.farmerOrganization = (FarmerOrganization)organization;
        this.enterprise = (USFDEnterprise)enterprise;
        this.produceDirectory = produceDirectory;
        this.rmDirectory = rmDirectory;
        System.out.println("farmer panel produce directory"+ produceDirectory);
        populateTable();
        populateRequestRMTable();
        populateCropTable();
        populatermCombo();
        
        if(requestRMjTable.getRowCount()==0)
        {
            populateInventoryRM();
        }
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)workRequestJTable.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request : farmerOrganization.getWorkQueue().getWorkRequestList()){
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

        void populateRequestRMTable() {
        DefaultTableModel model = (DefaultTableModel) requestRMjTable.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[5];
            row[0] = request.getMessage();
            row[1] = request.getSender();
            row[2] = request.getReceiver();
            String result = ((ProduceRequest) request).getTestResult();
            row[3] = result == null ? "Waiting" : result;
            row[4] = request.getRawMaterialQty();
            
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
        refreshJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        produceTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cropNameTextField = new javax.swing.JTextField();
        quantityTextField = new javax.swing.JTextField();
        priceTextField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        requestRMjTable = new javax.swing.JTable();
        requestTestJButton = new javax.swing.JButton();
        weatherButton = new javax.swing.JButton();
        addCropButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        inventoryRMTable = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 58, 440, 96));

        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });
        add(assignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 215, -1, -1));

        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 215, -1, -1));

        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 26, -1, -1));

        produceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Crop Name", "Quantity", "Price", "Farmer"
            }
        ));
        jScrollPane2.setViewportView(produceTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, -1, 170));

        jLabel1.setText("Crop Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 570, -1, -1));

        jLabel2.setText("Quantity");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 620, -1, -1));

        jLabel3.setText("Price");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 670, -1, -1));
        add(cropNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 570, 200, -1));
        add(quantityTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 620, 200, -1));
        add(priceTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 670, 200, -1));

        requestRMjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Sender", "Receiver", "Status", "Raw material Qty"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(requestRMjTable);
        if (requestRMjTable.getColumnModel().getColumnCount() > 0) {
            requestRMjTable.getColumnModel().getColumn(0).setResizable(false);
            requestRMjTable.getColumnModel().getColumn(1).setResizable(false);
            requestRMjTable.getColumnModel().getColumn(2).setResizable(false);
            requestRMjTable.getColumnModel().getColumn(3).setResizable(false);
            requestRMjTable.getColumnModel().getColumn(4).setResizable(false);
        }

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 620, 90));

        requestTestJButton.setText("Request Raw Material");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });
        add(requestTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 360, -1, -1));

        weatherButton.setText("Weather Information");
        weatherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weatherButtonActionPerformed(evt);
            }
        });
        add(weatherButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, -1, -1));

        addCropButton.setText("Add Crop");
        addCropButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCropButtonActionPerformed(evt);
            }
        });
        add(addCropButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 560, -1, -1));

        inventoryRMTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Raw Material", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(inventoryRMTable);
        if (inventoryRMTable.getColumnModel().getColumnCount() > 0) {
            inventoryRMTable.getColumnModel().getColumn(0).setResizable(false);
            inventoryRMTable.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, 420, 130));
    }// </editor-fold>//GEN-END:initComponents
    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();
       // String selectedRM = (String)rmComboBox.getSelectedItem();

        if (selectedRow < 0){
            return;
        }
        
        
        /*int i =0;
        for(int j=0; j<requestRMjTable.getRowCount();j++){
            String valueRMTable = requestRMjTable.getModel().getValueAt(j, i).toString();
            if(!(selectedRM.equalsIgnoreCase(valueRMTable))){
                continue;
            }                         
            else {
                
                break;
                
            }

        }

        JOptionPane.showMessageDialog(null, "can not assign, request for raw material");
  */
        WorkRequest request = (WorkRequest)workRequestJTable.getValueAt(selectedRow, 0);
        request.setReceiver(userAccount);
        request.setStatus("Pending");
        String cropName = workRequestJTable.getModel().getValueAt(selectedRow, 0).toString();
        int cropQty = Integer.parseInt((String.valueOf(workRequestJTable.getModel().getValueAt(selectedRow, 4))));
        populateTable();
        if(cropName.equalsIgnoreCase("rice")) if(cropName.equalsIgnoreCase("tomato")){
            JOptionPane.showMessageDialog(null, "The amount of pesticides required for rice of quality pest A is" + (cropQty*2) + 
                    "The amount of pesticides required for rice of quality pest B is" + (cropQty/2)+ "The amount of pesticides required for rice of quality pest A is" +(cropQty*1.5));
        }
        
        
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed
        
        int selectedRow = workRequestJTable.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        ProduceRequest request = (ProduceRequest)workRequestJTable.getValueAt(selectedRow, 0);
     
        request.setStatus("Processing");
        
        ProcessProduceRequestJPanel processWorkRequestJPanel = new ProcessProduceRequestJPanel(userProcessContainer, request);
        userProcessContainer.add("ProcessProduceJPanel", processWorkRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_processJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("RequestProduceJPanel", new RequestRawMaterialJPanel(userProcessContainer, userAccount, enterprise,produceDirectory));
        layout.next(userProcessContainer);

    }//GEN-LAST:event_requestTestJButtonActionPerformed

    private void weatherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weatherButtonActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("WeatherInformationJPanel", new WeatherInformationJPanel (userProcessContainer));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_weatherButtonActionPerformed

    private void addCropButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCropButtonActionPerformed
        // TODO add your handling code here:
        try 
        {
        if(cropNameTextField.getText().equals("") || quantityTextField.getText().equals("") || priceTextField.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Please fill all the details");
         else if (checkIfCropExists(cropNameTextField.getText()))
        {
            Produce produce =  produceDirectory.addProduce();
            produce.setCropName(cropNameTextField.getText());
            produce.setCropPrice(Double.parseDouble(priceTextField.getText()));
            produce.setCropQuantity(Integer.parseInt(quantityTextField.getText()));
            produce.setFarmerName(userAccount.getUsername());
            populateCropTable();
        }
        else {
             String tempName = null;   
             int cropQty = Integer.parseInt(quantityTextField.getText());
             int i = 0;
             String cropName = cropNameTextField.getText();
             for(int j = 0; j <produceTable.getRowCount(); j++){
             tempName = produceTable.getModel().getValueAt(j, i).toString();
             
             if(tempName.equalsIgnoreCase(cropName)){
                i++;
               
                cropQty = Integer.parseInt((String.valueOf(produceTable.getModel().getValueAt(j, i)))) + cropQty;
                 //System.out.println("New qunty" +cropQty);
                
                for (Produce prod : produceDirectory.getProduceList())
                {
                    if (prod.getCropName().equalsIgnoreCase(cropName))
                     prod.setCropQuantity(cropQty);
                }
                break;
            }
        }
             populateCropTable();
            }
        }
        catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null,"Please enter a number in Quantity  and price");
            }
    }//GEN-LAST:event_addCropButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCropButton;
    private javax.swing.JButton assignJButton;
    private javax.swing.JTextField cropNameTextField;
    private javax.swing.JTable inventoryRMTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JButton processJButton;
    private javax.swing.JTable produceTable;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTable requestRMjTable;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JButton weatherButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables

    private boolean checkIfCropExists(String text) {
         boolean flag = true;
        for (Produce produce: produceDirectory.getProduceList()){
            String temp = produce.getCropName();
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

    private void populatermCombo() {
        /*rmComboBox.addItem("Pest A");
        rmComboBox.addItem("Pest B");
        rmComboBox.addItem("Pest C");
*/

    }

    private void populateInventoryRM() {
        
        int status =3;
        String tempStatus = null;
        String tempRMName = null;
        int rm = 0;
        int qunatity= 4;
        int QtyRM;
        for(int j = 0; j <requestRMjTable.getRowCount(); j++){
           tempStatus =  requestRMjTable.getModel().getValueAt(j, status).toString();
           if (tempStatus.equalsIgnoreCase("done"))
           {
             /*tempRMName = requestRMjTable.getModel().getValueAt(j, rm).toString();
             QtyRM =  Integer.parseInt(String.valueOf(requestRMjTable.getModel().getValueAt(j, qunatity).toString()));
             DefaultTableModel dtm = (DefaultTableModel)inventoryRMTable.getModel();
        
             dtm.setRowCount(0);
            
            Object[] row = new Object[2];
            row[0] = tempRMName;
            row[1] = QtyRM;

            dtm.addRow(row);
        */
           
           for (RawMaterial rmD : rmDirectory.getRawMaterial())
           {
              DefaultTableModel dtm = (DefaultTableModel)inventoryRMTable.getModel();
        
             dtm.setRowCount(0);
            
            Object[] row = new Object[2];
            row[0] = rmD;
            row[1] = rmD.getMaterialQuantity();

            dtm.addRow(row); 
           }
           }
             
           }
        }
    

}