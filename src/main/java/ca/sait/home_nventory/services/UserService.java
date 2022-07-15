package ca.sait.home_nventory.services;

import ca.sait.home_nventory.dataaccess.UserDB;
import ca.sait.home_nventory.models.*;
import java.util.List;

public class UserService {
    
    private UserDB userDB = new UserDB();
    
    public User get(String email) throws Exception {
        User user = this.userDB.get(email);
        return user;
    }
    
    public List<User> getAll() throws Exception {
        List<User> users = this.userDB.getAll();
        return users;
    }
    
    public boolean insert(String email, boolean active, String firstName, String lastName, String password, Role role) throws Exception {
        User user = new User(email, active, firstName, lastName, password, role);
        return this.userDB.insert(user);
    }
    
    public boolean update(String email, boolean active, String firstName, String lastName, String password, Role role) throws Exception {
        User user = new User(email, active, firstName, lastName, password, role);
        return this.userDB.update(user);
    }
    
    public boolean deactivate(String email) throws Exception {
        User user = new User();
        user.setEmail(email);
        return this.userDB.deactivate(user);
    }
    
    public boolean activate(String email) throws Exception {
        User user = new User();
        user.setEmail(email);
        return this.userDB.activate(user);
    }
    
    public boolean delete(String email) throws Exception {
        User user = new User();
        user.setEmail(email);
        return this.userDB.delete(user);
    }
}
