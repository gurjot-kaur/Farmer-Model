/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.ManufacturerProducerRole;
import Business.Role.Role;
import Business.Role.WarehouseManagerRole;
import java.util.ArrayList;

/**
 *
 * @author gurjo
 */
public class WarehouseOrganization extends Organization {
    public WarehouseOrganization(){
        super(Type.Warehouse.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new WarehouseManagerRole());
        return roles;
    }  
}
