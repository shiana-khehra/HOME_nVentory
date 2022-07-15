package ca.sait.home_nventory.models;

public class ActiveUsersReport {
    
    private String firstName;
    private String lastName;
    private int items_no;
    
    public ActiveUsersReport() {
        
    }
    
    public ActiveUsersReport(String first, String last, int no) {
        this.firstName = first;
        this.lastName = last;
        this.items_no = no;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getItems_no() {
        return items_no;
    }
    
}
