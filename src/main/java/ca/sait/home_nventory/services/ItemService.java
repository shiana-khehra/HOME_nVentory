package ca.sait.home_nventory.services;

import ca.sait.home_nventory.dataaccess.ItemDB;
import ca.sait.home_nventory.models.Item;
import java.util.List;

public class ItemService {
    
    private ItemDB iDB = new ItemDB();
    
    public List<Item> get(String owner) throws Exception {
        List<Item> items = this.iDB.get(owner);
        return items;
    }
    
    public Item get(int id) throws Exception {
        Item item = this.iDB.get(id);
        return item;
    }
    
    public List<Item> getAll() throws Exception {
        List<Item> items = this.iDB.getAll();
        return items;
    }
    
    public boolean insert(int id, int category, String itemName, double price, String owner) throws Exception {
        Item item = new Item(id, category, itemName, price, owner);
        return this.iDB.insert(item);
    }
    
    public boolean update(int id, int category, String itemName, double price, String owner) throws Exception {
        Item item = new Item(id, category, itemName, price, owner);
        return this.iDB.update(item);
    }
    
    public boolean delete(int id) throws Exception {
        Item item = new Item();
        item.setItem_id(id);
        return this.iDB.delete(item);
    }
    
    public boolean delete(String email) throws Exception {
        return this.iDB.delete(email);
    }
    
    public List<Item> search(String chars) throws Exception {
        List<Item> items = this.iDB.search(chars);
        return items;
    }
}
