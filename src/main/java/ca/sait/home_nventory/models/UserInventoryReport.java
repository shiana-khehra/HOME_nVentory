package ca.sait.home_nventory.models;

public class UserInventoryReport {
    
    private String email;
    private int no_of_items;
    private double price;
    
    public UserInventoryReport() {
        
    }
    
    public UserInventoryReport(String email, int no, double price) {
        this.email = email;
        this.no_of_items = no;
        this.price = price;
    }

    public String getEmail() {
        return email;
    }

    public int getNo_of_items() {
        return no_of_items;
    }

    public double getPrice() {
        return price;
    }
    
}
