package ca.sait.home_nventory.dataaccess;

import ca.sait.home_nventory.models.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemDB {
    
    public List<Item> getAll() throws Exception {
        List<Item> items = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM item INNER JOIN category ON item.category = category.category_id";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            //rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                int item_id = rs.getInt(1);
                int category = rs.getInt(2);
                String itemName = rs.getString(3);
                double price = rs.getDouble(4);
                String owner = rs.getString(5);
                int categoryId = rs.getInt(6);
                String categoryName = rs.getString(7);
                
                Item item = new Item(item_id, category, itemName, price, owner);
                
                items.add(item);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

        return items;
    }

    public List<Item> get(String owner) throws Exception {
        List<Item> items = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM item INNER JOIN category ON item.category = category.category_id WHERE owner=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, owner);
            rs = ps.executeQuery();
            while (rs.next()) {
                int item_id = rs.getInt(1);
                int category = rs.getInt(2);
                String itemName = rs.getString(3);
                double price = rs.getDouble(4);
                int categoryId = rs.getInt(6);
                String categoryName = rs.getString(7);
                
                Item item = new Item(item_id, category, itemName, price, owner);
                items.add(item);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        return items;
    }
    
    public Item get(int id) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM item INNER JOIN category ON item.category = category.category_id WHERE item_id=?";
        Item item = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
                int category = rs.getInt(2);
                String itemName = rs.getString(3);
                double price = rs.getDouble(4);
                String owner = rs.getString(5);
                int categoryId = rs.getInt(6);
                String categoryName = rs.getString(7);
                
                item = new Item(id, category, itemName, price, owner);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        return item;
    }

    public boolean insert(Item item) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO item (`category`, `item_name`, `price`, `owner`) VALUES (?, ?, ?, ?)";
        
        boolean inserted = false;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, item.getCategory());
            ps.setString(2, item.getItem_name());
            ps.setDouble(3, item.getPrice());
            ps.setString(4, item.getOwner());

           inserted = ps.executeUpdate() != 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        return inserted;
    }

    public boolean update(Item item) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE item SET category = ?, item_name = ?, price = ?, owner = ? WHERE item_id = ?";
        
        boolean updated;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, item.getCategory());
            ps.setString(2, item.getItem_name());
            ps.setDouble(3, item.getPrice());
            ps.setString(4, item.getOwner());
            ps.setInt(5, item.getItem_id());
            updated = ps.executeUpdate() != 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        return updated;
    }

    public boolean delete(Item item) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "DELETE FROM item WHERE item_id = ?";
        
        boolean deleted;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, item.getItem_id());
            deleted = ps.executeUpdate() != 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return deleted;
    }
    
    public boolean delete(String email) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "DELETE FROM item WHERE owner = ?";
        
        boolean deleted;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            deleted = ps.executeUpdate() != 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return deleted;
    }
    
    public List<Item> search(String chars) throws Exception {
        List<Item> items = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM item WHERE item_name LIKE ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, chars+'%');
            rs = ps.executeQuery();

            //rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                int item_id = rs.getInt(1);
                int category = rs.getInt(2);
                String itemName = rs.getString(3);
                double price = rs.getDouble(4);
                String owner = rs.getString(5);
                
                Item item = new Item(item_id, category, itemName, price, owner);
                
                items.add(item);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

        return items;
    }
}
