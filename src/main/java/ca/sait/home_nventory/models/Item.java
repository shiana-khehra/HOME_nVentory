package ca.sait.home_nventory.models;

import java.io.Serializable;

/**
 * Represents an item
 * @author Shiana Khehra
 */
public class Item implements Serializable {
    private int item_id;
    private int category;
    private String item_name;
    private double price;
    private String owner;
    
    public Item() {
        
    }
    
    public Item(int id, int category, String itemName, double price, String owner) {
        this.item_id = id;
        this.category = category;
        this.item_name = itemName;
        this.price = price;
        this.owner = owner;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    
}
