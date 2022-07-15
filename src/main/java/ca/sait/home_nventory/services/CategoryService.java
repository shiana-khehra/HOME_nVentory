package ca.sait.home_nventory.services;

import ca.sait.home_nventory.dataaccess.CategoryDB;
import ca.sait.home_nventory.models.Category;
import java.util.List;

public class CategoryService {
    
    private CategoryDB cDB = new CategoryDB();
    
    public List<Category> getAll() throws Exception {
        List<Category> categories = this.cDB.getAll();
        return categories;
    }
    
    public boolean insert(int category_id, String category_name) throws Exception {
        Category category = new Category(category_id, category_name);
        return this.cDB.insert(category);
    }
    
    public boolean update(int category_id, String category_name) throws Exception {
        Category category = new Category(category_id, category_name);
        return this.cDB.update(category);
    }
    
    public int getCategoryId(String categoryName) throws Exception{
        int id = this.cDB.getCategoryId(categoryName);
        return id;
    }
}
