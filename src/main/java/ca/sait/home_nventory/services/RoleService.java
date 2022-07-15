package ca.sait.home_nventory.services;

import ca.sait.home_nventory.dataaccess.RoleDB;
import ca.sait.home_nventory.models.Role;
import java.util.List;

public class RoleService {
    
     private RoleDB roleDB = new RoleDB();
    
    public List<Role> getAll() throws Exception {
        List<Role> roles = this.roleDB.getAll();
        return roles;
    }
   
    public int getRoleID(String roleName) throws Exception{

        int id = this.roleDB.getRoleId(roleName);
        return id;
    }
}
