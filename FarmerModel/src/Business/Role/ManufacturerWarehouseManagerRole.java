/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;
import Business.EcoSystem;
import Business.Enterprise.*;
import Business.Organization.*;
import Business.Produce.ProduceDirectory;
import Business.ProduceReview.ProduceReviewDirectory;
import Business.RawMaterial.RawMaterialDirectory;
import Business.RawMaterialReview.RawMaterialReviewDirectory;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.ManufacturerWarehouseRole.ManufacturerWarehouseJPanel;

/**
 *
 * @author Welcome
 */
public class ManufacturerWarehouseManagerRole extends Role {
     @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,ProduceDirectory produceDirectory, RawMaterialDirectory rmDirectory,ProduceReviewDirectory prDirectory,RawMaterialReviewDirectory rmrDirectory) {
        return new ManufacturerWarehouseJPanel(userProcessContainer,account, (ManufacturerWarehouseOrganization)organization,(ManufacturerEnterprise)enterprise,business,rmDirectory);
       
    }
    
}
