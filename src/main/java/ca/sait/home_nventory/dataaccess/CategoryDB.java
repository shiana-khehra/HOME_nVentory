package ca.sait.home_nventory.dataaccess;

import ca.sait.home_nventory.models.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDB {
    
    public List<Category> getAll() throws Exception {
        List<Category> categories = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM category";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            //rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                int category_id = rs.getInt(1);
                String category_name = rs.getString(2);
                
                Category category = new Category(category_id, category_name);
                
                categories.add(category);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

        return categories;
    }

    public boolean insert(Category category) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO category (`category_id`, `category_name`) VALUES (?, ?)";
        
        boolean inserted = false;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, category.getCategory_id());
            ps.setString(2, category.getCategory_name());
            
           inserted = ps.executeUpdate() != 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        return inserted;
    }

    public boolean update(Category category) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE category SET category_name = ? WHERE category_id = ?";
        
        boolean updated;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, category.getCategory_name());
            ps.setInt(2, category.getCategory_id());
           
            updated = ps.executeUpdate() != 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        return updated;
    }
    
    public int getCategoryId(String categoryName) throws Exception{
        
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id = 0;
        
        String sql = "SELECT category_id FROM category WHERE category_name=?;";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, categoryName);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        return id;
    }
}
