package ca.sait.home_nventory.dataaccess;

import ca.sait.home_nventory.models.ActiveUsersReport;
import ca.sait.home_nventory.models.UserInventoryReport;
import java.sql.*;
import java.util.*;

public class ReportDB {
    
    public List<UserInventoryReport> getAll() throws Exception {
        List<UserInventoryReport> reports = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT email Users, COUNT(item_id) \"No of items\", NVL(SUM(price), 0) \"Total Price\" FROM user LEFT JOIN item ON (user.email = item.owner) GROUP by email";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String email = rs.getString(1);
                int no_of_items = rs.getInt(2);
                double price = rs.getDouble(3);
                
                UserInventoryReport report = new UserInventoryReport(email, no_of_items, price);
                
                reports.add(report);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

        return reports;
    }
    
    public List<ActiveUsersReport> getActiveAll() throws Exception {
        List<ActiveUsersReport> reports = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT first_name \"First Name\", last_name \"Last Name\", COUNT(item_id) \"No of items\" FROM user LEFT JOIN item ON (user.email = item.owner) WHERE role = 2 GROUP by email ORDER BY last_name, first_name";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String firstName = rs.getString(1);
                String lastName = rs.getString(2);
                int no_of_items = rs.getInt(3);
                
                ActiveUsersReport activeReport = new ActiveUsersReport(firstName, lastName, no_of_items);
                
                reports.add(activeReport);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

        return reports;
    }
}
