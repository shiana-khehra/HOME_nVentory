package ca.sait.home_nventory.servlets;

import ca.sait.home_nventory.models.*;
import ca.sait.home_nventory.services.*;
import java.io.*;
import com.opencsv.*;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shiana Khehra
 */
public class ManageUsersServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserService userservice = new UserService();
        RoleService roleservice = new RoleService();
        ItemService itemservice = new ItemService();
        String action = request.getParameter("action");
        String email = (String) session.getAttribute("email");
        List<User> users = null;
        List<Role> roles = null;
        User user = null;
        
        if(email != null) {
        try {
            user = userservice.get(email);
            String firstName = user.getFirstName();
            String lastName = user.getLastName();
            
            request.setAttribute("firstname", firstName);
            request.setAttribute("lastname", lastName);
            
            users = userservice.getAll();
            request.setAttribute("users", users);
            roles = roleservice.getAll();
            request.setAttribute("roles", roles);
            
            if(action!= null && action.equals("editButton")) {
                String selectedEmail = request.getParameter("emaill");
                request.setAttribute("emailid", selectedEmail);
                getServletContext().getRequestDispatcher("/WEB-INF/editUserByAdmin.jsp").forward(request, response);
            }
            
            if(action!= null && action.equals("deactivateButton")) {
                    users =userservice.getAll();
                    request.setAttribute("users", users);
                    String emaill = request.getParameter("emaill");
                    emaill = emaill.replace(" ","+");
                    if(userservice.deactivate(emaill)) {
                    users = userservice.getAll();
                    request.setAttribute("users", users);
                    request.setAttribute("msg", "Account deactivated!");
                    }
            }
            
            if(action!= null && action.equals("activateButton")) {
                    users =userservice.getAll();
                    request.setAttribute("users", users);
                    String emaill = request.getParameter("emaill");
                    emaill = emaill.replace(" ","+");
                    if(userservice.activate(emaill)) {
                    users = userservice.getAll();
                    request.setAttribute("users", users);
                    request.setAttribute("msg", "Account activated!");
                    }
            }
            
            if(action!= null && action.equals("inventoryadmin")) {
                    try {
                        String chars = request.getParameter("search");
                        List<Item> items = itemservice.getAll();

                        request.setAttribute("admininvens", items);
                    } catch (Exception ex) {
                        Logger.getLogger(ManageUsersServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    getServletContext().getRequestDispatcher("/WEB-INF/viewinventoryadmin.jsp").forward(request, response);
            }
                    
            if(action!= null && action.equals("deleteButton")) {
                    users =userservice.getAll();
                    request.setAttribute("users", users);
                    String emaill = request.getParameter("emaill");
                    emaill = emaill.replace(" ","+");
                    if(userservice.delete(emaill)) {
                    users = userservice.getAll();
                    request.setAttribute("users", users);
                    request.setAttribute("msg", "1 account deleted!");
                    }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ManageUsersServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserService userservice = new UserService();
        RoleService roleservice = new RoleService();
        ItemService itemservice = new ItemService();
        String action = request.getParameter("action");
        String email = (String) session.getAttribute("email");
        List<User> users = null;
        List<Role> roles = null;
        
        try {
            User user = userservice.get(email);
            String firstName = user.getFirstName();
            String lastName = user.getLastName();
            
            request.setAttribute("firstname", firstName);
            request.setAttribute("lastname", lastName);
            
            users = userservice.getAll();
            request.setAttribute("users", users);
            roles = roleservice.getAll();
            request.setAttribute("roles", roles);
            roles = roleservice.getAll();
            request.setAttribute("roles", roles);
        } catch (Exception ex) {
            Logger.getLogger(ManageUsersServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (action != null && action.equals("add")) {
            try {
                String emaill = request.getParameter("email");
            
                String firstname = request.getParameter("fname");
            
                String lastname = request.getParameter("lname");
            
                String roleName = request.getParameter("role");
                int roleId = roleservice.getRoleID(roleName);
                Role role = new Role(roleId, roleName);
                
                String password = request.getParameter("passwd");
                
                if(userservice.insert(emaill, true, firstname, lastname, password, role)) {
                users = userservice.getAll();
                request.setAttribute("users", users);
                request.setAttribute("msg", "New account created");
                }
            } catch (Exception ex) {
                Logger.getLogger(ManageUsersServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (action != null && action.equals("editUacc")) {
            try {
                String emaill = request.getParameter("emailId");
                User selectedUser = userservice.get(emaill);
            
                String firstname = request.getParameter("fname");
            
                String lastname = request.getParameter("lname");
            
                String roleName = request.getParameter("roleedit");
                int roleId = roleservice.getRoleID(roleName);
                Role role = new Role(roleId, roleName);
            
                if(userservice.update(emaill, selectedUser.isActive(), firstname, lastname, selectedUser.getPassword(), role)) {
                users = userservice.getAll();
                request.setAttribute("users", users);
                roles = roleservice.getAll();
                request.setAttribute("roles", roles);
                request.setAttribute("msg", "User account updated successfully");
                }
            } catch (Exception ex) {
                Logger.getLogger(ManageUsersServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(action != null && action.equals("admininventory")) {
            try {
                String chars = request.getParameter("search");
                List<Item> items = itemservice.search(chars);
                
                request.setAttribute("admininvens", items);
            } catch (Exception ex) {
                Logger.getLogger(ManageUsersServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            getServletContext().getRequestDispatcher("/WEB-INF/viewinventoryadmin.jsp").forward(request, response);
        }
        
        if(action != null && action.equals("report")) {
            try {
            ReportService rservice = new ReportService();
            List<UserInventoryReport> reports = rservice.getAll();
            String path = getServletContext().getRealPath("/userinventoryreport.csv");
            File file = new File(path);

            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer;
                writer = new CSVWriter(outputfile);
            
            // adding header to csv
            String[] header = { "User", "Number of items", "Total price" };
            writer.writeNext(header);
            
            Iterator it = reports.iterator();
            while(it.hasNext()) {
                UserInventoryReport rp = (UserInventoryReport) it.next();
                String[] data1 = { rp.getEmail(), rp.getNo_of_items()+"", rp.getPrice()+"" };
                writer.writeNext(data1);
            }
            
            request.setAttribute("msg", "Report generated.");
            
            // closing writer connection
            writer.close();
            response.sendRedirect("userinventoryreport.csv");
            return;
            }catch (IOException ex) {
                // TODO Auto-generated catch block
                Logger.getLogger(ManageUsersServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("msg", "Report generated in WEB-INF folder.");
            } catch (Exception ex) {
                Logger.getLogger(ManageUsersServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(action != null && action.equals("activeuser")) {
            try {
            ReportService rservice = new ReportService();
            List<ActiveUsersReport> reports = rservice.getActiveAll();
            String path = getServletContext().getRealPath("/userreport.csv");
            File file = new File(path);

            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer;
                writer = new CSVWriter(outputfile);
            
            // adding header to csv
            String[] header = { "Name", "Number of items"};
            writer.writeNext(header);
            
            Iterator it = reports.iterator();
            while(it.hasNext()) {
                ActiveUsersReport rp = (ActiveUsersReport) it.next();
                String[] data1 = { rp.getLastName()+", "+rp.getFirstName(), rp.getItems_no()+""};
                writer.writeNext(data1);
            }
            
            request.setAttribute("msg", "Report generated.");
            
            // closing writer connection
            writer.close();
            response.sendRedirect("userreport.csv");
            return;
            }catch (IOException ex) {
                // TODO Auto-generated catch block
                Logger.getLogger(ManageUsersServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("msg", "Report generated in WEB-INF folder.");
            } catch (Exception ex) {
                Logger.getLogger(ManageUsersServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
    }
}