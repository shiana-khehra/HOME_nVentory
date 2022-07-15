package ca.sait.home_nventory.models;

import java.io.Serializable;

/**
 * Represents a category
 * @author Shiana Khehra
 */
public class Category implements Serializable {
    private int category_id;
    private String category_name;
    
    public Category() {
        
    }
    
    public Category(int id, String name)  {
        this.category_id = id;
        this.category_name = name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
    
}
