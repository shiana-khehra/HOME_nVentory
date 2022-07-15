package ca.sait.home_nventory.services;

import ca.sait.home_nventory.dataaccess.UserDB;
import ca.sait.home_nventory.models.User;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountService {
    
    public User login(String email, String password) {
        UserDB userDB = new UserDB();
        
        try {
            User user = userDB.get(email);
            if (password.equals(user.getPassword())) {
                return user;
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
