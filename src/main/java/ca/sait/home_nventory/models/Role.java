package ca.sait.home_nventory.models;

import java.io.Serializable;

/**
 * Represents a role
 * @author Shiana Khehra
 */
public class Role implements Serializable {
    private int role_id;
    private String role_name;
    
    public Role() {
        
    }
    
    public Role(int id, String name) {
        this.role_id = id;
        this.role_name = name;
    }

    public int getId() {
        return role_id;
    }

    public void setId(int id) {
        this.role_id = id;
    }

    public String getName() {
        return role_name;
    }

    public void setName(String name) {
        this.role_name = name;
    }
}
