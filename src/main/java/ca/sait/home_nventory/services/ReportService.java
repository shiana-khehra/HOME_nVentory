package ca.sait.home_nventory.services;

import ca.sait.home_nventory.dataaccess.ReportDB;
import ca.sait.home_nventory.models.ActiveUsersReport;
import ca.sait.home_nventory.models.UserInventoryReport;
import java.util.List;

public class ReportService {
    
    private ReportDB rdb = new ReportDB();
    
    public List<UserInventoryReport> getAll() throws Exception {
        List<UserInventoryReport> reports = this.rdb.getAll();
        return reports;
    }
    
    public List<ActiveUsersReport> getActiveAll() throws Exception {
        List<ActiveUsersReport> reports = this.rdb.getActiveAll();
        return reports;
    }
}
